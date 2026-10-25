package com.p091jc.p092code.p093v3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;
import p131o.AbstractC3542d8;
import p131o.AbstractC4524s4;
import p131o.C2605P;
import p131o.C2936U7;
import p131o.C3670f8;
import p131o.InterfaceC3405b3;
import p131o.InterfaceC3606e8;
import p131o.InterfaceC3665f3;

/* loaded from: classes.dex */
public class ScreenCaptureService extends Service {
    private static final String CHANNEL_ID = "jc_screen_capture";
    private static final int NOTIFICATION_ID = 1001;
    private static final long WATCH_TIMEOUT_MS = 90000;
    private static ScreenCaptureService sInstance;
    private static InterfaceC1112JHa sListener;
    private Handler mHandler;
    private ImageReader mImageReader;
    private MediaProjection mMediaProjection;
    private InterfaceC3606e8 mRecognizer;

    /* renamed from: mThread */
    private HandlerThread f4821mThread;
    private VirtualDisplay mVirtualDisplay;
    private static final Pattern SIX_DIGITS = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");

    /* renamed from: IP_PORT */
    private static final Pattern f4818IP_PORT = Pattern.compile("(\\d{1,3}(?:\\.\\d{1,3}){3})(?::(\\d{2,5}))?");

    /* renamed from: PORT */
    private static final Pattern f4819PORT = Pattern.compile("(?<!\\d)(\\d{4,5})(?!\\d)");
    private static volatile boolean sRunning = false;
    private volatile boolean mOcrBusy = false;

    /* renamed from: mFound */
    private volatile boolean f4820mFound = false;
    private final Runnable mCapture = new RunnableC1115mjFkc();
    private final Runnable mTimeout = new RunnableC1111AZxh();

