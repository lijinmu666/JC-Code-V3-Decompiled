package com.jc.code.v3;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.media.projection.MediaProjectionManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.Settings;
import android.security.KeyChain;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.indidevs.android.adbeesh.notifications.NotificationFlowConfig;
import com.jc.code.v3.ScreenCaptureService;
import com.jc.code.v3.mjFkc;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;
import kotlin.time.DurationKt;
import o.AbstractC1857s4;
import o.AbstractC1978u4;
import o.CBEvIj;
import o.CrDc;
import o.D4;
import o.E4;
import o.H1;
import o.H4;
import o.J4;
import o.S4;
import o.vEiZJ;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.pqc.crypto.xmss.XMSSKeyParameters;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.hiddenapibypass.HiddenApiBypass;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class MainActivity extends Activity {
    public static MainActivity sRqPfw;
    public LinearLayout ANMGZc;
    public TextView AZxh;
    public float BAnRFn;
    public qtZIjO GMIER;
    public WindowManager IEE;
    public String IVlxe;
    public View JHa;
    public qtZIjO JYgkl;
    public qtZIjO JYn;
    public View KLFTb;
    public EditText KLMXS;
    public TextView KRTLGT;
    public String Moer;
    public View Pq;
    public LinearLayout SwgkN;
    public ProgressBar Ucbh;
    public View VA;
    public float VocHEe;
    public ObjectAnimator WGXroI;
    public LinearLayout WrLQs;
    public LinearLayout XV;
    public Intent XbiWeM;
    public TextView YoKzxo;
    public TextView ZfxDd;
    public LinearLayout alEkx;
    public LinearLayout aqHPIZ;
    public TextView bbzow;
    public View cMLeY;
    public TextView diqgf;
    public LinearLayout eyqo;
    public View fFz;
    public ProgressDialog fehf;
    public ObjectAnimator gYa;
    public ImageView gtIJp;
    public Bitmap kism;
    public float lB;
    public Object lgHUyS;
    public LinearLayout oCFDzJ;
    public ServerSocket qGY;
    public Class qdMbNW;
    public volatile String rWxwaT;
    public ScrollView rkYL;
    public boolean tjSezt;
    public View uH;
    public qtZIjO uHVRx;
    public float vI;
    public View vjlshU;
    public TextView wA;
    public String xROA;
    public WebView xrEuO;
    public ImageView yX;
    public View zvd;
    public static final Pattern XD = Pattern.compile("\\[(\\d+),(\\d+)\\]\\[(\\d+),(\\d+)\\]");
    public static final Pattern gtr = Pattern.compile("(\\d{1,3}(?:\\.\\d{1,3}){3})(?::(\\d{2,5}))?");
    public static final Pattern Dp = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");
    public final Handler mjFkc = new Handler(Looper.getMainLooper());
    public boolean xJ = true;
    public boolean Dt = false;
    public File ETF = null;
    public StringBuilder MiMN = new StringBuilder();
    public boolean huTpC = false;
    public int Gd = -1;
    public int HGpJ = -1;
    public boolean wJVbdd = false;
    public volatile boolean mByQ = false;
    public Method OjSQV = null;
    public int Ne = 0;
    public String CqaNbM = BuildConfig.FLAVOR;
    public final List Vnb = new ArrayList();
    public int NPj = 0;
    public int vadzgd = 4;
    public String JrJO = "正在连接...";
    public Boolean nxI = null;
    public volatile String JBhc = "检测中...";
    public volatile boolean Vdz = false;
    public volatile boolean jm = false;
    public boolean dm = false;
    public volatile boolean tQ = false;
    public volatile boolean yfx = false;
    public long SmIWf = 0;
    public long SOS = 0;
    public boolean Qr = false;
    public int NKyg = 0;
    public volatile boolean LREOK = false;
    public long XFUzSY = 0;
    public volatile boolean XtE = false;
    public volatile boolean jx = true;
    public String tISON = BuildConfig.FLAVOR;
    public final Runnable Vgyli = new bc();
    public boolean lti = false;
    public boolean giT = false;

    public class ANMGZc implements DialogInterface.OnClickListener {
        public ANMGZc() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.o();
        }
    }

    public class APn implements Runnable {
        public APn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.R();
        }
    }

    public class AZxh implements Runnable {
        public AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.Q();
        }
    }

    public class ArO implements View.OnClickListener {
        public ArO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.MiMN.setLength(0);
            if (MainActivity.this.YoKzxo != null) {
                MainActivity.this.YoKzxo.setText(BuildConfig.FLAVOR);
            }
        }
    }

    public class BABY implements Runnable {
        public BABY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.OGo();
        }
    }

    public class BAnRFn implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public BAnRFn(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.m("install-ca-cert " + str, this.mjFkc, this.AZxh);
        }
    }

    public class BxruE implements View.OnClickListener {
        public BxruE() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            MainActivity.this.v0();
        }
    }

    public class CTcA implements Runnable {
        public CTcA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.uube();
        }
    }

    public class CcoH implements View.OnClickListener {
        public CcoH() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.O();
        }
    }

    public class CqAnRZ implements Runnable {
        public final /* synthetic */ Uri mjFkc;

        public CqAnRZ(Uri uri) {
            this.mjFkc = uri;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            MainActivity.this.dXmy(this.mjFkc);
        }
    }

    public class CqaNbM implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public class mjFkc implements DialogInterface.OnClickListener {
            public final /* synthetic */ String mjFkc;

            public mjFkc(String str) {
                this.mjFkc = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = MainActivity.this;
                String str = "pm clear " + this.mjFkc;
                CqaNbM cqaNbM = CqaNbM.this;
                mainActivity.q(str, cqaNbM.mjFkc, cqaNbM.AZxh);
            }
        }

        public CqaNbM(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.U(new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setTitle("⚠ 清除应用数据").setMessage("将清除 " + str + " 的全部数据（账号、聊天记录、设置等都会丢失，且不可恢复）。\n\n确定继续？").setPositiveButton("清除", new mjFkc(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    public class Dp implements ServiceConnection {
        public Dp() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class Dt implements Runnable {
        public final /* synthetic */ Map AZxh;
        public final /* synthetic */ LinearLayout mjFkc;
        public final /* synthetic */ EditText wA;

        public class AZxh implements Runnable {
            public final /* synthetic */ boolean AZxh;
            public final /* synthetic */ List mjFkc;
            public final /* synthetic */ Map wA;

            /* renamed from: com.jc.code.v3.MainActivity$Dt$AZxh$AZxh, reason: collision with other inner class name */
            public class C0033AZxh implements CompoundButton.OnCheckedChangeListener {
                public final /* synthetic */ TextView AZxh;
                public final /* synthetic */ String mjFkc;

                public C0033AZxh(String str, TextView textView) {
                    this.mjFkc = str;
                    this.AZxh = textView;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (Boolean.TRUE.equals(compoundButton.getTag())) {
                        return;
                    }
                    MainActivity.this.w(this.mjFkc, z, compoundButton, this.AZxh);
                }
            }

            public class mjFkc implements View.OnClickListener {
                public final /* synthetic */ CheckBox mjFkc;

                public mjFkc(CheckBox checkBox) {
                    this.mjFkc = checkBox;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.mjFkc.setChecked(!r0.isChecked());
                }
            }

            public class wA implements TextWatcher {
                public wA() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String strTrim = editable.toString().toLowerCase().trim();
                    Iterator it = Dt.this.AZxh.entrySet().iterator();
                    while (it.hasNext()) {
                        View view = (View) ((Map.Entry) it.next()).getValue();
                        view.setVisibility((strTrim.isEmpty() || ((TextView) view.findViewById(AbstractC1978u4.fehf)).getText().toString().toLowerCase().contains(strTrim) || ((TextView) view.findViewById(AbstractC1978u4.diqgf)).getText().toString().toLowerCase().contains(strTrim)) ? 0 : 8);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            }

            public AZxh(List list, boolean z, Map map) {
                this.mjFkc = list;
                this.AZxh = z;
                this.wA = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                Dt.this.mjFkc.removeAllViews();
                for (PackageInfo packageInfo : this.mjFkc) {
                    String string = packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString();
                    String str = packageInfo.packageName;
                    View viewInflate = LayoutInflater.from(MainActivity.this).inflate(H4.ZfxDd, (ViewGroup) null);
                    ImageView imageView = (ImageView) viewInflate.findViewById(AbstractC1978u4.qdMbNW);
                    TextView textView = (TextView) viewInflate.findViewById(AbstractC1978u4.fehf);
                    TextView textView2 = (TextView) viewInflate.findViewById(AbstractC1978u4.diqgf);
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(AbstractC1978u4.KLFTb);
                    imageView.setImageDrawable(packageInfo.applicationInfo.loadIcon(MainActivity.this.getPackageManager()));
                    textView.setText(string);
                    textView.setTextColor(this.AZxh ? -419430401 : -15066598);
                    boolean z = this.wA.containsKey(str) && ((Boolean) this.wA.get(str)).booleanValue();
                    textView2.setText(str);
                    textView2.setTextColor(z ? -15171528 : this.AZxh ? -1711276033 : -1728053248);
                    checkBox.setChecked(z);
                    viewInflate.setOnClickListener(new mjFkc(checkBox));
                    checkBox.setOnCheckedChangeListener(new C0033AZxh(str, textView2));
                    Dt.this.mjFkc.addView(viewInflate);
                    Dt.this.AZxh.put(str, viewInflate);
                }
                Dt.this.wA.addTextChangedListener(new wA());
            }
        }

        public class mjFkc implements Comparator {
            public mjFkc() {
            }

            @Override // java.util.Comparator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
                return packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString().compareToIgnoreCase(packageInfo2.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString());
            }
        }

        public Dt(LinearLayout linearLayout, Map map, EditText editText) {
            this.mjFkc = linearLayout;
            this.AZxh = map;
            this.wA = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zIsUninstallBlocked;
            List<PackageInfo> installedPackages = MainActivity.this.getPackageManager().getInstalledPackages(0);
            ArrayList<PackageInfo> arrayList = new ArrayList();
            for (PackageInfo packageInfo : installedPackages) {
                if (!packageInfo.packageName.startsWith("com.android.") || packageInfo.packageName.contains("launcher")) {
                    if (!packageInfo.packageName.equals("android")) {
                        arrayList.add(packageInfo);
                    }
                }
            }
            Collections.sort(arrayList, new mjFkc());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) MainActivity.this.getSystemService("device_policy");
                ComponentName componentName = new ComponentName(MainActivity.this, (Class<?>) JcDeviceAdminReceiver.class);
                for (PackageInfo packageInfo2 : arrayList) {
                    try {
                        zIsUninstallBlocked = devicePolicyManager.isUninstallBlocked(componentName, packageInfo2.packageName);
                    } catch (Throwable unused) {
                        zIsUninstallBlocked = false;
                    }
                    linkedHashMap.put(packageInfo2.packageName, Boolean.valueOf(zIsUninstallBlocked));
                }
            } catch (Throwable unused2) {
            }
            MainActivity.this.runOnUiThread(new AZxh(arrayList, MainActivity.this.xJ, linkedHashMap));
        }
    }

    public class ERt implements Runnable {
        public final /* synthetic */ View mjFkc;

        public ERt(View view) {
            this.mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((ViewGroup) MainActivity.this.getWindow().getDecorView()).removeView(this.mjFkc);
            } catch (Throwable unused) {
            }
        }
    }

    public class ETF implements Runnable {
        public ETF() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.mL();
        }
    }

    public class EeoThB implements Runnable {
        public final /* synthetic */ GradientDrawable AZxh;
        public final /* synthetic */ View mjFkc;
        public final /* synthetic */ int wA;

        public EeoThB(View view, GradientDrawable gradientDrawable, int i) {
            this.mjFkc = view;
            this.AZxh = gradientDrawable;
            this.wA = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mjFkc.setBackground(this.AZxh);
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(this.mjFkc);
                while (!arrayDeque.isEmpty()) {
                    View view = (View) arrayDeque.poll();
                    if (view != this.mjFkc) {
                        view.setBackground(this.AZxh);
                    }
                    if (view instanceof TextView) {
                        try {
                            if (((TextView) view).getId() != D4.mByQ) {
                                ((TextView) view).setTextColor(this.wA);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            arrayDeque.add(viewGroup.getChildAt(i));
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public class EoC implements View.OnClickListener {
        public EoC() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            MainActivity.this.v0();
        }
    }

    public class Es implements Runnable {
        public Es() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.P();
        }
    }

    public class FOJ implements Runnable {
        public FOJ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.M();
        }
    }

    public class FbxKQm implements View.OnClickListener {
        public FbxKQm() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.xrEuO.reload();
        }
    }

    public class Fztqa implements Runnable {
        public Fztqa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("mail", "aono_saki@outlook.com"));
            MainActivity.this.X("邮箱已复制");
        }
    }

    public class GMIER implements DialogInterface.OnClickListener {
        public final /* synthetic */ CheckBox mjFkc;

        public GMIER(CheckBox checkBox) {
            this.mjFkc = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.r(this.mjFkc.isChecked());
            MainActivity.this.Frh();
        }
    }

    public class Gd implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public Gd(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.m("is-uninstall-blocked " + str, this.mjFkc, this.AZxh);
        }
    }

    public class HExgdj implements Runnable {
        public final /* synthetic */ boolean AZxh;
        public final /* synthetic */ String ZfxDd;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ String wA;

        public class AZxh implements DialogInterface.OnClickListener {
            public AZxh() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public class mjFkc implements DialogInterface.OnClickListener {
            public mjFkc() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HExgdj hExgdj = HExgdj.this;
                MainActivity.this.bL(hExgdj.ZfxDd);
            }
        }

        public HExgdj(String str, boolean z, String str2, String str3) {
            this.mjFkc = str;
            this.AZxh = z;
            this.wA = str2;
            this.ZfxDd = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str3 = this.mjFkc;
            if (str3 == null || str3.length() <= 0) {
                str = BuildConfig.FLAVOR;
            } else {
                str = this.mjFkc + "\n\n";
            }
            sb.append(str);
            if (this.AZxh) {
                str2 = "当前版本 3.2.6 已停止支持，必须更新到 " + this.wA + " 及以上才能继续使用。";
            } else {
                str2 = "当前版本 3.2.6，最新版本 " + this.wA + "。";
            }
            sb.append(str2);
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setTitle(this.AZxh ? "必须更新" : "发现新版本").setMessage(sb.toString()).setPositiveButton("立即更新", new mjFkc());
            if (this.AZxh) {
                positiveButton.setNegativeButton("退出", new AZxh());
            } else {
                positiveButton.setNegativeButton("稍后再说", (DialogInterface.OnClickListener) null);
            }
            AlertDialog alertDialogU = MainActivity.this.U(positiveButton);
            MainActivity.this.u(alertDialogU, 540.0f);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.l0(alertDialogU, -13916000, mainActivity.xJ ? -6643546 : -10525848);
            if (this.AZxh) {
                MainActivity.this.UokA(alertDialogU);
            }
        }
    }

    public class HGpJ implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public HGpJ(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.m("set-uninstall-blocked " + str + " true", this.mjFkc, this.AZxh);
        }
    }

    public class HX implements Runnable {
        public HX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.PX();
        }
    }

    public class Hk implements Runnable {
        public Hk() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("search_bg_scale", "center").apply();
            MainActivity.this.zo();
        }
    }

    public class Htq implements View.OnClickListener {
        public Htq() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.O();
        }
    }

    public class IEE implements View.OnClickListener {
        public final /* synthetic */ TextView mjFkc;

        public IEE(TextView textView) {
            this.mjFkc = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.setText("JC 终端就绪 · 命令经 ADB 通道执行（shell 权限）\n");
        }
    }

    public class IPpyV implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public IPpyV(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.dismiss();
            MainActivity.this.gb();
        }
    }

    public class IVlxe implements Runnable {
        public final /* synthetic */ StringBuilder mjFkc;

        public class mjFkc implements Runnable {
            public final /* synthetic */ String mjFkc;

            public mjFkc(String str) {
                this.mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.T("设备信息", this.mjFkc);
            }
        }

        public IVlxe(StringBuilder sb) {
            this.mjFkc = sb;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException, PackageManager.NameNotFoundException, IOException {
            this.mjFkc.append("═══ 设备基本信息 ═══\n");
            StringBuilder sb = this.mjFkc;
            sb.append("型号: ");
            sb.append(Build.MODEL);
            sb.append("\n");
            StringBuilder sb2 = this.mjFkc;
            sb2.append("品牌: ");
            sb2.append(Build.BRAND);
            sb2.append("\n");
            StringBuilder sb3 = this.mjFkc;
            sb3.append("系统: Android ");
            sb3.append(Build.VERSION.RELEASE);
            sb3.append(" (API ");
            sb3.append(Build.VERSION.SDK_INT);
            sb3.append(")\n");
            StringBuilder sb4 = this.mjFkc;
            sb4.append("安全补丁: ");
            sb4.append(Build.VERSION.SECURITY_PATCH);
            sb4.append("\n");
            StringBuilder sb5 = this.mjFkc;
            sb5.append("序列号: ");
            sb5.append(Build.SERIAL);
            sb5.append("\n");
            String str = Build.FINGERPRINT;
            StringBuilder sb6 = this.mjFkc;
            sb6.append("指纹: ");
            if (str.length() > 60) {
                str = str.substring(0, 60) + "...";
            }
            sb6.append(str);
            sb6.append("\n");
            this.mjFkc.append("\n═══ ZYB 环境 ═══\n");
            try {
                Process processExec = Runtime.getRuntime().exec(new String[]{"getprop", "persist.sys.env_config"});
                String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
                processExec.waitFor();
                StringBuilder sb7 = this.mjFkc;
                sb7.append("环境配置: ");
                if (line == null) {
                    line = "未设置";
                }
                sb7.append(line);
                sb7.append("\n");
            } catch (Exception unused) {
                this.mjFkc.append("环境配置: 读取失败\n");
            }
            this.mjFkc.append("\n═══ ADB 状态 ═══\n");
            String[] strArr = {"adb_enabled", "adb_wifi_enabled", "development_settings_enabled"};
            for (int i = 0; i < 3; i++) {
                String str2 = strArr[i];
                try {
                    Process processExec2 = Runtime.getRuntime().exec(new String[]{"settings", "get", "global", str2});
                    String line2 = new BufferedReader(new InputStreamReader(processExec2.getInputStream())).readLine();
                    processExec2.waitFor();
                    StringBuilder sb8 = this.mjFkc;
                    sb8.append(str2);
                    sb8.append(" = ");
                    sb8.append(line2 != null ? line2.trim() : "?");
                    sb8.append("\n");
                } catch (Exception unused2) {
                    StringBuilder sb9 = this.mjFkc;
                    sb9.append(str2);
                    sb9.append(" = 读取失败\n");
                }
            }
            this.mjFkc.append("\n═══ 设备标识 ═══\n");
            try {
                Cursor cursorQuery = MainActivity.this.getContentResolver().query(Uri.parse("content://com.zuoyebang.iot.oaid"), null, null, null, null);
                if (cursorQuery != null) {
                    this.mjFkc.append("OAID: ");
                    if (cursorQuery.moveToFirst()) {
                        for (int i2 = 0; i2 < Math.min(cursorQuery.getColumnCount(), 3); i2++) {
                            StringBuilder sb10 = this.mjFkc;
                            sb10.append(cursorQuery.getColumnName(i2));
                            sb10.append("=");
                            sb10.append(cursorQuery.getString(i2));
                            sb10.append(" | ");
                        }
                    }
                    StringBuilder sb11 = this.mjFkc;
                    sb11.append(" (");
                    sb11.append(cursorQuery.getCount());
                    sb11.append(" 行)\n");
                    cursorQuery.close();
                } else {
                    this.mjFkc.append("OAID: Provider 返回 null\n");
                }
            } catch (Exception e) {
                StringBuilder sb12 = this.mjFkc;
                sb12.append("OAID: ");
                sb12.append(e.getMessage());
                sb12.append("\n");
            }
            this.mjFkc.append("\n═══ ZYB 进程状态 ═══\n");
            String[] strArr2 = {"com.zuoyebang.padms", "com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.zptcpservice", "com.zuoyebang.iot.pad.appstore", "com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.zp.lib.ota.server"};
            for (int i3 = 0; i3 < 6; i3++) {
                String str3 = strArr2[i3];
                try {
                    MainActivity.this.getPackageManager().getPackageInfo(str3, 0);
                    String strSubstring = str3.substring(str3.lastIndexOf(46) + 1);
                    StringBuilder sb13 = this.mjFkc;
                    sb13.append("✓ ");
                    sb13.append(strSubstring);
                    sb13.append("\n");
                } catch (Exception unused3) {
                    String strSubstring2 = str3.substring(str3.lastIndexOf(46) + 1);
                    StringBuilder sb14 = this.mjFkc;
                    sb14.append("✗ ");
                    sb14.append(strSubstring2);
                    sb14.append(" (未安装)\n");
                }
            }
            MainActivity.this.mjFkc.post(new mjFkc(this.mjFkc.toString()));
        }
    }

    public class IvRQOa implements Runnable {
        public IvRQOa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.gcD();
        }
    }

    public class IyS implements View.OnClickListener {
        public final /* synthetic */ Runnable mjFkc;

        public IyS(Runnable runnable) {
            this.mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.run();
        }
    }

    public class JBhc implements Runnable {

        public class mjFkc implements Runnable {
            public final /* synthetic */ String mjFkc;

            public mjFkc(String str) {
                this.mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.a(true);
                MainActivity.this.T("申请设备所有者", this.mjFkc);
            }
        }

        public JBhc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strBbzow;
            String string;
            ArrayList<String> arrayList = new ArrayList();
            try {
                String strBbzow2 = com.jc.code.v3.mjFkc.bbzow("dumpsys account");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Pattern patternCompile = Pattern.compile("Account \\{name=[^,]*, type=([A-Za-z0-9._]+)\\}");
                String strReplace = BuildConfig.FLAVOR;
                if (strBbzow2 == null) {
                    strBbzow2 = BuildConfig.FLAVOR;
                }
                Matcher matcher = patternCompile.matcher(strBbzow2);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (strGroup != null && strGroup.contains(".")) {
                        linkedHashSet.add(strGroup);
                    }
                }
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("[*] 检测到账号: ");
                sb.append(linkedHashSet.isEmpty() ? "无" : linkedHashSet.toString());
                mainActivity.aQ(sb.toString());
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    try {
                        String strBbzow3 = com.jc.code.v3.mjFkc.bbzow("pm disable-user --user 0 " + str);
                        arrayList.add(str);
                        MainActivity mainActivity2 = MainActivity.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[*] 已临时停用: ");
                        sb2.append(str);
                        sb2.append(" (");
                        sb2.append(strBbzow3 != null ? strBbzow3.trim() : BuildConfig.FLAVOR);
                        sb2.append(")");
                        mainActivity2.aQ(sb2.toString());
                    } catch (Throwable th) {
                        MainActivity.this.aQ("[!] 停用失败: " + str + " - " + MainActivity.mYYU(th));
                    }
                }
                try {
                    strBbzow = com.jc.code.v3.mjFkc.bbzow("CLASSPATH='" + MainActivity.this.getApplicationInfo().sourceDir + "' app_process /system/bin com.jc.code.v3.SetDeviceOwnerAgent 'JC.CODE.V3/com.jc.code.v3.JcDeviceAdminReceiver' 2>&1");
                } catch (Throwable th2) {
                    strBbzow = "错误: " + MainActivity.mYYU(th2);
                }
                MainActivity mainActivity3 = MainActivity.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[*] set-device-owner: ");
                if (strBbzow != null) {
                    strReplace = strBbzow.trim().replace("\n", " | ");
                }
                sb3.append(strReplace);
                mainActivity3.aQ(sb3.toString());
                for (String str2 : arrayList) {
                    try {
                        com.jc.code.v3.mjFkc.bbzow("pm enable " + str2);
                        MainActivity.this.aQ("[*] 已恢复: " + str2);
                    } catch (Throwable th3) {
                        MainActivity.this.aQ("[!] 恢复失败: " + str2 + " - " + MainActivity.mYYU(th3));
                    }
                }
                boolean zKbpP = MainActivity.this.KbpP();
                MainActivity.this.aQ("[*] 本应用是否设备所有者: " + zKbpP);
                if (zKbpP) {
                    string = "✓ 已成为设备所有者！\n现在「安装证书」可静默完成，然后「一键开开发者」全自动。";
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("✗ 未成为设备所有者\n\n命令输出：");
                    sb4.append(strBbzow != null ? strBbzow.trim() : "(空)");
                    string = sb4.toString();
                }
                MainActivity.this.aQ(zKbpP ? "[+] 申请设备所有者成功" : "[!] 申请设备所有者失败");
                MainActivity.this.mjFkc.post(new mjFkc(string));
            } catch (Throwable th4) {
                MainActivity.this.aQ("[!] 流程异常: " + MainActivity.mYYU(th4));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    try {
                        com.jc.code.v3.mjFkc.bbzow("pm enable " + ((String) it2.next()));
                    } catch (Throwable unused) {
                    }
                }
                MainActivity.this.Y("✗ 流程异常: " + MainActivity.mYYU(th4));
            }
        }
    }

    public class JHa implements Runnable {
        public final /* synthetic */ View mjFkc;

        public JHa(View view) {
            this.mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = MainActivity.this.xJ;
            float f = MainActivity.this.getResources().getDisplayMetrics().density;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(8.0f * f);
            gradientDrawable.setColor(z ? -13948117 : -1);
            this.mjFkc.setBackground(gradientDrawable);
            TextView textView = (TextView) this.mjFkc.findViewById(AbstractC1978u4.Pq);
            if (textView != null) {
                textView.setTextColor(z ? -419430401 : -15066598);
            }
            TextView textView2 = (TextView) this.mjFkc.findViewById(AbstractC1978u4.qGY);
            if (textView2 != null) {
                textView2.setTextColor(z ? -419430401 : -15066598);
            }
            EditText editText = (EditText) this.mjFkc.findViewById(AbstractC1978u4.xJ);
            if (editText != null) {
                editText.setTextColor(z ? -419430401 : -15066598);
                editText.setHintTextColor(z ? -1711276033 : -1728053248);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(f * 4.0f);
                gradientDrawable2.setColor(z ? -13816531 : -1);
                gradientDrawable2.setStroke(1, z ? -11908534 : -3026479);
                editText.setBackground(gradientDrawable2);
            }
            TextView textView3 = (TextView) this.mjFkc.findViewById(AbstractC1978u4.mjFkc);
            if (textView3 != null) {
                textView3.setTextColor(z ? -11746561 : -16750656);
            }
            TextView textView4 = (TextView) this.mjFkc.findViewById(AbstractC1978u4.ZfxDd);
            if (textView4 != null) {
                textView4.setTextColor(z ? -16437175 : -1);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(f * 4.0f);
                gradientDrawable3.setColor(z ? -11746561 : -16750656);
                textView4.setBackground(gradientDrawable3);
            }
        }
    }

    public class JOe implements Runnable {
        public final /* synthetic */ String mjFkc;

        public JOe(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("本应用需要联网向服务器确认后才能使用。\n请检查网络后重试。");
            String str2 = this.mjFkc;
            if (str2 == null || str2.length() <= 0) {
                str = BuildConfig.FLAVOR;
            } else {
                str = "\n(" + this.mjFkc + ")";
            }
            sb.append(str);
            mainActivity.H(true, "无法连接验证服务器", sb.toString());
            MainActivity.this.mjFkc.removeCallbacks(MainActivity.this.Vgyli);
            MainActivity.this.mjFkc.postDelayed(MainActivity.this.Vgyli, 30000L);
        }
    }

    public class JYgkl implements Runnable {
        public JYgkl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.olO();
        }
    }

    public class JYn implements Runnable {
        public JYn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.YDiFPt();
        }
    }

    public class Jidt implements Runnable {
        public Jidt() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.UXIO();
        }
    }

    public class Jk implements Runnable {
        public Jk() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.LyQ();
        }
    }

    public class JrJO implements Runnable {
        public JrJO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.khjiU();
        }
    }

    public class KLFTb implements View.OnClickListener {
        public final /* synthetic */ AlertDialog AZxh;
        public final /* synthetic */ Set mjFkc;

        public KLFTb(Set set, AlertDialog alertDialog) {
            this.mjFkc = set;
            this.AZxh = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mjFkc.isEmpty()) {
                MainActivity.this.X("请先选择要卸载的应用");
                return;
            }
            this.AZxh.dismiss();
            Iterator it = this.mjFkc.iterator();
            while (it.hasNext()) {
                MainActivity.this.c0((String) it.next());
            }
            MainActivity.this.Y("正在卸载 " + this.mjFkc.size() + " 个应用...");
        }
    }

    public class KLMXS implements Runnable {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ ScrollView wA;

        public KLMXS(String str, TextView textView, ScrollView scrollView) {
            this.mjFkc = str;
            this.AZxh = textView;
            this.wA = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            MainActivity.this.Ipwl();
            try {
                String strBbzow = com.jc.code.v3.mjFkc.bbzow(this.mjFkc);
                MainActivity mainActivity = MainActivity.this;
                TextView textView = this.AZxh;
                ScrollView scrollView = this.wA;
                StringBuilder sb = new StringBuilder();
                if (strBbzow == null || strBbzow.trim().length() == 0) {
                    strBbzow = "(无输出)";
                }
                sb.append(strBbzow);
                sb.append("\n");
                mainActivity.iEjzEW(textView, scrollView, sb.toString(), -2629912);
            } catch (Throwable th) {
                MainActivity.this.iEjzEW(this.AZxh, this.wA, "✗ " + MainActivity.mYYU(th) + "\n", -1074534);
            }
        }
    }

    public class KRTLGT implements DialogInterface.OnClickListener {
        public final /* synthetic */ CheckBox mjFkc;

        public KRTLGT(CheckBox checkBox) {
            this.mjFkc = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.r(this.mjFkc.isChecked());
        }
    }

    public class KRckQg implements mjFkc.fehf {
        public KRckQg() {
        }

        @Override // com.jc.code.v3.mjFkc.fehf
        public void mjFkc(String str) {
            MainActivity.this.aQ("[ADB] " + str);
        }
    }

    public class KSf implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ String mjFkc;

        public class mjFkc implements DialogInterface.OnClickListener {
            public mjFkc() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public KSf(String str, String str2) {
            this.mjFkc = str;
            this.AZxh = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            String strWfQA = MainActivity.this.wfQA();
            String str2 = this.mjFkc;
            if (str2 == null || str2.length() <= 0) {
                str = BuildConfig.FLAVOR;
            } else {
                str = this.mjFkc + "\n\n";
            }
            String str3 = str + "本机设备码：" + strWfQA + "\n（联系处理时请提供此码）";
            MainActivity.this.N(this.AZxh, str3);
            AlertDialog alertDialogU = MainActivity.this.U(new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setTitle(this.AZxh).setMessage(str3).setPositiveButton("退出", new mjFkc()));
            MainActivity.this.u(alertDialogU, 520.0f);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.l0(alertDialogU, mainActivity.xJ ? -6643546 : -10525848, MainActivity.this.xJ ? -6643546 : -10525848);
            MainActivity.this.UokA(alertDialogU);
        }
    }

    public class LREOK implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText mjFkc;

        public LREOK(EditText editText) {
            this.mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty() || !(strTrim.startsWith("http://") || strTrim.startsWith("https://"))) {
                MainActivity.this.X("请输入合法 URL");
            } else {
                MainActivity.this.Jkjs(strTrim, null, null);
            }
        }
    }

    public class LeWm implements Runnable {
        public LeWm() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://app.aibangos.xyz/Jc.Four")));
            } catch (Exception unused) {
                MainActivity.this.X("无法打开浏览器");
            }
        }
    }

    public class LlB implements Runnable {
        public LlB() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.jeHSg();
        }
    }

    public class LsBneK implements View.OnLongClickListener {
        public LsBneK() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            MainActivity.this.D();
            return true;
        }
    }

    public class MC implements Runnable {
        public final /* synthetic */ File mjFkc;

        public class mjFkc implements Runnable {
            public final /* synthetic */ Bitmap mjFkc;

            public mjFkc(Bitmap bitmap) {
                this.mjFkc = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = MainActivity.this.yX;
                if (imageView != null) {
                    imageView.setImageBitmap(this.mjFkc);
                }
            }
        }

        public MC(File file) {
            this.mjFkc = file;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.aibangos.xyz/tb.png").openConnection();
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();
                if (bitmapDecodeStream != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.mjFkc);
                        bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    MainActivity.this.mjFkc.post(new mjFkc(bitmapDecodeStream));
                }
            } catch (Exception unused2) {
            }
        }
    }

    public class MFekjo implements View.OnClickListener {
        public MFekjo() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.rtBEoQ();
        }
    }

    public class MiMN implements Runnable {
        public final /* synthetic */ boolean AZxh;
        public final /* synthetic */ TextView ZfxDd;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ CompoundButton wA;

        public class mjFkc implements Runnable {
            public final /* synthetic */ boolean mjFkc;

            public mjFkc(boolean z) {
                this.mjFkc = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.mjFkc) {
                    MiMN.this.wA.setTag(Boolean.TRUE);
                    MiMN.this.wA.setChecked(!r0.AZxh);
                    MiMN.this.wA.setTag(null);
                    MainActivity.this.X("✗ 操作失败: " + MiMN.this.mjFkc);
                    return;
                }
                MiMN miMN = MiMN.this;
                TextView textView = miMN.ZfxDd;
                if (textView != null) {
                    textView.setTextColor(miMN.AZxh ? -15171528 : MainActivity.this.xJ ? -1711276033 : -1728053248);
                }
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append(MiMN.this.AZxh ? "✓ 已防卸载: " : "✓ 已解除: ");
                sb.append(MiMN.this.mjFkc);
                mainActivity.X(sb.toString());
                MiMN miMN2 = MiMN.this;
                if (miMN2.AZxh) {
                    MainActivity.this.J();
                }
            }
        }

        public MiMN(String str, boolean z, CompoundButton compoundButton, TextView textView) {
            this.mjFkc = str;
            this.AZxh = z;
            this.wA = compoundButton;
            this.ZfxDd = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) MainActivity.this.getSystemService("device_policy");
                ComponentName componentName = new ComponentName(MainActivity.this, (Class<?>) JcDeviceAdminReceiver.class);
                devicePolicyManager.setUninstallBlocked(componentName, this.mjFkc, this.AZxh);
                if (devicePolicyManager.isUninstallBlocked(componentName, this.mjFkc) == this.AZxh) {
                    z = true;
                }
            } catch (Throwable th) {
                MainActivity.this.aQ("[!] 防卸载失败: " + this.mjFkc + " - " + MainActivity.mYYU(th));
            }
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "[+] " : "[!] ");
            sb.append(this.AZxh ? "防卸载开启: " : "防卸载解除: ");
            sb.append(this.mjFkc);
            mainActivity.aQ(sb.toString());
            MainActivity.this.mjFkc.post(new mjFkc(z));
        }
    }

    public class Moer implements Runnable {

        public class mjFkc implements Runnable {
            public final /* synthetic */ boolean mjFkc;

            public mjFkc(boolean z) {
                this.mjFkc = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.mjFkc) {
                    MainActivity.this.aAlqX();
                } else {
                    MainActivity.this.k0();
                }
            }
        }

        public Moer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zRW = MainActivity.this.RW();
            if (zRW) {
                MainActivity.this.JGvOM();
            }
            MainActivity.this.mjFkc.post(new mjFkc(zRW));
        }
    }

    public class Mpf implements Runnable {
        public Mpf() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.OGo();
        }
    }

    public class NKyg implements Runnable {
        public NKyg() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gjvQ gjvqUAgKP;
            String str;
            try {
                try {
                } catch (Exception e) {
                    MainActivity.this.aQ("[!] 自动配对异常: " + e.getMessage());
                }
                if (MainActivity.this.RW()) {
                    MainActivity.this.aQ("[*] 监听配对码中（最多 60 秒），请在系统页面点击「使用配对码配对设备」...");
                    long jCurrentTimeMillis = System.currentTimeMillis() + DurationKt.MILLIS_IN_MINUTE;
                    while (MainActivity.this.yfx && System.currentTimeMillis() < jCurrentTimeMillis) {
                        if (com.jc.code.v3.mjFkc.NPj() || com.jc.code.v3.mjFkc.xrEuO()) {
                            MainActivity.this.aQ("[*] ADB 已连接，停止监听配对码");
                            break;
                        }
                        Thread.sleep(1800L);
                        String strJxC = MainActivity.this.jxC("rm -f /data/local/tmp/jc_pair_ui.xml; timeout 8 uiautomator dump /data/local/tmp/jc_pair_ui.xml >/dev/null 2>&1; cat /data/local/tmp/jc_pair_ui.xml");
                        if (strJxC != null && strJxC.indexOf("<hierarchy") >= 0) {
                            try {
                                List listEaLbDP = MainActivity.EaLbDP(strJxC);
                                if (!listEaLbDP.isEmpty() && (gjvqUAgKP = MainActivity.uAgKP(listEaLbDP)) != null && gjvqUAgKP.mjFkc != null) {
                                    String strUhQ = MainActivity.uhQ(listEaLbDP);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(gjvqUAgKP.mjFkc);
                                    if (strUhQ != null) {
                                        str = " " + strUhQ;
                                    } else {
                                        str = BuildConfig.FLAVOR;
                                    }
                                    sb.append(str);
                                    String string = sb.toString();
                                    MainActivity.this.GmK(string);
                                    MainActivity.this.IVlxe = gjvqUAgKP.mjFkc;
                                    MainActivity.this.Moer = strUhQ;
                                    MainActivity.this.aQ("[+] 识别到配对码: " + string + "，开始自动配对");
                                    MainActivity.this.C0("已识别配对码，正在自动配对…", true);
                                    MainActivity.this.e();
                                    MainActivity.this.o0(gjvqUAgKP.mjFkc);
                                }
                            } catch (Exception unused) {
                                continue;
                            }
                        }
                    }
                    if (!com.jc.code.v3.mjFkc.NPj() && !com.jc.code.v3.mjFkc.xrEuO()) {
                        MainActivity.this.aQ("[!] 自动配对超时：未识别到配对码");
                        MainActivity.this.s0("自动配对超时，未识别到配对码");
                    }
                } else {
                    MainActivity.this.aQ("[!] 自动配对需要 Root 权限：读取系统页面并自动填写配对码");
                    MainActivity.this.s0("自动配对需要 Root 权限");
                }
            } finally {
                MainActivity.this.yfx = false;
            }
        }
    }

    public class NPj implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ Boolean mjFkc;

        public NPj(Boolean bool, String str) {
            this.mjFkc = bool;
            this.AZxh = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Boolean bool = this.mjFkc;
            if (bool != null) {
                MainActivity.this.v(bool.booleanValue());
                MainActivity.this.CrDc(true);
            }
            if (this.AZxh.startsWith("✓")) {
                MainActivity.this.Y(this.AZxh);
            } else {
                MainActivity.this.X(this.AZxh);
            }
            Boolean bool2 = this.mjFkc;
            if (bool2 == null || !bool2.booleanValue()) {
                return;
            }
            MainActivity.this.U(new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setTitle("已停用 PadMS · 重要提醒").setMessage("已停用 PadMS，本次开机期间系统不会再删除第三方应用。\n\n⚠ 但保护只在本次开机有效：系统每次开机时 PadMS 都会自动扫描并删除黑名单应用，重启 / 关机后保护即失效。\n\n· 每次开机后可再点一次「阻止系统删应用」重新停用\n· 如需重启后依然不被删除，请用「单独应用防卸载」，保护重启后仍有效\n\n重要资料请提前备份。").setPositiveButton("我知道了", (DialogInterface.OnClickListener) null));
        }
    }

    public class NV implements Runnable {
        public NV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.ilrRDI();
        }
    }

    public class Ne implements Runnable {
        public Ne() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.rKxis();
        }
    }

    public class OjSQV implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public OjSQV(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.q("pm enable " + str, this.mjFkc, this.AZxh);
        }
    }

    public class Otxclu implements Runnable {
        public final /* synthetic */ AlertDialog mjFkc;

        public Otxclu(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView;
            boolean z = MainActivity.this.xJ;
            int i = z ? -1842205 : -14737633;
            int i2 = z ? -3552047 : -12302522;
            int i3 = z ? -5919253 : -10589486;
            try {
                TextView textView2 = (TextView) this.mjFkc.findViewById(E4.xJ);
                if (textView2 != null) {
                    textView2.setTextColor(i);
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                    textView2.setTextSize(19.0f);
                }
            } catch (Exception unused) {
            }
            int identifier = MainActivity.this.getResources().getIdentifier("alertTitle", "id", "android");
            if (identifier > 0 && (textView = (TextView) this.mjFkc.findViewById(identifier)) != null) {
                textView.setTextColor(i);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextSize(19.0f);
            }
            TextView textView3 = (TextView) this.mjFkc.findViewById(R.id.message);
            if (textView3 != null) {
                textView3.setTextColor(i2);
                textView3.setTextSize(15.0f);
                textView3.setLineSpacing(2.0f, 1.0f);
            }
            int[] iArr = {R.id.button1, R.id.button2, R.id.button3};
            for (int i4 = 0; i4 < 3; i4++) {
                TextView textView4 = (TextView) this.mjFkc.findViewById(iArr[i4]);
                if (textView4 != null) {
                    textView4.setTextColor(i3);
                    textView4.setTypeface(Typeface.DEFAULT_BOLD);
                    textView4.setAllCaps(false);
                }
            }
            try {
                int identifier2 = MainActivity.this.getResources().getIdentifier("select_dialog_listview", "id", "android");
                if (identifier2 == 0) {
                    identifier2 = R.id.list;
                }
                ListView listView = (ListView) this.mjFkc.findViewById(identifier2);
                if (listView != null) {
                    for (int i5 = 0; i5 < listView.getChildCount(); i5++) {
                        View childAt = listView.getChildAt(i5);
                        if (childAt instanceof TextView) {
                            ((TextView) childAt).setTextColor(i2);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            MainActivity.this.x(this.mjFkc.getWindow().getDecorView(), z);
        }
    }

    public class OzIs implements View.OnClickListener {
        public final /* synthetic */ xVYW AZxh;
        public final /* synthetic */ AlertDialog[] mjFkc;

        public OzIs(AlertDialog[] alertDialogArr, xVYW xvyw) {
            this.mjFkc = alertDialogArr;
            this.AZxh = xvyw;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog = this.mjFkc[0];
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.AZxh.KLFTb.run();
        }
    }

    public class Pq implements View.OnClickListener {
        public final /* synthetic */ boolean[] AZxh;
        public final /* synthetic */ ScrollView[] ZfxDd;
        public final /* synthetic */ EditText mjFkc;
        public final /* synthetic */ TextView[] wA;

        public Pq(EditText editText, boolean[] zArr, TextView[] textViewArr, ScrollView[] scrollViewArr) {
            this.mjFkc = editText;
            this.AZxh = zArr;
            this.wA = textViewArr;
            this.ZfxDd = scrollViewArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.mjFkc.setText(BuildConfig.FLAVOR);
            if (this.AZxh[0]) {
                MainActivity.this.m(strTrim, this.wA[0], this.ZfxDd[0]);
            } else {
                MainActivity.this.q(strTrim, this.wA[0], this.ZfxDd[0]);
            }
        }
    }

    public class Qr implements Runnable {
        public Qr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.Qs()) {
                MainActivity.this.s0("请点「使用配对码配对设备」");
            }
        }
    }

    public class QyMqpM implements Runnable {
        public QyMqpM() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strSubstring;
            View view = MainActivity.this.uH;
            if (view == null || view.getParent() == null) {
                String strSubstring2 = MainActivity.this.tISON;
                int iIndexOf = strSubstring2.indexOf("||");
                if (iIndexOf >= 0) {
                    strSubstring = strSubstring2.substring(0, iIndexOf);
                    strSubstring2 = strSubstring2.substring(iIndexOf + 2);
                } else {
                    strSubstring = "已锁定";
                }
                MainActivity.this.N(strSubstring, strSubstring2);
            }
        }
    }

    public class QyqF implements Runnable {
        public final /* synthetic */ qtZIjO mjFkc;

        public QyqF(qtZIjO qtzijo) {
            this.mjFkc = qtzijo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.Dt) {
                this.mjFkc.KLFTb.run();
                return;
            }
            if (this.mjFkc.lgHUyS && MainActivity.this.RV()) {
                this.mjFkc.KLFTb.run();
                return;
            }
            if (MainActivity.this.kgk()) {
                MainActivity.this.K(this.mjFkc.mjFkc);
                return;
            }
            MainActivity.this.aQ("[!] " + this.mjFkc.mjFkc + " 需 zybos 绑定，当前未连接");
            new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setTitle(this.mjFkc.mjFkc + " 暂不可用").setMessage("该功能依赖 zybos 服务绑定，当前尚未连接。\n\n可先到「设备信息」页执行一键探测，绑定成功后此功能自动恢复可用。").setPositiveButton("知道了", (DialogInterface.OnClickListener) null).show();
        }
    }

    public class RWb implements View.OnClickListener {
        public RWb() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("JC Code V3 Log", MainActivity.this.MiMN.toString()));
            MainActivity.this.X("✓ 日志已复制到剪贴板");
        }
    }

    public class RWyiuY implements Runnable {
        public RWyiuY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.W();
        }
    }

    public class Rc implements DownloadListener {
        public Rc() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            MainActivity.this.aQ("[*] 浏览器下载请求: " + str + " (" + str4 + ")");
            if (MainActivity.this.gGFLGZ(str, str3, str4)) {
                MainActivity.this.vEiZJ(str);
                return;
            }
            if (MainActivity.this.EqDGZ(str, str3, str4)) {
                MainActivity.this.pCk(str);
                return;
            }
            MainActivity.this.X("非 APK 下载，未拦截: " + str);
        }
    }

    public class Rsp implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText mjFkc;

        public Rsp(EditText editText) {
            this.mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.mjFkc.getText().toString().trim();
            SharedPreferences.Editor editorEdit = MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit();
            if (strTrim.isEmpty()) {
                strTrim = "JC Code 搜索";
            }
            editorEdit.putString("search_title", strTrim).apply();
            MainActivity.this.X("搜索页标题已更新");
        }
    }

    public class SKTn extends WebChromeClient {
        public SKTn() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (MainActivity.this.KLMXS == null || str == null || str.isEmpty() || str.contains("://")) {
                return;
            }
            MainActivity.this.aQ("[*] 页面标题: " + str);
        }
    }

    public class SOS implements Runnable {
        public SOS() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.Qs()) {
                MainActivity.this.yfx = true;
                MainActivity.this.s0("请点「使用配对码配对设备」，配对码出现后自动完成");
                MainActivity.this.j0();
            }
        }
    }

    public class SmIWf implements ScreenCaptureService.JHa {

        public class AZxh implements Runnable {
            public final /* synthetic */ boolean AZxh;
            public final /* synthetic */ String mjFkc;

            public AZxh(String str, boolean z) {
                this.mjFkc = str;
                this.AZxh = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.aQ("[OCR] " + this.mjFkc);
                if (this.AZxh) {
                    return;
                }
                MainActivity.this.s0(this.mjFkc);
            }
        }

        public class mjFkc implements Runnable {
            public final /* synthetic */ String AZxh;
            public final /* synthetic */ String mjFkc;

            public mjFkc(String str, String str2) {
                this.mjFkc = str;
                this.AZxh = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append(this.mjFkc);
                if (this.AZxh != null) {
                    str = " " + this.AZxh;
                } else {
                    str = BuildConfig.FLAVOR;
                }
                sb.append(str);
                String string = sb.toString();
                MainActivity.this.GmK(string);
                MainActivity.this.IVlxe = this.mjFkc;
                MainActivity.this.Moer = this.AZxh;
                MainActivity.this.aQ("[OCR] 识别到配对码: " + string + "，开始自动配对");
                MainActivity.this.C0("已识别配对码，正在自动配对…", true);
                MainActivity.this.e();
                MainActivity.this.o0(this.mjFkc);
            }
        }

        public SmIWf() {
        }

        @Override // com.jc.code.v3.ScreenCaptureService.JHa
        public void AZxh(String str, String str2) {
            MainActivity.this.mjFkc.post(new mjFkc(str, str2));
        }

        @Override // com.jc.code.v3.ScreenCaptureService.JHa
        public void mjFkc(String str, boolean z) {
            MainActivity.this.mjFkc.post(new AZxh(str, z));
        }
    }

    public class SwgkN implements DialogInterface.OnClickListener {
        public SwgkN() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.l();
        }
    }

    public class Sx implements Runnable {
        public final /* synthetic */ ImageView mjFkc;

        public Sx(ImageView imageView) {
            this.mjFkc = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mjFkc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mjFkc.getParent()).removeView(this.mjFkc);
            }
        }
    }

    public class TFbkuO implements Runnable {
        public final /* synthetic */ View mjFkc;

        public TFbkuO(View view) {
            this.mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.tjSezt = true;
            this.mjFkc.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(400L).setInterpolator(new PathInterpolator(0.16f, 1.0f, 0.3f, 1.0f)).start();
            MainActivity.this.y0();
        }
    }

    public class TvfBiy implements Runnable {
        public final /* synthetic */ View mjFkc;

        public TvfBiy(View view) {
            this.mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mjFkc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mjFkc.getParent()).removeView(this.mjFkc);
            }
        }
    }

    public class Tw implements Runnable {
        public final /* synthetic */ qtZIjO mjFkc;

        public Tw(qtZIjO qtzijo) {
            this.mjFkc = qtzijo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.RV()) {
                this.mjFkc.KLFTb.run();
            } else {
                MainActivity.this.A(this.mjFkc.mjFkc);
            }
        }
    }

    public class UDcil implements Runnable {
        public UDcil() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            MainActivity.this.MQhVKd();
        }
    }

    public class UOnCkw implements PixelCopy.OnPixelCopyFinishedListener {
        public final /* synthetic */ int AZxh;
        public final /* synthetic */ int mjFkc;
        public final /* synthetic */ Bitmap wA;

        public class mjFkc implements Runnable {

            /* renamed from: com.jc.code.v3.MainActivity$UOnCkw$mjFkc$mjFkc, reason: collision with other inner class name */
            public class RunnableC0034mjFkc implements Runnable {
                public final /* synthetic */ Bitmap mjFkc;

                public RunnableC0034mjFkc(Bitmap bitmap) {
                    this.mjFkc = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MainActivity.this.NKyg <= 0) {
                        this.mjFkc.recycle();
                        return;
                    }
                    MainActivity.this.kism = this.mjFkc;
                    MainActivity.this.y0();
                }
            }

            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.NKyg <= 0) {
                    return;
                }
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(UOnCkw.this.wA, Math.max(1, UOnCkw.this.mjFkc / 8), Math.max(1, UOnCkw.this.AZxh / 8), true);
                    UOnCkw uOnCkw = UOnCkw.this;
                    Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, uOnCkw.mjFkc, uOnCkw.AZxh, true);
                    bitmapCreateScaledBitmap.recycle();
                    new Canvas(bitmapCreateScaledBitmap2).drawColor(MainActivity.this.xJ ? -1945433073 : -1930366218);
                    MainActivity.this.mjFkc.post(new RunnableC0034mjFkc(bitmapCreateScaledBitmap2));
                } catch (Exception unused) {
                }
            }
        }

        public UOnCkw(int i, int i2, Bitmap bitmap) {
            this.mjFkc = i;
            this.AZxh = i2;
            this.wA = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i != 0) {
                return;
            }
            new Thread(new mjFkc()).start();
        }
    }

    public class UPU implements Runnable {
        public UPU() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.M();
        }
    }

    public class Ucbh implements Runnable {
        public Ucbh() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.jCFSyK();
        }
    }

    public class VA implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public VA(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.dismiss();
        }
    }

    public class Vdz implements ServiceConnection {
        public final /* synthetic */ ServiceConnection[] AZxh;
        public final /* synthetic */ byte[] mjFkc;

        public class mjFkc implements Runnable {
            public final /* synthetic */ IBinder mjFkc;

            public mjFkc(IBinder iBinder) {
                this.mjFkc = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity;
                ServiceConnection serviceConnection;
                Method method;
                Object objInvoke;
                try {
                    try {
                        method = null;
                        objInvoke = Class.forName("android.security.IKeyChainService$Stub").getMethod("asInterface", IBinder.class).invoke(null, this.mjFkc);
                        Method[] methods = objInvoke.getClass().getMethods();
                        int length = methods.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Method method2 = methods[i];
                            if (method2.getName().equals("installCaCertificate") && method2.getParameterTypes().length == 1) {
                                method = method2;
                                break;
                            }
                            i++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (th.getCause() != null) {
                                th = th.getCause();
                            }
                            MainActivity.this.aQ("[!] CA 静默安装失败: " + th);
                            MainActivity.this.iBHnK();
                            Vdz vdz = Vdz.this;
                            mainActivity = MainActivity.this;
                            serviceConnection = vdz.AZxh[0];
                        } finally {
                            try {
                                Vdz vdz2 = Vdz.this;
                                MainActivity.this.unbindService(vdz2.AZxh[0]);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (method == null) {
                        MainActivity.this.aQ("[!] installCaCertificate 方法不存在");
                        MainActivity.this.iBHnK();
                        try {
                            Vdz vdz3 = Vdz.this;
                            MainActivity.this.unbindService(vdz3.AZxh[0]);
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    Object objInvoke2 = method.invoke(objInvoke, Vdz.this.mjFkc);
                    MainActivity.this.aQ("[+] CA 已静默装入用户证书库 (alias=" + objInvoke2 + ")");
                    MainActivity.this.Y("✓ CA 证书已安装");
                    Vdz vdz4 = Vdz.this;
                    mainActivity = MainActivity.this;
                    serviceConnection = vdz4.AZxh[0];
                    mainActivity.unbindService(serviceConnection);
                } catch (Throwable unused3) {
                }
            }
        }

        public Vdz(byte[] bArr, ServiceConnection[] serviceConnectionArr) {
            this.mjFkc = bArr;
            this.AZxh = serviceConnectionArr;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new Thread(new mjFkc(iBinder), "jc-ca-bind").start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class VfB implements Runnable {
        public final /* synthetic */ int mjFkc;

        public VfB(int i) {
            this.mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.p0(this.mjFkc, true);
        }
    }

    public class Vgyli implements Runnable {
        public Vgyli() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.PX();
        }
    }

    public class Vnb implements Runnable {
        public final /* synthetic */ int mjFkc;

        public Vnb(int i) {
            this.mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.mjFkc == 0 ? "停用 PadMS" : "恢复 PadMS";
            MainActivity.this.aQ("\n[*] " + str + " (ADB)...");
            try {
                String strBbzow = com.jc.code.v3.mjFkc.bbzow(this.mjFkc == 0 ? "pm disable-user --user 0 com.zuoyebang.padms ; am force-stop com.zuoyebang.padms" : "pm enable com.zuoyebang.padms");
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("[*] ");
                sb.append(strBbzow != null ? strBbzow.trim().replace("\n", " | ") : BuildConfig.FLAVOR);
                mainActivity.aQ(sb.toString());
                String strBbzow2 = com.jc.code.v3.mjFkc.bbzow("pm list packages -d com.zuoyebang.padms");
                boolean z = true;
                boolean z2 = strBbzow2 != null && strBbzow2.contains("com.zuoyebang.padms");
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("padms_disabled", z2).apply();
                if ((this.mjFkc == 0) != z2) {
                    z = false;
                }
                MainActivity mainActivity2 = MainActivity.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z ? "[+] " : "[!] ");
                sb2.append(str);
                sb2.append(z ? "成功" : "未生效");
                sb2.append("，当前状态: ");
                sb2.append(z2 ? "已停用" : "运行中");
                mainActivity2.aQ(sb2.toString());
                String str2 = "✗ 未生效，请重试";
                if (this.mjFkc == 0) {
                    if (z2) {
                        str2 = "✓ 已停用 PadMS，系统不再删除第三方应用";
                    }
                } else if (!z2) {
                    str2 = "✓ PadMS 已恢复";
                }
                MainActivity.this.niM(Boolean.valueOf(z2), str2);
            } catch (Throwable th) {
                MainActivity.this.aQ("[!] " + str + " 失败: " + MainActivity.mYYU(th));
                MainActivity.this.PvPg(th);
                MainActivity.this.niM(null, "✗ " + str + "失败: " + MainActivity.mYYU(th));
            }
        }
    }

    public class VocHEe implements kw {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ boolean mjFkc;
        public final /* synthetic */ ScrollView wA;

        public VocHEe(boolean z, TextView textView, ScrollView scrollView) {
            this.mjFkc = z;
            this.AZxh = textView;
            this.wA = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length < 2) {
                MainActivity.this.X("格式：包名 权限名");
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("set-permission-grant-state ");
            sb.append(strArrSplit[0]);
            sb.append(" ");
            sb.append(strArrSplit[1]);
            sb.append(" ");
            sb.append(this.mjFkc ? "granted" : "denied");
            mainActivity.m(sb.toString(), this.AZxh, this.wA);
        }
    }

    public class Vptz implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ boolean JHa;
        public final /* synthetic */ boolean KLFTb;
        public final /* synthetic */ String ZfxDd;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ String wA;

        public class AZxh implements View.OnClickListener {
            public final /* synthetic */ AlertDialog[] AZxh;
            public final /* synthetic */ String[] mjFkc;

            public AZxh(String[] strArr, AlertDialog[] alertDialogArr) {
                this.mjFkc = strArr;
                this.AZxh = alertDialogArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.qbGbxJ(this.mjFkc, this.AZxh[0]);
            }
        }

        public class mjFkc extends ViewOutlineProvider {
            public final /* synthetic */ float mjFkc;

            public mjFkc(float f) {
                this.mjFkc = f;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.mjFkc * 16.0f);
            }
        }

        public Vptz(String str, String str2, String str3, String str4, boolean z, boolean z2) {
            this.mjFkc = str;
            this.AZxh = str2;
            this.wA = str3;
            this.ZfxDd = str4;
            this.KLFTb = z;
            this.JHa = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            char c;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            String str = this.mjFkc;
            char c2 = 0;
            int i = 1;
            boolean z = str != null && str.trim().length() > 0;
            String str2 = this.AZxh;
            boolean z2 = str2 != null && str2.trim().length() > 0;
            if (z || z2) {
                float fMz = MainActivity.this.mz();
                boolean z3 = MainActivity.this.xJ;
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(1);
                int i2 = (int) (22.0f * fMz);
                int i3 = (int) (20.0f * fMz);
                linearLayout.setPadding(i2, i3, i2, i3);
                TextView textView = new TextView(MainActivity.this);
                String str3 = this.wA;
                textView.setText((str3 == null || str3.length() == 0) ? "公告" : this.wA);
                textView.setTextSize(18.0f);
                textView.setTypeface(Typeface.create("sans-serif", 1));
                textView.setLetterSpacing(0.02f);
                textView.setTextColor(z3 ? -1842205 : -14737633);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                View view = new View(MainActivity.this);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(2.0f * fMz);
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable.setColors(new int[]{-10589486, -13916000});
                view.setBackground(gradientDrawable);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (40.0f * fMz), (int) (3.0f * fMz));
                int i4 = (int) (10.0f * fMz);
                layoutParams.topMargin = i4;
                int i5 = (int) (fMz * 14.0f);
                layoutParams.bottomMargin = i5;
                linearLayout.addView(view, layoutParams);
                LinearLayout linearLayout2 = new LinearLayout(MainActivity.this);
                linearLayout2.setOrientation(1);
                if (z) {
                    TextView textView2 = new TextView(MainActivity.this);
                    textView2.setText(this.mjFkc);
                    textView2.setTextSize(13.5f);
                    textView2.setLineSpacing(fMz * 4.0f, 1.0f);
                    textView2.setTextColor(z3 ? -3616036 : -12302522);
                    linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
                }
                if (z2) {
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setVisibility(8);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    linearLayout2.addView(imageView, new LinearLayout.LayoutParams(-1, (int) (170.0f * fMz)));
                    imageView.setOutlineProvider(new mjFkc(fMz));
                    imageView.setClipToOutline(true);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    if (z) {
                        marginLayoutParams.topMargin = i5;
                    }
                    MainActivity.this.bXx(this.AZxh.trim(), imageView);
                }
                ScrollView scrollView = new ScrollView(MainActivity.this);
                scrollView.setVerticalScrollBarEnabled(false);
                scrollView.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (290.0f * fMz));
                layoutParams2.bottomMargin = (int) (fMz * 4.0f);
                linearLayout.addView(scrollView, layoutParams2);
                List<String[]> listBzZHlx = MainActivity.this.bzZHlx(this.ZfxDd);
                Iterator it = listBzZHlx.iterator();
                boolean z4 = false;
                while (true) {
                    c = 3;
                    if (!it.hasNext()) {
                        break;
                    } else if ("1".equals(((String[]) it.next())[3])) {
                        z4 = true;
                    }
                }
                if (!z4 && this.KLFTb) {
                    listBzZHlx.add(new String[]{"关闭", "close", BuildConfig.FLAVOR, "1"});
                }
                AlertDialog[] alertDialogArr = new AlertDialog[1];
                for (String[] strArr : listBzZHlx) {
                    TextView textView3 = new TextView(MainActivity.this);
                    textView3.setText(strArr[c2]);
                    textView3.setTextSize(14.0f);
                    textView3.setTypeface(Typeface.DEFAULT_BOLD);
                    textView3.setGravity(17);
                    float f = 16.0f * fMz;
                    int i6 = (int) f;
                    int i7 = (int) (fMz * 13.0f);
                    textView3.setPadding(i6, i7, i6, i7);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(f);
                    if ("1".equals(strArr[c])) {
                        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
                        gradientDrawable2.setColors(new int[]{-10589486, -13916000});
                        textView3.setTextColor(-1);
                    } else {
                        gradientDrawable2.setColor(z3 ? -14275018 : -986121);
                        gradientDrawable2.setStroke(Math.max(i, (int) fMz), z3 ? -12959156 : -1972757);
                        textView3.setTextColor(z3 ? -3550500 : -13682107);
                    }
                    textView3.setBackground(gradientDrawable2);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams3.topMargin = i4;
                    linearLayout.addView(textView3, layoutParams3);
                    textView3.setOnClickListener(new AZxh(strArr, alertDialogArr));
                    c2 = 0;
                    i = 1;
                    c = 3;
                }
                AlertDialog alertDialogU = MainActivity.this.U(new AlertDialog.Builder(MainActivity.this, S4.mjFkc).setView(linearLayout));
                MainActivity.this.u(alertDialogU, 580.0f);
                if (!this.JHa) {
                    MainActivity.this.UokA(alertDialogU);
                }
                alertDialogArr[0] = alertDialogU;
            }
        }
    }

    public class Vu implements Runnable {
        public Vu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.O();
        }
    }

    public class WGXroI implements DialogInterface.OnClickListener {
        public WGXroI() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.k();
        }
    }

    public class WrLQs implements Runnable {
        public WrLQs() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.CrDc(true);
            MainActivity.this.a(true);
        }
    }

    public class XD implements Runnable {
        public XD() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.YoKzxo != null) {
                MainActivity.this.YoKzxo.setText(MainActivity.this.MiMN.toString());
                if (MainActivity.this.rkYL != null) {
                    MainActivity.this.rkYL.fullScroll(130);
                }
            }
        }
    }

    public class XDdeP implements View.OnClickListener {
        public XDdeP() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.xrEuO.canGoBack()) {
                MainActivity.this.xrEuO.goBack();
            }
        }
    }

    public class XFUzSY implements Runnable {
        public final /* synthetic */ File AZxh;
        public final /* synthetic */ String mjFkc;

        public class mjFkc implements Runnable {
            public final /* synthetic */ Socket mjFkc;

            public mjFkc(Socket socket) {
                this.mjFkc = socket;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0087 A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:2:0x0000, B:3:0x0014, B:5:0x001a, B:8:0x0021, B:11:0x002b, B:13:0x0046, B:14:0x0078, B:16:0x007e, B:17:0x0083, B:19:0x0090, B:18:0x0087), top: B:24:0x0000 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws IOException {
                String line;
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mjFkc.getInputStream()));
                        String line2 = bufferedReader.readLine();
                        do {
                            line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                        } while (line.length() > 0);
                        OutputStream outputStream = this.mjFkc.getOutputStream();
                        if (line2 != null) {
                            if (line2.startsWith("GET /" + XFUzSY.this.mjFkc)) {
                                FileInputStream fileInputStream = new FileInputStream(XFUzSY.this.AZxh);
                                outputStream.write(("HTTP/1.1 200 OK\\r\\nContent-Type: application/vnd.android.package-archive\\r\\nContent-Length: " + XFUzSY.this.AZxh.length() + "\\r\\nConnection: close\\r\\n\\r\\n").getBytes("UTF-8"));
                                byte[] bArr = new byte[PKIFailureInfo.notAuthorized];
                                while (true) {
                                    int i = fileInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        outputStream.write(bArr, 0, i);
                                    }
                                }
                                fileInputStream.close();
                            } else {
                                outputStream.write("HTTP/1.1 404 Not Found\\r\\nConnection: close\\r\\n\\r\\n".getBytes("UTF-8"));
                            }
                        }
                        outputStream.flush();
                        outputStream.close();
                        this.mjFkc.close();
                    } catch (Exception unused) {
                        this.mjFkc.close();
                    }
                } catch (Exception unused2) {
                }
            }
        }

        public XFUzSY(String str, File file) {
            this.mjFkc = str;
            this.AZxh = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (MainActivity.this.qGY != null && !MainActivity.this.qGY.isClosed()) {
                try {
                    new Thread(new mjFkc(MainActivity.this.qGY.accept())).start();
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    public class XV implements Runnable {
        public XV() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            String str;
            try {
                str = MainActivity.this.getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
                str = BuildConfig.FLAVOR;
            }
            if (str == null || !str.startsWith("3.2")) {
                MainActivity.this.giT = true;
                MainActivity.this.Y("正在下载 3.2 个人中心…");
                File fileYRYQP = MainActivity.this.yRYQP("https://app.aibangos.xyz/dgrzx.apk", "/storage/emulated/0/Download/dgrzx_3.2.apk");
                if (fileYRYQP == null) {
                    MainActivity.this.Y("✗ 下载失败，请检查网络");
                    return;
                }
                MainActivity.this.aQ("[+] 3.2 个人中心下载完成，开始安装");
                MainActivity.this.Y("正在安装 3.2 个人中心…");
                MainActivity.this.jIShy(fileYRYQP.getAbsolutePath());
                long jCurrentTimeMillis = System.currentTimeMillis() + 90000;
                while (System.currentTimeMillis() < jCurrentTimeMillis) {
                    try {
                        String str2 = MainActivity.this.getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
                        if (str2 != null && str2.startsWith("3.2")) {
                            MainActivity.this.aQ("[+] 3.2 个人中心已就绪");
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused3) {
                        return;
                    }
                }
                MainActivity.this.aQ("[!] 3.2 个人中心安装未完成");
                MainActivity.this.Y("✗ 安装未完成，请重试");
                return;
            }
            MainActivity.this.HRWx();
            try {
                Thread.sleep(800L);
            } catch (InterruptedException unused4) {
            }
            MainActivity.this.e0();
        }
    }

    public class XbiWeM implements Runnable {
        public final /* synthetic */ Uri mjFkc;

        public class AZxh implements Runnable {
            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.X("本地 APK 已就绪，正在安装...");
            }
        }

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.X("启动本地服务失败");
            }
        }

        public class wA implements Runnable {
            public final /* synthetic */ Exception mjFkc;

            public wA(Exception exc) {
                this.mjFkc = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.X("处理失败: " + this.mjFkc.getMessage());
            }
        }

        public XbiWeM(Uri uri) {
            this.mjFkc = uri;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            String string;
            int columnIndex;
            try {
                Cursor cursorQuery = MainActivity.this.getContentResolver().query(this.mjFkc, null, null, null, null);
                string = (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) ? null : cursorQuery.getString(columnIndex);
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                string = null;
            }
            if (string != null) {
                try {
                    if (string.length() == 0) {
                        string = "local_" + System.currentTimeMillis() + ".apk";
                    }
                } catch (Exception e) {
                    MainActivity.this.aQ("[!] 本地 APK 处理失败: " + e);
                    MainActivity.this.runOnUiThread(new wA(e));
                    return;
                }
            } else {
                string = "local_" + System.currentTimeMillis() + ".apk";
            }
            File file = new File(MainActivity.this.getFilesDir(), "apk_server");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, string);
            InputStream inputStreamOpenInputStream = MainActivity.this.getContentResolver().openInputStream(this.mjFkc);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[PKIFailureInfo.notAuthorized];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
            String strI0 = MainActivity.this.i0(file2);
            if (strI0 == null) {
                MainActivity.this.runOnUiThread(new mjFkc());
                return;
            }
            MainActivity.this.aQ("[*] 本地 APK 服务已启动: " + strI0);
            MainActivity.this.runOnUiThread(new AZxh());
            MainActivity.this.Jkjs(strI0, null, null);
        }
    }

    public class XgAT implements Runnable {
        public XgAT() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.mh(mainActivity.KLMXS.getText().toString());
        }
    }

    public class XtE implements Runnable {
        public XtE() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jc.code.v3.mjFkc.bbzow("settings put global http_proxy :0; settings delete global http_proxy");
            } catch (Throwable unused) {
            }
        }
    }

    public class Xxz implements DialogInterface.OnKeyListener {
        public final /* synthetic */ Dialog mjFkc;

        public Xxz(Dialog dialog) {
            this.mjFkc = dialog;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (MainActivity.this.zvd != null && MainActivity.this.zvd.getVisibility() == 0) {
                MainActivity.this.xIpq(this.mjFkc);
                return true;
            }
            if (MainActivity.this.xrEuO == null || !MainActivity.this.xrEuO.canGoBack()) {
                MainActivity.this.xIpq(this.mjFkc);
                return true;
            }
            MainActivity.this.xrEuO.goBack();
            return true;
        }
    }

    public class XyP implements Runnable {
        public XyP() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("bg_scale", "center").apply();
            MainActivity.this.bVfe();
        }
    }

    public class YoKzxo implements DialogInterface.OnClickListener {
        public YoKzxo() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.Frh();
        }
    }

    public class ZGL implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText mjFkc;

        public ZGL(EditText editText) {
            this.mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            MainActivity.this.jIShy(strTrim);
        }
    }

    public class Zdbk implements Runnable {
        public final /* synthetic */ EditText mjFkc;

        public Zdbk(EditText editText) {
            this.mjFkc = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mjFkc.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.mjFkc, 0);
            }
        }
    }

    public class ZfxDd implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public ZfxDd(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.dismiss();
        }
    }

    public class aDq implements View.OnTouchListener {
        public final /* synthetic */ float mjFkc;

        public aDq(float f) {
            this.mjFkc = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.animate().cancel();
                view.animate().scaleX(0.96f).scaleY(0.96f).translationZ(this.mjFkc * 6.0f).setDuration(90L).start();
                view.performHapticFeedback(1);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.animate().cancel();
            view.animate().scaleX(1.0f).scaleY(1.0f).translationZ(0.0f).setDuration(260L).setInterpolator(new OvershootInterpolator(1.5f)).start();
            return false;
        }
    }

    public class alEkx implements Runnable {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("✓ ADB 权限已断开");
                MainActivity.this.a(true);
            }
        }

        public alEkx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.aQ("\n[*] 断开 ADB 权限...");
            try {
                com.jc.code.v3.mjFkc.JBhc("pkill -f 'jc_adb[_]bridge'");
                MainActivity.this.aQ("[*] 本地 ADB 通道已停止");
            } catch (Throwable th) {
                MainActivity.this.aQ("[*] 停止本地通道: " + MainActivity.mYYU(th));
            }
            try {
                com.jc.code.v3.mjFkc.vI();
                com.jc.code.v3.mjFkc.mByQ(com.jc.code.v3.mjFkc.CqaNbM());
                com.jc.code.v3.AZxh.JHa();
                MainActivity.this.aQ("[*] 配对身份已删除");
            } catch (Throwable th2) {
                MainActivity.this.aQ("[!] 清理配对: " + MainActivity.mYYU(th2));
            }
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
            MainActivity.this.aQ("[+] ADB 权限已断开");
            MainActivity.this.mjFkc.post(new mjFkc());
        }
    }

    public class aqHPIZ implements Runnable {
        public aqHPIZ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.vL();
        }
    }

    public class bWIyu implements Runnable {
        public bWIyu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("bg_scale", "stretch").apply();
            MainActivity.this.bVfe();
        }
    }

    public class bbzow implements Runnable {
        public bbzow() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.FoO();
        }
    }

    public class bc implements Runnable {
        public bc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.XtE) {
                MainActivity.this.vBFMCS();
            } else {
                MainActivity.this.h0(true);
            }
        }
    }

    public class cMLeY implements DialogInterface.OnClickListener {
        public cMLeY() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.Frh();
        }
    }

    public class cdjp implements Runnable {
        public final /* synthetic */ LinearLayout mjFkc;

        public cdjp(LinearLayout linearLayout) {
            this.mjFkc = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mjFkc.setVisibility(8);
        }
    }

    public class dGDT implements TextView.OnEditorActionListener {
        public final /* synthetic */ Runnable AZxh;
        public final /* synthetic */ EditText mjFkc;

        public dGDT(EditText editText, Runnable runnable) {
            this.mjFkc = editText;
            this.AZxh = runnable;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 2 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return true;
            }
            MainActivity.this.KLMXS.setText(strTrim);
            this.AZxh.run();
            return true;
        }
    }

    public class diqgf implements View.OnClickListener {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ TextView JHa;
        public final /* synthetic */ LinearLayout KLFTb;
        public final /* synthetic */ LinearLayout ZfxDd;
        public final /* synthetic */ boolean[] mjFkc;
        public final /* synthetic */ TextView wA;
        public final /* synthetic */ EditText xJ;

        public diqgf(boolean[] zArr, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, EditText editText) {
            this.mjFkc = zArr;
            this.AZxh = textView;
            this.wA = textView2;
            this.ZfxDd = linearLayout;
            this.KLFTb = linearLayout2;
            this.JHa = textView3;
            this.xJ = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc[0] = false;
            MainActivity.this.m0(this.AZxh, true);
            MainActivity.this.m0(this.wA, false);
            this.ZfxDd.setVisibility(0);
            this.KLFTb.setVisibility(8);
            this.JHa.setText("  adb shell · uid 2000");
            this.xJ.setHint("输入 shell 命令...");
        }
    }

    public class dkKKW implements DialogInterface.OnClickListener {
        public final /* synthetic */ String mjFkc;

        public dkKKW(String str) {
            this.mjFkc = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.Jkjs(this.mjFkc, null, null);
        }
    }

    public class dm implements DialogInterface.OnClickListener {
        public dm() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.p();
        }
    }

    public class eEOGOh implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ boolean mjFkc;

        public eEOGOh(boolean z, String str) {
            this.mjFkc = z;
            this.AZxh = str;
        }

        @Override // java.lang.Runnable
        public void run() throws PackageManager.NameNotFoundException {
            if (this.mjFkc) {
                try {
                    MainActivity.this.getPackageManager().getPackageInfo(this.AZxh, 0);
                    MainActivity.this.aQ("[+] 安装成功!");
                    MainActivity.this.Y("✓ 安装成功: " + this.AZxh);
                } catch (Exception unused) {
                    MainActivity.this.aQ("[!] 未检测到安装");
                    MainActivity.this.Y("✗ 未检测到安装结果");
                }
            }
            MainActivity.this.ZlB();
        }
    }

    public class eQ implements View.OnClickListener {
        public eQ() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.xrEuO.canGoForward()) {
                MainActivity.this.xrEuO.goForward();
            }
        }
    }

    public class eyqo implements View.OnClickListener {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ TextView JHa;
        public final /* synthetic */ LinearLayout KLFTb;
        public final /* synthetic */ LinearLayout ZfxDd;
        public final /* synthetic */ boolean[] mjFkc;
        public final /* synthetic */ TextView wA;
        public final /* synthetic */ EditText xJ;

        public eyqo(boolean[] zArr, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, EditText editText) {
            this.mjFkc = zArr;
            this.AZxh = textView;
            this.wA = textView2;
            this.ZfxDd = linearLayout;
            this.KLFTb = linearLayout2;
            this.JHa = textView3;
            this.xJ = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!MainActivity.this.KbpP()) {
                MainActivity.this.X("✗ 未激活设备所有者，请先「申请设备所有者」");
                return;
            }
            this.mjFkc[0] = true;
            MainActivity.this.m0(this.AZxh, false);
            MainActivity.this.m0(this.wA, true);
            this.ZfxDd.setVisibility(8);
            this.KLFTb.setVisibility(0);
            this.JHa.setText("  device-owner · OW");
            this.xJ.setHint("输入 OW 命令（help 查看列表）...");
        }
    }

    public class fFz implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public fFz(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            this.mjFkc.dismiss();
            MainActivity.this.RnaHj(true);
        }
    }

    public class fLidf implements Runnable {
        public final /* synthetic */ StringBuilder mjFkc;

        public fLidf(StringBuilder sb) {
            this.mjFkc = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.T("服务绑定探测", this.mjFkc.toString());
        }
    }

    public class fehf implements View.OnClickListener {
        public final /* synthetic */ Runnable mjFkc;

        public fehf(Runnable runnable) {
            this.mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.run();
        }
    }

    public class gYa implements Runnable {
        public final /* synthetic */ String mjFkc;

        public gYa(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) MainActivity.this.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("ADB 配对码", this.mjFkc));
                }
            } catch (Exception unused) {
            }
        }
    }

    public class giT implements Runnable {
        public final /* synthetic */ int mjFkc;

        public giT(int i) {
            this.mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.Ucbh != null) {
                    MainActivity.this.Ucbh.setProgress(this.mjFkc);
                }
                if (MainActivity.this.diqgf != null) {
                    MainActivity.this.diqgf.setText(this.mjFkc + "%");
                }
                if (MainActivity.this.fehf == null || !MainActivity.this.fehf.isShowing()) {
                    return;
                }
                MainActivity.this.fehf.setProgress(this.mjFkc);
            } catch (Exception unused) {
            }
        }
    }

    public static class gjvQ {
        public final ih AZxh;
        public final String mjFkc;

        public gjvQ(String str, ih ihVar) {
            this.mjFkc = str;
            this.AZxh = ihVar;
        }
    }

    public class gtIJp implements mjFkc.qGY {
        public final /* synthetic */ String mjFkc;

        public class AZxh implements Runnable {

            public class mjFkc implements Runnable {
                public mjFkc() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.BOPu();
                }
            }

            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("adb_paired", true).putBoolean("adb_pairing_verified", true).putString("adb_pairing_id", gtIJp.this.mjFkc).apply();
                MainActivity.this.aQ("[ADB] 自动配对成功，本机 ADB 连接已建立");
                MainActivity.this.s0("ADB 配对成功，安装/卸载已切换为 ADB");
                MainActivity.this.e();
                MainActivity.this.C0("配对成功，安装/卸载已切换为 ADB", false);
                MainActivity.this.mjFkc.postDelayed(new mjFkc(), 3000L);
                MainActivity.this.a(true);
                MainActivity.this.CrDc(true);
            }
        }

        public class mjFkc implements Runnable {
            public final /* synthetic */ String mjFkc;

            public mjFkc(String str) {
                this.mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.aQ("[ADB] " + this.mjFkc);
                MainActivity.this.C0(this.mjFkc, true);
            }
        }

        public class wA implements Runnable {
            public final /* synthetic */ String mjFkc;

            public class mjFkc implements Runnable {
                public mjFkc() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.BOPu();
                }
            }

            public wA(String str) {
                this.mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.aQ("[ADB] " + this.mjFkc);
                MainActivity.this.s0(this.mjFkc);
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
                MainActivity.this.C0("配对失败：" + this.mjFkc, false);
                MainActivity.this.mjFkc.postDelayed(new mjFkc(), 6000L);
                MainActivity.this.e();
            }
        }

        public gtIJp(String str) {
            this.mjFkc = str;
        }

        @Override // com.jc.code.v3.mjFkc.qGY
        public void AZxh() {
            MainActivity.this.mjFkc.post(new AZxh());
        }

        @Override // com.jc.code.v3.mjFkc.qGY
        public void mjFkc(String str) {
            MainActivity.this.mjFkc.post(new mjFkc(str));
        }

        @Override // com.jc.code.v3.mjFkc.qGY
        public void wA(String str) {
            MainActivity.this.mjFkc.post(new wA(str));
        }
    }

    public class gtr implements Runnable {
        public final /* synthetic */ String mjFkc;

        public gtr(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.T("系统能力检测", this.mjFkc);
        }
    }

    public class huTpC implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ ScrollView[] ZfxDd;
        public final /* synthetic */ boolean[] mjFkc;
        public final /* synthetic */ TextView[] wA;

        public huTpC(boolean[] zArr, String str, TextView[] textViewArr, ScrollView[] scrollViewArr) {
            this.mjFkc = zArr;
            this.AZxh = str;
            this.wA = textViewArr;
            this.ZfxDd = scrollViewArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mjFkc[0]) {
                MainActivity.this.Tz(this.AZxh, this.wA[0], this.ZfxDd[0]);
            } else {
                MainActivity.this.prww(this.AZxh, this.wA[0], this.ZfxDd[0]);
            }
        }
    }

    public class jTNPnW implements Runnable {
        public jTNPnW() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.rkYL.fullScroll(130);
        }
    }

    public class jY implements Runnable {
        public jY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.DanUFX();
        }
    }

    public class jm implements Runnable {

        public class AZxh implements Runnable {
            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("✗ 拉起验证页失败，请看运行日志");
            }
        }

        public class KLFTb implements Runnable {
            public KLFTb() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("未捕获到验证请求");
            }
        }

        public class ZfxDd implements Runnable {
            public ZfxDd() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("✗ 请先安装 CA 证书再重试");
            }
        }

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("随便输个密码 → 点确定，自动进开发者");
            }
        }

        public class wA implements Runnable {
            public wA() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Y("✓ 开发者已解锁");
            }
        }

        public jm() {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x014a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws InterruptedException {
            long jCurrentTimeMillis;
            if (!CBEvIj.JHa().Pq(MainActivity.this)) {
                MainActivity.this.aQ("[!] 内置代理启动失败");
                MainActivity.this.Y("✗ 代理启动失败");
                return;
            }
            boolean z = true;
            MainActivity.this.lti = true;
            MainActivity.this.aQ("[+] 内置代理已启动 127.0.0.1:8888");
            MainActivity.this.Ipwl();
            try {
                com.jc.code.v3.mjFkc.bbzow("settings put global http_proxy 127.0.0.1:8888");
                MainActivity.this.aQ("[+] 系统代理已设置 → 127.0.0.1:8888");
            } catch (Throwable th) {
                MainActivity.this.aQ("[!] 设置系统代理失败: " + MainActivity.mYYU(th));
            }
            MainActivity.this.mjFkc.post(new mjFkc());
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.pad.developer.ui.DeveloperModeRequestActivity"));
                intent.addFlags(268435456);
                MainActivity.this.startActivity(intent);
                try {
                    MainActivity.this.aQ("[+] 已拉起开发者验证页（本地 Intent）");
                } catch (Throwable th2) {
                    th = th2;
                    MainActivity.this.aQ("[!] 本地拉起失败: " + MainActivity.mYYU(th) + "，改走 ADB");
                    if (!z) {
                    }
                    jCurrentTimeMillis = System.currentTimeMillis() + 120000;
                    while (System.currentTimeMillis() < jCurrentTimeMillis) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                    if (MainActivity.this.giT) {
                    }
                    if (CBEvIj.JHa().xJ() <= 0) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
            if (!z) {
                MainActivity.this.Ipwl();
                try {
                    com.jc.code.v3.mjFkc.bbzow("am start -n com.zuoyebang.iot.pad.zpusercenter/com.zuoyebang.iot.pad.developer.ui.DeveloperModeRequestActivity");
                    MainActivity.this.aQ("[+] 已拉起开发者验证页（ADB am）");
                } catch (Throwable th4) {
                    MainActivity.this.aQ("[!] 拉起验证页失败: " + MainActivity.mYYU(th4));
                    MainActivity.this.mjFkc.post(new AZxh());
                }
            }
            jCurrentTimeMillis = System.currentTimeMillis() + 120000;
            while (System.currentTimeMillis() < jCurrentTimeMillis && CBEvIj.JHa().xJ() <= 0) {
                Thread.sleep(500L);
            }
            if (MainActivity.this.giT) {
                MainActivity.this.giT = false;
                MainActivity.this.jKf();
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException unused2) {
                }
                MainActivity.this.i();
            }
            if (CBEvIj.JHa().xJ() <= 0) {
                MainActivity.this.jKf();
                MainActivity.this.aQ("[+] 验证响应已改写（403→200），开发者已解锁 ✓");
                MainActivity.this.mjFkc.post(new wA());
            } else if (CBEvIj.JHa().qdMbNW()) {
                MainActivity.this.aQ("[!] TLS 握手失败：CA 证书未安装？请点「安装证书」后重试");
                MainActivity.this.mjFkc.post(new ZfxDd());
            } else {
                MainActivity.this.aQ("[!] 120 秒内未捕获验证请求（可点「清理代理」收尾）");
                MainActivity.this.mjFkc.post(new KLFTb());
            }
        }
    }

    public class jpz implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ String ZfxDd;
        public final /* synthetic */ File mjFkc;
        public final /* synthetic */ boolean wA;

        public jpz(File file, String str, boolean z, String str2) {
            this.mjFkc = file;
            this.AZxh = str;
            this.wA = z;
            this.ZfxDd = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (MainActivity.this.Uj(this.mjFkc, this.AZxh, this.wA, false)) {
                return;
            }
            MainActivity.this.FNhf(this.ZfxDd, this.AZxh, this.wA);
        }
    }

    public class jtz implements View.OnClickListener {
        public final /* synthetic */ Dialog mjFkc;

        public jtz(Dialog dialog) {
            this.mjFkc = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.xIpq(this.mjFkc);
        }
    }

    public class jx implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ String wA;

        public class AZxh implements Runnable {
            public final /* synthetic */ String AZxh;
            public final /* synthetic */ String mjFkc;
            public final /* synthetic */ String wA;

            public AZxh(String str, String str2, String str3) {
                this.mjFkc = str;
                this.AZxh = str2;
                this.wA = str3;
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                jx jxVar = jx.this;
                MainActivity.this.t(jxVar.mjFkc, this.mjFkc, this.AZxh, this.wA);
                MainActivity.this.Y("校验完成，已提交应用商店安装：" + this.AZxh + "（应用商店会自行下载安装包，需再下载一次）");
            }
        }

        public class ZfxDd implements Runnable {
            public final /* synthetic */ String mjFkc;

            public ZfxDd(String str) {
                this.mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.T("下载失败", "无法从该链接下载 APK：\n" + this.mjFkc + "\n\n可能原因：\n· 链接需要登录或特定来源（防盗链）\n· 站点屏蔽了非浏览器请求\n\n建议：用系统浏览器打开该链接下载后，再通过「安装 APK」安装。");
            }
        }

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.T("下载异常", "下载到的文件不是 APK 安装包（可能是网页跳转页或需要登录/特定来源）。\n\n建议：用系统浏览器打开该链接，或改用其他下载源。");
            }
        }

        public class wA implements Runnable {
            public final /* synthetic */ File mjFkc;

            public wA(File file) {
                this.mjFkc = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.mjFkc.exists()) {
                    this.mjFkc.delete();
                    MainActivity.this.aQ("[*] 临时文件已清理");
                }
            }
        }

        public jx(String str, String str2, String str3) {
            this.mjFkc = str;
            this.AZxh = str2;
            this.wA = str3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
        
            r6.flush();
            r6.close();
            r5.close();
            r0.disconnect();
            r15.ZfxDd.aQ("[+] APK 已下载: " + (r10 / 1024) + "KB");
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00ec, code lost:
        
            r0 = new java.io.FileInputStream(r1);
            r4 = new byte[4];
            r5 = r0.read(r4);
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00fb, code lost:
        
            if (r5 != 4) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0101, code lost:
        
            if (r4[0] != 80) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0107, code lost:
        
            if (r4[1] != 75) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0109, code lost:
        
            r0 = r15.AZxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x010b, code lost:
        
            if (r0 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0111, code lost:
        
            if (r0.isEmpty() != false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:
        
            r0 = r15.AZxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0116, code lost:
        
            r0 = r15.ZfxDd.HGlNf(r1);
            r15.ZfxDd.aQ("[+] MD5: " + r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0132, code lost:
        
            r2 = "com.external.apk";
            r3 = r15.wA;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0136, code lost:
        
            if (r3 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            if (r3.isEmpty() != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
        
            r3 = r15.wA;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0141, code lost:
        
            r3 = "JCCodeV3";
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0143, code lost:
        
            r4 = r15.ZfxDd.getPackageManager().getPackageArchiveInfo(r1.getAbsolutePath(), 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0151, code lost:
        
            if (r4 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0153, code lost:
        
            r2 = r4.packageName;
            r5 = r15.wA;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0157, code lost:
        
            if (r5 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x015d, code lost:
        
            if (r5.isEmpty() == false) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0160, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0162, code lost:
        
            r3 = r4.applicationInfo.loadLabel(r15.ZfxDd.getPackageManager()).toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0173, code lost:
        
            r15.ZfxDd.aQ("[!] 解析 APK 信息失败: " + r4.getMessage());
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws IOException {
            long j;
            String strHGlNf;
            String str;
            String string;
            try {
                File externalCacheDir = MainActivity.this.getExternalCacheDir();
                if (externalCacheDir == null) {
                    externalCacheDir = MainActivity.this.getCacheDir();
                }
                File file = new File(externalCacheDir, "url_install_" + System.currentTimeMillis() + ".apk");
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mjFkc).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36 JCCodeV3");
                String str2 = MainActivity.this.rWxwaT;
                if (str2 != null && !str2.isEmpty()) {
                    httpURLConnection.setRequestProperty("Referer", str2);
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 400) {
                    throw new IOException("HTTP " + responseCode);
                }
                long contentLengthLong = httpURLConnection.getContentLengthLong();
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[PKIFailureInfo.notAuthorized];
                j = 0;
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    if (MainActivity.this.mByQ) {
                        fileOutputStream.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        file.delete();
                        throw new IOException("已取消");
                    }
                    fileOutputStream.write(bArr, 0, i);
                    j += i;
                    if (contentLengthLong > 0) {
                        int i2 = (int) ((100 * j) / contentLengthLong);
                        if (i2 > 100) {
                            i2 = 100;
                        }
                        MainActivity.this.A0(i2);
                    }
                }
                MainActivity.this.boLb();
                MainActivity.this.runOnUiThread(new AZxh(strHGlNf, string, str));
                MainActivity.this.mjFkc.postDelayed(new wA(file), 30000L);
                return;
                MainActivity.this.boLb();
                MainActivity.this.aQ("[!] 下载到的不是 APK: " + j + " bytes");
                MainActivity.this.runOnUiThread(new mjFkc());
                file.delete();
            } catch (Exception e) {
                MainActivity.this.aQ("[!] 下载失败: " + e.getMessage());
                MainActivity.this.boLb();
                MainActivity.this.runOnUiThread(new ZfxDd(e.getMessage() != null ? e.getMessage() : "未知错误"));
            }
        }
    }

    public class kOlLW implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public kOlLW(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.dismiss();
            MainActivity.this.FiDh();
        }
    }

    public class kism implements Runnable {
        public final /* synthetic */ String mjFkc;

        public kism(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Toast.makeText(MainActivity.this, this.mjFkc, 0).show();
            } catch (Exception unused) {
            }
        }
    }

    public class knzZ implements Runnable {
        public knzZ() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            MainActivity.this.v0();
        }
    }

    public interface kw {
        void mjFkc(String str);
    }

    public class lB implements DialogInterface.OnClickListener {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public lB(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m("set-keyguard-disabled true", this.mjFkc, this.AZxh);
        }
    }

    public class lgHUyS implements Runnable {
        public final /* synthetic */ String mjFkc;

        public lgHUyS(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (MainActivity.this.z0(this.mjFkc)) {
                return;
            }
            if (!MainActivity.this.Dt || MainActivity.this.qdMbNW == null) {
                MainActivity.this.aQ("[!] 无可用卸载通道：ADB 未连接，zybos 未绑定");
                MainActivity.this.Y("✗ 卸载失败：请先完成无线调试配对");
                return;
            }
            try {
                Method methodCO = MainActivity.this.CO("silentUninstallApk", String.class, Boolean.TYPE);
                if (methodCO != null) {
                    methodCO.invoke(MainActivity.this.lgHUyS, this.mjFkc, Boolean.FALSE);
                    MainActivity.this.aQ("[+] 卸载调用成功: " + this.mjFkc);
                } else {
                    MainActivity.this.aQ("[!] silentUninstallApk 未找到");
                    MainActivity.this.X("✗ silentUninstallApk 方法未找到");
                }
            } catch (Exception e) {
                MainActivity.this.aQ("[!] 卸载失败: " + this.mjFkc + " - " + MainActivity.mYYU(e));
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("✗ 卸载失败: ");
                sb.append(MainActivity.mYYU(e));
                mainActivity.X(sb.toString());
            }
        }
    }

    public class lti implements View.OnTouchListener {
        public final /* synthetic */ float mjFkc;

        public lti(float f) {
            this.mjFkc = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                MainActivity.this.wJVbdd = false;
                MainActivity.this.vI = motionEvent.getRawX();
                MainActivity.this.VocHEe = motionEvent.getRawY();
                MainActivity mainActivity = MainActivity.this;
                mainActivity.BAnRFn = mainActivity.Gd >= 0 ? MainActivity.this.Gd : 0.0f;
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.lB = mainActivity2.HGpJ >= 0 ? MainActivity.this.HGpJ : 0.0f;
                return true;
            }
            if (actionMasked == 1) {
                if (!MainActivity.this.wJVbdd) {
                    MainActivity.this.t0();
                }
                return true;
            }
            if (actionMasked != 2) {
                return false;
            }
            float rawX = motionEvent.getRawX() - MainActivity.this.vI;
            float rawY = motionEvent.getRawY() - MainActivity.this.VocHEe;
            if (Math.abs(rawX) > this.mjFkc * 8.0f || Math.abs(rawY) > this.mjFkc * 8.0f) {
                MainActivity.this.wJVbdd = true;
            }
            if (MainActivity.this.wJVbdd && MainActivity.this.IEE != null && MainActivity.this.Pq != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) MainActivity.this.Pq.getLayoutParams();
                layoutParams.x = (int) (MainActivity.this.BAnRFn + rawX);
                layoutParams.y = (int) (MainActivity.this.lB + rawY);
                MainActivity.this.Gd = layoutParams.x;
                MainActivity.this.HGpJ = layoutParams.y;
                try {
                    MainActivity.this.IEE.updateViewLayout(MainActivity.this.Pq, layoutParams);
                } catch (Exception unused) {
                }
            }
            return true;
        }
    }

    public class mByQ implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public mByQ(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.q("pm disable-user --user 0 " + str + " && am force-stop " + str, this.mjFkc, this.AZxh);
        }
    }

    public class mPWV implements DialogInterface.OnClickListener {
        public final /* synthetic */ String mjFkc;

        public mPWV(String str) {
            this.mjFkc = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.Jkjs(this.mjFkc, null, null);
        }
    }

    public class mjFkc implements Runnable {
        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.C();
        }
    }

    public class mzUGzO implements Runnable {
        public final /* synthetic */ String mjFkc;

        public mzUGzO(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("device_code", this.mjFkc));
            MainActivity.this.X("设备码已复制: " + this.mjFkc);
        }
    }

    public class nUaNy implements Runnable {
        public nUaNy() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.HBzZAD(com.jc.code.v3.mjFkc.uHVRx(), MainActivity.this.KbpP(), true);
        }
    }

    public class np implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ String mjFkc;

        public class AZxh implements View.OnClickListener {
            public AZxh() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public class mjFkc implements View.OnTouchListener {
            public mjFkc() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public np(String str, String str2) {
            this.mjFkc = str;
            this.AZxh = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing()) {
                return;
            }
            MainActivity.this.tISON = this.mjFkc + "||" + this.AZxh;
            MainActivity.this.d();
            float fMz = MainActivity.this.mz();
            boolean z = MainActivity.this.xJ;
            FrameLayout frameLayout = new FrameLayout(MainActivity.this);
            frameLayout.setBackgroundColor(z ? -15460839 : -723207);
            frameLayout.setClickable(true);
            frameLayout.setFocusable(true);
            frameLayout.setOnTouchListener(new mjFkc());
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            int i = (int) (32.0f * fMz);
            linearLayout.setPadding(i, i, i, i);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 17));
            TextView textView = new TextView(MainActivity.this);
            textView.setText("!");
            textView.setTextSize(26.0f);
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView.setTypeface(typeface);
            textView.setTextColor(-1);
            textView.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-2543579);
            textView.setBackground(gradientDrawable);
            int i2 = (int) (52.0f * fMz);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(i2, i2));
            TextView textView2 = new TextView(MainActivity.this);
            textView2.setText(this.mjFkc);
            textView2.setTextSize(18.0f);
            textView2.setTypeface(typeface);
            textView2.setTextColor(z ? -1842205 : -14737633);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (18.0f * fMz);
            linearLayout.addView(textView2, layoutParams);
            TextView textView3 = new TextView(MainActivity.this);
            textView3.setText(this.AZxh);
            textView3.setTextSize(13.0f);
            textView3.setTextColor(z ? -6643546 : -10525848);
            textView3.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = (int) (10.0f * fMz);
            linearLayout.addView(textView3, layoutParams2);
            TextView textView4 = new TextView(MainActivity.this);
            textView4.setText("退出");
            textView4.setTextSize(14.0f);
            textView4.setTextColor(z ? -6643546 : -10525848);
            textView4.setGravity(17);
            int i3 = (int) (28.0f * fMz);
            int i4 = (int) (11.0f * fMz);
            textView4.setPadding(i3, i4, i3, i4);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(22.0f * fMz);
            gradientDrawable2.setColor(z ? -13881549 : -1512723);
            textView4.setBackground(gradientDrawable2);
            textView4.setOnClickListener(new AZxh());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = (int) (fMz * 24.0f);
            linearLayout.addView(textView4, layoutParams3);
            ((ViewGroup) MainActivity.this.getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            MainActivity.this.uH = frameLayout;
        }
    }

    public class nxI implements DialogInterface.OnClickListener {
        public nxI() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.Frh();
        }
    }

    public class oCFDzJ implements DialogInterface.OnClickListener {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() throws InterruptedException, IOException {
                MainActivity.this.gYsXfP();
            }
        }

        public oCFDzJ() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            new Thread(new mjFkc()).start();
        }
    }

    public class oJ implements Runnable {
        public oJ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("search_bg_uri").apply();
            MainActivity.this.X("搜索页背景已恢复默认");
        }
    }

    public class oVXlhB implements Runnable {
        public oVXlhB() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.YuaD();
        }
    }

    public class oaI implements Runnable {
        public oaI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.V();
        }
    }

    public class pJeaSR implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ boolean mjFkc;
        public final /* synthetic */ String wA;

        public class AZxh implements View.OnClickListener {
            public AZxh() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.g0();
            }
        }

        public class mjFkc implements View.OnTouchListener {
            public mjFkc() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public class wA implements View.OnClickListener {
            public wA() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public pJeaSR(boolean z, String str, String str2) {
            this.mjFkc = z;
            this.AZxh = str;
            this.wA = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing()) {
                return;
            }
            MainActivity.this.c();
            float fMz = MainActivity.this.mz();
            boolean z = MainActivity.this.xJ;
            FrameLayout frameLayout = new FrameLayout(MainActivity.this);
            frameLayout.setBackgroundColor(z ? -15460839 : -723207);
            frameLayout.setClickable(true);
            frameLayout.setFocusable(true);
            frameLayout.setOnTouchListener(new mjFkc());
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            int i = (int) (32.0f * fMz);
            linearLayout.setPadding(i, i, i, i);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 17));
            if (this.mjFkc) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText("!");
                textView.setTextSize(26.0f);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(-1);
                textView.setGravity(17);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(-2543579);
                textView.setBackground(gradientDrawable);
                int i2 = (int) (52.0f * fMz);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(i2, i2));
            } else {
                int i3 = (int) (40.0f * fMz);
                linearLayout.addView(new ProgressBar(MainActivity.this), new LinearLayout.LayoutParams(i3, i3));
            }
            TextView textView2 = new TextView(MainActivity.this);
            textView2.setText(this.AZxh);
            textView2.setTextSize(17.0f);
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView2.setTypeface(typeface);
            textView2.setTextColor(z ? -1842205 : -14737633);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (18.0f * fMz);
            linearLayout.addView(textView2, layoutParams);
            TextView textView3 = new TextView(MainActivity.this);
            textView3.setText(this.wA);
            textView3.setTextSize(13.0f);
            textView3.setTextColor(z ? -6643546 : -10525848);
            textView3.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = (int) (10.0f * fMz);
            linearLayout.addView(textView3, layoutParams2);
            if (this.mjFkc) {
                LinearLayout linearLayout2 = new LinearLayout(MainActivity.this);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(17);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.topMargin = (int) (24.0f * fMz);
                TextView textView4 = new TextView(MainActivity.this);
                textView4.setText("重试");
                textView4.setTextSize(14.0f);
                textView4.setTypeface(typeface);
                textView4.setTextColor(-1);
                textView4.setGravity(17);
                int i4 = (int) (28.0f * fMz);
                int i5 = (int) (11.0f * fMz);
                textView4.setPadding(i4, i5, i4, i5);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float f = fMz * 22.0f;
                gradientDrawable2.setCornerRadius(f);
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
                gradientDrawable2.setColors(new int[]{-10589486, -13916000});
                textView4.setBackground(gradientDrawable2);
                textView4.setOnClickListener(new AZxh());
                linearLayout2.addView(textView4, new LinearLayout.LayoutParams(-2, -2));
                TextView textView5 = new TextView(MainActivity.this);
                textView5.setText("退出");
                textView5.setTextSize(14.0f);
                textView5.setTextColor(z ? -6643546 : -10525848);
                textView5.setGravity(17);
                textView5.setPadding(i4, i5, i4, i5);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(f);
                gradientDrawable3.setColor(z ? -13881549 : -1512723);
                textView5.setBackground(gradientDrawable3);
                textView5.setOnClickListener(new wA());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.leftMargin = (int) (fMz * 12.0f);
                linearLayout2.addView(textView5, layoutParams4);
                linearLayout.addView(linearLayout2, layoutParams3);
            }
            ((ViewGroup) MainActivity.this.getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            MainActivity.this.fFz = frameLayout;
        }
    }

    public class peCqC implements View.OnClickListener {
        public final /* synthetic */ AlertDialog mjFkc;

        public peCqC(AlertDialog alertDialog) {
            this.mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.cancel();
        }
    }

    public class qGY implements DialogInterface.OnClickListener {
        public final /* synthetic */ kw AZxh;
        public final /* synthetic */ EditText mjFkc;

        public qGY(EditText editText, kw kwVar) {
            this.mjFkc = editText;
            this.AZxh = kwVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strReplaceAll = this.mjFkc.getText().toString().trim().replaceAll("[^A-Za-z0-9._]", BuildConfig.FLAVOR);
            if (strReplaceAll.isEmpty()) {
                return;
            }
            this.AZxh.mjFkc(strReplaceAll);
        }
    }

    public class qGgY implements Runnable {
        public final /* synthetic */ boolean mjFkc;

        public qGgY(boolean z) {
            this.mjFkc = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strMYYU;
            String strMjFkc;
            boolean z;
            String strNU = MainActivity.this.NU();
            boolean z2 = false;
            if (strNU != null) {
                MainActivity.this.aQ("[开关] 检测到" + strNU + "，拒绝验证");
                MainActivity.this.LREOK = false;
                MainActivity.this.UmFn("检测到" + strNU + "，请关闭 VPN / 网络代理后重试");
                return;
            }
            String strAb = MainActivity.this.Ab();
            if (strAb != null) {
                MainActivity.this.aQ("[开关] 安全校验失败: " + strAb);
                MainActivity.this.LREOK = false;
                MainActivity.this.tyXzYJ("安全校验失败", strAb);
                return;
            }
            if (!MainActivity.this.CBEvIj()) {
                MainActivity.this.aQ("[开关] 安装包签名校验失败（疑似被修改）");
                MainActivity.this.tyXzYJ("完整性校验失败", "应用文件已被修改，请从官方渠道重新安装。");
                return;
            }
            try {
                strMjFkc = CrDc.mjFkc("?v=3.2.6&d=" + MainActivity.this.wfQA() + "&_=" + System.currentTimeMillis());
                strMYYU = BuildConfig.FLAVOR;
            } catch (Throwable th) {
                strMYYU = MainActivity.mYYU(th);
                strMjFkc = null;
            }
            if (strMjFkc == null) {
                MainActivity.this.aQ("[开关] 验证失败: " + strMYYU);
                MainActivity.this.UmFn(strMYYU);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strMjFkc);
                if (jSONObject.optBoolean("banned", false)) {
                    MainActivity.this.aQ("[开关] 本设备已被列入黑名单（" + MainActivity.this.wfQA() + "）");
                    MainActivity.this.LREOK = false;
                    MainActivity.this.tyXzYJ("设备已禁用", "此设备已被管理员禁用。\n\n如有疑问请联系处理。");
                    return;
                }
                boolean z3 = jSONObject.has("enabled") && jSONObject.optBoolean("enabled", false);
                String strOptString = jSONObject.optString("latest", "0");
                String strOptString2 = jSONObject.optString("force_min", "0");
                String strOptString3 = jSONObject.optString("url", BuildConfig.FLAVOR);
                String strOptString4 = jSONObject.optString("msg", BuildConfig.FLAVOR);
                if (!z3) {
                    MainActivity.this.aQ("[开关] 服务器已停用本应用");
                    MainActivity.this.LREOK = false;
                    MainActivity.this.tyXzYJ("服务已停止", strOptString4);
                    return;
                }
                String strVdbwS = MainActivity.this.vdbwS(jSONObject.optString("block_pkgs", BuildConfig.FLAVOR));
                if (strVdbwS != null) {
                    MainActivity.this.aQ("[开关] 命中包名黑名单: " + strVdbwS);
                    MainActivity.this.LREOK = false;
                    MainActivity.this.tyXzYJ("无法使用", "检测到不兼容的应用（" + strVdbwS + "），请卸载后重试。\n\n如有疑问请联系处理。");
                    return;
                }
                if (MainActivity.this.lEH()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() + (this.mjFkc ? 2500L : 8000L);
                    while (true) {
                        try {
                            String strBbzow = com.jc.code.v3.mjFkc.bbzow("id");
                            if (strBbzow != null && strBbzow.contains("uid=2000")) {
                                z = true;
                                break;
                            }
                        } catch (Throwable unused) {
                        }
                        if (System.currentTimeMillis() >= jCurrentTimeMillis) {
                            break;
                        } else {
                            try {
                                Thread.sleep(400L);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                boolean zKbpP = MainActivity.this.KbpP();
                MainActivity.this.aQ("[开关] 验证通过 · 最新 " + strOptString + " · 强制下限 " + strOptString2);
                MainActivity.this.HBzZAD(z, zKbpP, this.mjFkc);
                MainActivity.this.HPA();
                if (jSONObject.optBoolean("popup_on", false)) {
                    MainActivity.this.S(jSONObject.optString("popup_title", BuildConfig.FLAVOR), jSONObject.optString("popup_msg", BuildConfig.FLAVOR), jSONObject.optString("popup_img", BuildConfig.FLAVOR), jSONObject.optString("popup_buttons", BuildConfig.FLAVOR), jSONObject.optBoolean("popup_dismissable", false), jSONObject.optBoolean("popup_auto_close", false));
                }
                if (this.mjFkc || MainActivity.cOuJ("3.2.6", strOptString) >= 0) {
                    return;
                }
                if (strOptString2 != null && strOptString2.length() > 0 && !"0".equals(strOptString2) && MainActivity.cOuJ("3.2.6", strOptString2) < 0) {
                    z2 = true;
                }
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("[开关] ");
                sb.append(z2 ? "必须强制更新" : "有新版本");
                sb.append(" → ");
                sb.append(strOptString);
                mainActivity.aQ(sb.toString());
                MainActivity.this.a0(z2, strOptString, strOptString3, strOptString4);
            } catch (Throwable th2) {
                MainActivity.this.aQ("[开关] 响应解析失败: " + MainActivity.mYYU(th2));
                MainActivity.this.UmFn("验证服务器响应异常");
            }
        }
    }

    public class qdMbNW implements DialogInterface.OnClickListener {
        public qdMbNW() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.rtBEoQ();
        }
    }

    public class qrxT implements Runnable {
        public final /* synthetic */ ImageView AZxh;
        public final /* synthetic */ String mjFkc;

        public class mjFkc implements Runnable {
            public final /* synthetic */ Bitmap mjFkc;

            public mjFkc(Bitmap bitmap) {
                this.mjFkc = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                qrxT.this.AZxh.setImageBitmap(this.mjFkc);
                qrxT.this.AZxh.setVisibility(0);
            }
        }

        public qrxT(String str, ImageView imageView) {
            this.mjFkc = str;
            this.AZxh = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mjFkc).openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(8000);
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0 || i >= 8388608) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    i += i2;
                }
                inputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i3 = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                while (options.outWidth / i3 > 1200) {
                    i3 *= 2;
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i3;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options2);
                if (bitmapDecodeByteArray != null) {
                    MainActivity.this.mjFkc.post(new mjFkc(bitmapDecodeByteArray));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class qtZIjO {
        public String AZxh;
        public String Dt;
        public boolean ETF;
        public GradientDrawable IEE;
        public boolean JHa;
        public Runnable KLFTb;
        public View MiMN;
        public boolean VA;
        public TextView YoKzxo;
        public int ZfxDd;
        public ImageView fehf;
        public boolean lgHUyS;
        public String mjFkc;
        public ImageView qGY;
        public boolean qdMbNW;
        public TextView rkYL;
        public int wA;
        public boolean xJ;

        public qtZIjO() {
        }

        public /* synthetic */ qtZIjO(KRckQg kRckQg) {
            this();
        }
    }

    public class rWxwaT implements DialogInterface.OnClickListener {
        public final /* synthetic */ boolean mjFkc;

        public rWxwaT(boolean z) {
            this.mjFkc = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.n(this.mjFkc ? 1 : 0);
        }
    }

    public class rdJr implements Runnable {
        public rdJr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.rtBEoQ();
        }
    }

    public class rkYL implements DialogInterface.OnClickListener {
        public final /* synthetic */ kw AZxh;
        public final /* synthetic */ EditText mjFkc;

        public rkYL(EditText editText, kw kwVar) {
            this.mjFkc = editText;
            this.AZxh = kwVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.AZxh.mjFkc(strTrim);
        }
    }

    public class sRqPfw implements Runnable {
        public sRqPfw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.fehf != null && MainActivity.this.fehf.isShowing()) {
                    MainActivity.this.fehf.dismiss();
                }
            } catch (Exception unused) {
            }
            MainActivity.this.b();
        }
    }

    public class sqndV implements Runnable {
        public sqndV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.D();
        }
    }

    public class tAfC implements TextView.OnEditorActionListener {
        public final /* synthetic */ Runnable mjFkc;

        public tAfC(Runnable runnable) {
            this.mjFkc = runnable;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2 && i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            this.mjFkc.run();
            return true;
        }
    }

    public class tISON implements View.OnClickListener {
        public tISON() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.mByQ = true;
            MainActivity.this.b();
            MainActivity.this.X("已取消下载");
        }
    }

    public class tPvjn implements Runnable {
        public tPvjn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.rKxis();
        }
    }

    public class tQ implements Runnable {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.a(true);
            }
        }

        public tQ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentName componentName;
            Method method;
            Object objInvoke;
            MainActivity.this.aQ("\n[*] 取消设备所有者...");
            MainActivity.this.Y("正在取消设备所有者…");
            try {
                MainActivity.this.JtIAgM();
                componentName = new ComponentName(MainActivity.this, (Class<?>) JcDeviceAdminReceiver.class);
                method = null;
                objInvoke = Class.forName("android.app.admin.IDevicePolicyManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "device_policy"));
                Method[] methods = objInvoke.getClass().getMethods();
                int length = methods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Method method2 = methods[i];
                    if (method2.getName().equals("clearDeviceOwner") && method2.getParameterTypes().length == 1) {
                        method = method2;
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                th = th;
                if (th.getCause() != null) {
                    th = th.getCause();
                }
                MainActivity.this.aQ("[!] 取消失败: " + th);
                MainActivity.this.Y("✗ 取消失败");
            }
            if (method == null) {
                MainActivity.this.aQ("[!] clearDeviceOwner 接口不存在");
                MainActivity.this.Y("✗ 系统不支持取消");
                return;
            }
            try {
                method.invoke(objInvoke, componentName);
            } catch (IllegalArgumentException unused) {
                method.invoke(objInvoke, "JC.CODE.V3");
            }
            if (MainActivity.this.KbpP()) {
                MainActivity.this.aQ("[!] 取消未生效，仍是设备所有者");
                MainActivity.this.Y("✗ 取消未生效");
            } else {
                MainActivity.this.aQ("[+] 设备所有者已取消 ✓");
                MainActivity.this.Y("✓ 设备所有者已取消");
            }
            MainActivity.this.a(true);
            MainActivity.this.mjFkc.post(new mjFkc());
        }
    }

    public class tjSezt implements Runnable {
        public final /* synthetic */ boolean AZxh;
        public final /* synthetic */ String mjFkc;

        public tjSezt(String str, boolean z) {
            this.mjFkc = str;
            this.AZxh = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService("notification");
                if (notificationManager == null) {
                    return;
                }
                String str = MainActivity.this.IVlxe;
                String str2 = this.mjFkc;
                if (str != null && str.length() > 0) {
                    str2 = this.mjFkc + " · 配对码 " + str;
                }
                Intent intent = new Intent(MainActivity.this, (Class<?>) MainActivity.class);
                intent.setFlags(603979776);
                notificationManager.notify(2002, new Notification.Builder(MainActivity.this, "jc_adb_pair_status_v2").setSmallIcon(AbstractC1857s4.Dt).setContentTitle("无线调试配对").setContentText(str2).setContentIntent(PendingIntent.getActivity(MainActivity.this, 0, intent, 201326592)).setOngoing(this.AZxh).setAutoCancel(!this.AZxh).setOnlyAlertOnce(true).setShowWhen(false).build());
            } catch (Exception unused) {
            }
        }
    }

    public class tpGcn implements View.OnClickListener {
        public final /* synthetic */ FrameLayout AZxh;
        public final /* synthetic */ CheckBox mjFkc;

        public tpGcn(CheckBox checkBox, FrameLayout frameLayout) {
            this.mjFkc = checkBox;
            this.AZxh = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.mjFkc.isChecked()) {
                MainActivity.this.X("请先勾选同意《用户协议》");
                return;
            }
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("agreement_accepted_v1", true).apply();
            MainActivity.this.jx = false;
            MainActivity.this.aQ("[*] 用户协议已同意");
            try {
                ((ViewGroup) MainActivity.this.getWindow().getDecorView()).removeView(this.AZxh);
            } catch (Throwable unused) {
            }
            MainActivity.this.g0();
        }
    }

    public class uH implements Runnable {
        public final /* synthetic */ String mjFkc;

        public uH(String str) {
            this.mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.fehf != null && MainActivity.this.fehf.isShowing()) {
                    MainActivity.this.fehf.dismiss();
                }
                if (MainActivity.this.rdtF()) {
                    MainActivity.this.G(this.mjFkc);
                    return;
                }
                MainActivity.this.f();
                MainActivity.this.fehf = new ProgressDialog(MainActivity.this);
                MainActivity.this.fehf.setProgressStyle(1);
                MainActivity.this.fehf.setTitle(this.mjFkc);
                MainActivity.this.fehf.setMessage("正在获取校验信息（应用商店还需下载一次）...");
                MainActivity.this.fehf.setMax(100);
                MainActivity.this.fehf.setProgress(0);
                MainActivity.this.fehf.setCancelable(false);
                MainActivity.this.fehf.show();
            } catch (Exception unused) {
            }
        }
    }

    public class uHVRx implements Runnable {
        public uHVRx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.zpm();
        }
    }

    public class ub implements Runnable {
        public final /* synthetic */ boolean AZxh;
        public final /* synthetic */ boolean mjFkc;
        public final /* synthetic */ boolean wA;

        public ub(boolean z, boolean z2, boolean z3) {
            this.mjFkc = z;
            this.AZxh = z2;
            this.wA = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            boolean z2 = MainActivity.this.Vdz && !this.mjFkc;
            if (MainActivity.this.jm && !this.AZxh) {
                z = true;
            }
            MainActivity.this.Vdz = this.mjFkc;
            MainActivity.this.jm = this.AZxh;
            MainActivity mainActivity = MainActivity.this;
            boolean z3 = this.mjFkc;
            mainActivity.JBhc = (z3 && this.AZxh) ? "ADB+OW" : z3 ? "ADB" : this.AZxh ? "OW" : "漏洞";
            MainActivity.this.wfW();
            MainActivity.this.tQ = true;
            MainActivity.this.nVsW(this.wA);
            if (MainActivity.this.XV != null) {
                MainActivity.this.Abw();
            }
            boolean z4 = this.wA;
            if (z4 && z2) {
                MainActivity.this.Y("ADB 通道已失效，请重新激活");
            } else if (z4 && z) {
                MainActivity.this.Y("设备所有者已失效，请重新激活");
            }
        }
    }

    public class ui implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ TextView mjFkc;

        public ui(TextView textView) {
            this.mjFkc = textView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.mjFkc.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    public class uxlM implements Runnable {
        public uxlM() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.gq();
        }
    }

    public class vI implements kw {
        public final /* synthetic */ ScrollView AZxh;
        public final /* synthetic */ TextView mjFkc;

        public vI(TextView textView, ScrollView scrollView) {
            this.mjFkc = textView;
            this.AZxh = scrollView;
        }

        @Override // com.jc.code.v3.MainActivity.kw
        public void mjFkc(String str) {
            MainActivity.this.m("set-uninstall-blocked " + str + " false", this.mjFkc, this.AZxh);
        }
    }

    public class vUsV implements Runnable {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!"漏洞".equals(MainActivity.this.JBhc) || MainActivity.this.dm || MainActivity.this.getSharedPreferences("jc_code_prefs", 0).getBoolean("vuln_hint_never", false)) {
                    return;
                }
                MainActivity.this.dm = true;
                MainActivity.this.b0();
            }
        }

        public vUsV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.LREOK = true;
            MainActivity.this.ORe();
            MainActivity.this.mjFkc.removeCallbacks(MainActivity.this.Vgyli);
            MainActivity.this.mjFkc.postDelayed(MainActivity.this.Vgyli, 30000L);
            MainActivity.this.mjFkc.postDelayed(new mjFkc(), 700L);
            if (MainActivity.this.XbiWeM != null) {
                Intent intent = MainActivity.this.XbiWeM;
                MainActivity.this.XbiWeM = null;
                MainActivity.this.DxPQMO(intent);
            }
        }
    }

    public class vZ implements View.OnClickListener {
        public final /* synthetic */ Runnable mjFkc;

        public vZ(Runnable runnable) {
            this.mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mjFkc.run();
        }
    }

    public class vadzgd implements Runnable {
        public vadzgd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.CrDc(true);
            MainActivity.this.a(true);
        }
    }

    public class vjlshU implements Runnable {
        public final /* synthetic */ StringBuilder AZxh;
        public final /* synthetic */ String[] mjFkc;

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                vjlshU vjlshu = vjlshU.this;
                MainActivity.this.T("管控探针", vjlshu.AZxh.toString());
            }
        }

        public vjlshU(String[] strArr, StringBuilder sb) {
            this.mjFkc = strArr;
            this.AZxh = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.mjFkc) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = MainActivity.this.getContentResolver().query(Uri.parse("content://com.zuoyebang.iot.pad.supervise" + str), null, null, null, null);
                        if (cursorQuery == null) {
                            StringBuilder sb = this.AZxh;
                            sb.append(str);
                            sb.append(" → null\n\n");
                            MainActivity.this.aQ("[-] " + str + " → null");
                        } else {
                            String[] columnNames = cursorQuery.getColumnNames();
                            StringBuilder sb2 = this.AZxh;
                            sb2.append(str);
                            sb2.append(" (");
                            sb2.append(cursorQuery.getCount());
                            sb2.append(" 行, ");
                            sb2.append(columnNames.length);
                            sb2.append(" 列)\n");
                            this.AZxh.append("  列: ");
                            for (int i = 0; i < Math.min(columnNames.length, 8); i++) {
                                StringBuilder sb3 = this.AZxh;
                                sb3.append(columnNames[i]);
                                sb3.append(", ");
                            }
                            if (columnNames.length > 8) {
                                this.AZxh.append("...");
                            }
                            this.AZxh.append("\n");
                            for (int i2 = 0; cursorQuery.moveToNext() && i2 < 3; i2++) {
                                StringBuilder sb4 = this.AZxh;
                                sb4.append("  [");
                                sb4.append(i2);
                                sb4.append("] ");
                                for (int i3 = 0; i3 < Math.min(columnNames.length, 5); i3++) {
                                    try {
                                        String string = cursorQuery.getString(i3);
                                        if (string != null && string.length() > 50) {
                                            string = string.substring(0, 50) + "...";
                                        }
                                        StringBuilder sb5 = this.AZxh;
                                        sb5.append(columnNames[i3]);
                                        sb5.append("=");
                                        sb5.append(string);
                                        sb5.append(" | ");
                                    } catch (Exception unused) {
                                    }
                                }
                                this.AZxh.append("\n");
                            }
                            this.AZxh.append("\n");
                            MainActivity.this.aQ("[+] " + str + " → " + cursorQuery.getCount() + " 行");
                        }
                    } catch (Exception e) {
                        StringBuilder sb6 = this.AZxh;
                        sb6.append(str);
                        sb6.append(" → 错误: ");
                        sb6.append(e.getMessage());
                        sb6.append("\n\n");
                        MainActivity.this.aQ("[!] " + str + " → " + e.getMessage());
                        if (cursorQuery != null) {
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            MainActivity.this.mjFkc.post(new mjFkc());
        }
    }

    public class wA implements Runnable {
        public final /* synthetic */ Set AZxh;
        public final /* synthetic */ EditText ZfxDd;
        public final /* synthetic */ LinearLayout mjFkc;
        public final /* synthetic */ Map wA;

        public class AZxh implements Runnable {
            public final /* synthetic */ boolean AZxh;
            public final /* synthetic */ List mjFkc;

            /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh$AZxh, reason: collision with other inner class name */
            public class C0035AZxh implements CompoundButton.OnCheckedChangeListener {
                public final /* synthetic */ String mjFkc;

                public C0035AZxh(String str) {
                    this.mjFkc = str;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        wA.this.AZxh.add(this.mjFkc);
                    } else {
                        wA.this.AZxh.remove(this.mjFkc);
                    }
                }
            }

            public class mjFkc implements View.OnClickListener {
                public final /* synthetic */ CheckBox mjFkc;

                public mjFkc(CheckBox checkBox) {
                    this.mjFkc = checkBox;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.mjFkc.setChecked(!r0.isChecked());
                }
            }

            /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh$wA, reason: collision with other inner class name */
            public class C0036wA implements TextWatcher {
                public C0036wA() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String strTrim = editable.toString().toLowerCase().trim();
                    Iterator it = wA.this.wA.entrySet().iterator();
                    while (it.hasNext()) {
                        View view = (View) ((Map.Entry) it.next()).getValue();
                        view.setVisibility((strTrim.isEmpty() || ((TextView) view.findViewById(AbstractC1978u4.fehf)).getText().toString().toLowerCase().contains(strTrim) || ((TextView) view.findViewById(AbstractC1978u4.diqgf)).getText().toString().toLowerCase().contains(strTrim)) ? 0 : 8);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            }

            public AZxh(List list, boolean z) {
                this.mjFkc = list;
                this.AZxh = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                wA.this.mjFkc.removeAllViews();
                for (PackageInfo packageInfo : this.mjFkc) {
                    String string = packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString();
                    String str = packageInfo.packageName;
                    View viewInflate = LayoutInflater.from(MainActivity.this).inflate(H4.ZfxDd, (ViewGroup) null);
                    ImageView imageView = (ImageView) viewInflate.findViewById(AbstractC1978u4.qdMbNW);
                    TextView textView = (TextView) viewInflate.findViewById(AbstractC1978u4.fehf);
                    TextView textView2 = (TextView) viewInflate.findViewById(AbstractC1978u4.diqgf);
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(AbstractC1978u4.KLFTb);
                    imageView.setImageDrawable(packageInfo.applicationInfo.loadIcon(MainActivity.this.getPackageManager()));
                    textView.setText(string);
                    textView.setTextColor(this.AZxh ? -419430401 : -15066598);
                    textView2.setText(str);
                    textView2.setTextColor(this.AZxh ? -1711276033 : -1728053248);
                    viewInflate.setOnClickListener(new mjFkc(checkBox));
                    checkBox.setOnCheckedChangeListener(new C0035AZxh(str));
                    wA.this.mjFkc.addView(viewInflate);
                    wA.this.wA.put(str, viewInflate);
                }
                wA.this.ZfxDd.addTextChangedListener(new C0036wA());
            }
        }

        public class mjFkc implements Comparator {
            public mjFkc() {
            }

            @Override // java.util.Comparator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
                return packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString().compareToIgnoreCase(packageInfo2.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString());
            }
        }

        public wA(LinearLayout linearLayout, Set set, Map map, EditText editText) {
            this.mjFkc = linearLayout;
            this.AZxh = set;
            this.wA = map;
            this.ZfxDd = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<PackageInfo> installedPackages = MainActivity.this.getPackageManager().getInstalledPackages(0);
            ArrayList arrayList = new ArrayList();
            for (PackageInfo packageInfo : installedPackages) {
                if (!packageInfo.packageName.startsWith("com.android.") || packageInfo.packageName.contains("launcher")) {
                    if (!packageInfo.packageName.equals("android")) {
                        arrayList.add(packageInfo);
                    }
                }
            }
            Collections.sort(arrayList, new mjFkc());
            MainActivity.this.runOnUiThread(new AZxh(arrayList, MainActivity.this.xJ));
        }
    }

    public class wGscSa implements DialogInterface.OnDismissListener {
        public wGscSa() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.ZODYfo();
        }
    }

    public class wJVbdd implements Runnable {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ ScrollView wA;

        public wJVbdd(String str, TextView textView, ScrollView scrollView) {
            this.mjFkc = str;
            this.AZxh = textView;
            this.wA = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strMjFkc = vEiZJ.mjFkc(MainActivity.this, this.mjFkc);
                MainActivity mainActivity = MainActivity.this;
                TextView textView = this.AZxh;
                ScrollView scrollView = this.wA;
                StringBuilder sb = new StringBuilder();
                if (strMjFkc == null || strMjFkc.trim().length() == 0) {
                    strMjFkc = "(无输出)";
                }
                sb.append(strMjFkc);
                sb.append("\n");
                mainActivity.iEjzEW(textView, scrollView, sb.toString(), -2629912);
            } catch (Throwable th) {
                MainActivity.this.iEjzEW(this.AZxh, this.wA, "✗ " + MainActivity.mYYU(th) + "\n", -1074534);
            }
        }
    }

    public class wLtdyQ implements View.OnTouchListener {
        public wLtdyQ() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class xBQUgd implements View.OnClickListener {
        public xBQUgd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.Frh();
        }
    }

    public class xCVa implements Runnable {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.LREOK) {
                    MainActivity.this.a(true);
                    MainActivity.this.CrDc(true);
                }
            }
        }

        public xCVa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strBbzow = com.jc.code.v3.mjFkc.bbzow("echo ok");
                if (strBbzow != null && strBbzow.indexOf("ok") >= 0) {
                    MainActivity.this.aQ("[ADB] 已自动恢复连接（无需重新配对）");
                    com.jc.code.v3.mjFkc.alEkx();
                    MainActivity.this.mjFkc.post(new mjFkc());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class xJ implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText mjFkc;

        public xJ(EditText editText) {
            this.mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            MainActivity.this.s(strTrim);
        }
    }

    public class xROA implements Runnable {
        public xROA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.Frh();
        }
    }

    public static final class xVYW {
        public final String AZxh;
        public final Runnable KLFTb;
        public final int ZfxDd;
        public final String mjFkc;
        public final int wA;

        public xVYW(String str, String str2, int i, int i2, Runnable runnable) {
            this.mjFkc = str;
            this.AZxh = str2;
            this.wA = i;
            this.ZfxDd = i2;
            this.KLFTb = runnable;
        }
    }

    public class xbjHT implements View.OnClickListener {
        public xbjHT() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://app.aibangos.xyz/Jc.Four")));
            } catch (Exception unused) {
                MainActivity.this.X("无法打开浏览器");
            }
        }
    }

    public class xfXeiC implements Runnable {
        public xfXeiC() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("search_bg_scale", "stretch").apply();
            MainActivity.this.zo();
        }
    }

    public class xrEuO implements DialogInterface.OnClickListener {
        public final /* synthetic */ TextView AZxh;
        public final /* synthetic */ String ZfxDd;
        public final /* synthetic */ String mjFkc;
        public final /* synthetic */ ScrollView wA;

        public xrEuO(String str, TextView textView, ScrollView scrollView, String str2) {
            this.mjFkc = str;
            this.AZxh = textView;
            this.wA = scrollView;
            this.ZfxDd = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.q(this.mjFkc, this.AZxh, this.wA);
            MainActivity.this.Y(this.ZfxDd + " 执行中...");
        }
    }

    public class yP implements View.OnClickListener {
        public yP() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.finishAffinity();
            Process.killProcess(Process.myPid());
        }
    }

    public class yX implements Runnable {
        public yX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.IxLrZ();
        }
    }

    public class ybBTr implements Runnable {
        public ybBTr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.u0();
        }
    }

    public class yfx implements Runnable {

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.X("✓ 代理已清理");
            }
        }

        public yfx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jc.code.v3.mjFkc.bbzow("settings put global http_proxy :0; settings delete global http_proxy");
                MainActivity.this.aQ("[*] 系统代理已清理");
            } catch (Throwable th) {
                MainActivity.this.aQ("[!] 清理系统代理失败: " + MainActivity.mYYU(th));
            }
            CBEvIj.JHa().diqgf();
            MainActivity.this.lti = false;
            MainActivity.this.mjFkc.post(new mjFkc());
        }
    }

    public class zPp extends ViewOutlineProvider {
        public zPp() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public class zvd implements Runnable {
        public final /* synthetic */ String AZxh;
        public final /* synthetic */ ScrollView ZfxDd;
        public final /* synthetic */ int mjFkc;
        public final /* synthetic */ TextView wA;

        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                zvd.this.ZfxDd.fullScroll(130);
            }
        }

        public zvd(int i, String str, TextView textView, ScrollView scrollView) {
            this.mjFkc = i;
            this.AZxh = str;
            this.wA = textView;
            this.ZfxDd = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mjFkc != 0) {
                SpannableString spannableString = new SpannableString(this.AZxh);
                spannableString.setSpan(new ForegroundColorSpan(this.mjFkc), 0, this.AZxh.length(), 33);
                this.wA.append(spannableString);
            } else {
                this.wA.append(this.AZxh);
            }
            this.ZfxDd.post(new mjFkc());
        }
    }

    public static List EaLbDP(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        ArrayList arrayList = new ArrayList();
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2 && "node".equals(xmlPullParserNewPullParser.getName())) {
                ih ihVar = new ih(null);
                ihVar.mjFkc = sMIIyd(xmlPullParserNewPullParser, "text");
                ihVar.AZxh = sMIIyd(xmlPullParserNewPullParser, "content-desc");
                ihVar.wA = sMIIyd(xmlPullParserNewPullParser, "class");
                ihVar.ZfxDd = sMIIyd(xmlPullParserNewPullParser, "package");
                ihVar.KLFTb = sMIIyd(xmlPullParserNewPullParser, "resource-id");
                ihVar.JHa = "true".equals(sMIIyd(xmlPullParserNewPullParser, "clickable"));
                RleMQT(sMIIyd(xmlPullParserNewPullParser, "bounds"), ihVar);
                arrayList.add(ihVar);
            }
        }
        return arrayList;
    }

    public static void RleMQT(String str, ih ihVar) {
        Pattern pattern = XD;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            ihVar.xJ = Integer.parseInt(matcher.group(1));
            ihVar.lgHUyS = Integer.parseInt(matcher.group(2));
            ihVar.qdMbNW = Integer.parseInt(matcher.group(3));
            ihVar.Dt = Integer.parseInt(matcher.group(4));
        }
    }

    public static int cOuJ(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        String[] strArrSplit = str.split("\\.");
        if (str2 == null) {
            str2 = "0";
        }
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int iGy = i < strArrSplit.length ? gy(strArrSplit[i]) : 0;
            int iGy2 = i < strArrSplit2.length ? gy(strArrSplit2[i]) : 0;
            if (iGy != iGy2) {
                return iGy < iGy2 ? -1 : 1;
            }
            i++;
        }
        return 0;
    }

    public static int gy(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        try {
            if (sb.length() == 0) {
                return 0;
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String mYYU(Throwable th) {
        if (th == null) {
            return "未知错误";
        }
        String message = th.getMessage();
        return (message == null || message.length() <= 0) ? th.getClass().getSimpleName() : message;
    }

    public static String sMIIyd(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? BuildConfig.FLAVOR : attributeValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static gjvQ uAgKP(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ih ihVar = (ih) it.next();
            String strTrim = ihVar.mjFkc.replace(" ", BuildConfig.FLAVOR).trim();
            if (strTrim.matches("\\d{6}")) {
                return new gjvQ(strTrim, ihVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ih ihVar2 = (ih) it2.next();
            if (ihVar2.mjFkc.trim().matches("\\d")) {
                arrayList.add(ihVar2);
            }
        }
        int i = 0;
        while (i + 6 <= arrayList.size()) {
            int i2 = ((ih) arrayList.get(i)).lgHUyS;
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 6; i3++) {
                ih ihVar3 = (ih) arrayList.get(i + i3);
                if (Math.abs(ihVar3.lgHUyS - i2) > 24) {
                    break;
                }
                sb.append(ihVar3.mjFkc.trim());
            }
            return new gjvQ(sb.toString(), (ih) arrayList.get(i));
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ih ihVar4 = (ih) it3.next();
            Matcher matcher = Dp.matcher(ihVar4.mjFkc);
            if (matcher.find()) {
                return new gjvQ(matcher.group(), ihVar4);
            }
        }
        return null;
    }

    public static String uhQ(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ih ihVar = (ih) it.next();
            Matcher matcher = gtr.matcher(ihVar.mjFkc + " " + ihVar.AZxh);
            if (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!strGroup.startsWith("127.") && !strGroup.startsWith("0.")) {
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 == null) {
                        return strGroup;
                    }
                    return strGroup + ":" + strGroup2;
                }
            }
        }
        return null;
    }

    public static int[] w0(int i, boolean z) {
        return z ? new int[]{-12168802, -14848406, -1} : new int[]{-10589486, -13916000, -1};
    }

    public static void wMV(String str) {
        MainActivity mainActivity = sRqPfw;
        if (mainActivity != null) {
            mainActivity.aQ(str);
        } else {
            Log.d("JCCodeV3", str);
        }
    }

    public final void A(String str) {
        new AlertDialog.Builder(this, S4.mjFkc).setTitle(str + " 需要 ADB 权限").setMessage("该功能通过无线调试 ADB 通道执行，当前尚未获得 ADB 权限。\n\n请先到「开发者工具 → 打开无线调试配对页面」完成配对，获得 ADB 权限后此项自动恢复可用。").setPositiveButton("去配对", new cMLeY()).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
    }

    public final void A0(int i) {
        runOnUiThread(new giT(i));
    }

    public final String Ab() {
        int iJavaEnvFlags = GateNative.javaEnvFlags();
        if (GateNative.available()) {
            int iEnvCheck = GateNative.envCheck();
            if (GateNative.aliveMagic() != 1245923121) {
                return "安全组件异常（疑似被 Hook）";
            }
            if ((iEnvCheck & 4095) != (iJavaEnvFlags & 4095)) {
                return "安全组件校验失败（疑似被针对性绕过）";
            }
            if ((iEnvCheck & GateNative.LOCK_MASK) != 0) {
                return "检测到注入 / Hook 框架（LSPosed、Xposed、Frida 等），请在干净环境使用";
            }
        }
        if ((iJavaEnvFlags & GateNative.LOCK_MASK) != 0) {
            return "检测到注入 / Hook 框架（LSPosed、Xposed、Frida 等），请在干净环境使用";
        }
        if (GateNative.stackHooked()) {
            return "检测到 Hook 注入（调用栈异常）";
        }
        try {
            if (Debug.isDebuggerConnected()) {
                return "检测到调试器连接";
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void Abw() {
        int i;
        if (this.XV == null) {
            return;
        }
        float fMz = mz();
        boolean z = this.xJ;
        int i2 = z ? -1842205 : -14737633;
        int i3 = z ? -6643546 : -12302522;
        this.XV.removeAllViews();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fMz);
        int i4 = -1;
        if (z) {
            gradientDrawable.setColor(-14408151);
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -12960446);
        } else {
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -1709843);
        }
        this.XV.setBackground(gradientDrawable);
        TextView textView = new TextView(this);
        textView.setText("状态总览");
        textView.setTextSize(12.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(z ? -5919253 : -10589486);
        int i5 = (int) (12.0f * fMz);
        textView.setPadding(0, 0, 0, i5);
        this.XV.addView(textView);
        Iterator it = this.Vnb.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            for (qtZIjO qtzijo : ((gJsSk) it.next()).ZfxDd) {
                if (!qtzijo.JHa && !qtzijo.VA) {
                    i6++;
                }
            }
        }
        String str = this.CqaNbM;
        String str2 = (str == null || str.length() == 0) ? "未检测" : this.CqaNbM;
        String[][] strArr = {new String[]{"服务状态", this.JrJO}, new String[]{"ZYB 版本", str2}, new String[]{"运行状态", this.JBhc}, new String[]{"功能入口", String.valueOf(i6) + " 项"}};
        int i7 = 0;
        while (true) {
            if (i7 >= 2) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            int i8 = -2;
            this.XV.addView(linearLayout, new LinearLayout.LayoutParams(i4, -2));
            int i9 = 0;
            for (int i10 = 2; i9 < i10; i10 = 2) {
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setOrientation(1);
                TextView textView2 = new TextView(this);
                int i11 = (i7 * 2) + i9;
                textView2.setText(strArr[i11][0]);
                textView2.setTextSize(11.5f);
                textView2.setTextColor(i3);
                linearLayout2.addView(textView2);
                if (i7 == 1 && i9 == 0) {
                    LinearLayout linearLayoutEey = Eey(true);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i8, i8);
                    layoutParams.topMargin = (int) (fMz * 4.0f);
                    linearLayout2.addView(linearLayoutEey, layoutParams);
                } else {
                    TextView textView3 = new TextView(this);
                    textView3.setText(strArr[i11][1]);
                    textView3.setTextSize(16.0f);
                    textView3.setTypeface(Typeface.DEFAULT_BOLD);
                    textView3.setTextColor(i2);
                    textView3.setPadding(0, (int) (2.0f * fMz), 0, 0);
                    textView3.setMaxLines(1);
                    textView3.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    linearLayout2.addView(textView3);
                    if (i11 == 0) {
                        this.bbzow = textView3;
                    }
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                if (i9 == 1) {
                    layoutParams2.leftMargin = (int) (16.0f * fMz);
                }
                linearLayout.addView(linearLayout2, layoutParams2);
                i9++;
                i8 = -2;
            }
            if (i7 == 0) {
                View view = new View(this);
                i = -1;
                new LinearLayout.LayoutParams(-1, i5);
                this.XV.addView(view);
            } else {
                i = -1;
            }
            i7++;
            i4 = i;
        }
    }

    public final void B() {
        float fMz = mz();
        boolean z = this.xJ;
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(z ? -15460839 : -723207);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setOnTouchListener(new wLtdyQ());
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (24.0f * fMz);
        linearLayout.setPadding(i, i, i, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
        float f = 18.0f * fMz;
        int i2 = (int) f;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        frameLayout.addView(linearLayout, layoutParams);
        TextView textView = new TextView(this);
        textView.setText("用户协议");
        textView.setTextSize(22.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        textView.setTextColor(z ? -1842205 : -14737633);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this);
        textView2.setText("首次使用前请阅读并同意以下条款");
        textView2.setTextSize(13.0f);
        textView2.setTextColor(z ? -6643546 : -10525848);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = (int) (fMz * 6.0f);
        int i3 = (int) (16.0f * fMz);
        layoutParams2.bottomMargin = i3;
        linearLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(this);
        textView3.setText("欢迎使用 JC Code V3（以下简称「本应用」）。请在使用前仔细阅读以下条款，勾选「我已阅读并同意」并点击「同意并开始使用」，即表示您已理解并接受本协议全部内容。\n\n一、协议性质与适用范围\n1. 本应用是一款面向个人设备的系统管理与应用安装辅助工具。\n2. 本协议适用于您对本应用的下载、安装、启动及全部使用行为。\n3. 若您不同意本协议任何内容，请点击「退出」并停止使用。\n\n二、使用规范\n1. 您应在自己拥有或经合法授权的设备上使用本应用，不得用于他人设备或未经授权的系统。\n2. 您不得利用本应用从事任何违反法律法规、侵犯他人合法权益或破坏计算机信息系统的行为。\n3. 您通过本应用安装、运行的任何第三方软件，其内容与责任由软件提供方及您自行承担。\n\n三、功能与风险提示\n1. 本应用提供应用安装 / 卸载、ADB 调试通道、设备所有者（Device Owner）等系统级操作能力，此类操作可能影响设备保修状态、系统稳定性或数据安全。\n2. 刷写、降级、停用系统组件等操作存在导致设备异常或数据丢失的风险，请提前自行备份重要资料。\n3. 因操作不当、设备差异、系统版本差异导致的任何设备损坏或数据损失，本应用不承担责任。\n\n四、联网与信息收集\n1. 本应用启动时需连接服务器完成服务状态验证，并获取版本更新与公告信息；无法连接服务器时本应用将无法使用。\n2. 为实现设备管理与安全管控，本应用会上报本机的设备码（基于设备标识生成的匿名编号）及应用版本号。上述信息不包含您的姓名、账号等个人身份信息。\n3. 服务端可下发停用、强制更新、兼容性黑名单等管控指令，用于维护软件生态与用户权益。\n\n五、免责声明\n1. 本应用按「现状」提供，不作任何明示或默示的担保，包括但不限于适销性、特定用途适用性。\n2. 在法律允许的最大范围内，开发者不对因使用或无法使用本应用导致的任何直接、间接损失承担责任。\n\n六、协议变更与终止\n1. 开发者可根据需要更新本协议，更新后的协议将随新版本发布；继续使用即视为接受变更。\n2. 您可随时停止使用并卸载本应用；如您违反本协议，开发者有权中止或终止您的使用。\n\n七、联系方式\n对本协议有任何疑问，请联系：aono_saki@outlook.com");
        textView3.setTextSize(12.0f);
        textView3.setLineSpacing(fMz * 3.0f, 1.0f);
        textView3.setTextColor(z ? -3616036 : -12302522);
        textView3.setPadding(i2, i3, i2, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(z ? -14999772 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -14012102);
        }
        textView3.setBackground(gradientDrawable);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(textView3, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, (int) (330.0f * fMz));
        layoutParams3.bottomMargin = i3;
        linearLayout.addView(scrollView, layoutParams3);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("我已阅读并同意《用户协议》");
        checkBox.setTextSize(13.5f);
        checkBox.setTextColor(z ? -1842205 : -14737633);
        linearLayout.addView(checkBox, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = i2;
        TextView textView4 = new TextView(this);
        textView4.setText("退出");
        textView4.setTextSize(14.0f);
        textView4.setTextColor(z ? -6643546 : -10525848);
        textView4.setGravity(17);
        int i4 = (int) (28.0f * fMz);
        int i5 = (int) (12.0f * fMz);
        textView4.setPadding(i4, i5, i4, i5);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float f2 = fMz * 22.0f;
        gradientDrawable2.setCornerRadius(f2);
        gradientDrawable2.setColor(z ? -13881549 : -1512723);
        textView4.setBackground(gradientDrawable2);
        textView4.setOnClickListener(new yP());
        linearLayout2.addView(textView4, new LinearLayout.LayoutParams(-2, -2));
        TextView textView5 = new TextView(this);
        textView5.setText("同意并开始使用");
        textView5.setTextSize(14.0f);
        textView5.setTypeface(Typeface.DEFAULT_BOLD);
        textView5.setTextColor(-1);
        textView5.setGravity(17);
        textView5.setPadding(i, i5, i, i5);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadius(f2);
        gradientDrawable3.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable3.setColors(new int[]{-10589486, -13916000});
        textView5.setBackground(gradientDrawable3);
        textView5.setAlpha(0.4f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = i5;
        linearLayout2.addView(textView5, layoutParams5);
        linearLayout.addView(linearLayout2, layoutParams4);
        checkBox.setOnCheckedChangeListener(new ui(textView5));
        textView5.setOnClickListener(new tpGcn(checkBox, frameLayout));
        ((ViewGroup) getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void B0(int i) {
        boolean z = this.xJ;
        int i2 = z ? -5919253 : -10589486;
        int i3 = z ? -6643546 : -12302522;
        float fMz = mz();
        int i4 = 0;
        while (i4 < this.Vnb.size()) {
            gJsSk gjssk = (gJsSk) this.Vnb.get(i4);
            if (gjssk.KLFTb != null) {
                boolean z2 = i4 == i;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(28.0f * fMz);
                if (z2) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(z ? new int[]{-13946542, -15189191} : new int[]{-1775880, -2691094});
                } else {
                    gradientDrawable.setColor(0);
                }
                gjssk.KLFTb.setBackground(new RippleDrawable(ColorStateList.valueOf(z ? 618914787 : 341732050), gradientDrawable, null));
                gjssk.JHa.setColorFilter(z2 ? i2 : i3, PorterDuff.Mode.SRC_IN);
                gjssk.xJ.setTextColor(z2 ? i2 : i3);
                gjssk.xJ.setTypeface(z2 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            }
            i4++;
        }
    }

    public final void BEUaYa(String str, String str2, String str3, String str4, kw kwVar) {
        EditText editText = new EditText(this);
        editText.setHint(str3);
        editText.setTextSize(14.0f);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle(str).setMessage(str2).setView(editText).setPositiveButton(str4, new rkYL(editText, kwVar)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final void BOPu() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(2002);
            }
        } catch (Exception unused) {
        }
    }

    public final View BWWRl(String str, String str2, int i, int i2) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i3 = (int) (24.0f * fMz);
        linearLayout.setPadding(i3, i3, i3, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fMz);
        gradientDrawable.setColor(this.xJ ? -13881549 : -854792);
        gradientDrawable.setStroke(Math.max(1, (int) fMz), this.xJ ? -12960446 : -1972757);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        FrameLayout frameLayout = new FrameLayout(this);
        int i4 = (int) (54.0f * fMz);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float f = 16.0f * fMz;
        gradientDrawable2.setCornerRadius(f);
        int[] iArrW0 = w0(i2, this.xJ);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrW0[0], iArrW0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        int i5 = (int) (28.0f * fMz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i5, i5, 17));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.bottomMargin = (int) f;
        linearLayout.addView(frameLayout, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(15.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(this.xJ ? -1842205 : -14737633);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(this.xJ ? -6643546 : -10525848);
        textView2.setPadding(0, (int) (fMz * 6.0f), 0, 0);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    public final void C() {
        View viewInflate = LayoutInflater.from(this).inflate(H4.AZxh, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(AbstractC1978u4.Dt);
        EditText editText = (EditText) viewInflate.findViewById(AbstractC1978u4.xJ);
        TextView textView = new TextView(this);
        textView.setText("加载应用列表中...");
        textView.setGravity(17);
        textView.setPadding(0, 60, 0, 60);
        textView.setTextColor(this.xJ ? -1711276033 : -1728053248);
        linearLayout.addView(textView);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        sjsh(viewInflate, alertDialogCreate);
        HashSet hashSet = new HashSet();
        new Thread(new wA(linearLayout, hashSet, new LinkedHashMap(), editText)).start();
        viewInflate.findViewById(AbstractC1978u4.mjFkc).setOnClickListener(new ZfxDd(alertDialogCreate));
        viewInflate.findViewById(AbstractC1978u4.ZfxDd).setOnClickListener(new KLFTb(hashSet, alertDialogCreate));
    }

    public final void C0(String str, boolean z) {
        this.mjFkc.post(new tjSezt(str, z));
    }

    public final boolean CBEvIj() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                byte[] bArrDigest = MessageDigest.getInstance(XMSSKeyParameters.SHA_256).digest(packageInfo.signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(String.format("%02x", Integer.valueOf(b & UByte.MAX_VALUE)));
                }
                return "5f6a730ca823387ce929ed1320f274cc1399722b0965bc551ed85868cf672a56".equalsIgnoreCase(sb.toString());
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final void CBhInx(LinearLayout linearLayout, String[][] strArr, TextView[] textViewArr, ScrollView[] scrollViewArr, boolean[] zArr) {
        float fMz = mz();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            String[] strArr2 = strArr[i2];
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(i);
            int i3 = -2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = (int) (8.0f * fMz);
            int length2 = strArr2.length;
            int i4 = i;
            while (i4 < length2) {
                String str = strArr2[i4];
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i3, 1.0f);
                layoutParams2.rightMargin = (int) (7.0f * fMz);
                linearLayout2.addView(WjcLD(str, new huTpC(zArr, str, textViewArr, scrollViewArr)), layoutParams2);
                i4++;
                length2 = length2;
                i = 0;
                i3 = -2;
            }
            linearLayout.addView(linearLayout2, layoutParams);
            i2++;
            i = 0;
        }
    }

    public final Method CO(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = this.qdMbNW.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            try {
                for (Method method : this.qdMbNW.getDeclaredMethods()) {
                    if (method.getName().equals(str)) {
                        method.setAccessible(true);
                        return method;
                    }
                }
            } catch (Exception unused2) {
            }
            Method method2 = this.OjSQV;
            if (method2 == null) {
                return null;
            }
            try {
                Method[] methodArr = (Method[]) method2.invoke(this.qdMbNW, Boolean.FALSE);
                if (methodArr == null) {
                    return null;
                }
                for (Method method3 : methodArr) {
                    if (method3.getName().equals(str)) {
                        method3.setAccessible(true);
                        return method3;
                    }
                }
                return null;
            } catch (Exception unused3) {
                return null;
            }
        }
    }

    public final Method[] CRhd() throws SecurityException {
        try {
            Method[] declaredMethods = this.qdMbNW.getDeclaredMethods();
            if (declaredMethods.length > 0) {
                return declaredMethods;
            }
        } catch (Exception unused) {
        }
        Method method = this.OjSQV;
        if (method != null) {
            try {
                Method[] methodArr = (Method[]) method.invoke(this.qdMbNW, Boolean.FALSE);
                if (methodArr != null) {
                    if (methodArr.length > 0) {
                        return methodArr;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return new Method[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void CrDc(boolean z) {
        View view;
        boolean zKgk = kgk();
        boolean zRV = RV();
        boolean z2 = getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false);
        Iterator it = this.Vnb.iterator();
        while (it.hasNext()) {
            for (qtZIjO qtzijo : ((gJsSk) it.next()).ZfxDd) {
                if (qtzijo.xJ && (view = qtzijo.MiMN) != null) {
                    boolean z3 = qtzijo.qdMbNW ? false : false;
                    view.setVisibility((z2 && z3) ? 8 : 0);
                    if (z || z3 != qtzijo.ETF) {
                        qtzijo.ETF = z3;
                        mz();
                        if (z3) {
                            qtzijo.MiMN.setAlpha(0.45f);
                            GradientDrawable gradientDrawable = qtzijo.IEE;
                            if (gradientDrawable != null) {
                                gradientDrawable.setColors(new int[]{-4735804, -6643546});
                                qtzijo.IEE.invalidateSelf();
                            }
                            ImageView imageView = qtzijo.qGY;
                            if (imageView != null) {
                                imageView.setColorFilter(-9736075, PorterDuff.Mode.SRC_IN);
                            }
                            TextView textView = qtzijo.rkYL;
                            if (textView != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(qtzijo.qdMbNW ? "等待 ADB 权限 · " : zKgk ? "高版本不可用 · " : "等待绑定 · ");
                                sb.append(qtzijo.Dt);
                                textView.setText(sb.toString());
                                qtzijo.rkYL.setTextColor(this.xJ ? -881790 : -3857889);
                            }
                        } else {
                            qtzijo.MiMN.setAlpha(1.0f);
                            int[] iArrW0 = w0(qtzijo.ZfxDd, this.xJ);
                            GradientDrawable gradientDrawable2 = qtzijo.IEE;
                            if (gradientDrawable2 != null) {
                                gradientDrawable2.setColors(new int[]{iArrW0[0], iArrW0[1]});
                                qtzijo.IEE.invalidateSelf();
                            }
                            ImageView imageView2 = qtzijo.qGY;
                            if (imageView2 != null) {
                                imageView2.setColorFilter(iArrW0[2], PorterDuff.Mode.SRC_IN);
                            }
                            TextView textView2 = qtzijo.rkYL;
                            if (textView2 != null) {
                                textView2.setText(qtzijo.Dt);
                                qtzijo.rkYL.setTextColor(this.xJ ? -6643546 : -10525848);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void D() {
        L("自定义背景", new xVYW[]{new xVYW("拉伸填满", "图片拉伸铺满整个背景", AbstractC1857s4.fehf, -10589486, new bWIyu()), new xVYW("居中原图", "保持原图比例居中显示", AbstractC1857s4.lgHUyS, -13916000, new XyP()), new xVYW("恢复默认", "清除自定义背景", AbstractC1857s4.BAnRFn, -10525848, new UDcil())}, 480.0f);
    }

    public final void D0(String str, boolean z) {
        this.JrJO = str;
        this.nxI = Boolean.valueOf(z);
        TextView textView = this.AZxh;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.bbzow;
        int i = -2543579;
        if (textView2 != null) {
            textView2.setText(str);
            TextView textView3 = this.bbzow;
            boolean z2 = this.xJ;
            textView3.setTextColor(z ? z2 ? -9647265 : -15171528 : z2 ? -881790 : -2543579);
        }
        if (this.VA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            if (z) {
                i = this.xJ ? -9647265 : -15171528;
            } else if (this.xJ) {
                i = -881790;
            }
            gradientDrawable.setColor(i);
            this.VA.setBackground(gradientDrawable);
            f0();
        }
        FPcN();
    }

    public final void DanUFX() {
        d0();
        this.mjFkc.postDelayed(new Qr(), 400L);
    }

    public final void Dc(Uri uri) {
        Y("正在准备本地 APK...");
        new Thread(new XbiWeM(uri)).start();
    }

    public final void DxPQMO(Intent intent) {
        if (intent != null) {
            if (!this.LREOK) {
                this.XbiWeM = intent;
                return;
            }
            Uri data = intent.getData();
            if (data != null) {
                String type = intent.getType();
                String path = data.getPath();
                if ("application/vnd.android.package-archive".equals(type) || ((path != null && path.toLowerCase().endsWith(".apk")) || "INSTALL_PACKAGE".equals(intent.getAction()) || "android.intent.action.INSTALL_PACKAGE".equals(intent.getAction()))) {
                    aQ("\n[*] 收到 APK intent: " + data);
                    this.mjFkc.postDelayed(new CqAnRZ(data), 600L);
                }
            }
        }
    }

    public final boolean E(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                int iMax = Math.max(1, width / 3);
                int iMax2 = Math.max(1, height / 3);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                PixelCopy.request(getWindow(), bitmapCreateBitmap, new UOnCkw(iMax, iMax2, bitmapCreateBitmap), this.mjFkc);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean E0(String str, long j, boolean z) throws InterruptedException, PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        while (true) {
            boolean z2 = false;
            if (System.currentTimeMillis() >= jCurrentTimeMillis) {
                return false;
            }
            try {
                getPackageManager().getPackageInfo(str, 0);
                z2 = true;
            } catch (Exception unused) {
            }
            if (z2 == z) {
                return true;
            }
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused2) {
            }
        }
    }

    public final LinearLayout Eey(boolean z) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        if ("检测中...".equals(this.JBhc)) {
            linearLayout.addView(MoUZ("检测中", AbstractC1857s4.Gd, -6643546, -4735804, z));
            return linearLayout;
        }
        if (this.Vdz) {
            linearLayout.addView(MoUZ("ADB", AbstractC1857s4.Ucbh, -13326253, -15171528, z));
        }
        if (this.jm) {
            View viewMoUZ = MoUZ("OW", AbstractC1857s4.huTpC, -7637518, -10337066, z);
            if (this.Vdz) {
                ((LinearLayout.LayoutParams) viewMoUZ.getLayoutParams()).leftMargin = (int) (mz() * 8.0f);
            }
            linearLayout.addView(viewMoUZ);
        }
        if (!this.Vdz && !this.jm) {
            linearLayout.addView(MoUZ("漏洞", AbstractC1857s4.Gd, -1424587, -3857889, z));
        }
        return linearLayout;
    }

    public final boolean EqDGZ(String str, String str2, String str3) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (gGFLGZ(str, str2, str3) || lowerCase.contains("apk") || lowerCase.contains("%2eapk") || lowerCase.contains("dl=") || lowerCase.contains("download")) {
            return true;
        }
        if (str2 != null && str2.toLowerCase().contains("attachment")) {
            return true;
        }
        if (str3 != null) {
            String lowerCase2 = str3.toLowerCase();
            if (lowerCase2.contains("octet-stream") || lowerCase2.contains("package-archive") || lowerCase2.contains("apk")) {
                return true;
            }
        }
        return false;
    }

    public final void F(String str) {
        runOnUiThread(new uH(str));
    }

    public final String F0() {
        return this.CqaNbM.length() > 0 ? this.CqaNbM : "未知";
    }

    public final boolean FBR() {
        if (this.Dt) {
            return true;
        }
        aQ("[!] 等待绑定");
        return false;
    }

    public final void FNhf(String str, String str2, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.Dt || this.qdMbNW == null) {
            aQ("[!] 无可用安装通道：ADB 安装未成功，zybos 也未绑定（高版本不可用）");
            Y("✗ 安装失败：ADB / zybos 通道均不可用");
            ZlB();
            return;
        }
        try {
            Class cls = Boolean.TYPE;
            Method methodCO = CO("setInstallPackageDisallow", cls);
            if (methodCO != null) {
                methodCO.invoke(this.lgHUyS, Boolean.FALSE);
                aQ("[+] setInstallPackageDisallow(false)");
            }
            Method methodCO2 = CO("silentInstallApk", String.class, cls, String.class);
            if (methodCO2 != null) {
                methodCO2.invoke(this.lgHUyS, str, Boolean.TRUE, str2);
                aQ("[+] silentInstallApk 已调用");
                Y("正在安装 " + str2 + "...");
            } else {
                aQ("[!] silentInstallApk 未找到");
                X("✗ silentInstallApk 未找到");
            }
        } catch (Exception e) {
            aQ("[!] 安装异常: " + mYYU(e));
            X("✗ 安装异常: " + mYYU(e));
        }
        this.mjFkc.postDelayed(new eEOGOh(z, str2), 5000L);
    }

    public final void FPcN() {
        String str;
        if (this.KRTLGT == null) {
            return;
        }
        Boolean bool = this.nxI;
        if (bool == null) {
            str = "● 正在连接 zybos…";
        } else if (bool.booleanValue()) {
            str = "● zybos 已连接 · " + F0();
        } else if (kgk()) {
            str = "○ " + F0() + " · 绑定不可用";
        } else {
            str = "○ zybos 未连接";
        }
        this.KRTLGT.setText(str);
        this.KRTLGT.animate().cancel();
        this.KRTLGT.setAlpha(0.0f);
        this.KRTLGT.animate().alpha(1.0f).setDuration(300L).start();
    }

    public final void FiDh() {
        boolean z = this.xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(48, 32, 48, 16);
        TextView textView = new TextView(this);
        textView.setText("输入 APK 直链 URL，通过应用商店代为下载安装。\nMD5 将自动计算，应用名从 APK 解析。");
        textView.setTextSize(12.0f);
        textView.setTextColor(z ? -419430401 : -570425344);
        linearLayout.addView(textView);
        EditText editText = new EditText(this);
        editText.setHint("http://192.168.x.x:8080/app.apk");
        editText.setTextSize(14.0f);
        editText.setTextColor(z ? -419430401 : -15066598);
        editText.setHintTextColor(z ? -1711276033 : -1728053248);
        linearLayout.addView(editText);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setTitle("直链安装").setView(linearLayout).setPositiveButton("发送", new LREOK(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        TextView textView2 = new TextView(this);
        textView2.setText("或使用内置浏览器搜索下载 APK");
        textView2.setTextSize(13.0f);
        textView2.setTextColor(z ? -11746561 : -16750656);
        textView2.setGravity(17);
        textView2.setPadding(0, (int) (getResources().getDisplayMetrics().density * 10.0f), 0, 0);
        textView2.setOnClickListener(new fFz(alertDialogCreate));
        linearLayout.addView(textView2);
        alertDialogCreate.show();
        YfFg(alertDialogCreate);
    }

    public final void FoO() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ZybSettings"));
            intent.putExtra(":settings:show_fragment", "com.android.settings.development.qstile.DevelopmentTileConfigFragment");
            intent.setFlags(268435456);
            startActivity(intent);
            aQ("[*] 开发者磁贴已跳转");
        } catch (Exception e) {
            aQ("[!] 开发者磁贴: " + e.getMessage());
            X("无法打开开发者磁贴");
        }
    }

    public final void FoPRDo(gJsSk gjssk, String str) {
        qtZIjO qtzijo = new qtZIjO(null);
        qtzijo.mjFkc = str;
        qtzijo.VA = true;
        gjssk.ZfxDd.add(qtzijo);
    }

    public final void Frh() {
        aQ("\n[*] 打开无线调试配对页面...");
        new Thread(new Moer()).start();
    }

    public final void G(String str) {
        int i;
        try {
            b();
            float f = getResources().getDisplayMetrics().density;
            FrameLayout frameLayout = new FrameLayout(this);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            int i2 = (int) (14.0f * f);
            int i3 = (int) (10.0f * f);
            linearLayout.setPadding(i2, i3, i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i4 = (int) (8.0f * f);
            gradientDrawable.setCornerRadius(i4);
            gradientDrawable.setColor(this.xJ ? -232051925 : -150994945);
            gradientDrawable.setStroke(1, this.xJ ? -12961222 : -1315861);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setVisibility(8);
            this.eyqo = linearLayout;
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams((int) (240.0f * f), -2));
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(this);
            textView.setText("正在获取 APK 校验信息...");
            textView.setTextSize(11.0f);
            textView.setTextColor(this.xJ ? -419430401 : -15066598);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView2 = new TextView(this);
            textView2.setText("取消");
            textView2.setTextSize(11.0f);
            textView2.setTextColor(this.xJ ? -26204 : -3921124);
            textView2.setGravity(17);
            int i5 = (int) (2.0f * f);
            textView2.setPadding(i3, i5, i5, i5);
            textView2.setOnClickListener(new tISON());
            linearLayout2.addView(textView2);
            ProgressBar progressBar = new ProgressBar(this, null, R.attr.progressBarStyleHorizontal);
            this.Ucbh = progressBar;
            progressBar.setMax(100);
            this.Ucbh.setProgress(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i4);
            layoutParams.topMargin = (int) (6.0f * f);
            linearLayout.addView(this.Ucbh, layoutParams);
            TextView textView3 = new TextView(this);
            this.diqgf = textView3;
            textView3.setText("0%");
            this.diqgf.setTextSize(11.0f);
            this.diqgf.setTextColor(this.xJ ? -16437175 : -1);
            this.diqgf.setGravity(17);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(this.xJ ? -431176961 : -436181056);
            gradientDrawable2.setStroke(1, 1157627903);
            this.diqgf.setBackground(gradientDrawable2);
            int i6 = (int) (52.0f * f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i6);
            layoutParams2.gravity = 17;
            frameLayout.addView(this.diqgf, layoutParams2);
            frameLayout.setOnTouchListener(new lti(f));
            this.Pq = frameLayout;
            this.IEE = (WindowManager) getSystemService("window");
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-2, -2, 2038, 296, -3);
            layoutParams3.gravity = 8388659;
            int i7 = this.Gd;
            if (i7 < 0 || (i = this.HGpJ) < 0) {
                layoutParams3.x = getResources().getDisplayMetrics().widthPixels - ((int) (80.0f * f));
                layoutParams3.y = (int) (f * 140.0f);
            } else {
                layoutParams3.x = i7;
                layoutParams3.y = i;
            }
            this.IEE.addView(this.Pq, layoutParams3);
            this.huTpC = false;
        } catch (Exception unused) {
        }
    }

    public final void GmK(String str) {
        this.mjFkc.post(new gYa(str));
    }

    public final void H(boolean z, String str, String str2) {
        pJeaSR pjeasr = new pJeaSR(z, str, str2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            pjeasr.run();
        } else {
            this.mjFkc.post(pjeasr);
        }
    }

    public final void HBzZAD(boolean z, boolean z2, boolean z3) {
        this.mjFkc.post(new ub(z, z2, z3));
    }

    public final String HGlNf(File file) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return this.ofUPN();
        }
    }

    public final String HL() {
        return com.jc.code.v3.AZxh.KLFTb() ? "本地 ADB 模式（断网可用）" : com.jc.code.v3.mjFkc.xrEuO() ? "已连接（无线调试）" : com.jc.code.v3.mjFkc.NPj() ? "已配对" : getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false) ? "已配对·待连接" : qpjZLY() ? "无线调试已开启·未配对" : "未配对";
    }

    public final void HPA() {
        this.mjFkc.post(new vUsV());
    }

    public final void HRWx() {
        aQ("\n[*] 安装 CA 证书...");
        Y("正在安装 CA 证书...");
        try {
            InputStream inputStreamOpen = getAssets().open("devca.crt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            inputStreamOpen.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (pGB(byteArray)) {
                aQ("[+] CA 已通过设备所有者静默安装");
                Y("✓ CA 证书已安装");
                return;
            }
            Intent intent = new Intent("android.security.IKeyChainService");
            intent.setComponent(new ComponentName("com.android.keychain", "com.android.keychain.KeyChainService"));
            Vdz vdz = new Vdz(byteArray, new ServiceConnection[]{vdz});
            if (bindService(intent, vdz, 1)) {
                return;
            }
            aQ("[!] KeyChainService 绑定失败，回退引导安装");
            iBHnK();
        } catch (Throwable th) {
            aQ("[!] 安装证书异常: " + mYYU(th) + "，回退引导安装");
            iBHnK();
        }
    }

    public final void I() {
        View viewInflate = LayoutInflater.from(this).inflate(H4.AZxh, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(AbstractC1978u4.Dt);
        EditText editText = (EditText) viewInflate.findViewById(AbstractC1978u4.xJ);
        TextView textView = (TextView) viewInflate.findViewById(AbstractC1978u4.qGY);
        if (textView != null) {
            textView.setText("单独应用防卸载（勾选即生效）");
        }
        View viewFindViewById = viewInflate.findViewById(AbstractC1978u4.ZfxDd);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(AbstractC1978u4.mjFkc);
        if (textView2 != null) {
            textView2.setText("关闭");
        }
        TextView textView3 = new TextView(this);
        textView3.setText("勾选 = 防卸载保护，取消勾选 = 解除，点按立即生效。\n✓ 被保护的应用关机重启后也不会被删除（比「阻止系统删应用」更持久）。\n仅恢复出厂 / 刷机会清除应用数据，重要资料仍建议备份。");
        textView3.setTextSize(11.5f);
        textView3.setTextColor(this.xJ ? -6643546 : -10525848);
        textView3.setPadding(0, 0, 0, (int) (mz() * 10.0f));
        ((ViewGroup) viewInflate).addView(textView3, 2);
        TextView textView4 = new TextView(this);
        textView4.setText("加载应用列表中...");
        textView4.setGravity(17);
        textView4.setPadding(0, 60, 0, 60);
        textView4.setTextColor(this.xJ ? -1711276033 : -1728053248);
        linearLayout.addView(textView4);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        sjsh(viewInflate, alertDialogCreate);
        new HashSet();
        new Thread(new Dt(linearLayout, new LinkedHashMap(), editText), "jc-guard-list").start();
        viewInflate.findViewById(AbstractC1978u4.mjFkc).setOnClickListener(new VA(alertDialogCreate));
    }

    public final String IRE() {
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        return sharedPreferences.getBoolean("adb_pairing_verified", false) ? sharedPreferences.getString("adb_pairing_id", "jc_code_v3") : "jc_code_v3";
    }

    public final qtZIjO IRYXZ(gJsSk gjssk, String str, String str2, int i, int i2, Runnable runnable, boolean z, boolean z2) {
        qtZIjO qtzijoJBjLUy = JBjLUy(gjssk, str, str2, i, i2, runnable, z);
        qtzijoJBjLUy.xJ = z2;
        return qtzijoJBjLUy;
    }

    public final void Io() {
        ScreenCaptureService.setListener(new SmIWf());
    }

    public final void Ipwl() throws InterruptedException {
        if (com.jc.code.v3.AZxh.KLFTb() || com.jc.code.v3.mjFkc.xrEuO()) {
            return;
        }
        if (com.jc.code.v3.mjFkc.NPj() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            aQ("[*] ADB 通道未就绪（冷启动），等待自动重连...");
            Y("ADB 通道准备中...");
            long jCurrentTimeMillis = System.currentTimeMillis() + 4000;
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                if (com.jc.code.v3.AZxh.KLFTb() || com.jc.code.v3.mjFkc.xrEuO()) {
                    return;
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            aQ("[*] 主动重建 ADB 会话...");
            try {
                String strBbzow = com.jc.code.v3.mjFkc.bbzow("echo ok");
                StringBuilder sb = new StringBuilder();
                sb.append("[*] 会话重建: ");
                sb.append(strBbzow != null ? strBbzow.trim() : BuildConfig.FLAVOR);
                aQ(sb.toString());
            } catch (Throwable th) {
                aQ("[!] 会话重建失败: " + mYYU(th));
            }
            com.jc.code.v3.mjFkc.alEkx();
            long jCurrentTimeMillis2 = System.currentTimeMillis() + 6000;
            while (System.currentTimeMillis() < jCurrentTimeMillis2 && !com.jc.code.v3.AZxh.KLFTb()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public final void IxLrZ() {
        if (RV() || KbpP()) {
            Z();
        } else {
            U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("终端工具").setMessage("终端需要以下任一权限：\n\n· ADB（无线调试配对后可用）\n· 设备所有者 OW（「申请设备所有者」后可用）\n\nADB 模式执行 shell 命令，OW 模式执行设备所有者命令。").setPositiveButton("去ADB激活", new YoKzxo()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    public final void J() {
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("guard_uninstall_warned", false)) {
            return;
        }
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("guard_uninstall_warned", true).apply();
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("防卸载已开启 · 保护说明").setMessage("被保护的应用不会被卸载或删除，关机重启后保护依然有效。\n\n与「阻止系统删应用」的区别：\n· 阻止系统删应用（停用 PadMS）只在本次开机有效——系统每次开机 PadMS 都会扫描删除应用\n· 单独应用防卸载由设备所有者强制执行，重启 / 关机后依然有效\n\n仍请注意：恢复出厂 / 刷机会清除全部应用数据，重要资料建议定期备份。").setPositiveButton("我知道了", (DialogInterface.OnClickListener) null));
    }

    public final qtZIjO JBjLUy(gJsSk gjssk, String str, String str2, int i, int i2, Runnable runnable, boolean z) {
        qtZIjO qtzijo = new qtZIjO(null);
        qtzijo.mjFkc = str;
        qtzijo.AZxh = str2;
        qtzijo.wA = i;
        qtzijo.ZfxDd = i2;
        qtzijo.KLFTb = runnable;
        qtzijo.JHa = z;
        qtzijo.Dt = str2;
        gjssk.ZfxDd.add(qtzijo);
        return qtzijo;
    }

    public final void JGvOM() {
        try {
            String strJxC = jxC("settings get secure enabled_accessibility_services");
            if (strJxC == null) {
                return;
            }
            String strTrim = strJxC.trim();
            if (!strTrim.isEmpty() && !"null".equalsIgnoreCase(strTrim)) {
                String[] strArrSplit = strTrim.split(":");
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (String str : strArrSplit) {
                    if (str != null && !str.trim().isEmpty()) {
                        if (str.toLowerCase().contains("pairingaccessibilityservice")) {
                            z = true;
                        } else {
                            if (sb.length() > 0) {
                                sb.append(":");
                            }
                            sb.append(str.trim());
                        }
                    }
                }
                if (z) {
                    if (sb.length() == 0) {
                        jxC("settings put secure accessibility_enabled 0");
                        jxC("settings delete secure enabled_accessibility_services");
                    } else {
                        jxC("settings put secure enabled_accessibility_services '" + ((Object) sb) + "'");
                    }
                    aQ("[*] 已清理残留的 JC Code 无障碍服务");
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void JQSH() throws IOException {
        this.KLFTb = findViewById(AbstractC1978u4.rkYL);
        this.JHa = findViewById(AbstractC1978u4.lgHUyS);
        this.wA = (TextView) findViewById(AbstractC1978u4.Ucbh);
        this.ZfxDd = (TextView) findViewById(AbstractC1978u4.huTpC);
        this.AZxh = (TextView) findViewById(AbstractC1978u4.eyqo);
        this.VA = findViewById(AbstractC1978u4.JHa);
        this.xJ = getSharedPreferences("jc_code_prefs", 0).getBoolean("night_mode", false);
        View view = (View) this.AZxh.getParent();
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
            LinearLayout linearLayout = (LinearLayout) view.getParent();
            int iIndexOfChild = linearLayout.indexOfChild(view);
            linearLayout.removeView(view);
            this.ANMGZc = Eey(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (mz() * 32.0f);
            linearLayout.addView(this.ANMGZc, iIndexOfChild, layoutParams);
        }
        this.KLFTb.setOnLongClickListener(new LsBneK());
        nTET();
        SllyO();
        nVsW(false);
        wsbqN();
        SrJcM(this.xJ);
        p0(0, false);
        fTu();
    }

    public final TextView JTqL(String str) {
        float fMz = mz();
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        int i = (int) (16.0f * fMz);
        int i2 = (int) (fMz * 8.0f);
        textView.setPadding(i, i2, i, i2);
        textView.setClickable(true);
        textView.setFocusable(true);
        return textView;
    }

    public final void Jkjs(String str, String str2, String str3) {
        String strTrim;
        if (str != null) {
            while (true) {
                strTrim = str.trim();
                if (strTrim.length() <= 0 || !(strTrim.endsWith("\"") || strTrim.endsWith("'") || strTrim.endsWith(")"))) {
                    break;
                } else {
                    str = strTrim.substring(0, strTrim.length() - 1);
                }
            }
            str = strTrim.replace("&amp;", "&").replace("&#38;", "&").replace("&quot;", "\"").replace("&#039;", "'");
        }
        this.mByQ = false;
        F("正在获取 APK 校验信息");
        new Thread(new jx(str, str3, str2)).start();
    }

    public final boolean JtIAgM() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            try {
                int i = HiddenApiBypass.mjFkc;
                HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
                return true;
            } catch (NoSuchMethodException | Exception unused) {
                Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(Class.class, "getDeclaredMethodsUnchecked", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                this.OjSQV = method;
                return true;
            }
        } catch (Exception unused2) {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = cls.getDeclaredMethod("getRuntime", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            try {
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod("setHiddenApiExemptions", String[].class);
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(objInvoke, new String[]{"L"});
                    return true;
                } catch (NoSuchMethodException unused3) {
                    Method declaredMethod3 = cls.getDeclaredMethod("disableHiddenApiRestrictions", null);
                    declaredMethod3.setAccessible(true);
                    declaredMethod3.invoke(objInvoke, null);
                    return true;
                }
            } catch (Exception unused4) {
                return false;
            }
        }
    }

    public final void K(String str) {
        aQ("[!] " + str + " 在当前版本 " + F0() + " 不可用（zybos 绑定已失效）");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, S4.mjFkc);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("不可用");
        U(builder.setTitle(sb.toString()).setMessage("当前 ZYB 系统版本 " + F0() + "（>= 7.10）\n该功能依赖 zybos 绑定，已被系统签名校验封禁。\n\n仍可用的替代方案：\n· 打开无线调试配对页面 → ADB 静默安装 / 卸载\n· 直链安装（广播通道）\n· 系统应用卸载（ADB / Root）").setPositiveButton("知道了", (DialogInterface.OnClickListener) null));
    }

    public final boolean KbpP() {
        DevicePolicyManager devicePolicyManager;
        List<ComponentName> activeAdmins;
        try {
            devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy");
        } catch (Throwable unused) {
        }
        if (devicePolicyManager == null) {
            return false;
        }
        String packageName = getPackageName();
        if (devicePolicyManager.isDeviceOwnerApp(packageName) && (activeAdmins = devicePolicyManager.getActiveAdmins()) != null) {
            for (ComponentName componentName : activeAdmins) {
                if (componentName != null && packageName.equals(componentName.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void L(String str, xVYW[] xvywArr, float f) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (14.0f * fMz);
        linearLayout.setPadding(i, i, i, i);
        AlertDialog[] alertDialogArr = new AlertDialog[1];
        for (xVYW xvyw : xvywArr) {
            View viewQMaC = qMaC(xvyw);
            viewQMaC.setOnClickListener(new OzIs(alertDialogArr, xvyw));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = (int) (10.0f * fMz);
            linearLayout.addView(viewQMaC, layoutParams);
        }
        AlertDialog alertDialogU = U(new AlertDialog.Builder(this, S4.mjFkc).setTitle(str).setView(linearLayout).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        u(alertDialogU, f);
        alertDialogArr[0] = alertDialogU;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0139 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void LyQ() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object systemService;
        Class<?> cls;
        Exception exc;
        boolean z;
        SecurityException securityException;
        Method declaredMethod;
        Object objInvoke;
        aQ("\n[*] 手动尝试绑定 zybos_manager...");
        StringBuilder sb = new StringBuilder();
        sb.append("=== 手动绑定诊断 ===\n\n");
        boolean zJtIAgM = JtIAgM();
        sb.append("[1] Hidden API bypass: ");
        String str = "OK";
        sb.append(zJtIAgM ? "OK" : "失败");
        sb.append("\n");
        aQ("[1] bypassHiddenApi = " + zJtIAgM);
        try {
            systemService = getSystemService("zybos_manager");
            try {
                sb.append("[2] getSystemService(zybos_manager): ");
                sb.append(systemService != null ? "获取到" : "返回 null");
                sb.append("\n");
            } catch (Exception e) {
                e = e;
                sb.append("[2] getSystemService 异常: ");
                sb.append(e.getMessage());
                sb.append("\n");
                aQ("[2] zybos_manager service = " + systemService);
                cls = Class.forName("android.os.ZybosSysApiManager");
                sb.append("[3] ZybosSysApiManager 类: 存在\n");
                aQ("[3] class = " + cls);
                if (cls != null) {
                }
                sb.append("\n[5] 实际调用测试（探测签名校验）:\n");
                if (systemService == null) {
                    sb.append("    服务/类不可用，跳过\n");
                }
                sb.append("\n════════════════════\n");
                if (kgk()) {
                }
                aQ("\n" + sb.toString());
                T("手动尝试绑定", sb.toString());
                if (!this.Dt) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            systemService = null;
        }
        aQ("[2] zybos_manager service = " + systemService);
        try {
            cls = Class.forName("android.os.ZybosSysApiManager");
        } catch (Exception e3) {
            e = e3;
            cls = null;
        }
        try {
            sb.append("[3] ZybosSysApiManager 类: 存在\n");
        } catch (Exception e4) {
            e = e4;
            sb.append("[3] ZybosSysApiManager 类: 不存在 ");
            sb.append(e.getMessage());
            sb.append("\n");
            aQ("[3] class = " + cls);
            if (cls != null) {
            }
            sb.append("\n[5] 实际调用测试（探测签名校验）:\n");
            if (systemService == null) {
            }
            sb.append("\n════════════════════\n");
            if (kgk()) {
            }
            aQ("\n" + sb.toString());
            T("手动尝试绑定", sb.toString());
            if (!this.Dt) {
            }
        }
        aQ("[3] class = " + cls);
        if (cls != null) {
            try {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                sb.append("[4] 反射到方法数: ");
                sb.append(length);
                sb.append("\n");
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                for (Method method : declaredMethods) {
                    String name = method.getName();
                    if ("silentInstallApk".equals(name)) {
                        z2 = true;
                    }
                    if ("silentUninstallApk".equals(name)) {
                        z3 = true;
                    }
                    if ("setPackageListDisallow".equals(name)) {
                        z4 = true;
                    }
                }
                sb.append("    silentInstallApk: ");
                sb.append(z2 ? "OK" : "X");
                sb.append("\n");
                sb.append("    silentUninstallApk: ");
                sb.append(z3 ? "OK" : "X");
                sb.append("\n");
                sb.append("    setPackageListDisallow: ");
                if (!z4) {
                    str = "X";
                }
                sb.append(str);
                sb.append("\n");
            } catch (Exception e5) {
                sb.append("[4] 方法扫描异常: ");
                sb.append(e5.getMessage());
                sb.append("\n");
            }
        }
        sb.append("\n[5] 实际调用测试（探测签名校验）:\n");
        if (systemService == null || cls == null) {
            sb.append("    服务/类不可用，跳过\n");
        } else {
            try {
                Method[] declaredMethods2 = cls.getDeclaredMethods();
                int length2 = declaredMethods2.length;
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        declaredMethod = null;
                        break;
                    }
                    declaredMethod = declaredMethods2[i];
                    if ("isDisallowInstallPackage".equals(declaredMethod.getName())) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (declaredMethod == null) {
                    try {
                        declaredMethod = cls.getDeclaredMethod("isSilentInstallDisallow", String.class);
                    } catch (Exception unused) {
                    }
                }
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    try {
                        objInvoke = declaredMethod.invoke(systemService, null);
                    } catch (IllegalArgumentException unused2) {
                        objInvoke = declaredMethod.invoke(systemService, "com.test.pkg");
                    }
                    sb.append("    调用成功! 返回: ");
                    sb.append(objInvoke);
                    sb.append(" - 绑定可用!\n");
                    try {
                        this.lgHUyS = systemService;
                        this.qdMbNW = cls;
                        this.Dt = true;
                        fg();
                        z = true;
                    } catch (SecurityException e6) {
                        securityException = e6;
                        z = true;
                        sb.append("    X SecurityException: ");
                        sb.append(securityException.getMessage());
                        sb.append("\n");
                        sb.append("    - zybos 被系统签名校验封禁 (enforceCallerIsSystem)\n");
                        sb.append("    仅 system(1000)/root(0)/平台签名应用可调用\n");
                        if (!z) {
                        }
                        sb.append("\n════════════════════\n");
                        if (kgk()) {
                        }
                        aQ("\n" + sb.toString());
                        T("手动尝试绑定", sb.toString());
                        if (!this.Dt) {
                        }
                    } catch (Exception e7) {
                        exc = e7;
                        z = true;
                        sb.append("    调用异常: ");
                        sb.append(exc.getMessage());
                        sb.append("\n");
                        if (!z) {
                        }
                        sb.append("\n════════════════════\n");
                        if (kgk()) {
                        }
                        aQ("\n" + sb.toString());
                        T("手动尝试绑定", sb.toString());
                        if (!this.Dt) {
                        }
                    }
                } else {
                    sb.append("    未找到可用的测试方法\n");
                    z = false;
                }
            } catch (SecurityException e8) {
                securityException = e8;
                z = false;
            } catch (Exception e9) {
                exc = e9;
                z = false;
            }
            if (!z) {
                aQ("[5] 调用被拦截（预期：高版本签名校验）");
            }
        }
        sb.append("\n════════════════════\n");
        if (kgk()) {
            sb.append("当前 ");
            sb.append(F0());
            sb.append("：自动绑定已禁用\n");
            sb.append("此诊断用于排查 root/LSPosed/改 services.jar 后\n绑定是否恢复。");
        } else {
            sb.append("当前 ");
            sb.append(F0());
            sb.append("：低版本应已自动绑定。");
        }
        aQ("\n" + sb.toString());
        T("手动尝试绑定", sb.toString());
        if (!this.Dt) {
            D0("绑定被系统校验拦截", false);
            return;
        }
        D0("手动绑定成功 · zybos 可用", true);
        boolean z5 = this.xJ;
        SZKiB(z5, z5 ? -1842205 : -14737633, z5 ? -6643546 : -12302522);
        fg();
    }

    public final void M() {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        int i = (int) (26.0f * fMz);
        int i2 = (int) (18.0f * fMz);
        linearLayout.setPadding(i, i2, i, (int) (fMz * 16.0f));
        View viewBWWRl = BWWRl("安装本地 APK", "文件选择 / 手动输入路径", AbstractC1857s4.Pq, -10589486);
        View viewBWWRl2 = BWWRl("直链安装", "URL 远程安装（商店通道）", AbstractC1857s4.VA, -15171528);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = i2;
        linearLayout.addView(viewBWWRl, layoutParams);
        linearLayout.addView(viewBWWRl2, layoutParams2);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setTitle("安装 APP").setView(linearLayout).create();
        alertDialogCreate.show();
        YfFg(alertDialogCreate);
        u(alertDialogCreate, 720.0f);
        viewBWWRl.setOnClickListener(new IPpyV(alertDialogCreate));
        viewBWWRl2.setOnClickListener(new kOlLW(alertDialogCreate));
    }

    public final void MLqR() throws IOException {
        View view;
        Bitmap bitmapCreateScaledBitmap;
        String string = getSharedPreferences("jc_code_prefs", 0).getString("bg_uri", null);
        if (string == null || string.isEmpty()) {
            return;
        }
        String string2 = getSharedPreferences("jc_code_prefs", 0).getString("bg_scale", "stretch");
        try {
            Uri uri = Uri.parse(string);
            try {
                getContentResolver().takePersistableUriPermission(uri, 1);
            } catch (Exception unused) {
            }
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                inputStreamOpenInputStream.close();
                if (bitmapDecodeStream == null || (view = this.KLFTb) == null) {
                    return;
                }
                int width = view.getWidth();
                int height = this.KLFTb.getHeight();
                if (width == 0 || height == 0) {
                    width = getResources().getDisplayMetrics().widthPixels;
                    height = getResources().getDisplayMetrics().heightPixels;
                }
                if ("center".equals(string2)) {
                    float fMax = Math.max(width / bitmapDecodeStream.getWidth(), height / bitmapDecodeStream.getHeight());
                    int width2 = (int) (bitmapDecodeStream.getWidth() * fMax);
                    int height2 = (int) (bitmapDecodeStream.getHeight() * fMax);
                    bitmapCreateScaledBitmap = Bitmap.createBitmap(Bitmap.createScaledBitmap(bitmapDecodeStream, width2, height2, true), (width2 - width) / 2, (height2 - height) / 2, width, height);
                } else {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, width, height, true);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateScaledBitmap);
                bitmapDrawable.setAlpha(180);
                this.KLFTb.setBackground(bitmapDrawable);
            }
        } catch (Exception unused2) {
            getSharedPreferences("jc_code_prefs", 0).edit().remove("bg_uri").apply();
        }
    }

    public final void MQhVKd() throws IOException {
        getSharedPreferences("jc_code_prefs", 0).edit().remove("bg_uri").apply();
        SrJcM(this.xJ);
        X("已恢复默认背景");
    }

    public final View MoUZ(String str, int i, int i2, int i3, boolean z) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i4 = (int) ((z ? 8 : 10) * fMz);
        int i5 = (int) ((z ? 3.0f : 4.5f) * fMz);
        linearLayout.setPadding(i4, i5, i4, i5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((z ? 12 : 15) * fMz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setColors(new int[]{i2, i3});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setElevation(this.xJ ? 0.0f : 2.0f * fMz);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        int i6 = (int) ((z ? 10.0f : 11.5f) * fMz);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i6, i6));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(z ? 10.5f : 11.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-1);
        textView.setLetterSpacing(0.03f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) (fMz * 4.0f);
        linearLayout.addView(textView, layoutParams);
        return linearLayout;
    }

    public final void N(String str, String str2) {
        this.mjFkc.post(new np(str, str2));
    }

    public final void NBLVO(boolean z, int i, int i2) {
        if (this.aqHPIZ == null) {
            return;
        }
        float fMz = mz();
        LinearLayout linearLayout = this.aqHPIZ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = 32.0f * fMz;
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -12960446);
        } else {
            linearLayout.setElevation(3.0f * fMz);
        }
        linearLayout.setBackground(gradientDrawable);
        linearLayout.removeAllViews();
        linearLayout.setGravity(1);
        int i3 = (int) (28.0f * fMz);
        linearLayout.setPadding(i3, (int) f, i3, (int) (30.0f * fMz));
        RURGdp(linearLayout, fMz);
        Ule(linearLayout, fMz, i, i2);
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Math.max(1, (int) fMz));
        int i4 = (int) (12.0f * fMz);
        layoutParams.topMargin = i4;
        layoutParams.bottomMargin = i4;
        view.setBackgroundColor(z ? 535028707 : 338439212);
        linearLayout.addView(view);
        VzXmn(linearLayout, fMz, z, i, i2);
    }

    public final String NBXYLM() {
        String string = getSharedPreferences("jc_code_prefs", 0).getString("search_title", null);
        return (string == null || string.trim().isEmpty()) ? "JC Code 搜索" : string.trim();
    }

    public final String NU() {
        String property;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager != null) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                NetworkCapabilities networkCapabilities = activeNetwork != null ? connectivityManager.getNetworkCapabilities(activeNetwork) : null;
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(4)) {
                        return "VPN";
                    }
                }
            }
        } catch (Throwable unused) {
        }
        try {
            property = System.getProperty("http.proxyHost");
        } catch (Throwable unused2) {
        }
        if (property != null && property.trim().length() > 0) {
            return "网络代理";
        }
        String string = Settings.Global.getString(getContentResolver(), "http_proxy");
        if (string != null && string.trim().length() > 0) {
            if (!":0".equals(string.trim())) {
                return "网络代理";
            }
        }
        return null;
    }

    public final void O() {
        boolean z = this.xJ;
        View viewInflate = LayoutInflater.from(this).inflate(H4.wA, (ViewGroup) null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDisplayMetrics().density * 28.0f);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) mz()), -12960446);
        }
        viewInflate.setBackground(gradientDrawable);
        this.YoKzxo = (TextView) viewInflate.findViewById(AbstractC1978u4.IEE);
        this.rkYL = (ScrollView) viewInflate.findViewById(AbstractC1978u4.MiMN);
        TextView textView = this.YoKzxo;
        if (textView != null) {
            textView.setText(this.MiMN.toString());
            this.YoKzxo.setTextColor(z ? -6643546 : -12302522);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(AbstractC1978u4.Pq);
        if (textView2 != null) {
            textView2.setTextColor(z ? -1842205 : -14737633);
        }
        View viewFindViewById = viewInflate.findViewById(AbstractC1978u4.MiMN);
        if (viewFindViewById != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(getResources().getDisplayMetrics().density * 16.0f);
            gradientDrawable2.setColor(z ? -13618892 : -985863);
            viewFindViewById.setBackground(gradientDrawable2);
        }
        viewInflate.findViewById(AbstractC1978u4.AZxh).setOnClickListener(new ArO());
        viewInflate.findViewById(AbstractC1978u4.wA).setOnClickListener(new RWb());
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        ScrollView scrollView = this.rkYL;
        if (scrollView != null) {
            scrollView.post(new jTNPnW());
        }
    }

    public final void OGo() {
        if (this.Dt || RV()) {
            L("静默卸载", new xVYW[]{new xVYW("从应用列表选择", "搜索并多选应用批量卸载", AbstractC1857s4.wA, -2543579, new mjFkc()), new xVYW("手动输入应用名", "输入显示名称自动查找卸载", AbstractC1857s4.MiMN, -1543926, new AZxh())}, 480.0f);
        } else {
            aQ("[!] 无可用卸载通道：ADB 未连接，zybos 未绑定");
            X("✗ 请先完成无线调试配对");
        }
    }

    public final void ORe() {
        View view = this.fFz;
        if (view == null) {
            return;
        }
        this.fFz = null;
        View view2 = this.KLFTb;
        if (view2 != null) {
            view2.setAlpha(0.55f);
            view2.setScaleX(0.985f);
            view2.setScaleY(0.985f);
            view2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(340L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
        }
        view.animate().alpha(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f)).withEndAction(new ERt(view)).start();
    }

    public final void P() {
        EditText editText = new EditText(this);
        editText.setText("/storage/emulated/0/");
        editText.setTextSize(14.0f);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setTitle("输入完整路径").setView(editText).setPositiveButton("安装", new ZGL(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.show();
        YfFg(alertDialogCreate);
        u(alertDialogCreate, 520.0f);
    }

    public final void PX() {
        String str;
        boolean z = com.jc.code.v3.AZxh.KLFTb() || com.jc.code.v3.mjFkc.xrEuO();
        boolean zKbpP = KbpP();
        if (z && zKbpP) {
            try {
                str = getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
                str = "未安装";
            }
            boolean z2 = str != null && str.startsWith("3.2");
            U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("一键开开发者").setMessage("流程：\n① 下载 3.2 个人中心（临时降级）\n② 安装必要组件\n③ 验证后自动进入开发者\n④ 自动恢复系统版本\n\n当前个人中心：" + str + "\n过程约 1~2 分钟，期间部分功能暂不可用，完成后自动恢复。").setPositiveButton(z2 ? "开始" : "下载并开始", new WGXroI()).setNegativeButton("关闭", (DialogInterface.OnClickListener) null));
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append("· ADB 通道（未激活）\n");
        }
        if (!zKbpP) {
            sb.append("· 设备所有者 OW（未激活）\n");
        }
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("无法使用").setMessage("此功能需要同时具备以下两项，当前缺少：\n\n" + ((Object) sb) + "\nADB 到「ADB激活页面」配对；OW 到「申请设备所有者」激活。").setPositiveButton("去ADB激活", new nxI()).setNegativeButton("知道了", (DialogInterface.OnClickListener) null));
    }

    public final void PvPg(Throwable th) {
        String strMYYU = mYYU(th);
        String lowerCase = strMYYU.toLowerCase();
        if (strMYYU.contains("not paired") || lowerCase.contains("authentication") || lowerCase.contains("pairing might be revoked")) {
            aQ("[!] ADB 连接异常: " + strMYYU);
            aQ("[*] 不清理配对状态，下次使用自动重连；确需重配时用「开发者工具 → 打开无线调试配对页面」");
            s0("ADB 连接异常，将自动重连");
            this.mjFkc.post(new vadzgd());
        }
    }

    public final void Q() {
        EditText editText = new EditText(this);
        editText.setHint("输入应用名称（如：微信）");
        editText.setTextSize(14.0f);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("手动卸载").setMessage("输入应用显示名称，自动查找并卸载").setView(editText).setPositiveButton("卸载", new xJ(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final View QQi(qtZIjO qtzijo) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(8388611);
        int i = (int) (18.0f * fMz);
        linearLayout.setPadding(i, i, i, (int) (16.0f * fMz));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fMz);
        if (this.xJ) {
            gradientDrawable.setColor(-13881549);
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -12960446);
        } else {
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -1709843);
        }
        linearLayout.setBackground(gradientDrawable);
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = (int) (44.0f * fMz);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.bottomMargin = (int) (12.0f * fMz);
        frameLayout.setLayoutParams(layoutParams);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(14.0f * fMz);
        int[] iArrW0 = w0(qtzijo.ZfxDd, this.xJ);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrW0[0], iArrW0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(qtzijo.wA);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(iArrW0[2], PorterDuff.Mode.SRC_IN);
        int i3 = (int) (24.0f * fMz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i3, i3, 17));
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(this);
        textView.setText(qtzijo.mjFkc);
        textView.setTextSize(15.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(8388611);
        textView.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(qtzijo.AZxh);
        textView2.setTextSize(12.5f);
        textView2.setGravity(8388611);
        textView2.setMaxLines(1);
        textView2.setEllipsize(truncateAt);
        textView2.setPadding(0, (int) (fMz * 3.0f), 0, 0);
        linearLayout.addView(textView2);
        qtzijo.MiMN = linearLayout;
        qtzijo.YoKzxo = textView;
        qtzijo.rkYL = textView2;
        qtzijo.qGY = imageView;
        qtzijo.fehf = null;
        qtzijo.IEE = gradientDrawable2;
        Runnable qyqF = qtzijo.KLFTb;
        if (qtzijo.qdMbNW) {
            qyqF = new Tw(qtzijo);
        } else if (qtzijo.xJ) {
            qyqF = new QyqF(qtzijo);
        }
        y(linearLayout, qyqF);
        return linearLayout;
    }

    public final void QfniOH(LinearLayout linearLayout, String str, String str2, int i, int i2) {
        float fMz = mz();
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (7.0f * fMz);
        linearLayout2.setPadding(0, i3, 0, i3);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(13.5f);
        textView.setTextColor(i2);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams((int) (fMz * 108.0f), -2));
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(13.5f);
        textView2.setTextColor(i);
        textView2.setGravity(8388613);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayout2);
    }

    public final void Qns() {
        a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Qs() {
        boolean z;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.wifi.WifiPickerActivity"));
            intent.putExtra(":settings:show_fragment", "com.android.settings.development.WirelessDebuggingFragment");
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            aQ("[+] 已打开: WifiPickerActivity + WirelessDebuggingFragment");
            z = true;
        } catch (Exception e2) {
            e = e2;
            z = true;
            aQ("[!] WifiPickerActivity 打开失败: " + e.getMessage());
            if (!z) {
            }
            if (z) {
            }
        }
        if (!z) {
            try {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.SettingsActivity"));
                intent2.putExtra(":settings:show_fragment", "com.android.settings.development.WirelessDebuggingFragment");
                intent2.setFlags(268435456);
                startActivity(intent2);
            } catch (Exception e3) {
                e = e3;
            }
            try {
                aQ("[+] 已使用 SettingsActivity 备用入口打开");
                z = true;
            } catch (Exception e4) {
                e = e4;
                z = true;
                aQ("[!] 备用入口失败: " + e.getMessage());
                if (z) {
                }
            }
        }
        if (z) {
            return true;
        }
        Y("无法打开无线调试页面");
        return false;
    }

    public final void R() {
        L("探测工具", new xVYW[]{new xVYW("完整设备状态", "型号 / ADB / OAID / 进程", AbstractC1857s4.ETF, -15551029, new uHVRx()), new xVYW("管控探针", "SuperviseProvider 管控配置", AbstractC1857s4.wJVbdd, -2543579, new JYn()), new xVYW("系统能力检测", "Zybos 方法可用性", AbstractC1857s4.ZfxDd, -1543926, new JYgkl()), new xVYW("服务绑定探测", "Supervise / AppStore 绑定", AbstractC1857s4.KLFTb, -10337066, new JrJO())}, 520.0f);
    }

    public final void RURGdp(LinearLayout linearLayout, float f) {
        FrameLayout frameLayout = new FrameLayout(this);
        int i = (int) (f * 96.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOutlineProvider(new zPp());
        imageView.setClipToOutline(true);
        imageView.setImageResource(J4.mjFkc);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        this.yX = imageView;
        UKTt(imageView);
        linearLayout.addView(frameLayout);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(frameLayout, "scaleX", 1.0f, 1.06f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(frameLayout, "scaleY", 1.0f, 1.06f);
        objectAnimatorOfFloat.setDuration(3000L);
        objectAnimatorOfFloat2.setDuration(3000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.6f, 1.0f));
        animatorSet.start();
        this.gYa = objectAnimatorOfFloat;
    }

    public final boolean RV() {
        if (com.jc.code.v3.AZxh.KLFTb() || com.jc.code.v3.mjFkc.NPj() || com.jc.code.v3.mjFkc.xrEuO() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            return true;
        }
        return qpjZLY();
    }

    public final synchronized boolean RW() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.SOS < 15000) {
            return this.Qr;
        }
        this.SOS = jCurrentTimeMillis;
        this.Qr = false;
        if (!j()) {
            return false;
        }
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"su", "-c", "id"});
            } catch (Exception unused) {
                this.Qr = false;
                if (0 != 0) {
                }
            }
            if (!processExec.waitFor(8L, TimeUnit.SECONDS)) {
                processExec.destroy();
                try {
                    processExec.destroy();
                } catch (Exception unused2) {
                }
                return false;
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            this.Qr = sb.toString().contains("uid=0");
            try {
                processExec.destroy();
            } catch (Exception unused3) {
            }
            return this.Qr;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    processExec.destroy();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public final void RnaHj(boolean z) throws IOException {
        int i;
        int i2;
        boolean z2 = this.xJ;
        String string = getSharedPreferences("jc_code_prefs", 0).getString("search_bg_uri", null);
        boolean z3 = (string == null || string.isEmpty()) ? false : true;
        Dialog dialog = new Dialog(this, R.style.Theme.Black.NoTitleBar.Fullscreen);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(z2 ? -14671840 : -789517));
            window.setLayout(-1, -1);
            window.addFlags(Integer.MIN_VALUE);
            if (z3) {
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
            } else {
                window.setStatusBarColor(z2 ? -14671840 : -789517);
                window.setNavigationBarColor(z2 ? -14671840 : -789517);
            }
            window.setSoftInputMode(48);
        }
        float f = getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(z2 ? -14671840 : -789517);
        linearLayout.setPadding(0, (int) (24.0f * f), 0, 0);
        this.cMLeY = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (8.0f * f);
        int i4 = (int) (4.0f * f);
        linearLayout2.setPadding(i3, i4, i3, i4);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (52.0f * f)));
        linearLayout.addView(linearLayout2);
        TextView textViewPVOu = pVOu(linearLayout2, "‹", z2, f);
        TextView textViewPVOu2 = pVOu(linearLayout2, "›", z2, f);
        TextView textViewPVOu3 = pVOu(linearLayout2, "⟳", z2, f);
        EditText editText = new EditText(this);
        this.KLMXS = editText;
        editText.setTextSize(13.0f);
        this.KLMXS.setSingleLine(true);
        this.KLMXS.setImeOptions(2);
        this.KLMXS.setInputType(524289);
        this.KLMXS.setHint("输入网址或搜索 APK 关键词");
        this.KLMXS.setTextColor(z2 ? -419430401 : -15066598);
        this.KLMXS.setHintTextColor(z2 ? -1711276033 : -1728053248);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f2 = i4;
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(z2 ? -13816531 : -1);
        gradientDrawable.setStroke(1, z2 ? -11908534 : -3026479);
        this.KLMXS.setBackground(gradientDrawable);
        int i5 = (int) (f * 12.0f);
        this.KLMXS.setPadding(i5, 0, i5, 0);
        linearLayout2.addView(this.KLMXS, new LinearLayout.LayoutParams(0, -1, 1.0f));
        TextView textViewPVOu4 = pVOu(linearLayout2, "Go", z2, f);
        TextView textViewPVOu5 = pVOu(linearLayout2, "✕", z2, f);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout3.setPadding(i5, 0, i5, (int) (6.0f * f));
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this);
        textView.setText("输入关键词自动 Bing 搜索 · .apk 链接自动拦截直链安装");
        textView.setTextSize(10.0f);
        textView.setTextColor(z2 ? -1711276033 : -1728053248);
        textView.setGravity(8388613);
        linearLayout3.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(17);
        int i6 = (int) (32.0f * f);
        linearLayout4.setPadding(i6, 0, i6, 0);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.addView(linearLayout4);
        XVrPFt(linearLayout);
        TextView textView2 = new TextView(this);
        textView2.setText(NBXYLM());
        textView2.setTextSize(30.0f);
        textView2.setTextColor(z2 ? -419430401 : -15066598);
        textView2.setGravity(17);
        textView2.setPadding(0, 0, 0, (int) (28.0f * f));
        linearLayout4.addView(textView2);
        EditText editText2 = new EditText(this);
        editText2.setTextSize(17.0f);
        editText2.setSingleLine(true);
        editText2.setImeOptions(3);
        editText2.setInputType(524289);
        editText2.setHint(BuildConfig.FLAVOR);
        editText2.setTextColor(z2 ? -419430401 : -15066598);
        editText2.setHintTextColor(z2 ? -1711276033 : -1728053248);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f2);
        gradientDrawable2.setColor(z2 ? -869454547 : -855638017);
        if (z2) {
            i2 = -11908534;
            i = 1;
        } else {
            i = 1;
            i2 = -3026479;
        }
        gradientDrawable2.setStroke(i, i2);
        editText2.setBackground(gradientDrawable2);
        int i7 = (int) (20.0f * f);
        editText2.setPadding(i7, i5, i7, i5);
        linearLayout4.addView(editText2, new LinearLayout.LayoutParams(-1, -2));
        TextView textView3 = new TextView(this);
        textView3.setText("搜索到 APK 下载链接时，可使用 JC Code 下载器下载安装");
        textView3.setTextSize(12.0f);
        textView3.setTextColor(z2 ? -1711276033 : -1728053248);
        textView3.setGravity(17);
        textView3.setPadding(0, (int) (f * 16.0f), 0, 0);
        linearLayout4.addView(textView3);
        WebView webView = new WebView(this);
        this.xrEuO = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(-1);
        String userAgentString = settings.getUserAgentString();
        if (!userAgentString.contains("Mobile")) {
            userAgentString = userAgentString.replace("Safari/", "Mobile Safari/");
            if (!userAgentString.contains("Mobile")) {
                userAgentString = userAgentString + " Mobile";
            }
        }
        settings.setUserAgentString(userAgentString + " JCCodeV3Browser/3.1");
        this.xrEuO.setVisibility(8);
        linearLayout.addView(this.xrEuO, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.xrEuO.setWebViewClient(new hvGY());
        this.xrEuO.setDownloadListener(new Rc());
        this.xrEuO.setWebChromeClient(new SKTn());
        textViewPVOu.setOnClickListener(new XDdeP());
        textViewPVOu2.setOnClickListener(new eQ());
        textViewPVOu3.setOnClickListener(new FbxKQm());
        textViewPVOu5.setOnClickListener(new jtz(dialog));
        XgAT xgAT = new XgAT();
        textViewPVOu4.setOnClickListener(new IyS(xgAT));
        this.KLMXS.setOnEditorActionListener(new tAfC(xgAT));
        editText2.setOnEditorActionListener(new dGDT(editText2, xgAT));
        dialog.setContentView(linearLayout);
        dialog.show();
        dialog.setOnKeyListener(new Xxz(dialog));
        this.zvd = linearLayout4;
        linearLayout4.postDelayed(new Zdbk(editText2), 350L);
        aQ("[*] 打开内置浏览器（搜索首页）");
    }

    public final void S(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.mjFkc.post(new Vptz(str2, str3, str, str4, z2, z));
    }

    public final void SZKiB(boolean z, int i, int i2) {
        if (this.oCFDzJ == null) {
            return;
        }
        float fMz = mz();
        LinearLayout linearLayout = this.oCFDzJ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(28.0f * fMz);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -12960446);
        } else {
            linearLayout.setElevation(fMz * 2.0f);
        }
        linearLayout.setBackground(gradientDrawable);
        linearLayout.removeAllViews();
        QfniOH(linearLayout, "型号", Build.MODEL + "（" + Build.BRAND + "）", i, i2);
        QfniOH(linearLayout, "系统", "Android " + Build.VERSION.RELEASE + " · API " + Build.VERSION.SDK_INT, i, i2);
        QfniOH(linearLayout, "安全补丁", Build.VERSION.SECURITY_PATCH, i, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(F0());
        sb.append(kgk() ? "（高版本）" : BuildConfig.FLAVOR);
        QfniOH(linearLayout, "ZYB 系统", sb.toString(), i, i2);
        QfniOH(linearLayout, "zybos 绑定", this.Dt ? "已连接" : kgk() ? "高版本不可用" : "未连接", i, i2);
        QfniOH(linearLayout, "ADB 通道", HL(), i, i2);
        QfniOH(linearLayout, "本机 IP", YxdwU(), i, i2);
    }

    public final int SbhK() throws IOException {
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"getprop", "ro.build.version.os"}).getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    strTrim = BuildConfig.FLAVOR;
                    break;
                }
                if (line.trim().length() > 0) {
                    strTrim = line.trim();
                    break;
                }
            }
            bufferedReader.close();
            this.CqaNbM = strTrim;
            if (this.XV != null) {
                Abw();
            }
            String[] strArrSplit = strTrim.replaceFirst("^[Vv]", BuildConfig.FLAVOR).split("\\.");
            try {
                return ((strArrSplit.length > 0 ? Integer.parseInt(strArrSplit[0].trim()) : 0) * NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE) + ((strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1].trim()) : 0) * 10) + (strArrSplit.length > 2 ? Integer.parseInt(strArrSplit[2].trim()) : 0);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } catch (Exception e) {
            aQ("[!] 读取系统版本失败: " + e.getMessage());
            return 0;
        }
    }

    public final void SllyO() {
        int i;
        ScrollView scrollView;
        int i2;
        LinearLayout linearLayout;
        float fMz = mz();
        LinearLayout linearLayout2 = (LinearLayout) findViewById(AbstractC1978u4.ETF);
        ViewGroup viewGroup = (ViewGroup) findViewById(AbstractC1978u4.YoKzxo);
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.Vnb.size()) {
            gJsSk gjssk = (gJsSk) this.Vnb.get(i4);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(i3);
            linearLayout3.setGravity(16);
            int i5 = (int) (16.0f * fMz);
            linearLayout3.setPadding(i5, i3, i5, i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (fMz * 56.0f));
            float f = 2.0f * fMz;
            layoutParams.bottomMargin = (int) f;
            linearLayout3.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float f2 = 28.0f * fMz;
            gradientDrawable.setCornerRadius(f2);
            gradientDrawable.setColor(i3);
            linearLayout3.setBackground(gradientDrawable);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(gjssk.wA);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int i6 = (int) (fMz * 24.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i6);
            int i7 = (int) (fMz * 14.0f);
            layoutParams2.rightMargin = i7;
            linearLayout3.addView(imageView, layoutParams2);
            TextView textView = new TextView(this);
            textView.setText(gjssk.mjFkc);
            textView.setTextSize(14.0f);
            ViewGroup viewGroup2 = viewGroup;
            linearLayout3.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            y(linearLayout3, new VfB(i4));
            gjssk.KLFTb = linearLayout3;
            gjssk.JHa = imageView;
            gjssk.xJ = textView;
            linearLayout2.addView(linearLayout3);
            ScrollView scrollView2 = new ScrollView(this);
            scrollView2.setVerticalScrollBarEnabled(false);
            scrollView2.setOverScrollMode(2);
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(1);
            float f3 = 32.0f * fMz;
            int i8 = (int) f3;
            linearLayout4.setPadding(i8, i6, i8, (int) (40.0f * fMz));
            scrollView2.addView(linearLayout4, new ViewGroup.LayoutParams(-1, -2));
            TextView textView2 = new TextView(this);
            textView2.setText(gjssk.mjFkc);
            textView2.setTextSize(27.0f);
            textView2.setTypeface(Typeface.create("sans-serif", 1));
            textView2.setPadding(0, 0, 0, (int) (8.0f * fMz));
            linearLayout4.addView(textView2);
            gjssk.qdMbNW = textView2;
            View view = new View(this);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(f);
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            LinearLayout linearLayout5 = linearLayout2;
            gradientDrawable2.setColors(new int[]{-10589486, -13916000});
            view.setBackground(gradientDrawable2);
            view.setScaleX(0.0f);
            view.setPivotX(0.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) (fMz * 44.0f), (int) (fMz * 4.0f));
            layoutParams3.bottomMargin = (int) (fMz * 10.0f);
            linearLayout4.addView(view, layoutParams3);
            gjssk.ETF = view;
            TextView textView3 = new TextView(this);
            textView3.setText(gjssk.AZxh);
            textView3.setTextSize(14.0f);
            int i9 = (int) (18.0f * fMz);
            textView3.setPadding(0, 0, 0, i9);
            linearLayout4.addView(textView3);
            gjssk.Dt = textView3;
            if ("首页".equals(gjssk.mjFkc)) {
                linearLayout4.addView(qqdo());
                LinearLayout linearLayout6 = new LinearLayout(this);
                linearLayout6.setOrientation(1);
                int i10 = (int) (fMz * 20.0f);
                linearLayout6.setPadding(i10, i5, i10, i7);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.bottomMargin = i7;
                linearLayout4.addView(linearLayout6, layoutParams4);
                this.XV = linearLayout6;
                Abw();
            }
            if ("设备信息".equals(gjssk.mjFkc)) {
                LinearLayout linearLayout7 = new LinearLayout(this);
                linearLayout7.setOrientation(1);
                int i11 = (int) f2;
                int i12 = (int) (26.0f * fMz);
                linearLayout7.setPadding(i11, i12, i11, i12);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(f3);
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.TL_BR);
                gradientDrawable3.setColors(new int[]{-10589486, -13916000});
                linearLayout7.setBackground(gradientDrawable3);
                linearLayout7.setElevation(this.xJ ? 0.0f : 3.0f * fMz);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                float f4 = fMz * 20.0f;
                int i13 = (int) f4;
                layoutParams5.bottomMargin = i13;
                linearLayout7.setLayoutParams(layoutParams5);
                TextView textView4 = new TextView(this);
                textView4.setText("当前设备");
                textView4.setTextSize(12.5f);
                textView4.setTextColor(-1275068417);
                textView4.setLetterSpacing(0.08f);
                linearLayout7.addView(textView4);
                TextView textView5 = new TextView(this);
                textView5.setText(Build.MODEL);
                textView5.setTextSize(30.0f);
                textView5.setTypeface(Typeface.create("sans-serif", 1));
                textView5.setTextColor(-1);
                int i14 = (int) (6.0f * fMz);
                textView5.setPadding(0, i14, 0, 0);
                linearLayout7.addView(textView5);
                TextView textView6 = new TextView(this);
                StringBuilder sb = new StringBuilder();
                i = i4;
                sb.append("Android ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(" · API ");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(" · ");
                sb.append(Build.BRAND);
                textView6.setText(sb.toString());
                textView6.setTextSize(13.5f);
                textView6.setTextColor(-637534209);
                textView6.setPadding(0, i14, 0, i5);
                linearLayout7.addView(textView6);
                TextView textView7 = new TextView(this);
                textView7.setTextSize(13.0f);
                textView7.setTextColor(-1);
                int i15 = (int) (7.0f * fMz);
                textView7.setPadding(i7, i15, i7, i15);
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setCornerRadius(f4);
                gradientDrawable4.setColor(872415231);
                textView7.setBackground(gradientDrawable4);
                linearLayout7.addView(textView7, new LinearLayout.LayoutParams(-2, -2));
                linearLayout4.addView(linearLayout7);
                this.WrLQs = linearLayout7;
                this.KRTLGT = textView7;
                FPcN();
                LinearLayout linearLayout8 = new LinearLayout(this);
                linearLayout8.setOrientation(1);
                linearLayout8.setPadding(i6, i9, i6, i9);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams6.bottomMargin = i13;
                linearLayout8.setLayoutParams(layoutParams6);
                linearLayout4.addView(linearLayout8);
                this.oCFDzJ = linearLayout8;
            } else {
                i = i4;
            }
            H1 h1 = new H1(this);
            h1.setRadius(0.0f);
            h1.setCardElevation(0.0f);
            h1.setStrokeWidth(0);
            h1.setCardBackgroundColor(0);
            h1.setClickable(false);
            LinearLayout linearLayout9 = new LinearLayout(this);
            linearLayout9.setOrientation(1);
            h1.addView(linearLayout9, new ViewGroup.LayoutParams(-1, -2));
            h1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout4.addView(h1);
            gjssk.VA = h1;
            boolean z = false;
            int i16 = 0;
            int i17 = 0;
            LinearLayout linearLayout10 = null;
            ScrollView scrollView3 = scrollView2;
            while (i16 < gjssk.ZfxDd.size()) {
                qtZIjO qtzijo = (qtZIjO) gjssk.ZfxDd.get(i16);
                if (qtzijo.JHa) {
                    scrollView = scrollView3;
                    linearLayout = linearLayout9;
                } else if (qtzijo.VA) {
                    View viewMZG = mZG(qtzijo);
                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams7.topMargin = z ? i7 : 0;
                    layoutParams7.bottomMargin = (int) (12.0f * fMz);
                    linearLayout9.addView(viewMZG, layoutParams7);
                    scrollView = scrollView3;
                    linearLayout = linearLayout9;
                    i17 = 0;
                    linearLayout10 = null;
                } else {
                    int i18 = i17 % 2;
                    if (i18 == 0) {
                        linearLayout10 = new LinearLayout(this);
                        linearLayout10.setOrientation(0);
                        scrollView = scrollView3;
                        i2 = -2;
                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams8.bottomMargin = i7;
                        linearLayout10.setLayoutParams(layoutParams8);
                        linearLayout9.addView(linearLayout10);
                    } else {
                        scrollView = scrollView3;
                        i2 = -2;
                    }
                    View viewQQi = QQi(qtzijo);
                    linearLayout = linearLayout9;
                    LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, i2, 1.0f);
                    if (i18 == 1) {
                        layoutParams9.leftMargin = i7;
                    }
                    linearLayout10.addView(viewQQi, layoutParams9);
                    i17++;
                    z = true;
                }
                i16++;
                scrollView3 = scrollView;
                linearLayout9 = linearLayout;
            }
            ScrollView scrollView4 = scrollView3;
            if (i17 % 2 == 1 && linearLayout10 != null) {
                View view2 = new View(this);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, 1, 1.0f);
                layoutParams10.leftMargin = i7;
                linearLayout10.addView(view2, layoutParams10);
            }
            if ("关于".equals(gjssk.mjFkc)) {
                LinearLayout linearLayout11 = new LinearLayout(this);
                linearLayout11.setOrientation(1);
                linearLayout11.setPadding(i6, i9, i6, i9);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams11.topMargin = (int) (fMz * 20.0f);
                linearLayout11.setLayoutParams(layoutParams11);
                linearLayout4.addView(linearLayout11);
                this.aqHPIZ = linearLayout11;
            }
            scrollView4.setVisibility(8);
            viewGroup2.addView(scrollView4, new FrameLayout.LayoutParams(-1, -1));
            gjssk.lgHUyS = scrollView4;
            i4 = i + 1;
            viewGroup = viewGroup2;
            linearLayout2 = linearLayout5;
            i3 = 0;
        }
        LinearLayout linearLayout12 = (LinearLayout) findViewById(AbstractC1978u4.VA);
        if (linearLayout12 == null || this.SwgkN != null) {
            return;
        }
        LinearLayout linearLayout13 = new LinearLayout(this);
        linearLayout13.setOrientation(1);
        int i19 = (int) (fMz * 20.0f);
        int i20 = (int) (fMz * 14.0f);
        linearLayout13.setPadding(i19, i20, i19, (int) (fMz * 18.0f));
        linearLayout12.addView(linearLayout13);
        this.SwgkN = linearLayout13;
        LinearLayout linearLayout14 = new LinearLayout(this);
        linearLayout14.setOrientation(0);
        linearLayout13.addView(linearLayout14, new LinearLayout.LayoutParams(-1, -2));
        TextView textViewZabxk = zabxk("运行日志", i20);
        textViewZabxk.setOnClickListener(new Htq());
        linearLayout14.addView(textViewZabxk, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewZabxk2 = zabxk("夜间模式", i20);
        textViewZabxk2.setOnClickListener(new BxruE());
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams12.leftMargin = (int) (fMz * 10.0f);
        linearLayout14.addView(textViewZabxk2, layoutParams12);
    }

    public final void SrJcM(boolean z) throws IOException {
        try {
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.uiMode = (configuration.uiMode & (-49)) | (z ? 32 : 16);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        } catch (Throwable unused) {
        }
        float fMz = mz();
        int i = z ? -15066338 : -460294;
        int i2 = z ? -15592683 : -985863;
        int i3 = z ? -1842205 : -14737633;
        int i4 = z ? -6643546 : -12302522;
        int i5 = z ? 535028707 : 338439212;
        int i6 = 0;
        String string = getSharedPreferences("jc_code_prefs", 0).getString("bg_uri", null);
        boolean z2 = (string == null || string.isEmpty()) ? false : true;
        getWindow().getDecorView().setBackgroundColor(i);
        View view = this.KLFTb;
        if (view != null && !z2) {
            view.setBackgroundColor(i);
        }
        View viewFindViewById = findViewById(AbstractC1978u4.VA);
        if (viewFindViewById != null) {
            if (z2) {
                i = z ? -652600546 : -637994502;
            }
            viewFindViewById.setBackgroundColor(i);
        }
        View viewFindViewById2 = findViewById(AbstractC1978u4.YoKzxo);
        if (viewFindViewById2 != null) {
            if (z2) {
                i2 = z ? -871362284 : -856821515;
            }
            viewFindViewById2.setBackgroundColor(i2);
        }
        if (z2) {
            MLqR();
        }
        TextView textView = this.wA;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = this.ZfxDd;
        if (textView2 != null) {
            textView2.setVisibility(z ? 8 : 0);
        }
        TextView textView3 = this.AZxh;
        if (textView3 != null) {
            textView3.setTextColor(i4);
        }
        if (this.VA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            Boolean bool = this.nxI;
            gradientDrawable.setColor(bool == null ? z ? -141725 : -1543926 : bool.booleanValue() ? z ? -9647265 : -15171528 : z ? -881790 : -2543579);
            this.VA.setBackground(gradientDrawable);
            f0();
        }
        Iterator it = this.Vnb.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            gJsSk gjssk = (gJsSk) it.next();
            TextView textView4 = gjssk.qdMbNW;
            if (textView4 != null) {
                textView4.setTextColor(i3);
            }
            TextView textView5 = gjssk.Dt;
            if (textView5 != null) {
                textView5.setTextColor(i4);
            }
            H1 h1 = gjssk.VA;
            if (h1 != null) {
                h1.setCardBackgroundColor(i6);
                gjssk.VA.setStrokeWidth(i6);
                gjssk.VA.setCardElevation(0.0f);
            }
            Iterator it2 = gjssk.MiMN.iterator();
            while (it2.hasNext()) {
                ((View) it2.next()).setBackgroundColor(i5);
            }
            for (qtZIjO qtzijo : gjssk.ZfxDd) {
                if (qtzijo.VA) {
                    TextView textView6 = qtzijo.YoKzxo;
                    if (textView6 != null) {
                        textView6.setTextColor(i3);
                    }
                } else {
                    TextView textView7 = qtzijo.YoKzxo;
                    if (textView7 != null) {
                        textView7.setTextColor(i3);
                        qtzijo.rkYL.setTextColor(i4);
                        int[] iArrW0 = w0(qtzijo.ZfxDd, z);
                        GradientDrawable gradientDrawable2 = qtzijo.IEE;
                        if (gradientDrawable2 != null) {
                            gradientDrawable2.setColors(new int[]{iArrW0[i6], iArrW0[1]});
                        }
                        qtzijo.qGY.setColorFilter(iArrW0[2], PorterDuff.Mode.SRC_IN);
                        if (qtzijo.MiMN != null) {
                            GradientDrawable gradientDrawable3 = new GradientDrawable();
                            gradientDrawable3.setCornerRadius(20.0f * fMz);
                            if (z) {
                                gradientDrawable3.setColor(-13881549);
                                gradientDrawable3.setStroke(Math.max(1, (int) fMz), -12960446);
                            } else {
                                gradientDrawable3.setColor(-1);
                                gradientDrawable3.setStroke(Math.max(1, (int) fMz), -1709843);
                            }
                            qtzijo.MiMN.setBackground(gradientDrawable3);
                        }
                        i6 = 0;
                    }
                }
            }
        }
        SZKiB(z, i3, i4);
        NBLVO(z, i3, i4);
        Abw();
        LinearLayout linearLayout = this.SwgkN;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            LinearLayout linearLayout2 = this.SwgkN;
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
            int i7 = (int) (14.0f * fMz);
            TextView textViewZabxk = zabxk("运行日志", i7);
            textViewZabxk.setOnClickListener(new CcoH());
            linearLayout3.addView(textViewZabxk, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textViewZabxk2 = zabxk("夜间模式", i7);
            textViewZabxk2.setOnClickListener(new EoC());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.leftMargin = (int) (10.0f * fMz);
            linearLayout3.addView(textViewZabxk2, layoutParams);
        }
        if (this.WrLQs != null) {
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setCornerRadius(32.0f * fMz);
            gradientDrawable4.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable4.setColors(z ? new int[]{-13418626, -15445939} : new int[]{-10589486, -13916000});
            this.WrLQs.setBackground(gradientDrawable4);
            this.WrLQs.setElevation(z ? 0.0f : fMz * 3.0f);
        }
        FPcN();
        B0(this.NPj);
        CrDc(true);
    }

    public final void T(String str, String str2) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, S4.mjFkc).setTitle(str).setMessage(str2).setPositiveButton("确定", (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.show();
        YfFg(alertDialogCreate);
    }

    public final void Tz(String str, TextView textView, ScrollView scrollView) {
        if ("命令列表".equals(str)) {
            m("help", textView, scrollView);
            return;
        }
        if ("查询设备所有者".equals(str)) {
            m("get-device-owner", textView, scrollView);
            return;
        }
        if ("防卸载查询".equals(str)) {
            YRhJjQ("防卸载查询", "输入应用包名", "查询", new Gd(textView, scrollView));
            return;
        }
        if ("防卸载开".equals(str)) {
            YRhJjQ("防卸载开", "输入要保护的应用包名（重启后保护依然有效）", "开启", new HGpJ(textView, scrollView));
            return;
        }
        if ("防卸载关".equals(str)) {
            YRhJjQ("防卸载关", "输入要解除保护的应用包名", "解除", new vI(textView, scrollView));
            return;
        }
        if ("权限授予".equals(str) || "权限拒绝".equals(str)) {
            boolean zEquals = "权限授予".equals(str);
            BEUaYa(zEquals ? "权限授予" : "权限拒绝", "格式：包名 权限名\n如 com.tencent.mm android.permission.CAMERA", "包名 权限名", zEquals ? "授予" : "拒绝", new VocHEe(zEquals, textView, scrollView));
        } else if ("安装CA证书".equals(str)) {
            BEUaYa("安装 CA 证书", "输入证书文件路径（.crt）", "/sdcard/xxx.crt", "安装", new BAnRFn(textView, scrollView));
        } else if ("关闭锁屏".equals(str)) {
            U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("关闭锁屏").setMessage("确定禁用锁屏（set-keyguard-disabled true）？\n可随时输入 set-keyguard-disabled false 恢复。").setPositiveButton("关闭", new lB(textView, scrollView)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    public final AlertDialog U(AlertDialog.Builder builder) {
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        YfFg(alertDialogCreate);
        return alertDialogCreate;
    }

    public final void UKTt(ImageView imageView) {
        Bitmap bitmapDecodeFile;
        File file = new File(getFilesDir(), "avatar_cache.png");
        if (file.exists() && (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) != null) {
            imageView.setImageBitmap(bitmapDecodeFile);
        }
        new Thread(new MC(file)).start();
    }

    public final void UXIO() {
        aQ("\n[*] DNS 配置深链...");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("zpapp://com.zuoyebang.iot.pad.developer.ui.dns/config"));
            intent.setFlags(268435456);
            startActivity(intent);
            aQ("[+] DNS 配置页已打开 ✓");
            X("✓ DNS 配置页");
        } catch (Exception e) {
            aQ("[!] DNS 深链失败: " + e.getMessage());
            X("✗ " + e.getMessage());
        }
    }

    public final boolean Uj(File file, String str, boolean z, boolean z2) throws InterruptedException {
        Ipwl();
        if (!RV()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 使用 ADB 通道安装");
        sb.append(z2 ? "（允许降级）" : BuildConfig.FLAVOR);
        sb.append("...");
        aQ(sb.toString());
        Y("ADB 安装中: " + str);
        try {
            com.jc.code.v3.mjFkc.zvd(file, z2);
            if (!z || E0(str, 6000L, true)) {
                aQ("[+] ADB 安装成功: " + str);
                Y("✓ ADB 安装成功: " + str);
            } else {
                aQ("[!] ADB 返回 Success，但系统未检测到 " + str);
                Y("✗ ADB 安装未生效: " + str);
            }
            ZlB();
            return true;
        } catch (Throwable th) {
            aQ("[!] ADB 安装失败: " + mYYU(th));
            PvPg(th);
            return false;
        }
    }

    public final void UlIi() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                getWindow().getAttributes().setBlurBehindRadius(30);
                getWindow().addFlags(4);
            }
        } catch (Exception unused) {
        }
    }

    public final void Ule(LinearLayout linearLayout, float f, int i, int i2) {
        TextView textView = new TextView(this);
        textView.setText("aonosaki / K-on唯");
        textView.setTextSize(24.0f);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView.setTypeface(typeface);
        textView.setTextColor(i);
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (f * 18.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this);
        textView2.setText("开发者 · 设计者 · 维护者");
        textView2.setTextSize(13.0f);
        textView2.setTextColor(i2);
        textView2.setGravity(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = (int) (4.0f * f);
        linearLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(this);
        textView3.setText("JC Code V3");
        textView3.setTextSize(18.0f);
        textView3.setTypeface(typeface);
        textView3.setTextColor(i);
        textView3.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) (22.0f * f);
        linearLayout.addView(textView3, layoutParams3);
        Iterator it = this.Vnb.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            for (qtZIjO qtzijo : ((gJsSk) it.next()).ZfxDd) {
                if (!qtzijo.JHa && !qtzijo.VA) {
                    i3++;
                }
            }
        }
        String[] strArr = {"功能入口 " + i3 + " 项 · 分类 " + this.Vnb.size() + " 个", "ZYB 环境: " + F0(), "包名: " + getPackageName()};
        for (int i4 = 0; i4 < 3; i4++) {
            String str = strArr[i4];
            TextView textView4 = new TextView(this);
            textView4.setText(str);
            textView4.setTextSize(13.0f);
            textView4.setTextColor(i2);
            textView4.setGravity(1);
            textView4.setPadding(0, (int) (3.0f * f), 0, 0);
            linearLayout.addView(textView4);
        }
    }

    public final void UmFn(String str) {
        this.mjFkc.post(new JOe(str));
    }

    public final void UokA(AlertDialog alertDialog) {
        try {
            alertDialog.setCancelable(false);
            alertDialog.setCanceledOnTouchOutside(false);
            View viewFindViewById = alertDialog.findViewById(R.id.content);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(null);
            }
        } catch (Throwable unused) {
        }
    }

    public final qtZIjO UqgK(gJsSk gjssk, String str, String str2, int i, int i2, Runnable runnable, boolean z, boolean z2, boolean z3) {
        qtZIjO qtzijoIRYXZ = IRYXZ(gjssk, str, str2, i, i2, runnable, z, z2);
        qtzijoIRYXZ.lgHUyS = z3;
        return qtzijoIRYXZ;
    }

    public final void V() {
        L("搜索页背景", new xVYW[]{new xVYW("拉伸填满", "图片拉伸铺满整个背景", AbstractC1857s4.fehf, -10589486, new xfXeiC()), new xVYW("居中裁剪", "保持比例居中裁剪显示", AbstractC1857s4.lgHUyS, -13916000, new Hk()), new xVYW("恢复默认", "清除自定义搜索页背景", AbstractC1857s4.BAnRFn, -10525848, new oJ())}, 480.0f);
    }

    public final void VzXmn(LinearLayout linearLayout, float f, boolean z, int i, int i2) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(this);
        textView.setText("作者");
        textView.setTextSize(13.0f);
        textView.setTextColor(i2);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("aonosaki / K-on唯");
        textView2.setTextSize(13.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = (int) (16.0f * f);
        layoutParams.leftMargin = i3;
        linearLayout2.addView(textView2, layoutParams);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        TextView textView3 = new TextView(this);
        textView3.setText("邮箱");
        textView3.setTextSize(13.0f);
        textView3.setTextColor(i2);
        linearLayout3.addView(textView3);
        TextView textView4 = new TextView(this);
        textView4.setText("aono_saki@outlook.com");
        textView4.setTextSize(13.0f);
        textView4.setTextColor(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = i3;
        linearLayout3.addView(textView4, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i4 = (int) (6.0f * f);
        layoutParams3.topMargin = i4;
        linearLayout.addView(linearLayout3, layoutParams3);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(0);
        TextView textView5 = new TextView(this);
        textView5.setText("官网");
        textView5.setTextSize(13.0f);
        textView5.setTextColor(i2);
        linearLayout4.addView(textView5);
        TextView textView6 = new TextView(this);
        textView6.setText("app.aibangos.xyz/Jc.Four");
        textView6.setTextSize(13.0f);
        textView6.setTextColor(z ? -5919253 : -10589486);
        textView6.setOnClickListener(new xbjHT());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = i3;
        linearLayout4.addView(textView6, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = i4;
        linearLayout.addView(linearLayout4, layoutParams5);
        TextView textView7 = new TextView(this);
        textView7.setText("JC Code V3 是一款面向 AIbangOS / 作业帮设备的系统能力探索工具，无需 Root 即可实现静默安装、管控解除、设备信息查看等功能。本工具仅供安全研究与学习交流使用，请遵守相关法律法规。");
        textView7.setTextSize(12.0f);
        textView7.setTextColor(i2);
        textView7.setLineSpacing((int) (4.0f * f), 1.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = (int) (f * 18.0f);
        linearLayout.addView(textView7, layoutParams6);
    }

    public final void W() {
        EditText editText = new EditText(this);
        editText.setText(NBXYLM());
        editText.setSelectAllOnFocus(true);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("修改搜索页标题").setView(editText).setPositiveButton("保存", new Rsp(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final LinearLayout WjcLD(String str, Runnable runnable) {
        float fMz = mz();
        boolean z = this.xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        int i = (int) (9.0f * fMz);
        linearLayout.setPadding((int) (10.0f * fMz), i, (int) (12.0f * fMz), i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fMz);
        gradientDrawable.setColor(z ? -14275018 : -1380106);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(r0(str));
        imageView.setColorFilter(z ? -7359504 : -10589486, PorterDuff.Mode.SRC_IN);
        int i2 = (int) (13.0f * fMz);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i2, i2));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(11.5f);
        textView.setSingleLine(true);
        textView.setTextColor(z ? -3550500 : -13682107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) (fMz * 5.0f);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new fehf(runnable));
        return linearLayout;
    }

    public final void X(String str) {
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            Snackbar snackbarDm = Snackbar.dm(viewFindViewById, str, -1);
            n0(snackbarDm);
            snackbarDm.JYn();
        }
    }

    public final boolean XDcuxS(WebView webView, String str) throws URISyntaxException {
        if (str == null) {
            return false;
        }
        aQ("[*] 浏览器导航: " + str);
        String scheme = null;
        if (gGFLGZ(str, null, null)) {
            vEiZJ(str);
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("https://https://") || lowerCase.contains("http://http://") || lowerCase.contains("//xn--https-") || lowerCase.contains("//xn--http-")) {
            aQ("[!] 拦截畸形 URL: " + str);
            X("链接格式异常，已拦截");
            return true;
        }
        try {
            scheme = Uri.parse(str).getScheme();
        } catch (Exception unused) {
        }
        if (scheme == null || scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            return false;
        }
        aQ("[*] 非网页协议 " + scheme + ":// → 尝试唤起系统应用");
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addFlags(268435456);
            startActivity(uri);
        } catch (Exception e) {
            X("无法打开 " + scheme + ":// 链接: " + e.getMessage());
        }
        return true;
    }

    public final void XVrPFt(View view) throws IOException {
        Bitmap bitmapCreateScaledBitmap;
        try {
            String string = getSharedPreferences("jc_code_prefs", 0).getString("search_bg_uri", null);
            if (string != null && !string.isEmpty()) {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(Uri.parse(string));
                if (inputStreamOpenInputStream == null) {
                    return;
                }
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                inputStreamOpenInputStream.close();
                if (bitmapDecodeStream == null) {
                    return;
                }
                String string2 = getSharedPreferences("jc_code_prefs", 0).getString("search_bg_scale", "stretch");
                int width = view.getWidth() > 0 ? view.getWidth() : getResources().getDisplayMetrics().widthPixels;
                int height = view.getHeight() > 0 ? view.getHeight() : getResources().getDisplayMetrics().heightPixels;
                if ("center".equals(string2)) {
                    float fMax = Math.max(width / bitmapDecodeStream.getWidth(), height / bitmapDecodeStream.getHeight());
                    int iMax = Math.max(1, (int) (bitmapDecodeStream.getWidth() * fMax));
                    int iMax2 = Math.max(1, (int) (bitmapDecodeStream.getHeight() * fMax));
                    bitmapCreateScaledBitmap = Bitmap.createBitmap(Bitmap.createScaledBitmap(bitmapDecodeStream, iMax, iMax2, true), (iMax - width) / 2, (iMax2 - height) / 2, width, height);
                } else {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, width, height, true);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateScaledBitmap);
                bitmapDrawable.setAlpha(255);
                view.setBackground(bitmapDrawable);
            }
        } catch (Exception unused) {
        }
    }

    public final void XvQLwQ() {
        try {
            File[] fileArrListFiles = new File(getApplicationInfo().dataDir, "shared_prefs").listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            int i = 0;
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (name.startsWith("adbeesh_identity_") && name.endsWith(".xml")) {
                    deleteSharedPreferences(name.substring(0, name.length() - 4));
                    i++;
                }
            }
            aQ("[*] 已清理 " + i + " 个本机配对身份");
        } catch (Exception e) {
            aQ("[!] 清理本机身份失败: " + mYYU(e));
        }
    }

    public final void Y(String str) {
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            Snackbar snackbarDm = Snackbar.dm(viewFindViewById, str, 0);
            n0(snackbarDm);
            snackbarDm.JYn();
        }
    }

    public final void YDiFPt() {
        aQ("\n[*] 管控探针：扫描 SuperviseProvider...");
        new Thread(new vjlshU(new String[]{"/advance", "/disable", "/key_value", "/grade", "/open_child_list", "/user_center"}, new StringBuilder())).start();
    }

    public final void YRhJjQ(String str, String str2, String str3, kw kwVar) {
        EditText editText = new EditText(this);
        editText.setHint("输入包名（如 com.tencent.mm）");
        editText.setTextSize(14.0f);
        editText.setSingleLine(true);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle(str).setMessage(str2).setView(editText).setPositiveButton(str3, new qGY(editText, kwVar)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final void YfFg(AlertDialog alertDialog) {
        if (alertDialog.getWindow() != null) {
            boolean z = this.xJ;
            float f = getResources().getDisplayMetrics().density;
            Window window = alertDialog.getWindow();
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(Build.VERSION.SDK_INT >= 31 ? 0.32f : 0.22f);
            window.setWindowAnimations(0);
            window.setGravity(17);
            window.getDecorView().setSystemUiVisibility(5894);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(R.id.content);
            ?? childAt = (viewGroup == null || viewGroup.getChildCount() <= 0) ? 0 : viewGroup.getChildAt(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(28.0f * f);
            gradientDrawable.setColor(z ? -14408151 : -1);
            if (z) {
                gradientDrawable.setStroke(Math.max(1, (int) f), -12960446);
            }
            if (childAt != 0) {
                childAt.setBackground(gradientDrawable);
                childAt.setClickable(true);
                if (childAt.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 17;
                    childAt.setLayoutParams(layoutParams);
                }
                int i = (int) (320.0f * f);
                childAt.setMinimumWidth(i);
                int i2 = (int) (displayMetrics.heightPixels * 0.78f);
                int i3 = (int) (f * 620.0f);
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
                if (childAt.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (measuredWidth <= i3) {
                        i3 = measuredWidth;
                    }
                    if (i3 >= i) {
                        i = i3;
                    }
                    layoutParams2.width = i;
                    childAt.setLayoutParams(layoutParams2);
                }
                if (childAt.getMeasuredHeight() >= i2 && (childAt.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams3.height = i2;
                    childAt.setLayoutParams(layoutParams3);
                }
            }
            if (viewGroup != null) {
                viewGroup.setOnClickListener(new peCqC(alertDialog));
            }
            zZ();
            alertDialog.setOnDismissListener(new wGscSa());
            if (childAt != 0) {
                viewGroup = childAt;
            }
            this.tjSezt = false;
            viewGroup.setAlpha(0.0f);
            viewGroup.setScaleX(0.72f);
            viewGroup.setScaleY(0.72f);
            viewGroup.postDelayed(new TFbkuO(viewGroup), 50L);
            alertDialog.getWindow().getDecorView().post(new Otxclu(alertDialog));
        }
    }

    public final void YuaD() {
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("⚠ 断开 ADB 权限").setMessage("将取消本机的 ADB 激活状态：\n\n· 断开无线调试连接并删除配对身份\n· 停止本地 ADB 通道\n\n断开后安装 / 卸载等功能不可用，\n需要时可到「ADB激活页面」重新激活。\n\n确定断开吗？").setPositiveButton("断开", new ANMGZc()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final String YxdwU() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                            return inetAddressNextElement.getHostAddress();
                        }
                    }
                }
            }
            return "127.0.0.1";
        } catch (Exception unused) {
            return "127.0.0.1";
        }
    }

    public final void Z() {
        float fMz = mz();
        boolean z = this.xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float f = fMz * 18.0f;
        int i = (int) f;
        linearLayout.setPadding(i, i, i, i);
        TextView[] textViewArr = new TextView[1];
        ScrollView[] scrollViewArr = new ScrollView[1];
        boolean[] zArr = {false};
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        float f2 = fMz * 12.0f;
        int i2 = (int) f2;
        layoutParams.bottomMargin = i2;
        TextView textViewJTqL = JTqL("ADB · uid 2000");
        TextView textViewJTqL2 = JTqL("设备所有者 · OW");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = (int) (fMz * 8.0f);
        layoutParams2.rightMargin = i3;
        linearLayout2.addView(textViewJTqL, layoutParams2);
        linearLayout2.addView(textViewJTqL2, new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(this);
        textView.setText("快捷命令");
        textView.setTextSize(12.0f);
        textView.setTextColor(z ? -6643546 : -10525848);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = i3;
        linearLayout.addView(textView, layoutParams3);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        CBhInx(linearLayout3, new String[][]{new String[]{"一键激活 Shizuku", "冻结应用", "解冻应用"}, new String[]{"清除应用数据", "查看设备信息", "进程列表"}, new String[]{"重启设备", "重启到 Fastboot", "关机"}}, textViewArr, scrollViewArr, zArr);
        CBhInx(linearLayout4, new String[][]{new String[]{"命令列表", "查询设备所有者", "防卸载查询"}, new String[]{"防卸载开", "防卸载关", "安装CA证书"}, new String[]{"权限授予", "权限拒绝", "关闭锁屏"}}, textViewArr, scrollViewArr, zArr);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(-15591909);
        int i4 = (int) fMz;
        gradientDrawable.setStroke(Math.max(1, i4), z ? -14012102 : -1972757);
        linearLayout5.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) (260.0f * fMz));
        layoutParams4.topMargin = (int) (6.0f * fMz);
        layoutParams4.bottomMargin = i2;
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        int i5 = (int) (fMz * 14.0f);
        int i6 = (int) (fMz * 10.0f);
        linearLayout6.setPadding(i5, i6, i5, i6);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-13326253);
        view.setBackground(gradientDrawable2);
        int i7 = (int) (7.0f * fMz);
        linearLayout6.addView(view, new LinearLayout.LayoutParams(i7, i7));
        TextView textView2 = new TextView(this);
        textView2.setText("  adb shell · uid 2000");
        textView2.setTextSize(11.0f);
        Typeface typeface = Typeface.MONOSPACE;
        textView2.setTypeface(typeface);
        textView2.setTextColor(-7694427);
        linearLayout6.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView3 = new TextView(this);
        textView3.setText("清屏");
        textView3.setTextSize(11.5f);
        textView3.setTextColor(-8531040);
        int i8 = (int) (4.0f * fMz);
        float f3 = 2.0f * fMz;
        textView3.setPadding(i3, i8, (int) f3, i8);
        linearLayout6.addView(textView3, new LinearLayout.LayoutParams(-2, -2));
        linearLayout5.addView(linearLayout6, new LinearLayout.LayoutParams(-1, -2));
        View view2 = new View(this);
        view2.setBackgroundColor(452984831);
        linearLayout5.addView(view2, new LinearLayout.LayoutParams(-1, Math.max(1, i4)));
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        scrollView.setClipToPadding(false);
        TextView textView4 = new TextView(this);
        textView4.setTypeface(typeface);
        textView4.setTextSize(12.0f);
        textView4.setTextColor(-2629912);
        textView4.setLineSpacing(f3, 1.0f);
        textView4.setPadding(i5, i2, i5, i2);
        textView4.setText("JC 终端就绪 · 命令经 ADB 通道执行（shell 权限）\n可输入任意 shell 命令，或点上方快捷命令\n");
        textView4.setTextIsSelectable(true);
        scrollView.addView(textView4, new ViewGroup.LayoutParams(-1, -2));
        linearLayout5.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        linearLayout.addView(linearLayout5, layoutParams4);
        textViewArr[0] = textView4;
        scrollViewArr[0] = scrollView;
        textView3.setOnClickListener(new IEE(textView4));
        LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setOrientation(0);
        linearLayout7.setGravity(16);
        EditText editText = new EditText(this);
        editText.setHint("输入 shell 命令...");
        editText.setTextSize(13.0f);
        editText.setSingleLine(true);
        editText.setTextColor(z ? -1842205 : -14737633);
        editText.setHintTextColor(z ? -6643546 : -10525848);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadius(f2);
        gradientDrawable3.setColor(z ? -13881549 : -723207);
        gradientDrawable3.setStroke(Math.max(1, i4), z ? -12960446 : -1972757);
        editText.setBackground(gradientDrawable3);
        int i9 = (int) (11.0f * fMz);
        editText.setPadding(i5, i9, i5, i9);
        linearLayout7.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        textView5.setText("执行");
        textView5.setTextSize(13.0f);
        textView5.setTypeface(Typeface.DEFAULT_BOLD);
        textView5.setTextColor(-1);
        textView5.setGravity(17);
        int i10 = (int) (20.0f * fMz);
        textView5.setPadding(i10, i2, i10, i2);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setCornerRadius(f2);
        gradientDrawable4.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable4.setColors(new int[]{-10589486, -13916000});
        textView5.setBackground(gradientDrawable4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = i6;
        linearLayout7.addView(textView5, layoutParams5);
        linearLayout.addView(linearLayout7, new LinearLayout.LayoutParams(-1, -2));
        u(U(new AlertDialog.Builder(this, S4.mjFkc).setView(linearLayout).setNegativeButton("关闭", (DialogInterface.OnClickListener) null)), 580.0f);
        textView5.setOnClickListener(new Pq(editText, zArr, textViewArr, scrollViewArr));
        textViewJTqL.setOnClickListener(new diqgf(zArr, textViewJTqL, textViewJTqL2, linearLayout3, linearLayout4, textView2, editText));
        textViewJTqL2.setOnClickListener(new eyqo(zArr, textViewJTqL, textViewJTqL2, linearLayout3, linearLayout4, textView2, editText));
        m0(textViewJTqL, true);
        m0(textViewJTqL2, false);
        if (RV() || !KbpP()) {
            return;
        }
        textViewJTqL2.performClick();
    }

    public final void ZODYfo() {
        View view;
        this.NKyg = Math.max(0, this.NKyg - 1);
        Bitmap bitmap = this.kism;
        if (bitmap != null) {
            bitmap.recycle();
            this.kism = null;
        }
        if (this.NKyg <= 0 && (view = this.KLFTb) != null) {
            view.animate().cancel();
            if (Build.VERSION.SDK_INT >= 31) {
                view.setRenderEffect(null);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.animate().alpha(1.0f).setDuration(280L).start();
                return;
            }
            ImageView imageView = this.gtIJp;
            if (imageView == null) {
                view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(280L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
                return;
            }
            this.gtIJp = null;
            imageView.animate().cancel();
            imageView.animate().alpha(0.0f).setDuration(260L).withEndAction(new Sx(imageView)).start();
            view.animate().alpha(1.0f).setDuration(280L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
        }
    }

    public final void ZlB() {
        File file = this.ETF;
        if (file == null || !file.exists()) {
            return;
        }
        boolean zDelete = this.ETF.delete();
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 临时文件清理: ");
        sb.append(zDelete ? "成功" : "失败");
        sb.append(" ");
        sb.append(this.ETF.getName());
        aQ(sb.toString());
        this.ETF = null;
    }

    public final void ZxmHEb() {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
                arrayList.add("android.permission.POST_NOTIFICATIONS");
            }
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (arrayList.isEmpty()) {
                return;
            }
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 3001);
        } catch (Exception unused) {
        }
    }

    public final void a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z || jCurrentTimeMillis - this.SmIWf >= 5000) {
            this.SmIWf = jCurrentTimeMillis;
            new Thread(new nUaNy(), "jc-mode-probe").start();
        }
    }

    public final void a0(boolean z, String str, String str2, String str3) {
        this.mjFkc.post(new HExgdj(str3, z, str, str2));
    }

    public final void aAlqX() {
        d0();
        this.mjFkc.postDelayed(new SOS(), 400L);
    }

    public final void aQ(String str) {
        Log.d("JCCodeV3", str);
        StringBuilder sb = this.MiMN;
        sb.append(str);
        sb.append("\n");
        this.mjFkc.post(new XD());
    }

    public final View avDfWJ(String str, String str2, String str3, int i) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i2 = (int) (14.0f * fMz);
        linearLayout.setPadding(i2, i2, i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f * fMz);
        gradientDrawable.setColor(788529151);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        int i3 = (int) (22.0f * fMz);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        int i4 = (int) (8.0f * fMz);
        layoutParams.rightMargin = i4;
        linearLayout2.addView(imageView, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(16.0f);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView.setTypeface(typeface);
        textView.setTextColor(-1);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(16.5f);
        textView2.setTypeface(typeface);
        textView2.setTextColor(-1);
        textView2.setPadding(0, i4, 0, 0);
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setText(str3);
        textView3.setTextSize(11.5f);
        textView3.setTextColor(-637534209);
        textView3.setPadding(0, (int) (fMz * 3.0f), 0, 0);
        linearLayout.addView(textView3);
        return linearLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[Catch: all -> 0x0053, Exception -> 0x0055, LOOP:0: B:24:0x0046->B:26:0x004c, LOOP_END, TryCatch #13 {Exception -> 0x0055, all -> 0x0053, blocks: (B:23:0x0042, B:24:0x0046, B:26:0x004c, B:31:0x005b), top: B:80:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7 A[Catch: all -> 0x00bb, Exception -> 0x00bf, TRY_LEAVE, TryCatch #8 {Exception -> 0x00bf, blocks: (B:36:0x00b1, B:38:0x00b7), top: B:66:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x005b A[EDGE_INSN: B:82:0x005b->B:31:0x005b BREAK  A[LOOP:0: B:24:0x0046->B:26:0x004c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String awnh(Uri uri, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream fileInputStream;
        InputStream inputStream;
        FileOutputStream fileOutputStream2;
        byte[] bArr;
        long j;
        int i;
        InputStream inputStream2 = null;
        try {
            fileInputStream = getContentResolver().openInputStream(uri);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        if (fileInputStream != null) {
            fileOutputStream = new FileOutputStream(file);
            bArr = new byte[PKIFailureInfo.notAuthorized];
            j = 0;
            while (true) {
                i = fileInputStream.read(bArr);
                if (i > 0) {
                }
                fileOutputStream.write(bArr, 0, i);
                j += i;
            }
            fileOutputStream.flush();
            aQ("[+] 复制成功: " + j + " bytes -> " + file.getAbsolutePath());
            String absolutePath = file.getAbsolutePath();
            fileInputStream.close();
            fileOutputStream.close();
            return absolutePath;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                aQ("[!] openInputStream / openFileDescriptor 均返回 null");
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
            fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            fileOutputStream = new FileOutputStream(file);
            try {
                bArr = new byte[PKIFailureInfo.notAuthorized];
                j = 0;
                while (true) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    j += i;
                }
                fileOutputStream.flush();
                aQ("[+] 复制成功: " + j + " bytes -> " + file.getAbsolutePath());
                String absolutePath2 = file.getAbsolutePath();
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused4) {
                }
                return absolutePath2;
            } catch (Exception e) {
                InputStream inputStream3 = fileInputStream;
                fileOutputStream2 = fileOutputStream;
                e = e;
                inputStream = inputStream3;
                try {
                    this.aQ("[!] 复制异常: " + e.getClass().getSimpleName() + ": " + e.getMessage());
                    try {
                        if (file.exists()) {
                        }
                    } catch (Exception unused5) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    inputStream2 = inputStream;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = fileInputStream;
                if (inputStream2 != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = fileInputStream;
            fileOutputStream2 = null;
            this.aQ("[!] 复制异常: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            if (file.exists()) {
                file.delete();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused6) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused7) {
                }
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            inputStream2 = fileInputStream;
            if (inputStream2 != null) {
            }
            if (fileOutputStream == null) {
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (Exception unused8) {
            }
        }
        if (fileOutputStream == null) {
            throw th;
        }
        try {
            fileOutputStream.close();
            throw th;
        } catch (Exception unused9) {
            throw th;
        }
    }

    public final void b() {
        View view;
        try {
            WindowManager windowManager = this.IEE;
            if (windowManager != null && (view = this.Pq) != null) {
                windowManager.removeView(view);
            }
        } catch (Exception unused) {
        }
        this.Pq = null;
    }

    public final void b0() {
        float fMz = mz();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("不再提示");
        checkBox.setTextSize(13.5f);
        checkBox.setChecked(getSharedPreferences("jc_code_prefs", 0).getBoolean("vuln_hint_never", false));
        checkBox.setTextColor(this.xJ ? -1842205 : -14737633);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding((int) (4.0f * fMz), (int) (fMz * 8.0f), 0, 0);
        linearLayout.addView(checkBox, new LinearLayout.LayoutParams(-1, -2));
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("运行状态：漏洞模式").setMessage("当前没有任何高权限通道（ADB / 设备所有者均未激活），大部分功能不可用。\n\n建议最低激活 ADB 运行：到「ADB激活页面」完成无线调试配对，\n安装 / 卸载 / 停用管控等功能即可正常使用。").setView(linearLayout).setPositiveButton("去激活", new GMIER(checkBox)).setNegativeButton("稍后", new KRTLGT(checkBox)));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bL(String str) {
        if (str != null) {
            try {
                if (str.length() <= 0) {
                    str = "https://app.aibangos.xyz/four.apk";
                }
            } catch (Exception unused) {
                X("无法打开浏览器");
                return;
            }
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void bVfe() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 1002);
        } catch (Exception unused) {
            X("未找到图片选择器");
        }
    }

    public final void bXx(String str, ImageView imageView) {
        new Thread(new qrxT(str, imageView), "jc-popup-img").start();
    }

    public final void boLb() {
        runOnUiThread(new sRqPfw());
    }

    public final List bzZHlx(String str) {
        String strSubstring;
        String str2;
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        for (String str3 : str.split("[\r\n]+")) {
            String strTrim = str3.trim();
            if (strTrim.length() != 0) {
                String[] strArrSplit = strTrim.split("\\|");
                String strTrim2 = strArrSplit[0].trim();
                if (strTrim2.length() != 0) {
                    String str4 = "none";
                    String str5 = BuildConfig.FLAVOR;
                    String str6 = "0";
                    for (int i = 1; i < strArrSplit.length; i++) {
                        String strTrim3 = strArrSplit[i].trim();
                        if (strTrim3.equalsIgnoreCase("close")) {
                            str6 = "1";
                        } else {
                            if (strTrim3.regionMatches(true, 0, "url=", 0, 4)) {
                                strSubstring = strTrim3.substring(4).trim();
                                str2 = "url";
                            } else if (strTrim3.regionMatches(true, 0, "copy=", 0, 5)) {
                                strSubstring = strTrim3.substring(5);
                                str2 = "copy";
                            }
                            String str7 = str2;
                            str5 = strSubstring;
                            str4 = str7;
                        }
                    }
                    arrayList.add(new String[]{strTrim2, str4, str5, str6});
                }
            }
        }
        return arrayList;
    }

    public final void c() {
        if (this.fFz != null) {
            try {
                ((ViewGroup) getWindow().getDecorView()).removeView(this.fFz);
            } catch (Throwable unused) {
            }
            this.fFz = null;
        }
    }

    public final void c0(String str) {
        new Thread(new lgHUyS(str)).start();
    }

    public final void d() {
        if (this.uH != null) {
            try {
                ((ViewGroup) getWindow().getDecorView()).removeView(this.uH);
            } catch (Throwable unused) {
            }
            this.uH = null;
        }
    }

    public final void d0() {
        String strCqaNbM = com.jc.code.v3.mjFkc.vadzgd() ? com.jc.code.v3.mjFkc.CqaNbM() : IRE();
        this.xROA = strCqaNbM;
        g();
        C0("正在搜索无线调试配对服务…", true);
        com.jc.code.v3.mjFkc.ANMGZc(this, strCqaNbM, new gtIJp(strCqaNbM));
    }

    public final void dXmy(Uri uri) throws Throwable {
        String scheme = uri.getScheme();
        String path = uri.getPath();
        aQ("[*] scheme=" + scheme + " path=" + path);
        if ("file".equals(scheme)) {
            String path2 = uri.getPath();
            if (path2 != null) {
                try {
                    path2 = URLDecoder.decode(path2, "UTF-8");
                } catch (Exception unused) {
                }
            }
            if (path2 == null || path2.isEmpty()) {
                aQ("[!] file:// URI 路径为空");
                return;
            } else {
                jIShy(path2);
                return;
            }
        }
        if (!"content".equals(scheme)) {
            if (path != null && !path.isEmpty()) {
                jIShy(path);
                return;
            }
            aQ("[!] 无法解析 URI: " + uri);
            return;
        }
        String strH = h(uri);
        if (strH != null) {
            aQ("[+] 解析到路径: " + strH);
            jIShy(strH);
            return;
        }
        if (path != null && new File(path).exists() && new File(path).canRead()) {
            aQ("[+] content 路径可直接读取: " + path);
            jIShy(path);
            return;
        }
        String strRB = rB(uri);
        if (strRB == null) {
            aQ("[!] content:// 处理失败");
            X("✗ 文件复制失败，无法安装");
            return;
        }
        aQ("[+] 已复制到: " + strRB);
        this.ETF = new File(strRB);
        jIShy(strRB);
    }

    public final void e() {
        if (this.vjlshU == null) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            if (windowManager != null) {
                windowManager.removeView(this.vjlshU);
            }
        } catch (Exception unused) {
        }
        this.vjlshU = null;
    }

    public final void e0() {
        aQ("\n[*] 一键开开发者：启动内置代理...");
        Y("正在准备开发者通道...");
        new Thread(new jm(), "jc-devmode").start();
    }

    public final void f() {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
            intent.addFlags(268435456);
            startActivity(intent);
            X("请开启悬浮窗权限，下次下载即可显示悬浮球进度");
        } catch (Exception e) {
            aQ("[!] 打开悬浮窗权限设置失败: " + e.getMessage());
        }
    }

    public final void f0() {
        if (this.VA == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.WGXroI;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.VA, "alpha", 0.35f, 1.0f);
        this.WGXroI = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(850L);
        this.WGXroI.setRepeatCount(-1);
        this.WGXroI.setRepeatMode(2);
        this.WGXroI.start();
    }

    public final void fTu() {
        PathInterpolator pathInterpolator = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        View viewFindViewById = findViewById(AbstractC1978u4.VA);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(0.0f);
            viewFindViewById.animate().alpha(1.0f).setDuration(200L).setInterpolator(pathInterpolator).start();
        }
        View viewFindViewById2 = findViewById(AbstractC1978u4.YoKzxo);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setAlpha(0.0f);
            viewFindViewById2.animate().alpha(1.0f).setDuration(220L).setInterpolator(pathInterpolator).start();
        }
        for (int i = 0; i < this.Vnb.size(); i++) {
            LinearLayout linearLayout = ((gJsSk) this.Vnb.get(i)).KLFTb;
            if (linearLayout != null) {
                linearLayout.setAlpha(1.0f);
                linearLayout.setTranslationX(0.0f);
            }
        }
        jwyZcq((gJsSk) this.Vnb.get(0), pathInterpolator);
        if (((gJsSk) this.Vnb.get(0)).ETF != null) {
            ((gJsSk) this.Vnb.get(0)).ETF.setScaleX(1.0f);
        }
    }

    public final void fg() {
        CrDc(false);
    }

    public final void g() {
        BOPu();
    }

    public final void g0() {
        h0(false);
    }

    public final boolean gGFLGZ(String str, String str2, String str3) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int iIndexOf = lowerCase.indexOf(63);
        int iIndexOf2 = lowerCase.indexOf(35);
        int length = lowerCase.length();
        if (iIndexOf < 0 || iIndexOf >= length) {
            iIndexOf = length;
        }
        if (iIndexOf2 < 0 || iIndexOf2 >= iIndexOf) {
            iIndexOf2 = iIndexOf;
        }
        if (lowerCase.substring(0, iIndexOf2).endsWith(".apk")) {
            return true;
        }
        if (str2 != null && str2.toLowerCase().contains("filename") && str2.toLowerCase().contains(".apk")) {
            return true;
        }
        return str3 != null && "application/vnd.android.package-archive".equalsIgnoreCase(str3);
    }

    public final void gYsXfP() throws InterruptedException, IOException {
        aQ("\n[*] 清理无线调试配对记录...");
        if (!RW()) {
            aQ("[!] 需要 Root 权限");
            X("✗ 需要 Root 权限");
            return;
        }
        String strJxC = jxC("rm -f /data/misc/adb/adb_temp_keys.xml; if [ -f /data/misc/adb/adb_keys ]; then grep -v 'JC Code V3' /data/misc/adb/adb_keys > /data/local/tmp/jc_adb_keys.new; cat /data/local/tmp/jc_adb_keys.new > /data/misc/adb/adb_keys; rm -f /data/local/tmp/jc_adb_keys.new; fi; echo DONE");
        StringBuilder sb = new StringBuilder();
        sb.append("[*] ");
        sb.append(strJxC != null ? strJxC.trim() : BuildConfig.FLAVOR);
        aQ(sb.toString());
        com.jc.code.v3.mjFkc.vI();
        com.jc.code.v3.mjFkc.mByQ(com.jc.code.v3.mjFkc.CqaNbM());
        getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
        XvQLwQ();
        aQ("[+] 配对记录已清理，请重新打开无线调试配对");
        Y("✓ 已清理配对记录，请重新配对");
        this.mjFkc.post(new WrLQs());
    }

    public final void gb() {
        L("安装本地 APK", new xVYW[]{new xVYW("通过文件管理器选择", "从系统文件选择器中选取 APK", AbstractC1857s4.rkYL, -10589486, new LlB()), new xVYW("手动输入路径", "直接填写 APK 文件路径", AbstractC1857s4.MiMN, -13916000, new Es())}, 480.0f);
    }

    public final void gcD() {
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("清理无线调试配对记录").setMessage("删除系统里所有由本应用产生的无线调试配对（“已配对的设备”列表）。\n\n· 需要 Root 权限\n· 电脑等其他设备的 ADB 授权会保留\n· 清理后本应用需要重新配对一次\n\n确定继续？").setPositiveButton("清理", new oCFDzJ()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final void gq() {
        aQ("[*] 绑定中...");
        if (!JtIAgM()) {
            aQ("[!] Hidden API bypass 全部失败");
            D0("连接失败", false);
            X("✗ Hidden API bypass 失败");
            return;
        }
        try {
            this.lgHUyS = getSystemService("zybos_manager");
            this.qdMbNW = Class.forName("android.os.ZybosSysApiManager");
            this.Dt = true;
            fg();
            Method[] methodArrCRhd = CRhd();
            Class cls = Boolean.TYPE;
            boolean z = CO("silentInstallApk", String.class, cls, String.class) != null;
            boolean z2 = CO("silentUninstallApk", String.class, cls) != null;
            aQ("[+] 绑定成功，" + methodArrCRhd.length + " 个方法");
            StringBuilder sb = new StringBuilder();
            sb.append("[+] 安装: ");
            sb.append(z ? "✓" : "✗");
            sb.append("  卸载: ");
            sb.append(z2 ? "✓" : "✗");
            aQ(sb.toString());
            D0("权限已生效 · " + methodArrCRhd.length + " 个方法可用", true);
            boolean z3 = this.xJ;
            SZKiB(z3, z3 ? -1842205 : -14737633, z3 ? -6643546 : -12302522);
        } catch (Exception e) {
            aQ("[!] 绑定失败: " + e.getMessage());
            D0("绑定失败", false);
        }
    }

    public final String h(Uri uri) throws UnsupportedEncodingException {
        String path;
        String authority = uri.getAuthority();
        if (authority != null && "com.android.externalstorage.documents".equals(authority) && (path = uri.getPath()) != null && path.startsWith("/document/")) {
            String strSubstring = path.substring(10);
            try {
                strSubstring = URLDecoder.decode(strSubstring, "UTF-8");
            } catch (Exception unused) {
            }
            if (strSubstring.startsWith("primary:")) {
                return "/storage/emulated/0/" + strSubstring.substring(8);
            }
        }
        return null;
    }

    public final void h0(boolean z) {
        this.XFUzSY = System.currentTimeMillis();
        if (!z) {
            H(false, "正在验证服务状态", "需要连接服务器确认后才能使用，请保持联网");
        }
        new Thread(new qGgY(z), "jc-gate").start();
    }

    public final void i() {
        try {
            aQ("[*] 恢复系统内置个人中心（卸载临时 3.2）...");
            String strBbzow = com.jc.code.v3.mjFkc.bbzow("pm uninstall com.zuoyebang.iot.pad.zpusercenter");
            StringBuilder sb = new StringBuilder();
            sb.append("[*] 恢复结果: ");
            String str = BuildConfig.FLAVOR;
            sb.append(strBbzow != null ? strBbzow.trim().replace("\n", " | ") : BuildConfig.FLAVOR);
            aQ(sb.toString());
            try {
                str = getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
            }
            if (str == null || str.startsWith("3.2")) {
                aQ("[!] 恢复未生效（当前 " + str + "），可手动卸载更新");
                Y("恢复未生效，可手动卸载更新");
                return;
            }
            aQ("[+] 已恢复系统版个人中心（" + str + "），全部功能恢复");
            Y("✓ 已恢复系统版个人中心");
        } catch (Throwable th) {
            aQ("[!] 恢复失败: " + mYYU(th) + "，可手动卸载更新");
            Y("恢复失败，可手动卸载更新");
        }
    }

    public final String i0(File file) throws UnsupportedEncodingException {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            this.qGY = serverSocket;
            int localPort = serverSocket.getLocalPort();
            String strEncode = URLEncoder.encode(file.getName(), "UTF-8");
            new Thread(new XFUzSY(strEncode, file)).start();
            return "http://127.0.0.1:" + localPort + "/" + strEncode;
        } catch (Exception e) {
            this.aQ("[!] 启动本地文件服务失败: " + e);
            return null;
        }
    }

    public final void iBHnK() {
        try {
            File fileKLFTb = CBEvIj.JHa().KLFTb(this);
            if (fileKLFTb == null) {
                return;
            }
            byte[] bArr = new byte[(int) fileKLFTb.length()];
            FileInputStream fileInputStream = new FileInputStream(fileKLFTb);
            fileInputStream.read(bArr);
            fileInputStream.close();
            Intent intentCreateInstallIntent = KeyChain.createInstallIntent();
            intentCreateInstallIntent.putExtra("CERT", bArr);
            intentCreateInstallIntent.putExtra("name", "JC Code Dev CA");
            startActivity(intentCreateInstallIntent);
            aQ("[*] 已拉起系统证书安装界面（需手动确认）");
        } catch (Throwable th) {
            aQ("[!] 回退安装失败: " + mYYU(th));
        }
    }

    public final void iEjzEW(TextView textView, ScrollView scrollView, String str, int i) {
        this.mjFkc.post(new zvd(i, str, textView, scrollView));
    }

    public final void ilrRDI() {
        aQ("\n[*] 启动 DebugHybrid...");
        String[][] strArr = {new String[]{"com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.page.activity.debug.DebugHybridActivity"}, new String[]{"com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.pad.zpusercenter.user.presentation.view.UserActivity"}, new String[]{"com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.pad.zpusercenter.feedback.presentation.view.FeedbackActivity"}};
        for (int i = 0; i < 3; i++) {
            String[] strArr2 = strArr[i];
            try {
                Intent intent = new Intent();
                intent.setClassName(strArr2[0], strArr2[1]);
                intent.setFlags(268435456);
                startActivity(intent);
                String str = strArr2[1];
                String strSubstring = str.substring(str.lastIndexOf(46) + 1);
                aQ("[+] " + strSubstring + " 已启动 ✓");
                StringBuilder sb = new StringBuilder();
                sb.append("✓ ");
                sb.append(strSubstring);
                X(sb.toString());
                return;
            } catch (Exception e) {
                String str2 = strArr2[1];
                aQ("[-] " + str2.substring(str2.lastIndexOf(46) + 1) + ": " + e.getMessage());
            }
        }
        aQ("[!] 所有 WebView Activity 均失败");
        X("✗ 无可用的 WebView 页面");
    }

    public final boolean j() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/sbin/su", "/su/bin/su", "/debug_ramdisk/su"};
        for (int i = 0; i < 5; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public final void j0() {
        new Thread(new NKyg()).start();
    }

    public final void jCFSyK() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (FBR()) {
            aQ("\n[*] 取消更新...");
            try {
                Method methodCO = CO("cancelUpdate", new Class[0]);
                if (methodCO != null) {
                    methodCO.invoke(this.lgHUyS, null);
                    aQ("[+] 取消更新成功");
                    X("✓ 系统更新已取消");
                } else {
                    aQ("[!] cancelUpdate 未找到");
                    X("✗ cancelUpdate 方法未找到");
                }
            } catch (Exception e) {
                aQ("[!] " + e.getMessage());
                X("✗ " + e.getMessage());
            }
        }
    }

    public final void jIShy(String str) {
        File file = new File(str);
        if (!file.exists()) {
            aQ("[!] 文件不存在: " + str);
            X("✗ 文件不存在");
            return;
        }
        String strReplace = file.getName().replace(".apk", BuildConfig.FLAVOR);
        boolean z = false;
        try {
            PackageInfo packageArchiveInfo = getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo != null) {
                strReplace = packageArchiveInfo.packageName;
                z = true;
            }
        } catch (Exception unused) {
        }
        String str2 = strReplace;
        aQ("[*] 安装: " + file.getName() + " (" + (file.length() / 1024) + "KB)");
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 包名: ");
        sb.append(str2);
        aQ(sb.toString());
        new Thread(new jpz(file, str2, z, str)).start();
    }

    public final void jKf() {
        new Thread(new yfx(), "jc-devproxy-clean").start();
    }

    public final void jeHSg() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/vnd.android.package-archive");
        try {
            startActivityForResult(intent, 1001);
        } catch (Exception unused) {
            X("未找到文件管理器");
            P();
        }
    }

    public final void jwyZcq(gJsSk gjssk, Interpolator interpolator) {
        View view;
        H1 h1 = gjssk.VA;
        if (h1 == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) h1.getChildAt(0);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                int i2 = 0;
                while (true) {
                    LinearLayout linearLayout2 = (LinearLayout) childAt;
                    if (i2 < linearLayout2.getChildCount()) {
                        View childAt2 = linearLayout2.getChildAt(i2);
                        if (childAt2 instanceof LinearLayout) {
                            childAt2.setAlpha(1.0f);
                            childAt2.setTranslationY(0.0f);
                        }
                        i2++;
                    }
                }
            }
        }
        for (qtZIjO qtzijo : gjssk.ZfxDd) {
            if (qtzijo.qGY != null && !qtzijo.JHa && (view = qtzijo.MiMN) != null && view.getParent() != null) {
                qtzijo.qGY.animate().cancel();
                qtzijo.qGY.setScaleX(1.0f);
                qtzijo.qGY.setScaleY(1.0f);
                qtzijo.qGY.setRotation(0.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.String] */
    public final String jxC(String str) throws InterruptedException, IOException {
        if (!RW() && RV()) {
            try {
                String strBbzow = com.jc.code.v3.mjFkc.bbzow(str);
                if (strBbzow == null) {
                    return BuildConfig.FLAVOR;
                }
                this = strBbzow.trim();
                return this;
            } catch (Throwable th) {
                this.aQ("[!] ADB Shell 失败: " + mYYU(th));
            }
        }
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{"su", "-c", str});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            int iWaitFor = processExec.waitFor();
            if (iWaitFor != 0 && sb.length() == 0) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream()));
                while (true) {
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        break;
                    }
                    sb.append(line2);
                    sb.append("\n");
                }
                if (sb.length() == 0) {
                    sb.append("su 拒绝或不可用 (exit=");
                    sb.append(iWaitFor);
                    sb.append(")");
                }
            }
            return sb.toString().trim();
        } catch (Exception e) {
            return "错误: " + e.getMessage();
        }
    }

    public final void k() {
        new Thread(new XV(), "jc-dev-wizard").start();
    }

    public final void k0() {
        if (ScreenCaptureService.isRunning()) {
            Io();
            ScreenCaptureService.extendWatch();
            DanUFX();
            return;
        }
        try {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            if (mediaProjectionManager == null) {
                throw new IllegalStateException("MediaProjectionManager 不可用");
            }
            aQ("[*] 请求屏幕读取授权（无需 Root / 无障碍）...");
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 2001);
        } catch (Exception e) {
            aQ("[!] 屏幕读取授权失败: " + e.getMessage());
            s0("无法申请屏幕读取权限");
            DanUFX();
        }
    }

    public final boolean kgk() {
        return this.Ne >= 7000;
    }

    public final boolean khi(String str) {
        int iIndexOf;
        if (str.contains(" ") || str.contains("\u3000") || (iIndexOf = str.indexOf(46)) <= 0 || iIndexOf >= str.length() - 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.' && cCharAt != '-' && cCharAt != '_' && cCharAt != ':' && cCharAt != '/' && cCharAt != '?' && cCharAt != '&' && cCharAt != '=' && cCharAt != '%') {
                return false;
            }
        }
        return true;
    }

    public final void khjiU() {
        aQ("\n[*] 服务绑定探测...");
        String[][] strArr = {new String[]{"com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.pad.supervise.SuperviseService"}, new String[]{"com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.pad.supervise.SelectChildService"}, new String[]{"com.zuoyebang.iot.pad.appstore", "com.zuoyebang.iot.pad.appstore.RemoteService"}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] strArr2 = strArr[i];
            try {
                Intent intent = new Intent();
                intent.setClassName(strArr2[0], strArr2[1]);
                boolean zBindService = bindService(intent, new Dp(), 1);
                String str = strArr2[1];
                String strSubstring = str.substring(str.lastIndexOf(46) + 1);
                sb.append(zBindService ? "✓ " : "✗ ");
                sb.append(strSubstring);
                sb.append("\n");
            } catch (Exception e) {
                sb.append("✗ ");
                String str2 = strArr2[1];
                sb.append(str2.substring(str2.lastIndexOf(46) + 1));
                sb.append(" — ");
                sb.append(e.getClass().getSimpleName());
                sb.append("\n");
            }
        }
        this.mjFkc.post(new fLidf(sb));
    }

    public final void l() {
        aQ("\n[*] ===== 申请设备所有者 =====");
        Y("申请设备所有者：开始...");
        new Thread(new JBhc(), "jc-device-owner").start();
    }

    public final void l0(AlertDialog alertDialog, int i, int i2) {
        try {
            Button button = alertDialog.getButton(-1);
            if (button != null) {
                button.setTextColor(i);
                button.setAllCaps(false);
            }
            Button button2 = alertDialog.getButton(-2);
            if (button2 != null) {
                button2.setTextColor(i2);
                button2.setAllCaps(false);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean lEH() {
        return com.jc.code.v3.mjFkc.NPj() || com.jc.code.v3.mjFkc.xrEuO() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false);
    }

    public final void m(String str, TextView textView, ScrollView scrollView) {
        iEjzEW(textView, scrollView, "\n# " + str + "\n", -5005825);
        new Thread(new wJVbdd(str, textView, scrollView), "jc-ow-term").start();
    }

    public final void m0(TextView textView, boolean z) {
        float fMz = mz();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(fMz * 20.0f);
        if (z) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setColors(new int[]{-10589486, -13916000});
            textView.setTextColor(-1);
        } else {
            gradientDrawable.setColor(this.xJ ? -14275018 : -1380106);
            textView.setTextColor(this.xJ ? -3550500 : -13682107);
        }
        textView.setBackground(gradientDrawable);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:4|29|5|(2:33|6)|31|13|14|(7:35|17|37|18|41|22|15)|39|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x014a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mL() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iUpdate;
        if (FBR()) {
            aQ("\n[*] 解除家长管控（三通道）...");
            x0("setPackageListDisallow", new Class[]{List.class}, new ArrayList());
            x0("setClassListDisallow", new Class[]{List.class}, new ArrayList());
            Class cls = Boolean.TYPE;
            Boolean bool = Boolean.FALSE;
            x0("setInstallPackageDisallow", new Class[]{cls}, bool);
            x0("setUSBDisallow", new Class[]{cls}, bool);
            aQ("[+] 通道1: ZybosSysApiManager 已调用");
            int i = 0;
            try {
                Uri uri = Uri.parse("content://com.zuoyebang.iot.zptcpservice.account.provider/config");
                ContentValues contentValues = new ContentValues();
                contentValues.put("class_forbidden", BuildConfig.FLAVOR);
                contentValues.put("app_status_list", BuildConfig.FLAVOR);
                contentValues.put("holidays", BuildConfig.FLAVOR);
                contentValues.put("tilt_enable", "0");
                contentValues.put("contact_protect", "0");
                contentValues.put("sms_collection", "0");
                iUpdate = getContentResolver().update(uri, contentValues, "_id=0", null);
            } catch (Exception e) {
                e = e;
                iUpdate = 0;
            }
            try {
                aQ("[+] 通道2: 云端配置已清空 (" + iUpdate + " 行)");
            } catch (Exception e2) {
                e = e2;
                aQ("[!] 通道2: " + e.getMessage());
                Uri.parse("content://com.zuoyebang.iot.pad.supervise");
                String[] strArr = {"/disable", "/key_value"};
                int i2 = 0;
                while (i < 2) {
                }
                aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i2 + "行)");
                X("✓ 管控已解除 (三通道)");
            }
            Uri.parse("content://com.zuoyebang.iot.pad.supervise");
            String[] strArr2 = {"/disable", "/key_value"};
            int i22 = 0;
            while (i < 2) {
                try {
                    String str = strArr2[i];
                    try {
                        Uri uri2 = Uri.parse("content://com.zuoyebang.iot.pad.supervise" + str);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("disabled_apps", BuildConfig.FLAVOR);
                        contentValues2.put("app_list", BuildConfig.FLAVOR);
                        int iDelete = getContentResolver().delete(uri2, null, null);
                        i22 += iDelete;
                        aQ("[+] 通道3: " + str + " 删除 " + iDelete + " 行");
                    } catch (Exception e3) {
                        aQ("[!] 通道3 " + str + ": " + e3.getMessage());
                    }
                    i++;
                } catch (Exception e4) {
                    e = e4;
                    i = i22;
                    aQ("[!] 通道3: " + e.getMessage());
                    i22 = i;
                    aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i22 + "行)");
                    X("✓ 管控已解除 (三通道)");
                }
            }
            aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i22 + "行)");
            X("✓ 管控已解除 (三通道)");
        }
    }

    public final View mZG(qtZIjO qtzijo) {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        View view = new View(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(2.0f * fMz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{-10589486, -13916000});
        view.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (4.0f * fMz), (int) (18.0f * fMz));
        layoutParams.rightMargin = (int) (fMz * 10.0f);
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(qtzijo.mjFkc);
        textView.setTextSize(16.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        textView.setTextColor(this.xJ ? -1842205 : -14737633);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        qtzijo.YoKzxo = textView;
        return linearLayout;
    }

    public final void mh(String str) {
        String strTrim = str == null ? BuildConfig.FLAVOR : str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) {
            if (khi(strTrim)) {
                strTrim = "https://" + strTrim;
            } else {
                try {
                    strTrim = "https://www.bing.com/search?q=" + URLEncoder.encode(strTrim, "UTF-8");
                } catch (Exception unused) {
                    strTrim = "https://www.bing.com/search?q=" + strTrim;
                }
            }
        }
        aQ("[*] 浏览器导航: " + strTrim);
        if (this.xrEuO != null) {
            View view = this.zvd;
            if (view != null && view.getVisibility() == 0) {
                this.zvd.setVisibility(8);
                this.xrEuO.setVisibility(0);
                View view2 = this.cMLeY;
                if (view2 != null) {
                    view2.setBackgroundColor(this.xJ ? -14671840 : -789517);
                }
            }
            this.xrEuO.loadUrl(strTrim);
        }
    }

    public final float mz() {
        return getResources().getDisplayMetrics().density;
    }

    public final void n(int i) {
        new Thread(new Vnb(i)).start();
    }

    public final void n0(Snackbar snackbar) {
        View viewNe = snackbar.Ne();
        float f = getResources().getDisplayMetrics().density;
        boolean z = this.xJ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(16.0f * f);
        int i = z ? -1842205 : -13486535;
        int i2 = z ? -14737633 : -920588;
        gradientDrawable.setColor(i);
        viewNe.setBackground(gradientDrawable);
        snackbar.xROA(i2);
        snackbar.yfx(z ? -10589486 : -5919253);
        EeoThB eeoThB = new EeoThB(viewNe, gradientDrawable, i2);
        eeoThB.run();
        viewNe.post(eeoThB);
        viewNe.postDelayed(eeoThB, 250L);
        viewNe.postDelayed(eeoThB, 700L);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewNe.getLayoutParams();
        marginLayoutParams.bottomMargin = (int) (48.0f * f);
        int i3 = (int) (f * 24.0f);
        marginLayoutParams.leftMargin = i3;
        marginLayoutParams.rightMargin = i3;
        viewNe.setLayoutParams(marginLayoutParams);
    }

    public final void nTET() {
        boolean zKgk = kgk();
        KRckQg kRckQg = null;
        gJsSk gjssk = new gJsSk(kRckQg);
        gjssk.mjFkc = "首页";
        gjssk.AZxh = "常用功能与快速入口";
        gjssk.wA = AbstractC1857s4.qGY;
        JBjLUy(gjssk, "安装APP", "本地 APK / 直链安装", AbstractC1857s4.Pq, -10589486, new FOJ(), false);
        JBjLUy(gjssk, "一键开开发者", "全自动 · 进入开发者模式", AbstractC1857s4.qdMbNW, -15171528, new HX(), false);
        UqgK(gjssk, "静默卸载", "ADB 静默卸载 · 列表或名称", AbstractC1857s4.CqaNbM, -2543579, new Mpf(), false, true, true);
        qtZIjO qtzijoUqgK = UqgK(gjssk, "阻止系统删应用", BuildConfig.FLAVOR, AbstractC1857s4.wJVbdd, -3857889, new tPvjn(), false, true, true);
        this.JYgkl = qtzijoUqgK;
        qtzijoUqgK.qdMbNW = true;
        this.Vnb.add(gjssk);
        gJsSk gjssk2 = new gJsSk(kRckQg);
        gjssk2.mjFkc = "应用与管控";
        gjssk2.AZxh = "应用安装、卸载与系统管控";
        gjssk2.wA = AbstractC1857s4.wA;
        FoPRDo(gjssk2, "应用管理");
        JBjLUy(gjssk2, "安装APP", "本地 APK / 直链安装", AbstractC1857s4.Pq, -15171528, new UPU(), false);
        UqgK(gjssk2, "静默卸载", "ADB 静默卸载 · 批量选择", AbstractC1857s4.CqaNbM, -2543579, new BABY(), false, true, true);
        FoPRDo(gjssk2, "系统管控");
        IRYXZ(gjssk2, "解除管控", "三通道清除家长管控限制", AbstractC1857s4.vI, -2543579, new ETF(), false, true);
        IRYXZ(gjssk2, "取消更新", "阻止系统 OTA 更新", AbstractC1857s4.JHa, -414976, new Ucbh(), false, true);
        qtZIjO qtzijoUqgK2 = UqgK(gjssk2, "阻止系统删应用", BuildConfig.FLAVOR, AbstractC1857s4.wJVbdd, -3857889, new Ne(), false, true, true);
        this.JYn = qtzijoUqgK2;
        qtzijoUqgK2.qdMbNW = true;
        v(getSharedPreferences("jc_code_prefs", 0).getBoolean("padms_disabled", false));
        JBjLUy(gjssk2, "单独应用防卸载", "设备所有者 · 保护指定应用不被卸载", AbstractC1857s4.OjSQV, -10337066, new aqHPIZ(), false);
        this.Vnb.add(gjssk2);
        gJsSk gjssk3 = new gJsSk(kRckQg);
        gjssk3.mjFkc = "开发者工具";
        gjssk3.AZxh = "调试入口与绑定诊断";
        gjssk3.wA = AbstractC1857s4.KLFTb;
        JBjLUy(gjssk3, "开发者磁贴", "无线调试 / 开发者设置", AbstractC1857s4.Dt, -15043608, new bbzow(), false);
        JBjLUy(gjssk3, "ADB激活页面", "无线调试 · 自动识别配对码并完成 ADB 配对", AbstractC1857s4.Dt, -15043608, new xROA(), false);
        JBjLUy(gjssk3, "终端工具", "ADB Shell 终端 · 快捷命令", AbstractC1857s4.ZfxDd, -13916000, new yX(), false);
        JBjLUy(gjssk3, "一键开开发者", "全自动 · 进入开发者模式", AbstractC1857s4.qdMbNW, -15171528, new Vgyli(), false);
        JBjLUy(gjssk3, "申请设备所有者", "临时停用账号 → 激活后可静默装 CA", AbstractC1857s4.huTpC, -10337066, new rdJr(), false);
        JBjLUy(gjssk3, "手动尝试绑定", "zybos 绑定诊断 / 兼容性测试", AbstractC1857s4.ZfxDd, -1543926, new Jk(), !zKgk);
        this.Vnb.add(gjssk3);
        gJsSk gjssk4 = new gJsSk(kRckQg);
        gjssk4.mjFkc = "杂项";
        gjssk4.AZxh = "杂类工具与闲散入口";
        gjssk4.wA = AbstractC1857s4.eyqo;
        JBjLUy(gjssk4, "DebugHybrid", "打开 ZYB WebView 调试页", AbstractC1857s4.AZxh, -7129882, new NV(), false);
        JBjLUy(gjssk4, "DNS 深链", "打开 DNS 配置页", AbstractC1857s4.lB, -10589486, new Jidt(), false);
        JBjLUy(gjssk4, "清理无线调试配对记录", "Root 清空“已配对的设备”列表（需重新配对）", AbstractC1857s4.OjSQV, -2543579, new IvRQOa(), false);
        this.Vnb.add(gjssk4);
        gJsSk gjssk5 = new gJsSk(kRckQg);
        gjssk5.mjFkc = "设备信息";
        gjssk5.AZxh = "设备状态与探测";
        gjssk5.wA = AbstractC1857s4.IEE;
        JBjLUy(gjssk5, "探测工具", "设备状态 / 管控 / 能力 / 服务 · 一键查询", AbstractC1857s4.YoKzxo, -15551029, new APn(), false);
        this.Vnb.add(gjssk5);
        gJsSk gjssk6 = new gJsSk(kRckQg);
        gjssk6.mjFkc = "设置";
        gjssk6.AZxh = "外观、背景与日志";
        gjssk6.wA = AbstractC1857s4.Ne;
        this.GMIER = JBjLUy(gjssk6, "夜间模式", this.xJ ? "当前：夜间 · 点击切换日间" : "当前：日间 · 点击切换夜间", AbstractC1857s4.HGpJ, -12828605, new knzZ(), false);
        this.uHVRx = JBjLUy(gjssk6, "隐藏不可用按钮", getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false) ? "当前：开启 · 不可用按钮已自动隐藏" : "当前：关闭 · 开启后自动隐藏不可用按钮", AbstractC1857s4.YoKzxo, -13916000, new ybBTr(), false);
        JBjLUy(gjssk6, "自定义背景", "设置主界面背景图", AbstractC1857s4.fehf, -7129882, new sqndV(), false);
        JBjLUy(gjssk6, "搜索页背景", "设置浏览器搜索页背景", AbstractC1857s4.fehf, -15551029, new oaI(), false);
        JBjLUy(gjssk6, "修改搜索页标题", "自定义浏览器首页标题", AbstractC1857s4.lB, -1543926, new RWyiuY(), false);
        JBjLUy(gjssk6, "查看运行日志", "复制或清空运行日志", AbstractC1857s4.diqgf, -15171528, new Vu(), false);
        JBjLUy(gjssk6, "断开 ADB 权限", "⚠ 取消本机的 ADB 激活状态", AbstractC1857s4.Dt, -2543579, new oVXlhB(), false);
        JBjLUy(gjssk6, "取消设备所有者", "⚠ 放弃设备管理权限（OW）", AbstractC1857s4.huTpC, -2543579, new CTcA(), false);
        this.Vnb.add(gjssk6);
        gJsSk gjssk7 = new gJsSk(kRckQg);
        gjssk7.mjFkc = "关于";
        gjssk7.AZxh = "作者与更新信息";
        gjssk7.wA = AbstractC1857s4.mjFkc;
        JBjLUy(gjssk7, "检查更新", "打开官网获取最新版本", AbstractC1857s4.KLFTb, -10589486, new LeWm(), false);
        JBjLUy(gjssk7, "复制邮箱", "aono_saki@outlook.com", AbstractC1857s4.IEE, -15171528, new Fztqa(), false);
        String strWfQA = wfQA();
        JBjLUy(gjssk7, "设备码", strWfQA + " · 点击复制", AbstractC1857s4.AZxh, -13916000, new mzUGzO(strWfQA), false);
        this.Vnb.add(gjssk7);
        for (int i = 0; i < this.Vnb.size(); i++) {
            if ("设备信息".equals(((gJsSk) this.Vnb.get(i)).mjFkc)) {
                this.vadzgd = i;
            }
        }
    }

    public final void nVsW(boolean z) {
        if (this.alEkx == null) {
            return;
        }
        boolean z2 = this.Vdz;
        boolean z3 = this.jm;
        boolean z4 = true;
        boolean z5 = (z2 && z3) ? false : true;
        float fMz = mz();
        if (!z5) {
            if (z && this.alEkx.getVisibility() == 0) {
                LinearLayout linearLayout = this.alEkx;
                linearLayout.animate().alpha(0.0f).translationY(fMz * (-10.0f)).scaleY(0.97f).setDuration(320L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f)).withEndAction(new cdjp(linearLayout)).start();
                return;
            }
            this.alEkx.animate().cancel();
            this.alEkx.setAlpha(1.0f);
            this.alEkx.setTranslationY(0.0f);
            this.alEkx.setScaleY(1.0f);
            this.alEkx.setVisibility(8);
            return;
        }
        boolean z6 = this.alEkx.getVisibility() != 0;
        this.alEkx.removeAllViews();
        TextView textView = new TextView(this);
        StringBuilder sb = new StringBuilder();
        sb.append("快速上手 · 建议先完成这");
        sb.append((z2 || z3) ? "一步" : "两步");
        textView.setText(sb.toString());
        textView.setTextSize(12.5f);
        textView.setLetterSpacing(0.08f);
        textView.setTextColor(-1275068417);
        this.alEkx.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("先激活通道，全部功能才可用");
        textView2.setTextSize(20.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(-1);
        textView2.setPadding(0, (int) (4.0f * fMz), 0, (int) (16.0f * fMz));
        this.alEkx.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        this.alEkx.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        if (!z2) {
            View viewAvDfWJ = avDfWJ("①", "ADB 激活", "无线调试配对 · 最低要求", AbstractC1857s4.Dt);
            linearLayout2.addView(viewAvDfWJ, new LinearLayout.LayoutParams(0, -2, 1.0f));
            viewAvDfWJ.setOnClickListener(new xBQUgd());
            z4 = false;
        }
        if (!z3) {
            View viewAvDfWJ2 = avDfWJ(z4 ? "①" : "②", "设备所有者", "静默装 CA · 解锁全自动", AbstractC1857s4.huTpC);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            if (!z4) {
                layoutParams.leftMargin = (int) (12.0f * fMz);
            }
            linearLayout2.addView(viewAvDfWJ2, layoutParams);
            viewAvDfWJ2.setOnClickListener(new MFekjo());
        }
        this.alEkx.setVisibility(0);
        if (z6 && z) {
            this.alEkx.setAlpha(0.0f);
            this.alEkx.setTranslationY(fMz * 30.0f);
            this.alEkx.setScaleY(0.94f);
            this.alEkx.animate().alpha(1.0f).translationY(0.0f).scaleY(1.0f).setDuration(480L).setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f)).start();
            return;
        }
        this.alEkx.animate().cancel();
        this.alEkx.setAlpha(1.0f);
        this.alEkx.setTranslationY(0.0f);
        this.alEkx.setScaleY(1.0f);
    }

    public final void niM(Boolean bool, String str) {
        this.mjFkc.post(new NPj(bool, str));
    }

    public final void o() {
        new Thread(new alEkx(), "jc-revoke-adb").start();
    }

    public final void o0(String str) {
        if (!com.jc.code.v3.mjFkc.vadzgd()) {
            d0();
        }
        com.jc.code.v3.mjFkc.vjlshU(str);
    }

    public final String ofUPN() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append("0123456789abcdef".charAt(random.nextInt(16)));
        }
        return sb.toString();
    }

    public final void olO() {
        if (FBR()) {
            aQ("\n[*] 系统能力检测...");
            StringBuilder sb = new StringBuilder();
            sb.append("═══ ZybosSysApiManager 方法检测 ═══\n\n");
            String[][] strArr = {new String[]{"isDisallowInstallPackage()", "安装是否被禁用"}, new String[]{"isSilentInstallDisallow()", "静默安装是否被禁用"}, new String[]{"isAdbEnabled()", "ADB 是否启用"}, new String[]{"isDisallowUSB()", "USB 是否被禁用"}, new String[]{"cancelUpdate()", "取消系统更新"}, new String[]{"silentInstallApk", "静默安装"}, new String[]{"silentUninstallApk", "静默卸载"}, new String[]{"setPackageListDisallow", "设置禁用列表"}};
            for (int i = 0; i < 8; i++) {
                String[] strArr2 = strArr[i];
                sb.append(CO(strArr2[0].replace("()", BuildConfig.FLAVOR), new Class[0]) != null ? "✓ " : "✗ ");
                sb.append(strArr2[0]);
                sb.append(" — ");
                sb.append(strArr2[1]);
                sb.append("\n");
            }
            this.mjFkc.post(new gtr(sb.toString()));
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 != -1 || intent == null) {
                aQ("[!] 用户拒绝屏幕读取授权");
                T("未授权屏幕读取", "非 Root 自动识别需要一次性屏幕读取授权（MediaProjection）。\n\n授权后仅在你点击「使用配对码配对设备」时截取屏幕识别配对码，识别完成或 90 秒后自动停止，不会保存截图。");
                DanUFX();
                return;
            }
            aQ("[+] 屏幕读取已授权，启动识别服务");
            Io();
            try {
                Intent intent2 = new Intent(this, (Class<?>) ScreenCaptureService.class);
                intent2.putExtra("resultCode", i2);
                intent2.putExtra("data", intent);
                startForegroundService(intent2);
            } catch (Exception e) {
                aQ("[!] 启动屏幕识别服务失败: " + e.getMessage());
            }
            this.mjFkc.postDelayed(new jY(), 700L);
            return;
        }
        if (i2 != -1 || intent == null) {
            return;
        }
        if (i == 1001) {
            Uri data2 = intent.getData();
            if (data2 != null) {
                dXmy(data2);
                return;
            }
            return;
        }
        if (i == 1002) {
            Uri data3 = intent.getData();
            if (data3 != null) {
                try {
                    getContentResolver().takePersistableUriPermission(data3, 1);
                } catch (Exception unused) {
                }
                getSharedPreferences("jc_code_prefs", 0).edit().putString("bg_uri", data3.toString()).apply();
                SrJcM(this.xJ);
                X("✓ 背景已设置");
                return;
            }
            return;
        }
        if (i == 1003) {
            Uri data4 = intent.getData();
            if (data4 != null) {
                Dc(data4);
                return;
            }
            return;
        }
        if (i != 1004 || (data = intent.getData()) == null) {
            return;
        }
        try {
            getContentResolver().takePersistableUriPermission(data, 1);
        } catch (Exception unused2) {
        }
        getSharedPreferences("jc_code_prefs", 0).edit().putString("search_bg_uri", data.toString()).apply();
        X("✓ 搜索页背景已设置");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.xrEuO;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.xrEuO.goBack();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        sRqPfw = this;
        UlIi();
        getWindow().getDecorView().setSystemUiVisibility(5894);
        setContentView(H4.mjFkc);
        this.Ne = SbhK();
        aQ("=== JC Code V3.0 · Material 3 ===");
        aQ("[*] ZYB 系统版本: " + F0() + " (解析值=" + this.Ne + ")");
        JQSH();
        com.jc.code.v3.mjFkc.XV(new KRckQg());
        q0();
        xM();
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("agreement_accepted_v1", false)) {
            this.jx = false;
            g0();
        } else {
            B();
        }
        MLqR();
        if (kgk()) {
            aQ("[!] 检测到高版本 " + F0() + "：zybos 绑定类功能（静默装/卸/清管控/取消更新）不可用");
            D0("绑定功能不可用", false);
        } else {
            this.mjFkc.postDelayed(new uxlM(), 300L);
        }
        DxPQMO(getIntent());
        ZxmHEb();
        Qns();
    }

    @Override // android.app.Activity
    public void onDestroy() throws IOException {
        super.onDestroy();
        if (sRqPfw == this) {
            sRqPfw = null;
        }
        if (this.lti) {
            this.lti = false;
            CBEvIj.JHa().diqgf();
            new Thread(new XtE(), "jc-devproxy-exit").start();
        }
        try {
            ServerSocket serverSocket = this.qGY;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        b();
        e();
        com.jc.code.v3.mjFkc.BAnRFn();
        ScreenCaptureService.setListener(null);
        try {
            stopService(new Intent(this, (Class<?>) ScreenCaptureService.class));
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        DxPQMO(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.LREOK && System.currentTimeMillis() - this.XFUzSY > 8000) {
            h0(true);
        }
        if (this.LREOK) {
            a(true);
        }
        CrDc(true);
    }

    public final void p() {
        new Thread(new tQ(), "jc-revoke-ow").start();
    }

    public final void p0(int i, boolean z) {
        LinearLayout linearLayout;
        View view;
        if (i < 0 || i >= this.Vnb.size()) {
            return;
        }
        if (z && i == this.NPj) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.3f, 0.0f, 0.8f, 0.15f);
        if (z && (view = ((gJsSk) this.Vnb.get(this.NPj)).lgHUyS) != null) {
            view.animate().cancel();
            view.animate().alpha(0.0f).translationX(-100.0f).setDuration(240L).setInterpolator(pathInterpolator2).start();
            view.setVisibility(8);
        }
        View view2 = ((gJsSk) this.Vnb.get(i)).lgHUyS;
        if (view2 != null) {
            view2.setVisibility(0);
            gJsSk gjssk = (gJsSk) this.Vnb.get(i);
            if (z) {
                view2.setAlpha(0.0f);
                view2.setTranslationX(140.0f);
                view2.animate().alpha(1.0f).translationX(0.0f).setDuration(460L).setInterpolator(pathInterpolator).start();
                View view3 = gjssk.ETF;
                if (view3 != null) {
                    view3.animate().cancel();
                    gjssk.ETF.setScaleX(0.0f);
                    gjssk.ETF.animate().scaleX(1.0f).setStartDelay(200L).setDuration(560L).setInterpolator(new OvershootInterpolator(0.9f)).start();
                }
                TextView textView = gjssk.qdMbNW;
                if (textView != null) {
                    textView.animate().cancel();
                    gjssk.qdMbNW.setTranslationY(10.0f);
                    gjssk.qdMbNW.animate().translationY(0.0f).setDuration(400L).setInterpolator(pathInterpolator).start();
                }
                TextView textView2 = gjssk.Dt;
                if (textView2 != null) {
                    textView2.animate().cancel();
                    gjssk.Dt.setAlpha(0.0f);
                    gjssk.Dt.animate().alpha(1.0f).setStartDelay(140L).setDuration(380L).start();
                }
                if (i == this.vadzgd && (linearLayout = this.WrLQs) != null) {
                    linearLayout.animate().cancel();
                    this.WrLQs.setScaleX(0.86f);
                    this.WrLQs.setScaleY(0.86f);
                    this.WrLQs.setAlpha(0.0f);
                    this.WrLQs.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setStartDelay(120L).setDuration(560L).setInterpolator(new OvershootInterpolator(0.7f)).start();
                }
                jwyZcq(gjssk, pathInterpolator);
            } else {
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                View view4 = gjssk.ETF;
                if (view4 != null) {
                    view4.setScaleX(1.0f);
                }
            }
        }
        this.NPj = i;
        B0(i);
    }

    public final void pCk(String str) {
        aQ("\n[?] 检测到可能为 APK 的下载请求: " + str);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("检测到下载请求").setMessage("该链接可能是 APK 应用包（无 .apk 后缀）：\n" + str + "\n\n是否尝试作为 APK 直链安装？").setPositiveButton("作为 APK 安装", new dkKKW(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final boolean pGB(byte[] bArr) {
        try {
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy");
            if (devicePolicyManager != null && devicePolicyManager.isDeviceOwnerApp(getPackageName())) {
                Object objInvoke = devicePolicyManager.getClass().getMethod("installCaCert", ComponentName.class, byte[].class).invoke(devicePolicyManager, new ComponentName(this, (Class<?>) JcDeviceAdminReceiver.class), bArr);
                aQ("[*] 设备所有者 installCaCert → " + objInvoke);
                return Boolean.TRUE.equals(objInvoke);
            }
            return false;
        } catch (Throwable th) {
            this.aQ("[!] 设备所有者 installCaCert: " + mYYU(th));
            return false;
        }
    }

    public final TextView pVOu(LinearLayout linearLayout, String str, boolean z, float f) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(18.0f);
        textView.setTextColor(z ? -2829100 : -15066598);
        textView.setGravity(17);
        int i = (int) (10.0f * f);
        int i2 = (int) (f * 6.0f);
        textView.setPadding(i, i2, i, i2);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -1));
        return textView;
    }

    public final void prww(String str, TextView textView, ScrollView scrollView) {
        if ("一键激活 Shizuku".equals(str)) {
            q("S1=/storage/emulated/0/Android/data/moe.shizuku.privileged.api/start.sh; S2=/storage/emulated/0/Android/data/moe.shizuku.privileged.api/files/start.sh; if [ -f \"$S1\" ]; then nohup sh \"$S1\" >/dev/null 2>&1 & echo 已通过 start.sh 启动 Shizuku; elif [ -f \"$S2\" ]; then nohup sh \"$S2\" >/dev/null 2>&1 & echo 已通过 start.sh 启动 Shizuku; else APK=$(pm path moe.shizuku.privileged.api | head -1 | sed 's/package://'); if [ -z \"$APK\" ]; then echo '✗ Shizuku 未安装'; else nohup sh -c \"CLASSPATH=$APK exec app_process /system/bin --nice-name=shizuku_server moe.shizuku.server.ShizukuStarter\" >/dev/null 2>&1 & echo \"Shizuku 启动中... (CLASSPATH=$APK)\"; fi; fi", textView, scrollView);
            return;
        }
        if ("查看设备信息".equals(str)) {
            q("echo \"型号: $(getprop ro.product.model)\"; echo \"Android $(getprop ro.build.version.release) (SDK $(getprop ro.build.version.sdk))\"; echo \"构建: $(getprop ro.build.display.id)\"; echo \"内存: $(head -1 /proc/meminfo)\"; echo \"存储: $(df -h /data | tail -1)\"; id", textView, scrollView);
            return;
        }
        if ("进程列表".equals(str)) {
            q("ps -A | head -30", textView, scrollView);
            return;
        }
        if ("冻结应用".equals(str)) {
            YRhJjQ("冻结应用", "输入要冻结的应用包名：停用并停止运行（应用数据保留），可随时解冻。", "冻结", new mByQ(textView, scrollView));
            return;
        }
        if ("解冻应用".equals(str)) {
            YRhJjQ("解冻应用", "输入要恢复的应用包名（之前被冻结的应用）。", "解冻", new OjSQV(textView, scrollView));
            return;
        }
        if ("清除应用数据".equals(str)) {
            YRhJjQ("清除应用数据", "输入应用包名（下一步会再确认一次）。", "下一步", new CqaNbM(textView, scrollView));
            return;
        }
        if ("重启设备".equals(str) || "重启到 Fastboot".equals(str) || "关机".equals(str)) {
            String str2 = "重启设备".equals(str) ? "reboot" : "重启到 Fastboot".equals(str) ? "reboot bootloader" : "reboot -p";
            U(new AlertDialog.Builder(this, S4.mjFkc).setTitle(str).setMessage("确定执行「" + str + "」？").setPositiveButton("执行", new xrEuO(str2, textView, scrollView, str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    public final void q(String str, TextView textView, ScrollView scrollView) {
        iEjzEW(textView, scrollView, "\n$ " + str + "\n", -8531040);
        new Thread(new KLMXS(str, textView, scrollView), "jc-term").start();
    }

    public final void q0() {
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        com.jc.code.v3.mjFkc.KLMXS(this, sharedPreferences.getBoolean("adb_pairing_verified", false) ? sharedPreferences.getString("adb_pairing_id", "jc_code_v3") : IRE());
    }

    public final View qMaC(xVYW xvyw) {
        float fMz = mz();
        boolean z = this.xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (12.0f * fMz);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(16.0f * fMz);
        gradientDrawable.setColor(z ? -13881549 : -526086);
        gradientDrawable.setStroke(Math.max(1, (int) fMz), z ? -12960446 : -1709843);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = (int) (40.0f * fMz);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(13.0f * fMz);
        int[] iArrW0 = w0(xvyw.ZfxDd, z);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrW0[0], iArrW0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(xvyw.wA);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(-1, mode);
        int i3 = (int) (22.0f * fMz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i3, i3, 17));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.rightMargin = (int) (14.0f * fMz);
        linearLayout.addView(frameLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setText(xvyw.mjFkc);
        textView.setTextSize(14.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(z ? -1842205 : -14737633);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(this);
        textView2.setText(xvyw.AZxh);
        textView2.setTextSize(11.5f);
        textView2.setTextColor(z ? -6643546 : -10525848);
        textView2.setPadding(0, (int) (2.0f * fMz), 0, 0);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(AbstractC1857s4.xJ);
        imageView2.setColorFilter(-6643546, mode);
        int i4 = (int) (fMz * 18.0f);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(i4, i4));
        return linearLayout;
    }

    public final void qbGbxJ(String[] strArr, AlertDialog alertDialog) {
        String str = strArr[1];
        String str2 = strArr[2];
        boolean zEquals = "1".equals(strArr[3]);
        if ("url".equals(str)) {
            bL(str2);
        } else if ("copy".equals(str)) {
            try {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("jc_popup", str2));
                X("✓ 已复制");
            } catch (Throwable unused) {
            }
        }
        if (!zEquals || alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Throwable unused2) {
        }
    }

    public final boolean qpjZLY() {
        try {
            if (Settings.Global.getInt(getContentResolver(), "adb_wifi_enabled", 0) == 1) {
                return true;
            }
        } catch (Exception unused) {
        }
        return getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_paired", false) || com.jc.code.v3.mjFkc.NPj();
    }

    public final View qqdo() {
        float fMz = mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (20.0f * fMz);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(24.0f * fMz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setColors(new int[]{-10589486, -13916000});
        linearLayout.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = (int) (fMz * 16.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVisibility(8);
        linearLayout.setAlpha(0.0f);
        this.alEkx = linearLayout;
        return linearLayout;
    }

    public final void r(boolean z) {
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("vuln_hint_never", z).apply();
    }

    public final int r0(String str) {
        return "一键激活 Shizuku".equals(str) ? AbstractC1857s4.Ucbh : "冻结应用".equals(str) ? AbstractC1857s4.HGpJ : "解冻应用".equals(str) ? AbstractC1857s4.mByQ : "清除应用数据".equals(str) ? AbstractC1857s4.BAnRFn : "查看设备信息".equals(str) ? AbstractC1857s4.ETF : "进程列表".equals(str) ? AbstractC1857s4.wA : "重启设备".equals(str) ? AbstractC1857s4.JHa : "重启到 Fastboot".equals(str) ? AbstractC1857s4.KLFTb : "命令列表".equals(str) ? AbstractC1857s4.diqgf : "查询设备所有者".equals(str) ? AbstractC1857s4.huTpC : "防卸载查询".equals(str) ? AbstractC1857s4.YoKzxo : "防卸载开".equals(str) ? AbstractC1857s4.wJVbdd : "防卸载关".equals(str) ? AbstractC1857s4.OjSQV : "安装CA证书".equals(str) ? AbstractC1857s4.xrEuO : "权限授予".equals(str) ? AbstractC1857s4.AZxh : "权限拒绝".equals(str) ? AbstractC1857s4.JHa : AbstractC1857s4.VocHEe;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[PHI: r1 r2
      0x002e: PHI (r1v14 java.lang.String) = (r1v22 java.lang.String), (r1v17 java.lang.String) binds: [B:22:0x004f, B:15:0x002c] A[DONT_GENERATE, DONT_INLINE]
      0x002e: PHI (r2v17 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v19 android.database.Cursor) binds: [B:22:0x004f, B:15:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String rB(Uri uri) throws Throwable {
        Cursor cursorQuery;
        StringBuilder sb;
        File file;
        int columnIndex;
        Cursor cursor = null;
        strSubstring = null;
        strSubstring = null;
        strSubstring = null;
        strSubstring = null;
        String strSubstring = null;
        try {
            cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_display_name")) >= 0) {
                            strSubstring = cursorQuery.getString(columnIndex);
                        }
                    } catch (Exception e) {
                        e = e;
                        aQ("[!] 获取文件名: " + e.getMessage());
                        if (cursorQuery != null) {
                        }
                        if (strSubstring != null) {
                            strSubstring = "install_" + System.currentTimeMillis() + ".apk";
                        }
                        aQ("[*] 文件名: " + strSubstring);
                        if (strSubstring.endsWith(".apk")) {
                        }
                        sb.append(strSubstring);
                        sb.append("_");
                        sb.append(System.currentTimeMillis());
                        sb.append(".apk");
                        String string = sb.toString();
                        file = new File("/storage/emulated/0/birchua_误删");
                        if (!file.exists()) {
                        }
                        if (file.canWrite()) {
                        }
                        return awnh(uri, new File(getCacheDir(), string));
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (strSubstring != null || strSubstring.isEmpty()) {
            strSubstring = "install_" + System.currentTimeMillis() + ".apk";
        }
        aQ("[*] 文件名: " + strSubstring);
        if (strSubstring.endsWith(".apk")) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            strSubstring = strSubstring.substring(0, strSubstring.length() - 4);
        }
        sb.append(strSubstring);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append(".apk");
        String string2 = sb.toString();
        file = new File("/storage/emulated/0/birchua_误删");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            aQ("[*] 公共目录不可写（缺存储权限），改用应用缓存目录");
        } else {
            String strAwnh = awnh(uri, new File(file, string2));
            if (strAwnh != null) {
                return strAwnh;
            }
        }
        return awnh(uri, new File(getCacheDir(), string2));
    }

    public final void rKxis() {
        if (!RV()) {
            A("阻止系统删应用");
            return;
        }
        boolean z = getSharedPreferences("jc_code_prefs", 0).getBoolean("padms_disabled", false);
        AlertDialog.Builder title = new AlertDialog.Builder(this, S4.mjFkc).setTitle(z ? "已停用 PadMS" : "阻止系统删应用");
        StringBuilder sb = new StringBuilder();
        sb.append("原理：系统内置的 PadMS 管控服务会按黑名单自动删除第三方应用，还会拦截安装、关闭 ADB。\n\n这里用 ADB 把它停用（pm disable-user），之后系统就不再删除第三方应用，安装也不会被拦。\n\n⚠ 注意：停用只在本次开机有效。系统每次开机时 PadMS 都会自动扫描并删除黑名单应用，重启 / 关机后保护即失效，重要资料请先备份。\n如需重启后依然不被删除，请用「系统管控 → 单独应用防卸载」（重启后仍然有效）。\n\n当前：");
        sb.append(z ? "已停用，可随时恢复。" : "运行中。");
        U(title.setMessage(sb.toString()).setPositiveButton(z ? "恢复" : "停用", new rWxwaT(z)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final boolean rdtF() {
        return Settings.canDrawOverlays(this);
    }

    public final void rtBEoQ() {
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("申请设备所有者").setMessage("流程说明（全自动，约 1 分钟）：\n\n1. 查询设备上的全部账号（ADB）\n2. 临时停用账号所属应用（账号数据保留）\n3. 激活设备所有者（dpm set-device-owner）\n4. 恢复刚才停用的账号应用\n\n成为设备所有者后可静默安装 CA 证书，\n「一键开开发者」即可全程自动化。\n\n⚠ 设备所有者拥有设备管理权限；账号应用会短暂消失、数据不受影响。").setPositiveButton("进入流程", new SwgkN()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final void s(String str) {
        String str2;
        for (PackageInfo packageInfo : getPackageManager().getInstalledPackages(0)) {
            String string = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            if (string.equalsIgnoreCase(str) || string.contains(str)) {
                str2 = packageInfo.packageName;
                break;
            }
        }
        str2 = null;
        if (str2 == null) {
            aQ("[!] 未找到应用: " + str);
            X("✗ 未找到应用: " + str);
            return;
        }
        aQ("[*] 找到: " + str + " -> " + str2);
        c0(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("正在卸载: ");
        sb.append(str);
        X(sb.toString());
    }

    public final void s0(String str) {
        this.mjFkc.post(new kism(str));
    }

    public final void sjsh(View view, AlertDialog alertDialog) {
        view.post(new JHa(view));
    }

    public final void t(String str, String str2, String str3, String str4) throws JSONException {
        aQ("\n[*] 发送 appstore 直链安装广播...");
        aQ("[*] URL: " + str);
        aQ("[*] 包名: " + str4);
        try {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 17; i++) {
                sb.append(random.nextInt(10));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("advertisement", 0);
            jSONObject.put("advertisementLabel", "无");
            jSONObject.put("age", 0);
            jSONObject.put("ageLabel", BuildConfig.FLAVOR);
            jSONObject.put("apkMd5", str2);
            jSONObject.put("apkName", str4);
            jSONObject.put("apkSize", 32767);
            jSONObject.put("apkSizeStr", "32767M");
            jSONObject.put("apkUrl", str);
            jSONObject.put("apkVersion", "32767");
            jSONObject.put("apkVersionCode", 32767);
            jSONObject.put("appIdThird", 32767);
            jSONObject.put("browseWeb", 0);
            jSONObject.put("browseWebLabel", "无");
            jSONObject.put("changeLog", "Crack By KON-唯");
            jSONObject.put("containPayContent", 1);
            jSONObject.put("developer", "Crack By KON-唯");
            jSONObject.put("enName", BuildConfig.FLAVOR);
            jSONObject.put("entertainment", 0);
            jSONObject.put("entertainmentLabel", "无");
            jSONObject.put("extraThird", Base64.encodeToString("JCCodeV3".getBytes(), 2));
            jSONObject.put("from", 1);
            jSONObject.put("icon", "https://www.birchua.cn/tb.png");
            jSONObject.put("icpNumber", "JC Code");
            jSONObject.put("id", random.nextInt(3000) + 1);
            jSONObject.put("isCtlWhite", 0);
            jSONObject.put("isGreenApp", 1);
            jSONObject.put("isMonitored", false);
            jSONObject.put("isSensitive", 0);
            jSONObject.put("name", str3);
            jSONObject.put("onShelf", 1);
            jSONObject.put("payContentLabel", BuildConfig.FLAVOR);
            Object obj = JSONObject.NULL;
            jSONObject.put("permissions", obj);
            jSONObject.put("previewPics", obj);
            jSONObject.put("privacyLink", "https://www.birchua.cn");
            jSONObject.put("remark", "Crack By KON-唯");
            jSONObject.put("remoteInstallMsg", "安装 " + str3 + " 中...（Crack By KON-唯）");
            jSONObject.put("risk", 0);
            jSONObject.put("statusInPad", 0);
            jSONObject.put("summary", "Crack By KON-唯");
            jSONObject.put("supervise", 1);
            jSONObject.put("tags", obj);
            jSONObject.put("type", 1);
            jSONObject.put("uploadTime", 32767L);
            jSONObject.put("versionCodeThird", 32767);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkg_name", "com.zuoyebang.iot.pad.appstore");
            jSONObject2.put("msg_id", sb.toString());
            jSONObject2.put("sub_type", 3);
            jSONObject2.put("type", 2);
            jSONObject2.put("data", jSONObject);
            Intent intent = new Intent("com.zuoyebang.iot.push");
            intent.setPackage("com.zuoyebang.iot.pad.appstore");
            intent.putExtra("response", jSONObject2.toString());
            intent.addFlags(268435456);
            sendBroadcast(intent);
            aQ("[+] 广播已发送 (msgId=" + ((Object) sb) + ")");
            aQ("[*] appstore 应开始下载并安装...");
        } catch (Exception e) {
            aQ("[!] " + e.getMessage());
        }
    }

    public final void t0() {
        LinearLayout linearLayout;
        boolean z = this.huTpC;
        this.huTpC = !z;
        TextView textView = this.diqgf;
        if (textView == null || (linearLayout = this.eyqo) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(8);
            this.diqgf.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.eyqo.setVisibility(0);
        }
    }

    public final void tyXzYJ(String str, String str2) {
        this.XtE = true;
        this.mjFkc.post(new KSf(str2, str));
    }

    public final void u(AlertDialog alertDialog, float f) {
        ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(R.id.content);
        View childAt = (viewGroup == null || viewGroup.getChildCount() <= 0) ? null : viewGroup.getChildAt(0);
        if (childAt != null) {
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                layoutParams.width = (int) (f * mz());
                childAt.setMinimumWidth(0);
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public final void u0() {
        boolean z = getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false);
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("hide_unavailable", !z).apply();
        qtZIjO qtzijo = this.uHVRx;
        if (qtzijo != null) {
            String str = !z ? "当前：开启 · 不可用按钮已自动隐藏" : "当前：关闭 · 开启后自动隐藏不可用按钮";
            qtzijo.AZxh = str;
            qtzijo.Dt = str;
            TextView textView = qtzijo.rkYL;
            if (textView != null) {
                textView.setText(str);
            }
        }
        CrDc(true);
        X(!z ? "✓ 不可用按钮已隐藏" : "✓ 不可用按钮已恢复显示");
    }

    public final void uube() {
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("⚠ 取消设备所有者").setMessage("将放弃设备管理权限（OW）：\n\n· 设备所有者相关的静默能力失效（如静默装证书）\n· 「一键开开发者」等功能将不可用\n\n需要时可在「申请设备所有者」重新激活。\n\n确定取消吗？").setPositiveButton("取消 OW", new dm()).setNegativeButton("返回", (DialogInterface.OnClickListener) null));
    }

    public final void v(boolean z) {
        String str = z ? "已停用 · 应用不会再被系统删除，点击恢复" : "停用 PadMS 管控 · 防止系统删除第三方应用";
        qtZIjO qtzijo = this.JYn;
        if (qtzijo != null) {
            qtzijo.AZxh = str;
            qtzijo.Dt = str;
        }
        qtZIjO qtzijo2 = this.JYgkl;
        if (qtzijo2 != null) {
            qtzijo2.AZxh = str;
            qtzijo2.Dt = str;
        }
    }

    public final void v0() throws IOException {
        TextView textView;
        this.xJ = !this.xJ;
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("night_mode", this.xJ).apply();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            View view = new View(this);
            view.setBackgroundColor(this.xJ ? -15724268 : -723207);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            SrJcM(this.xJ);
            view.animate().alpha(0.0f).setDuration(1200L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).withEndAction(new TvfBiy(view)).start();
        } else {
            SrJcM(this.xJ);
        }
        qtZIjO qtzijo = this.GMIER;
        if (qtzijo != null && (textView = qtzijo.rkYL) != null) {
            textView.setText(this.xJ ? "当前：夜间 · 点击切换日间" : "当前：日间 · 点击切换夜间");
            ImageView imageView = this.GMIER.qGY;
            if (imageView != null) {
                imageView.setImageResource(this.xJ ? AbstractC1857s4.HGpJ : AbstractC1857s4.mByQ);
                this.GMIER.qGY.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }
        }
        X(this.xJ ? "已切换到夜间模式" : "已切换到日间模式");
    }

    public final void vBFMCS() {
        this.mjFkc.post(new QyMqpM());
    }

    public final void vEiZJ(String str) {
        aQ("\n[!] 拦截到 APK 下载链接: " + str);
        U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("检测到 APK 下载").setMessage("拦截到 .apk 链接：\n" + str + "\n\n是否通过应用商店直链安装？").setPositiveButton("直链安装", new mPWV(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    public final void vL() {
        if (KbpP()) {
            I();
        } else {
            U(new AlertDialog.Builder(this, S4.mjFkc).setTitle("需要设备所有者").setMessage("单独应用防卸载需要本应用成为设备所有者（OW）。\n\n到「开发者工具 → 申请设备所有者」完成激活后，即可为任意应用单独上防卸载。").setPositiveButton("去申请", new qdMbNW()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    public final String vdbwS(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split("[,\\s;，；]+")) {
            String strTrim = str2.trim();
            if (strTrim.length() != 0) {
                try {
                    getPackageManager().getPackageInfo(strTrim, 0);
                    return strTrim;
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public final void w(String str, boolean z, CompoundButton compoundButton, TextView textView) {
        new Thread(new MiMN(str, z, compoundButton, textView), "jc-uninstall-guard").start();
    }

    public final String wfQA() {
        String string;
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        String string2 = sharedPreferences.getString("device_code", BuildConfig.FLAVOR);
        if (string2 != null && string2.length() > 0) {
            return string2;
        }
        String string3 = Settings.Secure.getString(getContentResolver(), "android_id");
        if (string3 == null || string3.length() == 0) {
            string3 = "jc-" + System.currentTimeMillis();
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest((string3 + "|jc-gate").getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder("JC-");
            for (int i = 0; i < 8; i++) {
                if (i == 4) {
                    sb.append('-');
                }
                sb.append("ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt((bArrDigest[i] & UByte.MAX_VALUE) % 32));
            }
            string = sb.toString();
        } catch (Throwable unused) {
            string = "JC-" + Integer.toHexString(string3.hashCode() | 268435456).toUpperCase();
        }
        sharedPreferences.edit().putString("device_code", string).apply();
        return string;
    }

    public final void wfW() {
        ViewGroup viewGroup;
        LinearLayout linearLayout = this.ANMGZc;
        if (linearLayout == null || (viewGroup = (ViewGroup) linearLayout.getParent()) == null) {
            return;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this.ANMGZc);
        LinearLayout linearLayout2 = this.ANMGZc;
        LinearLayout linearLayoutEey = Eey(false);
        this.ANMGZc = linearLayoutEey;
        try {
            viewGroup.removeView(linearLayout2);
            viewGroup.addView(linearLayoutEey, iIndexOfChild);
        } catch (Throwable unused) {
        }
    }

    public final void wsbqN() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            try {
                notificationManager.deleteNotificationChannel("jc_adb_pair_status");
            } catch (Exception unused) {
            }
            NotificationChannel notificationChannel = new NotificationChannel("jc_adb_pair_status_v2", "ADB 配对状态", 2);
            notificationChannel.setDescription("无线调试配对进度（静默）");
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        } catch (Exception unused2) {
        }
    }

    public final void x(View view, boolean z) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            editText.setTextColor(z ? -1842205 : -14737633);
            editText.setHintTextColor(z ? -6643546 : -12302522);
            editText.setTextSize(15.0f);
            float f = getResources().getDisplayMetrics().density;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(14.0f * f);
            gradientDrawable.setColor(z ? -13618634 : -985863);
            editText.setBackground(gradientDrawable);
            int i = (int) (16.0f * f);
            int i2 = (int) (f * 12.0f);
            editText.setPadding(i, i2, i, i2);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                x(viewGroup.getChildAt(i3), z);
            }
        }
    }

    public final boolean x0(String str, Class[] clsArr, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method methodCO = CO(str, clsArr);
            if (methodCO == null) {
                aQ("[!] " + str + " not found");
                return false;
            }
            methodCO.invoke(this.lgHUyS, objArr);
            aQ("[+] " + str + " OK");
            return true;
        } catch (Exception e) {
            aQ("[!] " + str + ": " + e.getMessage());
            return false;
        }
    }

    public final void xIpq(Dialog dialog) {
        try {
            WebView webView = this.xrEuO;
            if (webView != null) {
                webView.stopLoading();
                this.xrEuO.setWebViewClient(null);
                this.xrEuO.setDownloadListener(null);
                this.xrEuO.removeAllViews();
                this.xrEuO.destroy();
                this.xrEuO = null;
                this.rWxwaT = null;
            }
        } catch (Exception unused) {
        }
        try {
            dialog.dismiss();
        } catch (Exception unused2) {
        }
    }

    public final void xM() {
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            new Thread(new xCVa()).start();
        }
    }

    public final void y(View view, Runnable runnable) {
        if (view != null) {
            view.setOnTouchListener(new aDq(mz()));
            view.setOnClickListener(new vZ(runnable));
        }
    }

    public final void y0() {
        Bitmap bitmap = this.kism;
        if (bitmap == null) {
            return;
        }
        if (this.gtIJp != null || this.NKyg <= 0) {
            this.kism = null;
            bitmap.recycle();
            return;
        }
        if (this.tjSezt) {
            try {
                this.kism = null;
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
                if (viewGroup == null) {
                    bitmap.recycle();
                    return;
                }
                ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageBitmap(bitmap);
                imageView.setAlpha(0.0f);
                viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                imageView.animate().alpha(1.0f).setDuration(320L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
                this.gtIJp = imageView;
            } catch (Exception unused) {
            }
        }
    }

    public final File yRYQP(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(120000);
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    fileOutputStream.close();
                    inputStream.close();
                    aQ("[+] 下载完成: " + (j / 1024) + "KB");
                    return new File(str2);
                }
                fileOutputStream.write(bArr, 0, i);
                j += i;
            }
        } catch (Throwable th) {
            aQ("[!] 下载失败: " + mYYU(th));
            return null;
        }
    }

    public final boolean z(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("https://https://") || lowerCase.contains("http://http://") || lowerCase.contains("//xn--https-") || lowerCase.contains("//xn--http-")) {
            return true;
        }
        return lowerCase.contains("action=sendintent") || lowerCase.contains("mybaiduboxapp") || lowerCase.contains("baiduboxapp://");
    }

    public final boolean z0(String str) throws InterruptedException {
        Ipwl();
        if (!RV()) {
            return false;
        }
        aQ("[*] 使用无线调试 ADB 卸载: " + str);
        try {
            com.jc.code.v3.mjFkc.Moer(str);
            if (!E0(str, 5000L, false)) {
                aQ("[!] ADB 返回 Success，但包仍可见（可能是系统包或其他用户）");
                Y("✓ ADB 卸载已执行: " + str);
                return true;
            }
            aQ("[+] ADB 卸载成功: " + str);
            Y("✓ ADB 卸载成功: " + str);
            return true;
        } catch (Throwable th) {
            aQ("[!] ADB 卸载失败: " + mYYU(th) + "，尝试其他通道");
            PvPg(th);
            return false;
        }
    }

    public final void zZ() {
        View view;
        int i = this.NKyg;
        this.NKyg = i + 1;
        if (i <= 0 && (view = this.KLFTb) != null) {
            view.animate().cancel();
            if (Build.VERSION.SDK_INT >= 31) {
                float f = getResources().getDisplayMetrics().density * 14.0f;
                view.setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP));
            } else {
                if (E(view)) {
                    return;
                }
                view.animate().alpha(0.7f).setDuration(320L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
            }
        }
    }

    public final TextView zabxk(String str, int i) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        float fMz = mz();
        int i2 = (int) (12.0f * fMz);
        textView.setPadding(0, i2, 0, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setColor(this.xJ ? -14408151 : -985863);
        if (this.xJ) {
            gradientDrawable.setStroke(Math.max(1, (int) fMz), -12960446);
        }
        textView.setBackground(gradientDrawable);
        textView.setTextColor(this.xJ ? -5919253 : -10589486);
        return textView;
    }

    public final void zo() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 1004);
        } catch (Exception unused) {
            X("未找到图片选择器");
        }
    }

    public final void zpm() {
        aQ("\n[*] 设备信息扫描...");
        new Thread(new IVlxe(new StringBuilder())).start();
    }

    public class hvGY extends WebViewClient {
        public hvGY() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (MainActivity.this.KLMXS != null) {
                MainActivity.this.KLMXS.setText(str);
            }
            MainActivity.this.rWxwaT = str;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str == null || !MainActivity.this.z(str)) {
                return super.shouldInterceptRequest(webView, str);
            }
            MainActivity.this.aQ("[!] 拦截请求: " + str);
            return new WebResourceResponse("text/plain", "UTF-8", null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return MainActivity.this.XDcuxS(webView, webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return MainActivity.this.XDcuxS(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
            if (string != null && MainActivity.this.z(string)) {
                MainActivity.this.aQ("[!] 拦截请求: " + string);
                return new WebResourceResponse("text/plain", "UTF-8", null);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public static class gJsSk {
        public String AZxh;
        public TextView Dt;
        public View ETF;
        public ImageView JHa;
        public LinearLayout KLFTb;
        public List MiMN;
        public H1 VA;
        public List ZfxDd;
        public View lgHUyS;
        public String mjFkc;
        public TextView qdMbNW;
        public int wA;
        public TextView xJ;

        public gJsSk() {
            this.ZfxDd = new ArrayList();
            this.MiMN = new ArrayList();
        }

        public /* synthetic */ gJsSk(KRckQg kRckQg) {
            this();
        }
    }

    public static class ih {
        public String AZxh;
        public int Dt;
        public boolean JHa;
        public String KLFTb;
        public String ZfxDd;
        public int lgHUyS;
        public String mjFkc;
        public int qdMbNW;
        public String wA;
        public int xJ;

        public ih() {
            this.mjFkc = BuildConfig.FLAVOR;
            this.AZxh = BuildConfig.FLAVOR;
            this.wA = BuildConfig.FLAVOR;
            this.ZfxDd = BuildConfig.FLAVOR;
            this.KLFTb = BuildConfig.FLAVOR;
            this.JHa = false;
            this.xJ = 0;
            this.lgHUyS = 0;
            this.qdMbNW = 0;
            this.Dt = 0;
        }

        public /* synthetic */ ih(KRckQg kRckQg) {
            this();
        }
    }
}