    /* renamed from: com.jc.code.v3.ScreenCaptureService$AZxh */
    public class RunnableC1111AZxh implements Runnable {
        public RunnableC1111AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ScreenCaptureService.sRunning || ScreenCaptureService.this.f4820mFound) {
                return;
            }
            ScreenCaptureService.notifyStatus("屏幕读取超时：未识别到配对码", false);
            ScreenCaptureService.this.stopCapture();
        }
    }

    /* renamed from: com.jc.code.v3.ScreenCaptureService$JHa */
    public interface InterfaceC1112JHa {
        /* renamed from: AZxh */
        void mo4869AZxh(String str, String str2);

        /* renamed from: mjFkc */
        void mo4870mjFkc(String str, boolean z);
    }

    /* renamed from: com.jc.code.v3.ScreenCaptureService$KLFTb */
    public class C1113KLFTb implements InterfaceC3665f3 {

        /* renamed from: mjFkc */
        public final /* synthetic */ Bitmap f4824mjFkc;

        public C1113KLFTb(Bitmap bitmap) {
            this.f4824mjFkc = bitmap;
        }

        @Override // p131o.InterfaceC3665f3
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo4876mjFkc(C2936U7 c2936u7) throws NumberFormatException {
            ScreenCaptureService.this.mOcrBusy = false;
            ScreenCaptureService.this.handleOcrResult(c2936u7);
            this.f4824mjFkc.recycle();
        }
    }

    /* renamed from: com.jc.code.v3.ScreenCaptureService$ZfxDd */
    public class C1114ZfxDd implements InterfaceC3405b3 {

        /* renamed from: mjFkc */
        public final /* synthetic */ Bitmap f4826mjFkc;

        public C1114ZfxDd(Bitmap bitmap) {
            this.f4826mjFkc = bitmap;
        }

        @Override // p131o.InterfaceC3405b3
        /* renamed from: mjFkc */
        public void mo4877mjFkc(Exception exc) {
            ScreenCaptureService.this.mOcrBusy = false;
            this.f4826mjFkc.recycle();
        }
    }

    /* renamed from: com.jc.code.v3.ScreenCaptureService$mjFkc */
    public class RunnableC1115mjFkc implements Runnable {
        public RunnableC1115mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScreenCaptureService.sRunning) {
                ScreenCaptureService.this.grabFrame();
                if (ScreenCaptureService.sRunning) {
                    ScreenCaptureService.this.mHandler.postDelayed(this, 1500L);
                }
            }
        }
    }

    /* renamed from: com.jc.code.v3.ScreenCaptureService$wA */
    public class C1116wA extends MediaProjection.Callback {
        public C1116wA() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            ScreenCaptureService.this.stopCapture();
        }
    }

    private void createChannel() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "屏幕读取", 2);
        notificationChannel.setDescription("识别无线调试配对码时临时截取屏幕");
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static void extendWatch() {
        Handler handler;
        ScreenCaptureService screenCaptureService = sInstance;
        if (screenCaptureService == null || (handler = screenCaptureService.mHandler) == null) {
            return;
        }
        handler.removeCallbacks(screenCaptureService.mTimeout);
        ScreenCaptureService screenCaptureService2 = sInstance;
        screenCaptureService2.mHandler.postDelayed(screenCaptureService2.mTimeout, WATCH_TIMEOUT_MS);
        sInstance.f4820mFound = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grabFrame() {
        if (this.mImageReader == null || this.mOcrBusy || this.f4820mFound) {
            return;
        }
        Image image = null;
        try {
            Image imageAcquireLatestImage = this.mImageReader.acquireLatestImage();
            if (imageAcquireLatestImage == null) {
                return;
            }
            try {
                Image.Plane plane = imageAcquireLatestImage.getPlanes()[0];
                ByteBuffer buffer = plane.getBuffer();
                int pixelStride = plane.getPixelStride();
                int rowStride = plane.getRowStride();
                int width = imageAcquireLatestImage.getWidth();
                int height = imageAcquireLatestImage.getHeight();
                int i = ((rowStride - (pixelStride * width)) / pixelStride) + width;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, height, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
                if (i != width) {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height);
                    bitmapCreateBitmap.recycle();
                    bitmapCreateBitmap = bitmapCreateBitmap2;
                }
                imageAcquireLatestImage.close();
                this.mOcrBusy = true;
                this.mRecognizer.mo4302qGY(C2605P.m9927mjFkc(bitmapCreateBitmap, 0)).mo7666ZfxDd(new C1113KLFTb(bitmapCreateBitmap)).mo7670wA(new C1114ZfxDd(bitmapCreateBitmap));
            } catch (Exception unused) {
                image = imageAcquireLatestImage;
                this.mOcrBusy = false;
                if (image != null) {
                    try {
                        image.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleOcrResult(C2936U7 c2936u7) throws NumberFormatException {
        String strGroup;
        Rect rectM10476mjFkc;
        int i;
        if (!sRunning || this.f4820mFound) {
            return;
        }
        ArrayList<C2936U7.AZxh> arrayList = new ArrayList();
        Iterator it = c2936u7.m10470AZxh().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((C2936U7.KLFTb) it.next()).m10474ZfxDd());
        }
        String strM10471mjFkc = c2936u7.m10471mjFkc();
        String strReplaceAll = strM10471mjFkc.replaceAll("\\s+", BuildConfig.f24315FLAVOR);
        String lowerCase = strM10471mjFkc.toLowerCase();
        boolean z = strReplaceAll.contains("配对码") || lowerCase.contains("pairingcode") || lowerCase.contains("pairing code");
        boolean z2 = strReplaceAll.contains("取消") || lowerCase.contains("cancel") || strReplaceAll.contains("Wi-Fi配对码") || lowerCase.contains("wifi pairing code");
        Matcher matcher = f4818IP_PORT.matcher(strReplaceAll);
        String str = null;
        if (matcher.find()) {
            strGroup = matcher.group(1);
            if (strGroup.startsWith("127.") || strGroup.startsWith("0.")) {
                strGroup = null;
            } else if (matcher.group(2) != null) {
                strGroup = strGroup + ":" + matcher.group(2);
            } else {
                Matcher matcher2 = Pattern.compile("^:?(\\d{2,5})(?!\\d)").matcher(strReplaceAll.substring(matcher.end()));
                String str2 = (!matcher2.find() || (i = Integer.parseInt(matcher2.group(1))) < 30000 || i > 49999) ? null : strGroup + ":" + i;
                if (str2 != null) {
                    strGroup = str2;
                }
            }
        }
        if (strGroup == null) {
            Matcher matcher3 = Pattern.compile("(\\d{1,3}(?:\\.\\d{1,3}){3})").matcher(strReplaceAll);
            if (matcher3.find()) {
                String strGroup2 = matcher3.group(1);
                Matcher matcher4 = f4819PORT.matcher(strReplaceAll);
                while (true) {
                    if (!matcher4.find()) {
                        break;
                    }
                    int i2 = Integer.parseInt(matcher4.group(1));
                    if (i2 >= 30000 && i2 <= 49999) {
                        strGroup = strGroup2 + ":" + i2;
                        break;
                    }
                }
                if (strGroup == null) {
                    strGroup = strGroup2;
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                rectM10476mjFkc = null;
                break;
            }
            C2936U7.AZxh aZxh = (C2936U7.AZxh) it2.next();
            String strM10472ZfxDd = aZxh.m10472ZfxDd();
            if (strM10472ZfxDd != null && strM10472ZfxDd.replace(" ", BuildConfig.f24315FLAVOR).matches(".*\\d{1,3}(\\.\\d{1,3}){3}.*")) {
                rectM10476mjFkc = aZxh.m10476mjFkc();
                break;
            }
        }
        int i3 = Integer.MAX_VALUE;
        for (C2936U7.AZxh aZxh2 : arrayList) {
            Matcher matcher5 = SIX_DIGITS.matcher(aZxh2.m10472ZfxDd().replaceAll("[ \\t\\u00A0]", BuildConfig.f24315FLAVOR));
            if (matcher5.find()) {
                String strGroup3 = matcher5.group();
                Rect rectM10476mjFkc2 = aZxh2.m10476mjFkc();
                int iAbs = (rectM10476mjFkc == null || rectM10476mjFkc2 == null) ? 0 : Math.abs(((rectM10476mjFkc2.top + rectM10476mjFkc2.bottom) / 2) - ((rectM10476mjFkc.top + rectM10476mjFkc.bottom) / 2));
                if (str == null || iAbs < i3) {
                    i3 = iAbs;
                    str = strGroup3;
                }
            }
        }
        if (str == null) {
            return;
        }
        if (strGroup != null || (z && z2)) {
            this.f4820mFound = true;
            notifyCode(str, strGroup);
            stopCapture();
        }
    }

    public static boolean isRunning() {
        return sRunning;
    }

    private static void notifyCode(String str, String str2) {
        InterfaceC1112JHa interfaceC1112JHa = sListener;
        if (interfaceC1112JHa != null) {
            try {
                interfaceC1112JHa.mo4869AZxh(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyStatus(String str, boolean z) {
        InterfaceC1112JHa interfaceC1112JHa = sListener;
        if (interfaceC1112JHa != null) {
            try {
                interfaceC1112JHa.mo4870mjFkc(str, z);
            } catch (Exception unused) {
            }
        }
    }

    public static void setListener(InterfaceC1112JHa interfaceC1112JHa) {
        sListener = interfaceC1112JHa;
    }

    private void startForegroundCompat() {
        startForeground(NOTIFICATION_ID, new Notification.Builder(this, CHANNEL_ID).setContentTitle("正在识别配对码").setContentText("仅截取当前屏幕用于读取无线调试配对码").setSmallIcon(AbstractC4524s4.f16419Dt).setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 201326592)).build(), 32);
    }

    private void startVirtualDisplay() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        float f = i > 900 ? 0.5f : 0.75f;
        int iMax = Math.max(1, (int) (i * f));
        int iMax2 = Math.max(1, (int) (displayMetrics.heightPixels * f));
        ImageReader imageReaderNewInstance = ImageReader.newInstance(iMax, iMax2, 1, 2);
        this.mImageReader = imageReaderNewInstance;
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("jc-pair-screen", iMax, iMax2, displayMetrics.densityDpi, 16, imageReaderNewInstance.getSurface(), null, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCapture() {
        sRunning = false;
        this.f4820mFound = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mCapture);
            this.mHandler.removeCallbacks(this.mTimeout);
        }
        VirtualDisplay virtualDisplay = this.mVirtualDisplay;
        if (virtualDisplay != null) {
            try {
                virtualDisplay.release();
            } catch (Exception unused) {
            }
            this.mVirtualDisplay = null;
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            try {
                imageReader.close();
            } catch (Exception unused2) {
            }
            this.mImageReader = null;
        }
        MediaProjection mediaProjection = this.mMediaProjection;
        if (mediaProjection != null) {
            try {
                mediaProjection.stop();
            } catch (Exception unused3) {
            }
            this.mMediaProjection = null;
        }
        try {
            stopForeground(true);
        } catch (Exception unused4) {
        }
        try {
            stopSelf();
        } catch (Exception unused5) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        HandlerThread handlerThread = new HandlerThread("jc-screen-ocr");
        this.f4821mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.f4821mThread.getLooper());
        this.mRecognizer = AbstractC3542d8.m11709mjFkc(C3670f8.f13525ZfxDd);
        createChannel();
    }

    @Override // android.app.Service
    public void onDestroy() {
        sRunning = false;
        sInstance = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VirtualDisplay virtualDisplay = this.mVirtualDisplay;
        if (virtualDisplay != null) {
            try {
                virtualDisplay.release();
            } catch (Exception unused) {
            }
            this.mVirtualDisplay = null;
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            try {
                imageReader.close();
            } catch (Exception unused2) {
            }
            this.mImageReader = null;
        }
        MediaProjection mediaProjection = this.mMediaProjection;
        if (mediaProjection != null) {
            try {
                mediaProjection.stop();
            } catch (Exception unused3) {
            }
            this.mMediaProjection = null;
        }
        InterfaceC3606e8 interfaceC3606e8 = this.mRecognizer;
        if (interfaceC3606e8 != null) {
            try {
                interfaceC3606e8.close();
            } catch (Exception unused4) {
            }
            this.mRecognizer = null;
        }
        HandlerThread handlerThread = this.f4821mThread;
        if (handlerThread != null) {
            try {
                handlerThread.quitSafely();
            } catch (Exception unused5) {
            }
            this.f4821mThread = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        MediaProjection mediaProjection;
        startForegroundCompat();
        if (intent == null) {
            stopCapture();
            return 2;
        }
        int intExtra = intent.getIntExtra("resultCode", 0);
        Intent intent2 = (Intent) intent.getParcelableExtra("data");
        if (intent2 == null) {
            notifyStatus("屏幕读取授权数据为空", false);
            stopCapture();
            return 2;
        }
        if (this.mMediaProjection != null) {
            extendWatch();
            return 2;
        }
        try {
            mediaProjection = ((MediaProjectionManager) getSystemService("media_projection")).getMediaProjection(intExtra, intent2);
            this.mMediaProjection = mediaProjection;
        } catch (Exception e) {
            notifyStatus("启动屏幕读取失败: " + e.getMessage(), false);
            stopCapture();
        }
        if (mediaProjection == null) {
            notifyStatus("获取屏幕读取权限失败", false);
            stopCapture();
            return 2;
        }
        mediaProjection.registerCallback(new C1116wA(), this.mHandler);
        startVirtualDisplay();
        sRunning = true;
        this.f4820mFound = false;
        this.mHandler.removeCallbacks(this.mTimeout);
        this.mHandler.postDelayed(this.mTimeout, WATCH_TIMEOUT_MS);
        this.mHandler.postDelayed(this.mCapture, 800L);
        return 2;
    }
}
