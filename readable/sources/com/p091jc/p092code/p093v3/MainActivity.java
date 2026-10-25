package com.p091jc.p092code.p093v3;

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
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.jc.code.v3.AdbConnectionManager;
import com.p038google.p039android.material.snackbar.Snackbar;
import com.p091jc.p092code.p093v3.ScreenCaptureService;
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
import o.CloudGateClient;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.p370lsposed.hiddenapibypass.HiddenApiBypass;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p094kotlin.C1126UByte;
import p094kotlin.p119time.DurationKt;
import p131o.AbstractC1803D4;
import p131o.AbstractC1865E4;
import p131o.AbstractC2071H4;
import p131o.AbstractC2208J4;
import p131o.AbstractC2803S4;
import p131o.AbstractC4524s4;
import p131o.AbstractC4658u4;
import p131o.AbstractC4735vEiZJ;
import p131o.C1742CBEvIj;
import p131o.C2068H1;

/* loaded from: classes.dex */
public class MainActivity extends Activity {

    /* renamed from: sRqPfw */
    public static MainActivity f4215sRqPfw;

    /* renamed from: ANMGZc */
    public LinearLayout f4216ANMGZc;

    /* renamed from: AZxh */
    public TextView f4217AZxh;

    /* renamed from: BAnRFn */
    public float f4218BAnRFn;

    /* renamed from: GMIER */
    public C1071qtZIjO f4222GMIER;

    /* renamed from: IEE */
    public WindowManager f4225IEE;

    /* renamed from: IVlxe */
    public String f4226IVlxe;

    /* renamed from: JHa */
    public View f4228JHa;

    /* renamed from: JYgkl */
    public C1071qtZIjO f4229JYgkl;

    /* renamed from: JYn */
    public C1071qtZIjO f4230JYn;

    /* renamed from: KLFTb */
    public View f4232KLFTb;

    /* renamed from: KLMXS */
    public EditText f4233KLMXS;

    /* renamed from: KRTLGT */
    public TextView f4234KRTLGT;

    /* renamed from: Moer */
    public String f4237Moer;

    /* renamed from: Pq */
    public View f4242Pq;

    /* renamed from: SwgkN */
    public LinearLayout f4246SwgkN;

    /* renamed from: Ucbh */
    public ProgressBar f4247Ucbh;

    /* renamed from: VA */
    public View f4248VA;

    /* renamed from: VocHEe */
    public float f4252VocHEe;

    /* renamed from: WGXroI */
    public ObjectAnimator f4253WGXroI;

    /* renamed from: WrLQs */
    public LinearLayout f4254WrLQs;

    /* renamed from: XV */
    public LinearLayout f4256XV;

    /* renamed from: XbiWeM */
    public Intent f4257XbiWeM;

    /* renamed from: YoKzxo */
    public TextView f4259YoKzxo;

    /* renamed from: ZfxDd */
    public TextView f4260ZfxDd;

    /* renamed from: alEkx */
    public LinearLayout f4261alEkx;

    /* renamed from: aqHPIZ */
    public LinearLayout f4262aqHPIZ;

    /* renamed from: bbzow */
    public TextView f4263bbzow;

    /* renamed from: cMLeY */
    public View f4264cMLeY;

    /* renamed from: diqgf */
    public TextView f4265diqgf;

    /* renamed from: eyqo */
    public LinearLayout f4267eyqo;

    /* renamed from: fFz */
    public View f4268fFz;

    /* renamed from: fehf */
    public ProgressDialog f4269fehf;

    /* renamed from: gYa */
    public ObjectAnimator f4270gYa;

    /* renamed from: gtIJp */
    public ImageView f4272gtIJp;

    /* renamed from: kism */
    public Bitmap f4276kism;

    /* renamed from: lB */
    public float f4277lB;

    /* renamed from: lgHUyS */
    public Object f4278lgHUyS;

    /* renamed from: oCFDzJ */
    public LinearLayout f4283oCFDzJ;

    /* renamed from: qGY */
    public ServerSocket f4284qGY;

    /* renamed from: qdMbNW */
    public Class f4285qdMbNW;

    /* renamed from: rWxwaT */
    public volatile String f4286rWxwaT;

    /* renamed from: rkYL */
    public ScrollView f4287rkYL;

    /* renamed from: tjSezt */
    public boolean f4290tjSezt;

    /* renamed from: uH */
    public View f4291uH;

    /* renamed from: uHVRx */
    public C1071qtZIjO f4292uHVRx;

    /* renamed from: vI */
    public float f4293vI;

    /* renamed from: vjlshU */
    public View f4295vjlshU;

    /* renamed from: wA */
    public TextView f4296wA;

    /* renamed from: xROA */
    public String f4299xROA;

    /* renamed from: xrEuO */
    public WebView f4300xrEuO;

    /* renamed from: yX */
    public ImageView f4301yX;

    /* renamed from: zvd */
    public View f4303zvd;

    /* renamed from: XD */
    public static final Pattern f4213XD = Pattern.compile("\\[(\\d+),(\\d+)\\]\\[(\\d+),(\\d+)\\]");

    /* renamed from: gtr */
    public static final Pattern f4214gtr = Pattern.compile("(\\d{1,3}(?:\\.\\d{1,3}){3})(?::(\\d{2,5}))?");

    /* renamed from: Dp */
    public static final Pattern f4212Dp = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)");

    /* renamed from: mjFkc */
    public final Handler f4281mjFkc = new Handler(Looper.getMainLooper());

    /* renamed from: xJ */
    public boolean f4298xJ = true;

    /* renamed from: Dt */
    public boolean f4220Dt = false;

    /* renamed from: ETF */
    public File f4221ETF = null;

    /* renamed from: MiMN */
    public StringBuilder f4236MiMN = new StringBuilder();

    /* renamed from: huTpC */
    public boolean f4273huTpC = false;

    /* renamed from: Gd */
    public int f4223Gd = -1;

    /* renamed from: HGpJ */
    public int f4224HGpJ = -1;

    /* renamed from: wJVbdd */
    public boolean f4297wJVbdd = false;

    /* renamed from: mByQ */
    public volatile boolean f4280mByQ = false;

    /* renamed from: OjSQV */
    public Method f4241OjSQV = null;

    /* renamed from: Ne */
    public int f4240Ne = 0;

    /* renamed from: CqaNbM */
    public String f4219CqaNbM = BuildConfig.f24315FLAVOR;

    /* renamed from: Vnb */
    public final List f4251Vnb = new ArrayList();

    /* renamed from: NPj */
    public int f4239NPj = 0;

    /* renamed from: vadzgd */
    public int f4294vadzgd = 4;

    /* renamed from: JrJO */
    public String f4231JrJO = "正在连接...";

    /* renamed from: nxI */
    public Boolean f4282nxI = null;

    /* renamed from: JBhc */
    public volatile String f4227JBhc = "检测中...";

    /* renamed from: Vdz */
    public volatile boolean f4249Vdz = false;

    /* renamed from: jm */
    public volatile boolean f4274jm = false;

    /* renamed from: dm */
    public boolean f4266dm = false;

    /* renamed from: tQ */
    public volatile boolean f4289tQ = false;

    /* renamed from: yfx */
    public volatile boolean f4302yfx = false;

    /* renamed from: SmIWf */
    public long f4245SmIWf = 0;

    /* renamed from: SOS */
    public long f4244SOS = 0;

    /* renamed from: Qr */
    public boolean f4243Qr = false;

    /* renamed from: NKyg */
    public int f4238NKyg = 0;

    /* renamed from: LREOK */
    public volatile boolean f4235LREOK = false;

    /* renamed from: XFUzSY */
    public long f4255XFUzSY = 0;

    /* renamed from: XtE */
    public volatile boolean f4258XtE = false;

    /* renamed from: jx */
    public volatile boolean f4275jx = true;

    /* renamed from: tISON */
    public String f4288tISON = BuildConfig.f24315FLAVOR;

    /* renamed from: Vgyli */
    public final Runnable f4250Vgyli = new RunnableC1019bc();

    /* renamed from: lti */
    public boolean f4279lti = false;

    /* renamed from: giT */
    public boolean f4271giT = false;

    /* renamed from: com.jc.code.v3.MainActivity$ANMGZc */
    public class DialogInterfaceOnClickListenerC0909ANMGZc implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0909ANMGZc() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4812o();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$APn */
    public class RunnableC0910APn implements Runnable {
        public RunnableC0910APn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4708R();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$AZxh */
    public class RunnableC0911AZxh implements Runnable {
        public RunnableC0911AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4703Q();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ArO */
    public class ViewOnClickListenerC0912ArO implements View.OnClickListener {
        public ViewOnClickListenerC0912ArO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.f4236MiMN.setLength(0);
            if (MainActivity.this.f4259YoKzxo != null) {
                MainActivity.this.f4259YoKzxo.setText(BuildConfig.f24315FLAVOR);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$BABY */
    public class RunnableC0913BABY implements Runnable {
        public RunnableC0913BABY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4698OGo();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$BAnRFn */
    public class C0914BAnRFn implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4309AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4310mjFkc;

        public C0914BAnRFn(TextView textView, ScrollView scrollView) {
            this.f4310mjFkc = textView;
            this.f4309AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4801m("install-ca-cert " + str, this.f4310mjFkc, this.f4309AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$BxruE */
    public class ViewOnClickListenerC0915BxruE implements View.OnClickListener {
        public ViewOnClickListenerC0915BxruE() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            MainActivity.this.m4844v0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$CTcA */
    public class RunnableC0916CTcA implements Runnable {
        public RunnableC0916CTcA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4842uube();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$CcoH */
    public class ViewOnClickListenerC0917CcoH implements View.OnClickListener {
        public ViewOnClickListenerC0917CcoH() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.m4697O();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$CqAnRZ */
    public class RunnableC0918CqAnRZ implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ Uri f4316mjFkc;

        public RunnableC0918CqAnRZ(Uri uri) {
            this.f4316mjFkc = uri;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            MainActivity.this.m4764dXmy(this.f4316mjFkc);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$CqaNbM */
    public class C0919CqaNbM implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4317AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4318mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$CqaNbM$mjFkc */
        public class mjFkc implements DialogInterface.OnClickListener {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4321mjFkc;

            public mjFkc(String str) {
                this.f4321mjFkc = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = MainActivity.this;
                String str = "pm clear " + this.f4321mjFkc;
                C0919CqaNbM c0919CqaNbM = C0919CqaNbM.this;
                mainActivity.m4822q(str, c0919CqaNbM.f4318mjFkc, c0919CqaNbM.f4317AZxh);
            }
        }

        public C0919CqaNbM(TextView textView, ScrollView scrollView) {
            this.f4318mjFkc = textView;
            this.f4317AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4720U(new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setTitle("⚠ 清除应用数据").setMessage("将清除 " + str + " 的全部数据（账号、聊天记录、设置等都会丢失，且不可恢复）。\n\n确定继续？").setPositiveButton("清除", new mjFkc(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Dp */
    public class ServiceConnectionC0920Dp implements ServiceConnection {
        public ServiceConnectionC0920Dp() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Dt */
    public class RunnableC0921Dt implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ Map f4323AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ LinearLayout f4325mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ EditText f4326wA;

        /* renamed from: com.jc.code.v3.MainActivity$Dt$AZxh */
        public class AZxh implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ boolean f4327AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ List f4329mjFkc;

            /* renamed from: wA */
            public final /* synthetic */ Map f4330wA;

            /* renamed from: com.jc.code.v3.MainActivity$Dt$AZxh$AZxh, reason: collision with other inner class name */
            public class C6350AZxh implements CompoundButton.OnCheckedChangeListener {

                /* renamed from: AZxh */
                public final /* synthetic */ TextView f4331AZxh;

                /* renamed from: mjFkc */
                public final /* synthetic */ String f4332mjFkc;

                public C6350AZxh(String str, TextView textView) {
                    this.f4332mjFkc = str;
                    this.f4331AZxh = textView;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (Boolean.TRUE.equals(compoundButton.getTag())) {
                        return;
                    }
                    MainActivity.this.m4849w(this.f4332mjFkc, z, compoundButton, this.f4331AZxh);
                }
            }

            /* renamed from: com.jc.code.v3.MainActivity$Dt$AZxh$mjFkc */
            public class mjFkc implements View.OnClickListener {

                /* renamed from: mjFkc */
                public final /* synthetic */ CheckBox f4335mjFkc;

                public mjFkc(CheckBox checkBox) {
                    this.f4335mjFkc = checkBox;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f4335mjFkc.setChecked(!r0.isChecked());
                }
            }

            /* renamed from: com.jc.code.v3.MainActivity$Dt$AZxh$wA */
            public class wA implements TextWatcher {
                public wA() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String strTrim = editable.toString().toLowerCase().trim();
                    Iterator it = RunnableC0921Dt.this.f4323AZxh.entrySet().iterator();
                    while (it.hasNext()) {
                        View view = (View) ((Map.Entry) it.next()).getValue();
                        view.setVisibility((strTrim.isEmpty() || ((TextView) view.findViewById(AbstractC4658u4.f16789fehf)).getText().toString().toLowerCase().contains(strTrim) || ((TextView) view.findViewById(AbstractC4658u4.f16787diqgf)).getText().toString().toLowerCase().contains(strTrim)) ? 0 : 8);
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
                this.f4329mjFkc = list;
                this.f4327AZxh = z;
                this.f4330wA = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0921Dt.this.f4325mjFkc.removeAllViews();
                for (PackageInfo packageInfo : this.f4329mjFkc) {
                    String string = packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString();
                    String str = packageInfo.packageName;
                    View viewInflate = LayoutInflater.from(MainActivity.this).inflate(AbstractC2071H4.f8529ZfxDd, (ViewGroup) null);
                    ImageView imageView = (ImageView) viewInflate.findViewById(AbstractC4658u4.f16794qdMbNW);
                    TextView textView = (TextView) viewInflate.findViewById(AbstractC4658u4.f16789fehf);
                    TextView textView2 = (TextView) viewInflate.findViewById(AbstractC4658u4.f16787diqgf);
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(AbstractC4658u4.f16780KLFTb);
                    imageView.setImageDrawable(packageInfo.applicationInfo.loadIcon(MainActivity.this.getPackageManager()));
                    textView.setText(string);
                    textView.setTextColor(this.f4327AZxh ? -419430401 : -15066598);
                    boolean z = this.f4330wA.containsKey(str) && ((Boolean) this.f4330wA.get(str)).booleanValue();
                    textView2.setText(str);
                    textView2.setTextColor(z ? -15171528 : this.f4327AZxh ? -1711276033 : -1728053248);
                    checkBox.setChecked(z);
                    viewInflate.setOnClickListener(new mjFkc(checkBox));
                    checkBox.setOnCheckedChangeListener(new C6350AZxh(str, textView2));
                    RunnableC0921Dt.this.f4325mjFkc.addView(viewInflate);
                    RunnableC0921Dt.this.f4323AZxh.put(str, viewInflate);
                }
                RunnableC0921Dt.this.f4326wA.addTextChangedListener(new wA());
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$Dt$mjFkc */
        public class mjFkc implements Comparator {
            public mjFkc() {
            }

            @Override // java.util.Comparator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
                return packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString().compareToIgnoreCase(packageInfo2.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString());
            }
        }

        public RunnableC0921Dt(LinearLayout linearLayout, Map map, EditText editText) {
            this.f4325mjFkc = linearLayout;
            this.f4323AZxh = map;
            this.f4326wA = editText;
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
            MainActivity.this.runOnUiThread(new AZxh(arrayList, MainActivity.this.f4298xJ, linkedHashMap));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ERt */
    public class RunnableC0922ERt implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f4339mjFkc;

        public RunnableC0922ERt(View view) {
            this.f4339mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((ViewGroup) MainActivity.this.getWindow().getDecorView()).removeView(this.f4339mjFkc);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ETF */
    public class RunnableC0923ETF implements Runnable {
        public RunnableC0923ETF() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.m4803mL();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$EeoThB */
    public class RunnableC0924EeoThB implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ GradientDrawable f4341AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ View f4343mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ int f4344wA;

        public RunnableC0924EeoThB(View view, GradientDrawable gradientDrawable, int i) {
            this.f4343mjFkc = view;
            this.f4341AZxh = gradientDrawable;
            this.f4344wA = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4343mjFkc.setBackground(this.f4341AZxh);
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(this.f4343mjFkc);
                while (!arrayDeque.isEmpty()) {
                    View view = (View) arrayDeque.poll();
                    if (view != this.f4343mjFkc) {
                        view.setBackground(this.f4341AZxh);
                    }
                    if (view instanceof TextView) {
                        try {
                            if (((TextView) view).getId() != AbstractC1803D4.f7815mByQ) {
                                ((TextView) view).setTextColor(this.f4344wA);
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

    /* renamed from: com.jc.code.v3.MainActivity$EoC */
    public class ViewOnClickListenerC0925EoC implements View.OnClickListener {
        public ViewOnClickListenerC0925EoC() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            MainActivity.this.m4844v0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Es */
    public class RunnableC0926Es implements Runnable {
        public RunnableC0926Es() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4700P();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$FOJ */
    public class RunnableC0927FOJ implements Runnable {
        public RunnableC0927FOJ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4689M();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$FbxKQm */
    public class ViewOnClickListenerC0928FbxKQm implements View.OnClickListener {
        public ViewOnClickListenerC0928FbxKQm() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.f4300xrEuO.reload();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Fztqa */
    public class RunnableC0929Fztqa implements Runnable {
        public RunnableC0929Fztqa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("mail", "aono_saki@outlook.com"));
            MainActivity.this.m4733X("邮箱已复制");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$GMIER */
    public class DialogInterfaceOnClickListenerC0930GMIER implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ CheckBox f4351mjFkc;

        public DialogInterfaceOnClickListenerC0930GMIER(CheckBox checkBox) {
            this.f4351mjFkc = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4828r(this.f4351mjFkc.isChecked());
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Gd */
    public class C0931Gd implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4352AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4353mjFkc;

        public C0931Gd(TextView textView, ScrollView scrollView) {
            this.f4353mjFkc = textView;
            this.f4352AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4801m("is-uninstall-blocked " + str, this.f4353mjFkc, this.f4352AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$HExgdj */
    public class RunnableC0932HExgdj implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ boolean f4355AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ String f4357ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4358mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ String f4359wA;

        /* renamed from: com.jc.code.v3.MainActivity$HExgdj$AZxh */
        public class AZxh implements DialogInterface.OnClickListener {
            public AZxh() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$HExgdj$mjFkc */
        public class mjFkc implements DialogInterface.OnClickListener {
            public mjFkc() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC0932HExgdj runnableC0932HExgdj = RunnableC0932HExgdj.this;
                MainActivity.this.m4755bL(runnableC0932HExgdj.f4357ZfxDd);
            }
        }

        public RunnableC0932HExgdj(String str, boolean z, String str2, String str3) {
            this.f4358mjFkc = str;
            this.f4355AZxh = z;
            this.f4359wA = str2;
            this.f4357ZfxDd = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str3 = this.f4358mjFkc;
            if (str3 == null || str3.length() <= 0) {
                str = BuildConfig.f24315FLAVOR;
            } else {
                str = this.f4358mjFkc + "\n\n";
            }
            sb.append(str);
            if (this.f4355AZxh) {
                str2 = "当前版本 3.2.6 已停止支持，必须更新到 " + this.f4359wA + " 及以上才能继续使用。";
            } else {
                str2 = "当前版本 3.2.6，最新版本 " + this.f4359wA + "。";
            }
            sb.append(str2);
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setTitle(this.f4355AZxh ? "必须更新" : "发现新版本").setMessage(sb.toString()).setPositiveButton("立即更新", new mjFkc());
            if (this.f4355AZxh) {
                positiveButton.setNegativeButton("退出", new AZxh());
            } else {
                positiveButton.setNegativeButton("稍后再说", (DialogInterface.OnClickListener) null);
            }
            AlertDialog alertDialogM4720U = MainActivity.this.m4720U(positiveButton);
            MainActivity.this.m4840u(alertDialogM4720U, 540.0f);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.m4799l0(alertDialogM4720U, -13916000, mainActivity.f4298xJ ? -6643546 : -10525848);
            if (this.f4355AZxh) {
                MainActivity.this.m4727UokA(alertDialogM4720U);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$HGpJ */
    public class C0933HGpJ implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4362AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4363mjFkc;

        public C0933HGpJ(TextView textView, ScrollView scrollView) {
            this.f4363mjFkc = textView;
            this.f4362AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4801m("set-uninstall-blocked " + str + " true", this.f4363mjFkc, this.f4362AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$HX */
    public class RunnableC0934HX implements Runnable {
        public RunnableC0934HX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4701PX();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Hk */
    public class RunnableC0935Hk implements Runnable {
        public RunnableC0935Hk() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("search_bg_scale", "center").apply();
            MainActivity.this.m4864zo();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Htq */
    public class ViewOnClickListenerC0936Htq implements View.OnClickListener {
        public ViewOnClickListenerC0936Htq() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.m4697O();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$IEE */
    public class ViewOnClickListenerC0937IEE implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4369mjFkc;

        public ViewOnClickListenerC0937IEE(TextView textView) {
            this.f4369mjFkc = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4369mjFkc.setText("JC 终端就绪 · 命令经 ADB 通道执行（shell 权限）\n");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$IPpyV */
    public class ViewOnClickListenerC0938IPpyV implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4371mjFkc;

        public ViewOnClickListenerC0938IPpyV(AlertDialog alertDialog) {
            this.f4371mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4371mjFkc.dismiss();
            MainActivity.this.m4775gb();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$IVlxe */
    public class RunnableC0939IVlxe implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ StringBuilder f4373mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$IVlxe$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4375mjFkc;

            public mjFkc(String str) {
                this.f4375mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4718T("设备信息", this.f4375mjFkc);
            }
        }

        public RunnableC0939IVlxe(StringBuilder sb) {
            this.f4373mjFkc = sb;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException, PackageManager.NameNotFoundException, IOException {
            this.f4373mjFkc.append("═══ 设备基本信息 ═══\n");
            StringBuilder sb = this.f4373mjFkc;
            sb.append("型号: ");
            sb.append(Build.MODEL);
            sb.append("\n");
            StringBuilder sb2 = this.f4373mjFkc;
            sb2.append("品牌: ");
            sb2.append(Build.BRAND);
            sb2.append("\n");
            StringBuilder sb3 = this.f4373mjFkc;
            sb3.append("系统: Android ");
            sb3.append(Build.VERSION.RELEASE);
            sb3.append(" (API ");
            sb3.append(Build.VERSION.SDK_INT);
            sb3.append(")\n");
            StringBuilder sb4 = this.f4373mjFkc;
            sb4.append("安全补丁: ");
            sb4.append(Build.VERSION.SECURITY_PATCH);
            sb4.append("\n");
            StringBuilder sb5 = this.f4373mjFkc;
            sb5.append("序列号: ");
            sb5.append(Build.SERIAL);
            sb5.append("\n");
            String str = Build.FINGERPRINT;
            StringBuilder sb6 = this.f4373mjFkc;
            sb6.append("指纹: ");
            if (str.length() > 60) {
                str = str.substring(0, 60) + "...";
            }
            sb6.append(str);
            sb6.append("\n");
            this.f4373mjFkc.append("\n═══ ZYB 环境 ═══\n");
            try {
                Process processExec = Runtime.getRuntime().exec(new String[]{"getprop", "persist.sys.env_config"});
                String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
                processExec.waitFor();
                StringBuilder sb7 = this.f4373mjFkc;
                sb7.append("环境配置: ");
                if (line == null) {
                    line = "未设置";
                }
                sb7.append(line);
                sb7.append("\n");
            } catch (Exception unused) {
                this.f4373mjFkc.append("环境配置: 读取失败\n");
            }
            this.f4373mjFkc.append("\n═══ ADB 状态 ═══\n");
            String[] strArr = {"adb_enabled", "adb_wifi_enabled", "development_settings_enabled"};
            for (int i = 0; i < 3; i++) {
                String str2 = strArr[i];
                try {
                    Process processExec2 = Runtime.getRuntime().exec(new String[]{"settings", "get", "global", str2});
                    String line2 = new BufferedReader(new InputStreamReader(processExec2.getInputStream())).readLine();
                    processExec2.waitFor();
                    StringBuilder sb8 = this.f4373mjFkc;
                    sb8.append(str2);
                    sb8.append(" = ");
                    sb8.append(line2 != null ? line2.trim() : "?");
                    sb8.append("\n");
                } catch (Exception unused2) {
                    StringBuilder sb9 = this.f4373mjFkc;
                    sb9.append(str2);
                    sb9.append(" = 读取失败\n");
                }
            }
            this.f4373mjFkc.append("\n═══ 设备标识 ═══\n");
            try {
                Cursor cursorQuery = MainActivity.this.getContentResolver().query(Uri.parse("content://com.zuoyebang.iot.oaid"), null, null, null, null);
                if (cursorQuery != null) {
                    this.f4373mjFkc.append("OAID: ");
                    if (cursorQuery.moveToFirst()) {
                        for (int i2 = 0; i2 < Math.min(cursorQuery.getColumnCount(), 3); i2++) {
                            StringBuilder sb10 = this.f4373mjFkc;
                            sb10.append(cursorQuery.getColumnName(i2));
                            sb10.append("=");
                            sb10.append(cursorQuery.getString(i2));
                            sb10.append(" | ");
                        }
                    }
                    StringBuilder sb11 = this.f4373mjFkc;
                    sb11.append(" (");
                    sb11.append(cursorQuery.getCount());
                    sb11.append(" 行)\n");
                    cursorQuery.close();
                } else {
                    this.f4373mjFkc.append("OAID: Provider 返回 null\n");
                }
            } catch (Exception e) {
                StringBuilder sb12 = this.f4373mjFkc;
                sb12.append("OAID: ");
                sb12.append(e.getMessage());
                sb12.append("\n");
            }
            this.f4373mjFkc.append("\n═══ ZYB 进程状态 ═══\n");
            String[] strArr2 = {"com.zuoyebang.padms", "com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.zptcpservice", "com.zuoyebang.iot.pad.appstore", "com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.zp.lib.ota.server"};
            for (int i3 = 0; i3 < 6; i3++) {
                String str3 = strArr2[i3];
                try {
                    MainActivity.this.getPackageManager().getPackageInfo(str3, 0);
                    String strSubstring = str3.substring(str3.lastIndexOf(46) + 1);
                    StringBuilder sb13 = this.f4373mjFkc;
                    sb13.append("✓ ");
                    sb13.append(strSubstring);
                    sb13.append("\n");
                } catch (Exception unused3) {
                    String strSubstring2 = str3.substring(str3.lastIndexOf(46) + 1);
                    StringBuilder sb14 = this.f4373mjFkc;
                    sb14.append("✗ ");
                    sb14.append(strSubstring2);
                    sb14.append(" (未安装)\n");
                }
            }
            MainActivity.this.f4281mjFkc.post(new mjFkc(this.f4373mjFkc.toString()));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$IvRQOa */
    public class RunnableC0940IvRQOa implements Runnable {
        public RunnableC0940IvRQOa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4776gcD();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$IyS */
    public class ViewOnClickListenerC0941IyS implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Runnable f4378mjFkc;

        public ViewOnClickListenerC0941IyS(Runnable runnable) {
            this.f4378mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4378mjFkc.run();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JBhc */
    public class RunnableC0942JBhc implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$JBhc$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4381mjFkc;

            public mjFkc(String str) {
                this.f4381mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4747a(true);
                MainActivity.this.m4718T("申请设备所有者", this.f4381mjFkc);
            }
        }

        public RunnableC0942JBhc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM4920bbzow;
            String string;
            ArrayList<String> arrayList = new ArrayList();
            try {
                String strM4920bbzow2 = AdbConnectionManager.m4920bbzow("dumpsys account");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Pattern patternCompile = Pattern.compile("Account \\{name=[^,]*, type=([A-Za-z0-9._]+)\\}");
                String strReplace = BuildConfig.f24315FLAVOR;
                if (strM4920bbzow2 == null) {
                    strM4920bbzow2 = BuildConfig.f24315FLAVOR;
                }
                Matcher matcher = patternCompile.matcher(strM4920bbzow2);
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
                mainActivity.m4750aQ(sb.toString());
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    try {
                        String strM4920bbzow3 = AdbConnectionManager.m4920bbzow("pm disable-user --user 0 " + str);
                        arrayList.add(str);
                        MainActivity mainActivity2 = MainActivity.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[*] 已临时停用: ");
                        sb2.append(str);
                        sb2.append(" (");
                        sb2.append(strM4920bbzow3 != null ? strM4920bbzow3.trim() : BuildConfig.f24315FLAVOR);
                        sb2.append(")");
                        mainActivity2.m4750aQ(sb2.toString());
                    } catch (Throwable th) {
                        MainActivity.this.m4750aQ("[!] 停用失败: " + str + " - " + MainActivity.m4563mYYU(th));
                    }
                }
                try {
                    strM4920bbzow = AdbConnectionManager.m4920bbzow("CLASSPATH='" + MainActivity.this.getApplicationInfo().sourceDir + "' app_process /system/bin com.jc.code.v3.SetDeviceOwnerAgent 'JC.CODE.V3/com.jc.code.v3.JcDeviceAdminReceiver' 2>&1");
                } catch (Throwable th2) {
                    strM4920bbzow = "错误: " + MainActivity.m4563mYYU(th2);
                }
                MainActivity mainActivity3 = MainActivity.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[*] set-device-owner: ");
                if (strM4920bbzow != null) {
                    strReplace = strM4920bbzow.trim().replace("\n", " | ");
                }
                sb3.append(strReplace);
                mainActivity3.m4750aQ(sb3.toString());
                for (String str2 : arrayList) {
                    try {
                        AdbConnectionManager.m4920bbzow("pm enable " + str2);
                        MainActivity.this.m4750aQ("[*] 已恢复: " + str2);
                    } catch (Throwable th3) {
                        MainActivity.this.m4750aQ("[!] 恢复失败: " + str2 + " - " + MainActivity.m4563mYYU(th3));
                    }
                }
                boolean zM4686KbpP = MainActivity.this.m4686KbpP();
                MainActivity.this.m4750aQ("[*] 本应用是否设备所有者: " + zM4686KbpP);
                if (zM4686KbpP) {
                    string = "✓ 已成为设备所有者！\n现在「安装证书」可静默完成，然后「一键开开发者」全自动。";
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("✗ 未成为设备所有者\n\n命令输出：");
                    sb4.append(strM4920bbzow != null ? strM4920bbzow.trim() : "(空)");
                    string = sb4.toString();
                }
                MainActivity.this.m4750aQ(zM4686KbpP ? "[+] 申请设备所有者成功" : "[!] 申请设备所有者失败");
                MainActivity.this.f4281mjFkc.post(new mjFkc(string));
            } catch (Throwable th4) {
                MainActivity.this.m4750aQ("[!] 流程异常: " + MainActivity.m4563mYYU(th4));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    try {
                        AdbConnectionManager.m4920bbzow("pm enable " + ((String) it2.next()));
                    } catch (Throwable unused) {
                    }
                }
                MainActivity.this.m4737Y("✗ 流程异常: " + MainActivity.m4563mYYU(th4));
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JHa */
    public class RunnableC0943JHa implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f4383mjFkc;

        public RunnableC0943JHa(View view) {
            this.f4383mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = MainActivity.this.f4298xJ;
            float f = MainActivity.this.getResources().getDisplayMetrics().density;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(8.0f * f);
            gradientDrawable.setColor(z ? -13948117 : -1);
            this.f4383mjFkc.setBackground(gradientDrawable);
            TextView textView = (TextView) this.f4383mjFkc.findViewById(AbstractC4658u4.f16782Pq);
            if (textView != null) {
                textView.setTextColor(z ? -419430401 : -15066598);
            }
            TextView textView2 = (TextView) this.f4383mjFkc.findViewById(AbstractC4658u4.f16793qGY);
            if (textView2 != null) {
                textView2.setTextColor(z ? -419430401 : -15066598);
            }
            EditText editText = (EditText) this.f4383mjFkc.findViewById(AbstractC4658u4.f16797xJ);
            if (editText != null) {
                editText.setTextColor(z ? -419430401 : -15066598);
                editText.setHintTextColor(z ? -1711276033 : -1728053248);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(f * 4.0f);
                gradientDrawable2.setColor(z ? -13816531 : -1);
                gradientDrawable2.setStroke(1, z ? -11908534 : -3026479);
                editText.setBackground(gradientDrawable2);
            }
            TextView textView3 = (TextView) this.f4383mjFkc.findViewById(AbstractC4658u4.f16792mjFkc);
            if (textView3 != null) {
                textView3.setTextColor(z ? -11746561 : -16750656);
            }
            TextView textView4 = (TextView) this.f4383mjFkc.findViewById(AbstractC4658u4.f16786ZfxDd);
            if (textView4 != null) {
                textView4.setTextColor(z ? -16437175 : -1);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(f * 4.0f);
                gradientDrawable3.setColor(z ? -11746561 : -16750656);
                textView4.setBackground(gradientDrawable3);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JOe */
    public class RunnableC0944JOe implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4385mjFkc;

        public RunnableC0944JOe(String str) {
            this.f4385mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("本应用需要联网向服务器确认后才能使用。\n请检查网络后重试。");
            String str2 = this.f4385mjFkc;
            if (str2 == null || str2.length() <= 0) {
                str = BuildConfig.f24315FLAVOR;
            } else {
                str = "\n(" + this.f4385mjFkc + ")";
            }
            sb.append(str);
            mainActivity.m4666H(true, "无法连接验证服务器", sb.toString());
            MainActivity.this.f4281mjFkc.removeCallbacks(MainActivity.this.f4250Vgyli);
            MainActivity.this.f4281mjFkc.postDelayed(MainActivity.this.f4250Vgyli, 30000L);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JYgkl */
    public class RunnableC0945JYgkl implements Runnable {
        public RunnableC0945JYgkl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4815olO();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JYn */
    public class RunnableC0946JYn implements Runnable {
        public RunnableC0946JYn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4738YDiFPt();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Jidt */
    public class RunnableC0947Jidt implements Runnable {
        public RunnableC0947Jidt() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4722UXIO();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Jk */
    public class RunnableC0948Jk implements Runnable {
        public RunnableC0948Jk() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.m4688LyQ();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$JrJO */
    public class RunnableC0949JrJO implements Runnable {
        public RunnableC0949JrJO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4797khjiU();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$KLFTb */
    public class ViewOnClickListenerC0950KLFTb implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ AlertDialog f4391AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Set f4392mjFkc;

        public ViewOnClickListenerC0950KLFTb(Set set, AlertDialog alertDialog) {
            this.f4392mjFkc = set;
            this.f4391AZxh = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f4392mjFkc.isEmpty()) {
                MainActivity.this.m4733X("请先选择要卸载的应用");
                return;
            }
            this.f4391AZxh.dismiss();
            Iterator it = this.f4392mjFkc.iterator();
            while (it.hasNext()) {
                MainActivity.this.m4761c0((String) it.next());
            }
            MainActivity.this.m4737Y("正在卸载 " + this.f4392mjFkc.size() + " 个应用...");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$KLMXS */
    public class RunnableC0951KLMXS implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4394AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4396mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ScrollView f4397wA;

        public RunnableC0951KLMXS(String str, TextView textView, ScrollView scrollView) {
            this.f4396mjFkc = str;
            this.f4394AZxh = textView;
            this.f4397wA = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            MainActivity.this.m4676Ipwl();
            try {
                String strM4920bbzow = AdbConnectionManager.m4920bbzow(this.f4396mjFkc);
                MainActivity mainActivity = MainActivity.this;
                TextView textView = this.f4394AZxh;
                ScrollView scrollView = this.f4397wA;
                StringBuilder sb = new StringBuilder();
                if (strM4920bbzow == null || strM4920bbzow.trim().length() == 0) {
                    strM4920bbzow = "(无输出)";
                }
                sb.append(strM4920bbzow);
                sb.append("\n");
                mainActivity.m4783iEjzEW(textView, scrollView, sb.toString(), -2629912);
            } catch (Throwable th) {
                MainActivity.this.m4783iEjzEW(this.f4394AZxh, this.f4397wA, "✗ " + MainActivity.m4563mYYU(th) + "\n", -1074534);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$KRTLGT */
    public class DialogInterfaceOnClickListenerC0952KRTLGT implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ CheckBox f4399mjFkc;

        public DialogInterfaceOnClickListenerC0952KRTLGT(CheckBox checkBox) {
            this.f4399mjFkc = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4828r(this.f4399mjFkc.isChecked());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$KRckQg */
    public class C0953KRckQg implements AdbConnectionManager.fehf {
        public C0953KRckQg() {
        }

        @Override // com.jc.code.v3.AdbConnectionManager.fehf
        /* renamed from: mjFkc */
        public void mo4868mjFkc(String str) {
            MainActivity.this.m4750aQ("[ADB] " + str);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$KSf */
    public class RunnableC0954KSf implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4401AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4402mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$KSf$mjFkc */
        public class mjFkc implements DialogInterface.OnClickListener {
            public mjFkc() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public RunnableC0954KSf(String str, String str2) {
            this.f4402mjFkc = str;
            this.f4401AZxh = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            String strM4850wfQA = MainActivity.this.m4850wfQA();
            String str2 = this.f4402mjFkc;
            if (str2 == null || str2.length() <= 0) {
                str = BuildConfig.f24315FLAVOR;
            } else {
                str = this.f4402mjFkc + "\n\n";
            }
            String str3 = str + "本机设备码：" + strM4850wfQA + "\n（联系处理时请提供此码）";
            MainActivity.this.m4693N(this.f4401AZxh, str3);
            AlertDialog alertDialogM4720U = MainActivity.this.m4720U(new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setTitle(this.f4401AZxh).setMessage(str3).setPositiveButton("退出", new mjFkc()));
            MainActivity.this.m4840u(alertDialogM4720U, 520.0f);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.m4799l0(alertDialogM4720U, mainActivity.f4298xJ ? -6643546 : -10525848, MainActivity.this.f4298xJ ? -6643546 : -10525848);
            MainActivity.this.m4727UokA(alertDialogM4720U);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$LREOK */
    public class DialogInterfaceOnClickListenerC0955LREOK implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4406mjFkc;

        public DialogInterfaceOnClickListenerC0955LREOK(EditText editText) {
            this.f4406mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.f4406mjFkc.getText().toString().trim();
            if (strTrim.isEmpty() || !(strTrim.startsWith("http://") || strTrim.startsWith("https://"))) {
                MainActivity.this.m4733X("请输入合法 URL");
            } else {
                MainActivity.this.m4683Jkjs(strTrim, null, null);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$LeWm */
    public class RunnableC0956LeWm implements Runnable {
        public RunnableC0956LeWm() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://app.aibangos.xyz/Jc.Four")));
            } catch (Exception unused) {
                MainActivity.this.m4733X("无法打开浏览器");
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$LlB */
    public class RunnableC0957LlB implements Runnable {
        public RunnableC0957LlB() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4790jeHSg();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$LsBneK */
    public class ViewOnLongClickListenerC0958LsBneK implements View.OnLongClickListener {
        public ViewOnLongClickListenerC0958LsBneK() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            MainActivity.this.m4646D();
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$MC */
    public class RunnableC0959MC implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ File f4411mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$MC$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ Bitmap f4413mjFkc;

            public mjFkc(Bitmap bitmap) {
                this.f4413mjFkc = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = MainActivity.this.f4301yX;
                if (imageView != null) {
                    imageView.setImageBitmap(this.f4413mjFkc);
                }
            }
        }

        public RunnableC0959MC(File file) {
            this.f4411mjFkc = file;
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
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f4411mjFkc);
                        bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    MainActivity.this.f4281mjFkc.post(new mjFkc(bitmapDecodeStream));
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$MFekjo */
    public class ViewOnClickListenerC0960MFekjo implements View.OnClickListener {
        public ViewOnClickListenerC0960MFekjo() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.m4833rtBEoQ();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$MiMN */
    public class RunnableC0961MiMN implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ boolean f4415AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ TextView f4417ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4418mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ CompoundButton f4419wA;

        /* renamed from: com.jc.code.v3.MainActivity$MiMN$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ boolean f4421mjFkc;

            public mjFkc(boolean z) {
                this.f4421mjFkc = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f4421mjFkc) {
                    RunnableC0961MiMN.this.f4419wA.setTag(Boolean.TRUE);
                    RunnableC0961MiMN.this.f4419wA.setChecked(!r0.f4415AZxh);
                    RunnableC0961MiMN.this.f4419wA.setTag(null);
                    MainActivity.this.m4733X("✗ 操作失败: " + RunnableC0961MiMN.this.f4418mjFkc);
                    return;
                }
                RunnableC0961MiMN runnableC0961MiMN = RunnableC0961MiMN.this;
                TextView textView = runnableC0961MiMN.f4417ZfxDd;
                if (textView != null) {
                    textView.setTextColor(runnableC0961MiMN.f4415AZxh ? -15171528 : MainActivity.this.f4298xJ ? -1711276033 : -1728053248);
                }
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append(RunnableC0961MiMN.this.f4415AZxh ? "✓ 已防卸载: " : "✓ 已解除: ");
                sb.append(RunnableC0961MiMN.this.f4418mjFkc);
                mainActivity.m4733X(sb.toString());
                RunnableC0961MiMN runnableC0961MiMN2 = RunnableC0961MiMN.this;
                if (runnableC0961MiMN2.f4415AZxh) {
                    MainActivity.this.m4678J();
                }
            }
        }

        public RunnableC0961MiMN(String str, boolean z, CompoundButton compoundButton, TextView textView) {
            this.f4418mjFkc = str;
            this.f4415AZxh = z;
            this.f4419wA = compoundButton;
            this.f4417ZfxDd = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) MainActivity.this.getSystemService("device_policy");
                ComponentName componentName = new ComponentName(MainActivity.this, (Class<?>) JcDeviceAdminReceiver.class);
                devicePolicyManager.setUninstallBlocked(componentName, this.f4418mjFkc, this.f4415AZxh);
                if (devicePolicyManager.isUninstallBlocked(componentName, this.f4418mjFkc) == this.f4415AZxh) {
                    z = true;
                }
            } catch (Throwable th) {
                MainActivity.this.m4750aQ("[!] 防卸载失败: " + this.f4418mjFkc + " - " + MainActivity.m4563mYYU(th));
            }
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "[+] " : "[!] ");
            sb.append(this.f4415AZxh ? "防卸载开启: " : "防卸载解除: ");
            sb.append(this.f4418mjFkc);
            mainActivity.m4750aQ(sb.toString());
            MainActivity.this.f4281mjFkc.post(new mjFkc(z));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Moer */
    public class RunnableC0962Moer implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$Moer$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ boolean f4424mjFkc;

            public mjFkc(boolean z) {
                this.f4424mjFkc = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4424mjFkc) {
                    MainActivity.this.m4749aAlqX();
                } else {
                    MainActivity.this.m4794k0();
                }
            }
        }

        public RunnableC0962Moer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zM4711RW = MainActivity.this.m4711RW();
            if (zM4711RW) {
                MainActivity.this.m4680JGvOM();
            }
            MainActivity.this.f4281mjFkc.post(new mjFkc(zM4711RW));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Mpf */
    public class RunnableC0963Mpf implements Runnable {
        public RunnableC0963Mpf() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4698OGo();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$NKyg */
    public class RunnableC0964NKyg implements Runnable {
        public RunnableC0964NKyg() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1035gjvQ c1035gjvQM4598uAgKP;
            String str;
            try {
                try {
                } catch (Exception e) {
                    MainActivity.this.m4750aQ("[!] 自动配对异常: " + e.getMessage());
                }
                if (MainActivity.this.m4711RW()) {
                    MainActivity.this.m4750aQ("[*] 监听配对码中（最多 60 秒），请在系统页面点击「使用配对码配对设备」...");
                    long jCurrentTimeMillis = System.currentTimeMillis() + DurationKt.MILLIS_IN_MINUTE;
                    while (MainActivity.this.f4302yfx && System.currentTimeMillis() < jCurrentTimeMillis) {
                        if (AdbConnectionManager.m4902NPj() || AdbConnectionManager.m4947xrEuO()) {
                            MainActivity.this.m4750aQ("[*] ADB 已连接，停止监听配对码");
                            break;
                        }
                        Thread.sleep(1800L);
                        String strM4792jxC = MainActivity.this.m4792jxC("rm -f /data/local/tmp/jc_pair_ui.xml; timeout 8 uiautomator dump /data/local/tmp/jc_pair_ui.xml >/dev/null 2>&1; cat /data/local/tmp/jc_pair_ui.xml");
                        if (strM4792jxC != null && strM4792jxC.indexOf("<hierarchy") >= 0) {
                            try {
                                List listM4407EaLbDP = MainActivity.m4407EaLbDP(strM4792jxC);
                                if (!listM4407EaLbDP.isEmpty() && (c1035gjvQM4598uAgKP = MainActivity.m4598uAgKP(listM4407EaLbDP)) != null && c1035gjvQM4598uAgKP.f4600mjFkc != null) {
                                    String strM4602uhQ = MainActivity.m4602uhQ(listM4407EaLbDP);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(c1035gjvQM4598uAgKP.f4600mjFkc);
                                    if (strM4602uhQ != null) {
                                        str = " " + strM4602uhQ;
                                    } else {
                                        str = BuildConfig.f24315FLAVOR;
                                    }
                                    sb.append(str);
                                    String string = sb.toString();
                                    MainActivity.this.m4665GmK(string);
                                    MainActivity.this.f4226IVlxe = c1035gjvQM4598uAgKP.f4600mjFkc;
                                    MainActivity.this.f4237Moer = strM4602uhQ;
                                    MainActivity.this.m4750aQ("[+] 识别到配对码: " + string + "，开始自动配对");
                                    MainActivity.this.m4640C0("已识别配对码，正在自动配对…", true);
                                    MainActivity.this.m4765e();
                                    MainActivity.this.m4813o0(c1035gjvQM4598uAgKP.f4600mjFkc);
                                }
                            } catch (Exception unused) {
                                continue;
                            }
                        }
                    }
                    if (!AdbConnectionManager.m4902NPj() && !AdbConnectionManager.m4947xrEuO()) {
                        MainActivity.this.m4750aQ("[!] 自动配对超时：未识别到配对码");
                        MainActivity.this.m4835s0("自动配对超时，未识别到配对码");
                    }
                } else {
                    MainActivity.this.m4750aQ("[!] 自动配对需要 Root 权限：读取系统页面并自动填写配对码");
                    MainActivity.this.m4835s0("自动配对需要 Root 权限");
                }
            } finally {
                MainActivity.this.f4302yfx = false;
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$NPj */
    public class RunnableC0965NPj implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4427AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Boolean f4428mjFkc;

        public RunnableC0965NPj(Boolean bool, String str) {
            this.f4428mjFkc = bool;
            this.f4427AZxh = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Boolean bool = this.f4428mjFkc;
            if (bool != null) {
                MainActivity.this.m4843v(bool.booleanValue());
                MainActivity.this.m4645CrDc(true);
            }
            if (this.f4427AZxh.startsWith("✓")) {
                MainActivity.this.m4737Y(this.f4427AZxh);
            } else {
                MainActivity.this.m4733X(this.f4427AZxh);
            }
            Boolean bool2 = this.f4428mjFkc;
            if (bool2 == null || !bool2.booleanValue()) {
                return;
            }
            MainActivity.this.m4720U(new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setTitle("已停用 PadMS · 重要提醒").setMessage("已停用 PadMS，本次开机期间系统不会再删除第三方应用。\n\n⚠ 但保护只在本次开机有效：系统每次开机时 PadMS 都会自动扫描并删除黑名单应用，重启 / 关机后保护即失效。\n\n· 每次开机后可再点一次「阻止系统删应用」重新停用\n· 如需重启后依然不被删除，请用「单独应用防卸载」，保护重启后仍有效\n\n重要资料请提前备份。").setPositiveButton("我知道了", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$NV */
    public class RunnableC0966NV implements Runnable {
        public RunnableC0966NV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4784ilrRDI();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Ne */
    public class RunnableC0967Ne implements Runnable {
        public RunnableC0967Ne() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4831rKxis();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$OjSQV */
    public class C0968OjSQV implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4432AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4433mjFkc;

        public C0968OjSQV(TextView textView, ScrollView scrollView) {
            this.f4433mjFkc = textView;
            this.f4432AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4822q("pm enable " + str, this.f4433mjFkc, this.f4432AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Otxclu */
    public class RunnableC0969Otxclu implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4436mjFkc;

        public RunnableC0969Otxclu(AlertDialog alertDialog) {
            this.f4436mjFkc = alertDialog;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView;
            boolean z = MainActivity.this.f4298xJ;
            int i = z ? -1842205 : -14737633;
            int i2 = z ? -3552047 : -12302522;
            int i3 = z ? -5919253 : -10589486;
            try {
                TextView textView2 = (TextView) this.f4436mjFkc.findViewById(AbstractC1865E4.f7956xJ);
                if (textView2 != null) {
                    textView2.setTextColor(i);
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                    textView2.setTextSize(19.0f);
                }
            } catch (Exception unused) {
            }
            int identifier = MainActivity.this.getResources().getIdentifier("alertTitle", "id", "android");
            if (identifier > 0 && (textView = (TextView) this.f4436mjFkc.findViewById(identifier)) != null) {
                textView.setTextColor(i);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextSize(19.0f);
            }
            TextView textView3 = (TextView) this.f4436mjFkc.findViewById(R.id.message);
            if (textView3 != null) {
                textView3.setTextColor(i2);
                textView3.setTextSize(15.0f);
                textView3.setLineSpacing(2.0f, 1.0f);
            }
            int[] iArr = {R.id.button1, R.id.button2, R.id.button3};
            for (int i4 = 0; i4 < 3; i4++) {
                TextView textView4 = (TextView) this.f4436mjFkc.findViewById(iArr[i4]);
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
                ListView listView = (ListView) this.f4436mjFkc.findViewById(identifier2);
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
            MainActivity.this.m4853x(this.f4436mjFkc.getWindow().getDecorView(), z);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$OzIs */
    public class ViewOnClickListenerC0970OzIs implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ C1101xVYW f4437AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog[] f4438mjFkc;

        public ViewOnClickListenerC0970OzIs(AlertDialog[] alertDialogArr, C1101xVYW c1101xVYW) {
            this.f4438mjFkc = alertDialogArr;
            this.f4437AZxh = c1101xVYW;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog = this.f4438mjFkc[0];
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.f4437AZxh.f4795KLFTb.run();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Pq */
    public class ViewOnClickListenerC0971Pq implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ boolean[] f4440AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ScrollView[] f4442ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4443mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ TextView[] f4444wA;

        public ViewOnClickListenerC0971Pq(EditText editText, boolean[] zArr, TextView[] textViewArr, ScrollView[] scrollViewArr) {
            this.f4443mjFkc = editText;
            this.f4440AZxh = zArr;
            this.f4444wA = textViewArr;
            this.f4442ZfxDd = scrollViewArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String strTrim = this.f4443mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.f4443mjFkc.setText(BuildConfig.f24315FLAVOR);
            if (this.f4440AZxh[0]) {
                MainActivity.this.m4801m(strTrim, this.f4444wA[0], this.f4442ZfxDd[0]);
            } else {
                MainActivity.this.m4822q(strTrim, this.f4444wA[0], this.f4442ZfxDd[0]);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Qr */
    public class RunnableC0972Qr implements Runnable {
        public RunnableC0972Qr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.m4707Qs()) {
                MainActivity.this.m4835s0("请点「使用配对码配对设备」");
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$QyMqpM */
    public class RunnableC0973QyMqpM implements Runnable {
        public RunnableC0973QyMqpM() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strSubstring;
            View view = MainActivity.this.f4291uH;
            if (view == null || view.getParent() == null) {
                String strSubstring2 = MainActivity.this.f4288tISON;
                int iIndexOf = strSubstring2.indexOf("||");
                if (iIndexOf >= 0) {
                    strSubstring = strSubstring2.substring(0, iIndexOf);
                    strSubstring2 = strSubstring2.substring(iIndexOf + 2);
                } else {
                    strSubstring = "已锁定";
                }
                MainActivity.this.m4693N(strSubstring, strSubstring2);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$QyqF */
    public class RunnableC0974QyqF implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ C1071qtZIjO f4448mjFkc;

        public RunnableC0974QyqF(C1071qtZIjO c1071qtZIjO) {
            this.f4448mjFkc = c1071qtZIjO;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f4220Dt) {
                this.f4448mjFkc.f4713KLFTb.run();
                return;
            }
            if (this.f4448mjFkc.f4719lgHUyS && MainActivity.this.m4710RV()) {
                this.f4448mjFkc.f4713KLFTb.run();
                return;
            }
            if (MainActivity.this.m4795kgk()) {
                MainActivity.this.m4685K(this.f4448mjFkc.f4720mjFkc);
                return;
            }
            MainActivity.this.m4750aQ("[!] " + this.f4448mjFkc.f4720mjFkc + " 需 zybos 绑定，当前未连接");
            new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setTitle(this.f4448mjFkc.f4720mjFkc + " 暂不可用").setMessage("该功能依赖 zybos 服务绑定，当前尚未连接。\n\n可先到「设备信息」页执行一键探测，绑定成功后此功能自动恢复可用。").setPositiveButton("知道了", (DialogInterface.OnClickListener) null).show();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$RWb */
    public class ViewOnClickListenerC0975RWb implements View.OnClickListener {
        public ViewOnClickListenerC0975RWb() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("JC Code V3 Log", MainActivity.this.f4236MiMN.toString()));
            MainActivity.this.m4733X("✓ 日志已复制到剪贴板");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$RWyiuY */
    public class RunnableC0976RWyiuY implements Runnable {
        public RunnableC0976RWyiuY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4731W();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Rc */
    public class C0977Rc implements DownloadListener {
        public C0977Rc() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            MainActivity.this.m4750aQ("[*] 浏览器下载请求: " + str + " (" + str4 + ")");
            if (MainActivity.this.m4773gGFLGZ(str, str3, str4)) {
                MainActivity.this.m4846vEiZJ(str);
                return;
            }
            if (MainActivity.this.m4654EqDGZ(str, str3, str4)) {
                MainActivity.this.m4818pCk(str);
                return;
            }
            MainActivity.this.m4733X("非 APK 下载，未拦截: " + str);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Rsp */
    public class DialogInterfaceOnClickListenerC0978Rsp implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4453mjFkc;

        public DialogInterfaceOnClickListenerC0978Rsp(EditText editText) {
            this.f4453mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.f4453mjFkc.getText().toString().trim();
            SharedPreferences.Editor editorEdit = MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit();
            if (strTrim.isEmpty()) {
                strTrim = "JC Code 搜索";
            }
            editorEdit.putString("search_title", strTrim).apply();
            MainActivity.this.m4733X("搜索页标题已更新");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$SKTn */
    public class C0979SKTn extends WebChromeClient {
        public C0979SKTn() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (MainActivity.this.f4233KLMXS == null || str == null || str.isEmpty() || str.contains("://")) {
                return;
            }
            MainActivity.this.m4750aQ("[*] 页面标题: " + str);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$SOS */
    public class RunnableC0980SOS implements Runnable {
        public RunnableC0980SOS() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.m4707Qs()) {
                MainActivity.this.f4302yfx = true;
                MainActivity.this.m4835s0("请点「使用配对码配对设备」，配对码出现后自动完成");
                MainActivity.this.m4786j0();
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$SmIWf */
    public class C0981SmIWf implements ScreenCaptureService.InterfaceC1112JHa {

        /* renamed from: com.jc.code.v3.MainActivity$SmIWf$AZxh */
        public class AZxh implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ boolean f4457AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4458mjFkc;

            public AZxh(String str, boolean z) {
                this.f4458mjFkc = str;
                this.f4457AZxh = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4750aQ("[OCR] " + this.f4458mjFkc);
                if (this.f4457AZxh) {
                    return;
                }
                MainActivity.this.m4835s0(this.f4458mjFkc);
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$SmIWf$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ String f4460AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4461mjFkc;

            public mjFkc(String str, String str2) {
                this.f4461mjFkc = str;
                this.f4460AZxh = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4461mjFkc);
                if (this.f4460AZxh != null) {
                    str = " " + this.f4460AZxh;
                } else {
                    str = BuildConfig.f24315FLAVOR;
                }
                sb.append(str);
                String string = sb.toString();
                MainActivity.this.m4665GmK(string);
                MainActivity.this.f4226IVlxe = this.f4461mjFkc;
                MainActivity.this.f4237Moer = this.f4460AZxh;
                MainActivity.this.m4750aQ("[OCR] 识别到配对码: " + string + "，开始自动配对");
                MainActivity.this.m4640C0("已识别配对码，正在自动配对…", true);
                MainActivity.this.m4765e();
                MainActivity.this.m4813o0(this.f4461mjFkc);
            }
        }

        public C0981SmIWf() {
        }

        @Override // com.p091jc.p092code.p093v3.ScreenCaptureService.InterfaceC1112JHa
        /* renamed from: AZxh */
        public void mo4869AZxh(String str, String str2) {
            MainActivity.this.f4281mjFkc.post(new mjFkc(str, str2));
        }

        @Override // com.p091jc.p092code.p093v3.ScreenCaptureService.InterfaceC1112JHa
        /* renamed from: mjFkc */
        public void mo4870mjFkc(String str, boolean z) {
            MainActivity.this.f4281mjFkc.post(new AZxh(str, z));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$SwgkN */
    public class DialogInterfaceOnClickListenerC0982SwgkN implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0982SwgkN() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4798l();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Sx */
    public class RunnableC0983Sx implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ ImageView f4465mjFkc;

        public RunnableC0983Sx(ImageView imageView) {
            this.f4465mjFkc = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4465mjFkc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f4465mjFkc.getParent()).removeView(this.f4465mjFkc);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$TFbkuO */
    public class RunnableC0984TFbkuO implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f4467mjFkc;

        public RunnableC0984TFbkuO(View view) {
            this.f4467mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4290tjSezt = true;
            this.f4467mjFkc.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(400L).setInterpolator(new PathInterpolator(0.16f, 1.0f, 0.3f, 1.0f)).start();
            MainActivity.this.m4858y0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$TvfBiy */
    public class RunnableC0985TvfBiy implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f4469mjFkc;

        public RunnableC0985TvfBiy(View view) {
            this.f4469mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4469mjFkc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f4469mjFkc.getParent()).removeView(this.f4469mjFkc);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Tw */
    public class RunnableC0986Tw implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ C1071qtZIjO f4471mjFkc;

        public RunnableC0986Tw(C1071qtZIjO c1071qtZIjO) {
            this.f4471mjFkc = c1071qtZIjO;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.m4710RV()) {
                this.f4471mjFkc.f4713KLFTb.run();
            } else {
                MainActivity.this.m4630A(this.f4471mjFkc.f4720mjFkc);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$UDcil */
    public class RunnableC0987UDcil implements Runnable {
        public RunnableC0987UDcil() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            MainActivity.this.m4691MQhVKd();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$UOnCkw */
    public class PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: AZxh */
        public final /* synthetic */ int f4473AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4475mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Bitmap f4476wA;

        /* renamed from: com.jc.code.v3.MainActivity$UOnCkw$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: com.jc.code.v3.MainActivity$UOnCkw$mjFkc$mjFkc, reason: collision with other inner class name */
            public class RunnableC6351mjFkc implements Runnable {

                /* renamed from: mjFkc */
                public final /* synthetic */ Bitmap f4479mjFkc;

                public RunnableC6351mjFkc(Bitmap bitmap) {
                    this.f4479mjFkc = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MainActivity.this.f4238NKyg <= 0) {
                        this.f4479mjFkc.recycle();
                        return;
                    }
                    MainActivity.this.f4276kism = this.f4479mjFkc;
                    MainActivity.this.m4858y0();
                }
            }

            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.f4238NKyg <= 0) {
                    return;
                }
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.this.f4476wA, Math.max(1, PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.this.f4475mjFkc / 8), Math.max(1, PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.this.f4473AZxh / 8), true);
                    PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw pixelCopyOnPixelCopyFinishedListenerC0988UOnCkw = PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.this;
                    Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, pixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.f4475mjFkc, pixelCopyOnPixelCopyFinishedListenerC0988UOnCkw.f4473AZxh, true);
                    bitmapCreateScaledBitmap.recycle();
                    new Canvas(bitmapCreateScaledBitmap2).drawColor(MainActivity.this.f4298xJ ? -1945433073 : -1930366218);
                    MainActivity.this.f4281mjFkc.post(new RunnableC6351mjFkc(bitmapCreateScaledBitmap2));
                } catch (Exception unused) {
                }
            }
        }

        public PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw(int i, int i2, Bitmap bitmap) {
            this.f4475mjFkc = i;
            this.f4473AZxh = i2;
            this.f4476wA = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            if (i != 0) {
                return;
            }
            new Thread(new mjFkc()).start();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$UPU */
    public class RunnableC0989UPU implements Runnable {
        public RunnableC0989UPU() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4689M();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Ucbh */
    public class RunnableC0990Ucbh implements Runnable {
        public RunnableC0990Ucbh() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            MainActivity.this.m4787jCFSyK();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$VA */
    public class ViewOnClickListenerC0991VA implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4483mjFkc;

        public ViewOnClickListenerC0991VA(AlertDialog alertDialog) {
            this.f4483mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4483mjFkc.dismiss();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Vdz */
    public class ServiceConnectionC0992Vdz implements ServiceConnection {

        /* renamed from: AZxh */
        public final /* synthetic */ ServiceConnection[] f4484AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ byte[] f4485mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$Vdz$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ IBinder f4488mjFkc;

            public mjFkc(IBinder iBinder) {
                this.f4488mjFkc = iBinder;
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
                        objInvoke = Class.forName("android.security.IKeyChainService$Stub").getMethod("asInterface", IBinder.class).invoke(null, this.f4488mjFkc);
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
                            MainActivity.this.m4750aQ("[!] CA 静默安装失败: " + th);
                            MainActivity.this.m4782iBHnK();
                            ServiceConnectionC0992Vdz serviceConnectionC0992Vdz = ServiceConnectionC0992Vdz.this;
                            mainActivity = MainActivity.this;
                            serviceConnection = serviceConnectionC0992Vdz.f4484AZxh[0];
                        } finally {
                            try {
                                ServiceConnectionC0992Vdz serviceConnectionC0992Vdz2 = ServiceConnectionC0992Vdz.this;
                                MainActivity.this.unbindService(serviceConnectionC0992Vdz2.f4484AZxh[0]);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (method == null) {
                        MainActivity.this.m4750aQ("[!] installCaCertificate 方法不存在");
                        MainActivity.this.m4782iBHnK();
                        try {
                            ServiceConnectionC0992Vdz serviceConnectionC0992Vdz3 = ServiceConnectionC0992Vdz.this;
                            MainActivity.this.unbindService(serviceConnectionC0992Vdz3.f4484AZxh[0]);
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    Object objInvoke2 = method.invoke(objInvoke, ServiceConnectionC0992Vdz.this.f4485mjFkc);
                    MainActivity.this.m4750aQ("[+] CA 已静默装入用户证书库 (alias=" + objInvoke2 + ")");
                    MainActivity.this.m4737Y("✓ CA 证书已安装");
                    ServiceConnectionC0992Vdz serviceConnectionC0992Vdz4 = ServiceConnectionC0992Vdz.this;
                    mainActivity = MainActivity.this;
                    serviceConnection = serviceConnectionC0992Vdz4.f4484AZxh[0];
                    mainActivity.unbindService(serviceConnection);
                } catch (Throwable unused3) {
                }
            }
        }

        public ServiceConnectionC0992Vdz(byte[] bArr, ServiceConnection[] serviceConnectionArr) {
            this.f4485mjFkc = bArr;
            this.f4484AZxh = serviceConnectionArr;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new Thread(new mjFkc(iBinder), "jc-ca-bind").start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$VfB */
    public class RunnableC0993VfB implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4490mjFkc;

        public RunnableC0993VfB(int i) {
            this.f4490mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4817p0(this.f4490mjFkc, true);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Vgyli */
    public class RunnableC0994Vgyli implements Runnable {
        public RunnableC0994Vgyli() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4701PX();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Vnb */
    public class RunnableC0995Vnb implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4493mjFkc;

        public RunnableC0995Vnb(int i) {
            this.f4493mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f4493mjFkc == 0 ? "停用 PadMS" : "恢复 PadMS";
            MainActivity.this.m4750aQ("\n[*] " + str + " (ADB)...");
            try {
                String strM4920bbzow = AdbConnectionManager.m4920bbzow(this.f4493mjFkc == 0 ? "pm disable-user --user 0 com.zuoyebang.padms ; am force-stop com.zuoyebang.padms" : "pm enable com.zuoyebang.padms");
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("[*] ");
                sb.append(strM4920bbzow != null ? strM4920bbzow.trim().replace("\n", " | ") : BuildConfig.f24315FLAVOR);
                mainActivity.m4750aQ(sb.toString());
                String strM4920bbzow2 = AdbConnectionManager.m4920bbzow("pm list packages -d com.zuoyebang.padms");
                boolean z = true;
                boolean z2 = strM4920bbzow2 != null && strM4920bbzow2.contains("com.zuoyebang.padms");
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("padms_disabled", z2).apply();
                if ((this.f4493mjFkc == 0) != z2) {
                    z = false;
                }
                MainActivity mainActivity2 = MainActivity.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z ? "[+] " : "[!] ");
                sb2.append(str);
                sb2.append(z ? "成功" : "未生效");
                sb2.append("，当前状态: ");
                sb2.append(z2 ? "已停用" : "运行中");
                mainActivity2.m4750aQ(sb2.toString());
                String str2 = "✗ 未生效，请重试";
                if (this.f4493mjFkc == 0) {
                    if (z2) {
                        str2 = "✓ 已停用 PadMS，系统不再删除第三方应用";
                    }
                } else if (!z2) {
                    str2 = "✓ PadMS 已恢复";
                }
                MainActivity.this.m4811niM(Boolean.valueOf(z2), str2);
            } catch (Throwable th) {
                MainActivity.this.m4750aQ("[!] " + str + " 失败: " + MainActivity.m4563mYYU(th));
                MainActivity.this.m4702PvPg(th);
                MainActivity.this.m4811niM(null, "✗ " + str + "失败: " + MainActivity.m4563mYYU(th));
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$VocHEe */
    public class C0996VocHEe implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4494AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4496mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ScrollView f4497wA;

        public C0996VocHEe(boolean z, TextView textView, ScrollView scrollView) {
            this.f4496mjFkc = z;
            this.f4494AZxh = textView;
            this.f4497wA = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length < 2) {
                MainActivity.this.m4733X("格式：包名 权限名");
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("set-permission-grant-state ");
            sb.append(strArrSplit[0]);
            sb.append(" ");
            sb.append(strArrSplit[1]);
            sb.append(" ");
            sb.append(this.f4496mjFkc ? "granted" : "denied");
            mainActivity.m4801m(sb.toString(), this.f4494AZxh, this.f4497wA);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Vptz */
    public class RunnableC0997Vptz implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4498AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ boolean f4499JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ boolean f4500KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ String f4501ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4502mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ String f4503wA;

        /* renamed from: com.jc.code.v3.MainActivity$Vptz$AZxh */
        public class AZxh implements View.OnClickListener {

            /* renamed from: AZxh */
            public final /* synthetic */ AlertDialog[] f4505AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ String[] f4506mjFkc;

            public AZxh(String[] strArr, AlertDialog[] alertDialogArr) {
                this.f4506mjFkc = strArr;
                this.f4505AZxh = alertDialogArr;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.m4825qbGbxJ(this.f4506mjFkc, this.f4505AZxh[0]);
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$Vptz$mjFkc */
        public class mjFkc extends ViewOutlineProvider {

            /* renamed from: mjFkc */
            public final /* synthetic */ float f4509mjFkc;

            public mjFkc(float f) {
                this.f4509mjFkc = f;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f4509mjFkc * 16.0f);
            }
        }

        public RunnableC0997Vptz(String str, String str2, String str3, String str4, boolean z, boolean z2) {
            this.f4502mjFkc = str;
            this.f4498AZxh = str2;
            this.f4503wA = str3;
            this.f4501ZfxDd = str4;
            this.f4500KLFTb = z;
            this.f4499JHa = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            char c;
            if (MainActivity.this.isFinishing()) {
                return;
            }
            String str = this.f4502mjFkc;
            char c2 = 0;
            int i = 1;
            boolean z = str != null && str.trim().length() > 0;
            String str2 = this.f4498AZxh;
            boolean z2 = str2 != null && str2.trim().length() > 0;
            if (z || z2) {
                float fM4806mz = MainActivity.this.m4806mz();
                boolean z3 = MainActivity.this.f4298xJ;
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(1);
                int i2 = (int) (22.0f * fM4806mz);
                int i3 = (int) (20.0f * fM4806mz);
                linearLayout.setPadding(i2, i3, i2, i3);
                TextView textView = new TextView(MainActivity.this);
                String str3 = this.f4503wA;
                textView.setText((str3 == null || str3.length() == 0) ? "公告" : this.f4503wA);
                textView.setTextSize(18.0f);
                textView.setTypeface(Typeface.create("sans-serif", 1));
                textView.setLetterSpacing(0.02f);
                textView.setTextColor(z3 ? -1842205 : -14737633);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                View view = new View(MainActivity.this);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(2.0f * fM4806mz);
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable.setColors(new int[]{-10589486, -13916000});
                view.setBackground(gradientDrawable);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (40.0f * fM4806mz), (int) (3.0f * fM4806mz));
                int i4 = (int) (10.0f * fM4806mz);
                layoutParams.topMargin = i4;
                int i5 = (int) (fM4806mz * 14.0f);
                layoutParams.bottomMargin = i5;
                linearLayout.addView(view, layoutParams);
                LinearLayout linearLayout2 = new LinearLayout(MainActivity.this);
                linearLayout2.setOrientation(1);
                if (z) {
                    TextView textView2 = new TextView(MainActivity.this);
                    textView2.setText(this.f4502mjFkc);
                    textView2.setTextSize(13.5f);
                    textView2.setLineSpacing(fM4806mz * 4.0f, 1.0f);
                    textView2.setTextColor(z3 ? -3616036 : -12302522);
                    linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
                }
                if (z2) {
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setVisibility(8);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    linearLayout2.addView(imageView, new LinearLayout.LayoutParams(-1, (int) (170.0f * fM4806mz)));
                    imageView.setOutlineProvider(new mjFkc(fM4806mz));
                    imageView.setClipToOutline(true);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    if (z) {
                        marginLayoutParams.topMargin = i5;
                    }
                    MainActivity.this.m4757bXx(this.f4498AZxh.trim(), imageView);
                }
                ScrollView scrollView = new ScrollView(MainActivity.this);
                scrollView.setVerticalScrollBarEnabled(false);
                scrollView.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (290.0f * fM4806mz));
                layoutParams2.bottomMargin = (int) (fM4806mz * 4.0f);
                linearLayout.addView(scrollView, layoutParams2);
                List<String[]> listM4759bzZHlx = MainActivity.this.m4759bzZHlx(this.f4501ZfxDd);
                Iterator it = listM4759bzZHlx.iterator();
                boolean z4 = false;
                while (true) {
                    c = 3;
                    if (!it.hasNext()) {
                        break;
                    } else if ("1".equals(((String[]) it.next())[3])) {
                        z4 = true;
                    }
                }
                if (!z4 && this.f4500KLFTb) {
                    listM4759bzZHlx.add(new String[]{"关闭", "close", BuildConfig.f24315FLAVOR, "1"});
                }
                AlertDialog[] alertDialogArr = new AlertDialog[1];
                for (String[] strArr : listM4759bzZHlx) {
                    TextView textView3 = new TextView(MainActivity.this);
                    textView3.setText(strArr[c2]);
                    textView3.setTextSize(14.0f);
                    textView3.setTypeface(Typeface.DEFAULT_BOLD);
                    textView3.setGravity(17);
                    float f = 16.0f * fM4806mz;
                    int i6 = (int) f;
                    int i7 = (int) (fM4806mz * 13.0f);
                    textView3.setPadding(i6, i7, i6, i7);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(f);
                    if ("1".equals(strArr[c])) {
                        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
                        gradientDrawable2.setColors(new int[]{-10589486, -13916000});
                        textView3.setTextColor(-1);
                    } else {
                        gradientDrawable2.setColor(z3 ? -14275018 : -986121);
                        gradientDrawable2.setStroke(Math.max(i, (int) fM4806mz), z3 ? -12959156 : -1972757);
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
                AlertDialog alertDialogM4720U = MainActivity.this.m4720U(new AlertDialog.Builder(MainActivity.this, AbstractC2803S4.f10513mjFkc).setView(linearLayout));
                MainActivity.this.m4840u(alertDialogM4720U, 580.0f);
                if (!this.f4499JHa) {
                    MainActivity.this.m4727UokA(alertDialogM4720U);
                }
                alertDialogArr[0] = alertDialogM4720U;
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Vu */
    public class RunnableC0998Vu implements Runnable {
        public RunnableC0998Vu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4697O();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$WGXroI */
    public class DialogInterfaceOnClickListenerC0999WGXroI implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0999WGXroI() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4793k();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$WrLQs */
    public class RunnableC1000WrLQs implements Runnable {
        public RunnableC1000WrLQs() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4645CrDc(true);
            MainActivity.this.m4747a(true);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XD */
    public class RunnableC1001XD implements Runnable {
        public RunnableC1001XD() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f4259YoKzxo != null) {
                MainActivity.this.f4259YoKzxo.setText(MainActivity.this.f4236MiMN.toString());
                if (MainActivity.this.f4287rkYL != null) {
                    MainActivity.this.f4287rkYL.fullScroll(130);
                }
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XDdeP */
    public class ViewOnClickListenerC1002XDdeP implements View.OnClickListener {
        public ViewOnClickListenerC1002XDdeP() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.f4300xrEuO.canGoBack()) {
                MainActivity.this.f4300xrEuO.goBack();
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XFUzSY */
    public class RunnableC1003XFUzSY implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ File f4515AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4516mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$XFUzSY$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ Socket f4519mjFkc;

            public mjFkc(Socket socket) {
                this.f4519mjFkc = socket;
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
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f4519mjFkc.getInputStream()));
                        String line2 = bufferedReader.readLine();
                        do {
                            line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                        } while (line.length() > 0);
                        OutputStream outputStream = this.f4519mjFkc.getOutputStream();
                        if (line2 != null) {
                            if (line2.startsWith("GET /" + RunnableC1003XFUzSY.this.f4516mjFkc)) {
                                FileInputStream fileInputStream = new FileInputStream(RunnableC1003XFUzSY.this.f4515AZxh);
                                outputStream.write(("HTTP/1.1 200 OK\\r\\nContent-Type: application/vnd.android.package-archive\\r\\nContent-Length: " + RunnableC1003XFUzSY.this.f4515AZxh.length() + "\\r\\nConnection: close\\r\\n\\r\\n").getBytes("UTF-8"));
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
                        this.f4519mjFkc.close();
                    } catch (Exception unused) {
                        this.f4519mjFkc.close();
                    }
                } catch (Exception unused2) {
                }
            }
        }

        public RunnableC1003XFUzSY(String str, File file) {
            this.f4516mjFkc = str;
            this.f4515AZxh = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (MainActivity.this.f4284qGY != null && !MainActivity.this.f4284qGY.isClosed()) {
                try {
                    new Thread(new mjFkc(MainActivity.this.f4284qGY.accept())).start();
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XV */
    public class RunnableC1004XV implements Runnable {
        public RunnableC1004XV() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            String str;
            try {
                str = MainActivity.this.getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
                str = BuildConfig.f24315FLAVOR;
            }
            if (str == null || !str.startsWith("3.2")) {
                MainActivity.this.f4271giT = true;
                MainActivity.this.m4737Y("正在下载 3.2 个人中心…");
                File fileM4859yRYQP = MainActivity.this.m4859yRYQP("https://app.aibangos.xyz/dgrzx.apk", "/storage/emulated/0/Download/dgrzx_3.2.apk");
                if (fileM4859yRYQP == null) {
                    MainActivity.this.m4737Y("✗ 下载失败，请检查网络");
                    return;
                }
                MainActivity.this.m4750aQ("[+] 3.2 个人中心下载完成，开始安装");
                MainActivity.this.m4737Y("正在安装 3.2 个人中心…");
                MainActivity.this.m4788jIShy(fileM4859yRYQP.getAbsolutePath());
                long jCurrentTimeMillis = System.currentTimeMillis() + 90000;
                while (System.currentTimeMillis() < jCurrentTimeMillis) {
                    try {
                        String str2 = MainActivity.this.getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
                        if (str2 != null && str2.startsWith("3.2")) {
                            MainActivity.this.m4750aQ("[+] 3.2 个人中心已就绪");
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused3) {
                        return;
                    }
                }
                MainActivity.this.m4750aQ("[!] 3.2 个人中心安装未完成");
                MainActivity.this.m4737Y("✗ 安装未完成，请重试");
                return;
            }
            MainActivity.this.m4671HRWx();
            try {
                Thread.sleep(800L);
            } catch (InterruptedException unused4) {
            }
            MainActivity.this.m4766e0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XbiWeM */
    public class RunnableC1005XbiWeM implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ Uri f4522mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$XbiWeM$AZxh */
        public class AZxh implements Runnable {
            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4733X("本地 APK 已就绪，正在安装...");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$XbiWeM$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4733X("启动本地服务失败");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$XbiWeM$wA */
        public class wA implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ Exception f4526mjFkc;

            public wA(Exception exc) {
                this.f4526mjFkc = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4733X("处理失败: " + this.f4526mjFkc.getMessage());
            }
        }

        public RunnableC1005XbiWeM(Uri uri) {
            this.f4522mjFkc = uri;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            String string;
            int columnIndex;
            try {
                Cursor cursorQuery = MainActivity.this.getContentResolver().query(this.f4522mjFkc, null, null, null, null);
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
                    MainActivity.this.m4750aQ("[!] 本地 APK 处理失败: " + e);
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
            InputStream inputStreamOpenInputStream = MainActivity.this.getContentResolver().openInputStream(this.f4522mjFkc);
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
            String strM4781i0 = MainActivity.this.m4781i0(file2);
            if (strM4781i0 == null) {
                MainActivity.this.runOnUiThread(new mjFkc());
                return;
            }
            MainActivity.this.m4750aQ("[*] 本地 APK 服务已启动: " + strM4781i0);
            MainActivity.this.runOnUiThread(new AZxh());
            MainActivity.this.m4683Jkjs(strM4781i0, null, null);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XgAT */
    public class RunnableC1006XgAT implements Runnable {
        public RunnableC1006XgAT() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.m4805mh(mainActivity.f4233KLMXS.getText().toString());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XtE */
    public class RunnableC1007XtE implements Runnable {
        public RunnableC1007XtE() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdbConnectionManager.m4920bbzow("settings put global http_proxy :0; settings delete global http_proxy");
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Xxz */
    public class DialogInterfaceOnKeyListenerC1008Xxz implements DialogInterface.OnKeyListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Dialog f4530mjFkc;

        public DialogInterfaceOnKeyListenerC1008Xxz(Dialog dialog) {
            this.f4530mjFkc = dialog;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (MainActivity.this.f4303zvd != null && MainActivity.this.f4303zvd.getVisibility() == 0) {
                MainActivity.this.m4855xIpq(this.f4530mjFkc);
                return true;
            }
            if (MainActivity.this.f4300xrEuO == null || !MainActivity.this.f4300xrEuO.canGoBack()) {
                MainActivity.this.m4855xIpq(this.f4530mjFkc);
                return true;
            }
            MainActivity.this.f4300xrEuO.goBack();
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$XyP */
    public class RunnableC1009XyP implements Runnable {
        public RunnableC1009XyP() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("bg_scale", "center").apply();
            MainActivity.this.m4756bVfe();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$YoKzxo */
    public class DialogInterfaceOnClickListenerC1010YoKzxo implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1010YoKzxo() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ZGL */
    public class DialogInterfaceOnClickListenerC1011ZGL implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4534mjFkc;

        public DialogInterfaceOnClickListenerC1011ZGL(EditText editText) {
            this.f4534mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.f4534mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            MainActivity.this.m4788jIShy(strTrim);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$Zdbk */
    public class RunnableC1012Zdbk implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4536mjFkc;

        public RunnableC1012Zdbk(EditText editText) {
            this.f4536mjFkc = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4536mjFkc.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f4536mjFkc, 0);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ZfxDd */
    public class ViewOnClickListenerC1013ZfxDd implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4538mjFkc;

        public ViewOnClickListenerC1013ZfxDd(AlertDialog alertDialog) {
            this.f4538mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4538mjFkc.dismiss();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$aDq */
    public class ViewOnTouchListenerC1014aDq implements View.OnTouchListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ float f4540mjFkc;

        public ViewOnTouchListenerC1014aDq(float f) {
            this.f4540mjFkc = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.animate().cancel();
                view.animate().scaleX(0.96f).scaleY(0.96f).translationZ(this.f4540mjFkc * 6.0f).setDuration(90L).start();
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

    /* renamed from: com.jc.code.v3.MainActivity$alEkx */
    public class RunnableC1015alEkx implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$alEkx$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("✓ ADB 权限已断开");
                MainActivity.this.m4747a(true);
            }
        }

        public RunnableC1015alEkx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4750aQ("\n[*] 断开 ADB 权限...");
            try {
                AdbConnectionManager.m4892JBhc("pkill -f 'jc_adb[_]bridge'");
                MainActivity.this.m4750aQ("[*] 本地 ADB 通道已停止");
            } catch (Throwable th) {
                MainActivity.this.m4750aQ("[*] 停止本地通道: " + MainActivity.m4563mYYU(th));
            }
            try {
                AdbConnectionManager.m4940vI();
                AdbConnectionManager.m4930mByQ(AdbConnectionManager.m4884CqaNbM());
                LocalAdbBridge.resetReady();
                MainActivity.this.m4750aQ("[*] 配对身份已删除");
            } catch (Throwable th2) {
                MainActivity.this.m4750aQ("[!] 清理配对: " + MainActivity.m4563mYYU(th2));
            }
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
            MainActivity.this.m4750aQ("[+] ADB 权限已断开");
            MainActivity.this.f4281mjFkc.post(new mjFkc());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$aqHPIZ */
    public class RunnableC1016aqHPIZ implements Runnable {
        public RunnableC1016aqHPIZ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4847vL();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$bWIyu */
    public class RunnableC1017bWIyu implements Runnable {
        public RunnableC1017bWIyu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("bg_scale", "stretch").apply();
            MainActivity.this.m4756bVfe();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$bbzow */
    public class RunnableC1018bbzow implements Runnable {
        public RunnableC1018bbzow() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4661FoO();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$bc */
    public class RunnableC1019bc implements Runnable {
        public RunnableC1019bc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.f4258XtE) {
                MainActivity.this.m4845vBFMCS();
            } else {
                MainActivity.this.m4779h0(true);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$cMLeY */
    public class DialogInterfaceOnClickListenerC1020cMLeY implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1020cMLeY() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$cdjp */
    public class RunnableC1021cdjp implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ LinearLayout f4549mjFkc;

        public RunnableC1021cdjp(LinearLayout linearLayout) {
            this.f4549mjFkc = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4549mjFkc.setVisibility(8);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$dGDT */
    public class C1022dGDT implements TextView.OnEditorActionListener {

        /* renamed from: AZxh */
        public final /* synthetic */ Runnable f4550AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4551mjFkc;

        public C1022dGDT(EditText editText, Runnable runnable) {
            this.f4551mjFkc = editText;
            this.f4550AZxh = runnable;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 2 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            String strTrim = this.f4551mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return true;
            }
            MainActivity.this.f4233KLMXS.setText(strTrim);
            this.f4550AZxh.run();
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$diqgf */
    public class ViewOnClickListenerC1023diqgf implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4553AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ TextView f4554JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ LinearLayout f4555KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ LinearLayout f4556ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean[] f4558mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ TextView f4559wA;

        /* renamed from: xJ */
        public final /* synthetic */ EditText f4560xJ;

        public ViewOnClickListenerC1023diqgf(boolean[] zArr, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, EditText editText) {
            this.f4558mjFkc = zArr;
            this.f4553AZxh = textView;
            this.f4559wA = textView2;
            this.f4556ZfxDd = linearLayout;
            this.f4555KLFTb = linearLayout2;
            this.f4554JHa = textView3;
            this.f4560xJ = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4558mjFkc[0] = false;
            MainActivity.this.m4802m0(this.f4553AZxh, true);
            MainActivity.this.m4802m0(this.f4559wA, false);
            this.f4556ZfxDd.setVisibility(0);
            this.f4555KLFTb.setVisibility(8);
            this.f4554JHa.setText("  adb shell · uid 2000");
            this.f4560xJ.setHint("输入 shell 命令...");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$dkKKW */
    public class DialogInterfaceOnClickListenerC1024dkKKW implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4562mjFkc;

        public DialogInterfaceOnClickListenerC1024dkKKW(String str) {
            this.f4562mjFkc = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4683Jkjs(this.f4562mjFkc, null, null);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$dm */
    public class DialogInterfaceOnClickListenerC1025dm implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1025dm() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4816p();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$eEOGOh */
    public class RunnableC1026eEOGOh implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4564AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4565mjFkc;

        public RunnableC1026eEOGOh(boolean z, String str) {
            this.f4565mjFkc = z;
            this.f4564AZxh = str;
        }

        @Override // java.lang.Runnable
        public void run() throws PackageManager.NameNotFoundException {
            if (this.f4565mjFkc) {
                try {
                    MainActivity.this.getPackageManager().getPackageInfo(this.f4564AZxh, 0);
                    MainActivity.this.m4750aQ("[+] 安装成功!");
                    MainActivity.this.m4737Y("✓ 安装成功: " + this.f4564AZxh);
                } catch (Exception unused) {
                    MainActivity.this.m4750aQ("[!] 未检测到安装");
                    MainActivity.this.m4737Y("✗ 未检测到安装结果");
                }
            }
            MainActivity.this.m4745ZlB();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$eQ */
    public class ViewOnClickListenerC1027eQ implements View.OnClickListener {
        public ViewOnClickListenerC1027eQ() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.f4300xrEuO.canGoForward()) {
                MainActivity.this.f4300xrEuO.goForward();
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$eyqo */
    public class ViewOnClickListenerC1028eyqo implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4568AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ TextView f4569JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ LinearLayout f4570KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ LinearLayout f4571ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean[] f4573mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ TextView f4574wA;

        /* renamed from: xJ */
        public final /* synthetic */ EditText f4575xJ;

        public ViewOnClickListenerC1028eyqo(boolean[] zArr, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, EditText editText) {
            this.f4573mjFkc = zArr;
            this.f4568AZxh = textView;
            this.f4574wA = textView2;
            this.f4571ZfxDd = linearLayout;
            this.f4570KLFTb = linearLayout2;
            this.f4569JHa = textView3;
            this.f4575xJ = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!MainActivity.this.m4686KbpP()) {
                MainActivity.this.m4733X("✗ 未激活设备所有者，请先「申请设备所有者」");
                return;
            }
            this.f4573mjFkc[0] = true;
            MainActivity.this.m4802m0(this.f4568AZxh, false);
            MainActivity.this.m4802m0(this.f4574wA, true);
            this.f4571ZfxDd.setVisibility(8);
            this.f4570KLFTb.setVisibility(0);
            this.f4569JHa.setText("  device-owner · OW");
            this.f4575xJ.setHint("输入 OW 命令（help 查看列表）...");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$fFz */
    public class ViewOnClickListenerC1029fFz implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4577mjFkc;

        public ViewOnClickListenerC1029fFz(AlertDialog alertDialog) {
            this.f4577mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            this.f4577mjFkc.dismiss();
            MainActivity.this.m4712RnaHj(true);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$fLidf */
    public class RunnableC1030fLidf implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ StringBuilder f4579mjFkc;

        public RunnableC1030fLidf(StringBuilder sb) {
            this.f4579mjFkc = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4718T("服务绑定探测", this.f4579mjFkc.toString());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$fehf */
    public class ViewOnClickListenerC1031fehf implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Runnable f4581mjFkc;

        public ViewOnClickListenerC1031fehf(Runnable runnable) {
            this.f4581mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4581mjFkc.run();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$gYa */
    public class RunnableC1033gYa implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4596mjFkc;

        public RunnableC1033gYa(String str) {
            this.f4596mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) MainActivity.this.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("ADB 配对码", this.f4596mjFkc));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$giT */
    public class RunnableC1034giT implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4598mjFkc;

        public RunnableC1034giT(int i) {
            this.f4598mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.f4247Ucbh != null) {
                    MainActivity.this.f4247Ucbh.setProgress(this.f4598mjFkc);
                }
                if (MainActivity.this.f4265diqgf != null) {
                    MainActivity.this.f4265diqgf.setText(this.f4598mjFkc + "%");
                }
                if (MainActivity.this.f4269fehf == null || !MainActivity.this.f4269fehf.isShowing()) {
                    return;
                }
                MainActivity.this.f4269fehf.setProgress(this.f4598mjFkc);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$gjvQ */
    public static class C1035gjvQ {

        /* renamed from: AZxh */
        public final C1040ih f4599AZxh;

        /* renamed from: mjFkc */
        public final String f4600mjFkc;

        public C1035gjvQ(String str, C1040ih c1040ih) {
            this.f4600mjFkc = str;
            this.f4599AZxh = c1040ih;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$gtIJp */
    public class C1036gtIJp implements AdbConnectionManager.qGY {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4602mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$gtIJp$AZxh */
        public class AZxh implements Runnable {

            /* renamed from: com.jc.code.v3.MainActivity$gtIJp$AZxh$mjFkc */
            public class mjFkc implements Runnable {
                public mjFkc() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.m4637BOPu();
                }
            }

            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("adb_paired", true).putBoolean("adb_pairing_verified", true).putString("adb_pairing_id", C1036gtIJp.this.f4602mjFkc).apply();
                MainActivity.this.m4750aQ("[ADB] 自动配对成功，本机 ADB 连接已建立");
                MainActivity.this.m4835s0("ADB 配对成功，安装/卸载已切换为 ADB");
                MainActivity.this.m4765e();
                MainActivity.this.m4640C0("配对成功，安装/卸载已切换为 ADB", false);
                MainActivity.this.f4281mjFkc.postDelayed(new mjFkc(), 3000L);
                MainActivity.this.m4747a(true);
                MainActivity.this.m4645CrDc(true);
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$gtIJp$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4606mjFkc;

            public mjFkc(String str) {
                this.f4606mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4750aQ("[ADB] " + this.f4606mjFkc);
                MainActivity.this.m4640C0(this.f4606mjFkc, true);
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$gtIJp$wA */
        public class wA implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4608mjFkc;

            /* renamed from: com.jc.code.v3.MainActivity$gtIJp$wA$mjFkc */
            public class mjFkc implements Runnable {
                public mjFkc() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.m4637BOPu();
                }
            }

            public wA(String str) {
                this.f4608mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4750aQ("[ADB] " + this.f4608mjFkc);
                MainActivity.this.m4835s0(this.f4608mjFkc);
                MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
                MainActivity.this.m4640C0("配对失败：" + this.f4608mjFkc, false);
                MainActivity.this.f4281mjFkc.postDelayed(new mjFkc(), 6000L);
                MainActivity.this.m4765e();
            }
        }

        public C1036gtIJp(String str) {
            this.f4602mjFkc = str;
        }

        @Override // com.jc.code.v3.AdbConnectionManager.qGY
        /* renamed from: AZxh */
        public void mo4871AZxh() {
            MainActivity.this.f4281mjFkc.post(new AZxh());
        }

        @Override // com.jc.code.v3.AdbConnectionManager.qGY
        /* renamed from: mjFkc */
        public void mo4872mjFkc(String str) {
            MainActivity.this.f4281mjFkc.post(new mjFkc(str));
        }

        @Override // com.jc.code.v3.AdbConnectionManager.qGY
        /* renamed from: wA */
        public void mo4873wA(String str) {
            MainActivity.this.f4281mjFkc.post(new wA(str));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$gtr */
    public class RunnableC1037gtr implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4611mjFkc;

        public RunnableC1037gtr(String str) {
            this.f4611mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4718T("系统能力检测", this.f4611mjFkc);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$huTpC */
    public class RunnableC1038huTpC implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4612AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ScrollView[] f4614ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean[] f4615mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ TextView[] f4616wA;

        public RunnableC1038huTpC(boolean[] zArr, String str, TextView[] textViewArr, ScrollView[] scrollViewArr) {
            this.f4615mjFkc = zArr;
            this.f4612AZxh = str;
            this.f4616wA = textViewArr;
            this.f4614ZfxDd = scrollViewArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4615mjFkc[0]) {
                MainActivity.this.m4719Tz(this.f4612AZxh, this.f4616wA[0], this.f4614ZfxDd[0]);
            } else {
                MainActivity.this.m4821prww(this.f4612AZxh, this.f4616wA[0], this.f4614ZfxDd[0]);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jTNPnW */
    public class RunnableC1041jTNPnW implements Runnable {
        public RunnableC1041jTNPnW() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4287rkYL.fullScroll(130);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jY */
    public class RunnableC1042jY implements Runnable {
        public RunnableC1042jY() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4648DanUFX();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jm */
    public class RunnableC1043jm implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$jm$AZxh */
        public class AZxh implements Runnable {
            public AZxh() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("✗ 拉起验证页失败，请看运行日志");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jm$KLFTb */
        public class KLFTb implements Runnable {
            public KLFTb() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("未捕获到验证请求");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jm$ZfxDd */
        public class ZfxDd implements Runnable {
            public ZfxDd() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("✗ 请先安装 CA 证书再重试");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jm$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("随便输个密码 → 点确定，自动进开发者");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jm$wA */
        public class wA implements Runnable {
            public wA() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4737Y("✓ 开发者已解锁");
            }
        }

        public RunnableC1043jm() {
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
            if (!C1742CBEvIj.m7783JHa().m7791Pq(MainActivity.this)) {
                MainActivity.this.m4750aQ("[!] 内置代理启动失败");
                MainActivity.this.m4737Y("✗ 代理启动失败");
                return;
            }
            boolean z = true;
            MainActivity.this.f4279lti = true;
            MainActivity.this.m4750aQ("[+] 内置代理已启动 127.0.0.1:8888");
            MainActivity.this.m4676Ipwl();
            try {
                AdbConnectionManager.m4920bbzow("settings put global http_proxy 127.0.0.1:8888");
                MainActivity.this.m4750aQ("[+] 系统代理已设置 → 127.0.0.1:8888");
            } catch (Throwable th) {
                MainActivity.this.m4750aQ("[!] 设置系统代理失败: " + MainActivity.m4563mYYU(th));
            }
            MainActivity.this.f4281mjFkc.post(new mjFkc());
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.zuoyebang.iot.pad.zpusercenter", "com.zuoyebang.iot.pad.developer.ui.DeveloperModeRequestActivity"));
                intent.addFlags(268435456);
                MainActivity.this.startActivity(intent);
                try {
                    MainActivity.this.m4750aQ("[+] 已拉起开发者验证页（本地 Intent）");
                } catch (Throwable th2) {
                    th = th2;
                    MainActivity.this.m4750aQ("[!] 本地拉起失败: " + MainActivity.m4563mYYU(th) + "，改走 ADB");
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
                    if (MainActivity.this.f4271giT) {
                    }
                    if (C1742CBEvIj.m7783JHa().m7801xJ() <= 0) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
            if (!z) {
                MainActivity.this.m4676Ipwl();
                try {
                    AdbConnectionManager.m4920bbzow("am start -n com.zuoyebang.iot.pad.zpusercenter/com.zuoyebang.iot.pad.developer.ui.DeveloperModeRequestActivity");
                    MainActivity.this.m4750aQ("[+] 已拉起开发者验证页（ADB am）");
                } catch (Throwable th4) {
                    MainActivity.this.m4750aQ("[!] 拉起验证页失败: " + MainActivity.m4563mYYU(th4));
                    MainActivity.this.f4281mjFkc.post(new AZxh());
                }
            }
            jCurrentTimeMillis = System.currentTimeMillis() + 120000;
            while (System.currentTimeMillis() < jCurrentTimeMillis && C1742CBEvIj.m7783JHa().m7801xJ() <= 0) {
                Thread.sleep(500L);
            }
            if (MainActivity.this.f4271giT) {
                MainActivity.this.f4271giT = false;
                MainActivity.this.m4789jKf();
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException unused2) {
                }
                MainActivity.this.m4780i();
            }
            if (C1742CBEvIj.m7783JHa().m7801xJ() <= 0) {
                MainActivity.this.m4789jKf();
                MainActivity.this.m4750aQ("[+] 验证响应已改写（403→200），开发者已解锁 ✓");
                MainActivity.this.f4281mjFkc.post(new wA());
            } else if (C1742CBEvIj.m7783JHa().m7799qdMbNW()) {
                MainActivity.this.m4750aQ("[!] TLS 握手失败：CA 证书未安装？请点「安装证书」后重试");
                MainActivity.this.f4281mjFkc.post(new ZfxDd());
            } else {
                MainActivity.this.m4750aQ("[!] 120 秒内未捕获验证请求（可点「清理代理」收尾）");
                MainActivity.this.f4281mjFkc.post(new KLFTb());
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jpz */
    public class RunnableC1044jpz implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4636AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ String f4638ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ File f4639mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ boolean f4640wA;

        public RunnableC1044jpz(File file, String str, boolean z, String str2) {
            this.f4639mjFkc = file;
            this.f4636AZxh = str;
            this.f4640wA = z;
            this.f4638ZfxDd = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (MainActivity.this.m4723Uj(this.f4639mjFkc, this.f4636AZxh, this.f4640wA, false)) {
                return;
            }
            MainActivity.this.m4658FNhf(this.f4638ZfxDd, this.f4636AZxh, this.f4640wA);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jtz */
    public class ViewOnClickListenerC1045jtz implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Dialog f4642mjFkc;

        public ViewOnClickListenerC1045jtz(Dialog dialog) {
            this.f4642mjFkc = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.m4855xIpq(this.f4642mjFkc);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$jx */
    public class RunnableC1046jx implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4643AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4645mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ String f4646wA;

        /* renamed from: com.jc.code.v3.MainActivity$jx$AZxh */
        public class AZxh implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ String f4647AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4649mjFkc;

            /* renamed from: wA */
            public final /* synthetic */ String f4650wA;

            public AZxh(String str, String str2, String str3) {
                this.f4649mjFkc = str;
                this.f4647AZxh = str2;
                this.f4650wA = str3;
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                RunnableC1046jx runnableC1046jx = RunnableC1046jx.this;
                MainActivity.this.m4837t(runnableC1046jx.f4645mjFkc, this.f4649mjFkc, this.f4647AZxh, this.f4650wA);
                MainActivity.this.m4737Y("校验完成，已提交应用商店安装：" + this.f4647AZxh + "（应用商店会自行下载安装包，需再下载一次）");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jx$ZfxDd */
        public class ZfxDd implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ String f4652mjFkc;

            public ZfxDd(String str) {
                this.f4652mjFkc = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4718T("下载失败", "无法从该链接下载 APK：\n" + this.f4652mjFkc + "\n\n可能原因：\n· 链接需要登录或特定来源（防盗链）\n· 站点屏蔽了非浏览器请求\n\n建议：用系统浏览器打开该链接下载后，再通过「安装 APK」安装。");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jx$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4718T("下载异常", "下载到的文件不是 APK 安装包（可能是网页跳转页或需要登录/特定来源）。\n\n建议：用系统浏览器打开该链接，或改用其他下载源。");
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$jx$wA */
        public class wA implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ File f4655mjFkc;

            public wA(File file) {
                this.f4655mjFkc = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4655mjFkc.exists()) {
                    this.f4655mjFkc.delete();
                    MainActivity.this.m4750aQ("[*] 临时文件已清理");
                }
            }
        }

        public RunnableC1046jx(String str, String str2, String str3) {
            this.f4645mjFkc = str;
            this.f4643AZxh = str2;
            this.f4646wA = str3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
        
            r6.flush();
            r6.close();
            r5.close();
            r0.disconnect();
            r15.f4644ZfxDd.m4750aQ("[+] APK 已下载: " + (r10 / 1024) + "KB");
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
        
            r0 = r15.f4643AZxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x010b, code lost:
        
            if (r0 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0111, code lost:
        
            if (r0.isEmpty() != false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:
        
            r0 = r15.f4643AZxh;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0116, code lost:
        
            r0 = r15.f4644ZfxDd.m4668HGlNf(r1);
            r15.f4644ZfxDd.m4750aQ("[+] MD5: " + r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0132, code lost:
        
            r2 = "com.external.apk";
            r3 = r15.f4646wA;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0136, code lost:
        
            if (r3 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            if (r3.isEmpty() != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
        
            r3 = r15.f4646wA;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0141, code lost:
        
            r3 = "JCCodeV3";
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0143, code lost:
        
            r4 = r15.f4644ZfxDd.getPackageManager().getPackageArchiveInfo(r1.getAbsolutePath(), 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0151, code lost:
        
            if (r4 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0153, code lost:
        
            r2 = r4.packageName;
            r5 = r15.f4646wA;
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
        
            r3 = r4.applicationInfo.loadLabel(r15.f4644ZfxDd.getPackageManager()).toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0173, code lost:
        
            r15.f4644ZfxDd.m4750aQ("[!] 解析 APK 信息失败: " + r4.getMessage());
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws IOException {
            long j;
            String strM4668HGlNf;
            String str;
            String string;
            try {
                File externalCacheDir = MainActivity.this.getExternalCacheDir();
                if (externalCacheDir == null) {
                    externalCacheDir = MainActivity.this.getCacheDir();
                }
                File file = new File(externalCacheDir, "url_install_" + System.currentTimeMillis() + ".apk");
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4645mjFkc).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36 JCCodeV3");
                String str2 = MainActivity.this.f4286rWxwaT;
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
                    if (MainActivity.this.f4280mByQ) {
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
                        MainActivity.this.m4631A0(i2);
                    }
                }
                MainActivity.this.m4758boLb();
                MainActivity.this.runOnUiThread(new AZxh(strM4668HGlNf, string, str));
                MainActivity.this.f4281mjFkc.postDelayed(new wA(file), 30000L);
                return;
                MainActivity.this.m4758boLb();
                MainActivity.this.m4750aQ("[!] 下载到的不是 APK: " + j + " bytes");
                MainActivity.this.runOnUiThread(new mjFkc());
                file.delete();
            } catch (Exception e) {
                MainActivity.this.m4750aQ("[!] 下载失败: " + e.getMessage());
                MainActivity.this.m4758boLb();
                MainActivity.this.runOnUiThread(new ZfxDd(e.getMessage() != null ? e.getMessage() : "未知错误"));
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$kOlLW */
    public class ViewOnClickListenerC1047kOlLW implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4657mjFkc;

        public ViewOnClickListenerC1047kOlLW(AlertDialog alertDialog) {
            this.f4657mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4657mjFkc.dismiss();
            MainActivity.this.m4660FiDh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$kism */
    public class RunnableC1048kism implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4659mjFkc;

        public RunnableC1048kism(String str) {
            this.f4659mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Toast.makeText(MainActivity.this, this.f4659mjFkc, 0).show();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$knzZ */
    public class RunnableC1049knzZ implements Runnable {
        public RunnableC1049knzZ() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            MainActivity.this.m4844v0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$kw */
    public interface InterfaceC1050kw {
        /* renamed from: mjFkc */
        void mo4866mjFkc(String str);
    }

    /* renamed from: com.jc.code.v3.MainActivity$lB */
    public class DialogInterfaceOnClickListenerC1051lB implements DialogInterface.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4661AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4662mjFkc;

        public DialogInterfaceOnClickListenerC1051lB(TextView textView, ScrollView scrollView) {
            this.f4662mjFkc = textView;
            this.f4661AZxh = scrollView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4801m("set-keyguard-disabled true", this.f4662mjFkc, this.f4661AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$lgHUyS */
    public class RunnableC1052lgHUyS implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4665mjFkc;

        public RunnableC1052lgHUyS(String str) {
            this.f4665mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (MainActivity.this.m4861z0(this.f4665mjFkc)) {
                return;
            }
            if (!MainActivity.this.f4220Dt || MainActivity.this.f4285qdMbNW == null) {
                MainActivity.this.m4750aQ("[!] 无可用卸载通道：ADB 未连接，zybos 未绑定");
                MainActivity.this.m4737Y("✗ 卸载失败：请先完成无线调试配对");
                return;
            }
            try {
                Method methodM4643CO = MainActivity.this.m4643CO("silentUninstallApk", String.class, Boolean.TYPE);
                if (methodM4643CO != null) {
                    methodM4643CO.invoke(MainActivity.this.f4278lgHUyS, this.f4665mjFkc, Boolean.FALSE);
                    MainActivity.this.m4750aQ("[+] 卸载调用成功: " + this.f4665mjFkc);
                } else {
                    MainActivity.this.m4750aQ("[!] silentUninstallApk 未找到");
                    MainActivity.this.m4733X("✗ silentUninstallApk 方法未找到");
                }
            } catch (Exception e) {
                MainActivity.this.m4750aQ("[!] 卸载失败: " + this.f4665mjFkc + " - " + MainActivity.m4563mYYU(e));
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("✗ 卸载失败: ");
                sb.append(MainActivity.m4563mYYU(e));
                mainActivity.m4733X(sb.toString());
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$lti */
    public class ViewOnTouchListenerC1053lti implements View.OnTouchListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ float f4667mjFkc;

        public ViewOnTouchListenerC1053lti(float f) {
            this.f4667mjFkc = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                MainActivity.this.f4297wJVbdd = false;
                MainActivity.this.f4293vI = motionEvent.getRawX();
                MainActivity.this.f4252VocHEe = motionEvent.getRawY();
                MainActivity mainActivity = MainActivity.this;
                mainActivity.f4218BAnRFn = mainActivity.f4223Gd >= 0 ? MainActivity.this.f4223Gd : 0.0f;
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.f4277lB = mainActivity2.f4224HGpJ >= 0 ? MainActivity.this.f4224HGpJ : 0.0f;
                return true;
            }
            if (actionMasked == 1) {
                if (!MainActivity.this.f4297wJVbdd) {
                    MainActivity.this.m4838t0();
                }
                return true;
            }
            if (actionMasked != 2) {
                return false;
            }
            float rawX = motionEvent.getRawX() - MainActivity.this.f4293vI;
            float rawY = motionEvent.getRawY() - MainActivity.this.f4252VocHEe;
            if (Math.abs(rawX) > this.f4667mjFkc * 8.0f || Math.abs(rawY) > this.f4667mjFkc * 8.0f) {
                MainActivity.this.f4297wJVbdd = true;
            }
            if (MainActivity.this.f4297wJVbdd && MainActivity.this.f4225IEE != null && MainActivity.this.f4242Pq != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) MainActivity.this.f4242Pq.getLayoutParams();
                layoutParams.x = (int) (MainActivity.this.f4218BAnRFn + rawX);
                layoutParams.y = (int) (MainActivity.this.f4277lB + rawY);
                MainActivity.this.f4223Gd = layoutParams.x;
                MainActivity.this.f4224HGpJ = layoutParams.y;
                try {
                    MainActivity.this.f4225IEE.updateViewLayout(MainActivity.this.f4242Pq, layoutParams);
                } catch (Exception unused) {
                }
            }
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$mByQ */
    public class C1054mByQ implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4668AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4669mjFkc;

        public C1054mByQ(TextView textView, ScrollView scrollView) {
            this.f4669mjFkc = textView;
            this.f4668AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4822q("pm disable-user --user 0 " + str + " && am force-stop " + str, this.f4669mjFkc, this.f4668AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$mPWV */
    public class DialogInterfaceOnClickListenerC1055mPWV implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4672mjFkc;

        public DialogInterfaceOnClickListenerC1055mPWV(String str) {
            this.f4672mjFkc = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4683Jkjs(this.f4672mjFkc, null, null);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$mjFkc */
    public class RunnableC1056mjFkc implements Runnable {
        public RunnableC1056mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4639C();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$mzUGzO */
    public class RunnableC1057mzUGzO implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4675mjFkc;

        public RunnableC1057mzUGzO(String str) {
            this.f4675mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("device_code", this.f4675mjFkc));
            MainActivity.this.m4733X("设备码已复制: " + this.f4675mjFkc);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$nUaNy */
    public class RunnableC1058nUaNy implements Runnable {
        public RunnableC1058nUaNy() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4667HBzZAD(AdbConnectionManager.m4939uHVRx(), MainActivity.this.m4686KbpP(), true);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$np */
    public class RunnableC1059np implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4677AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4678mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$np$AZxh */
        public class AZxh implements View.OnClickListener {
            public AZxh() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$np$mjFkc */
        public class mjFkc implements View.OnTouchListener {
            public mjFkc() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public RunnableC1059np(String str, String str2) {
            this.f4678mjFkc = str;
            this.f4677AZxh = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing()) {
                return;
            }
            MainActivity.this.f4288tISON = this.f4678mjFkc + "||" + this.f4677AZxh;
            MainActivity.this.m4762d();
            float fM4806mz = MainActivity.this.m4806mz();
            boolean z = MainActivity.this.f4298xJ;
            FrameLayout frameLayout = new FrameLayout(MainActivity.this);
            frameLayout.setBackgroundColor(z ? -15460839 : -723207);
            frameLayout.setClickable(true);
            frameLayout.setFocusable(true);
            frameLayout.setOnTouchListener(new mjFkc());
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            int i = (int) (32.0f * fM4806mz);
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
            int i2 = (int) (52.0f * fM4806mz);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(i2, i2));
            TextView textView2 = new TextView(MainActivity.this);
            textView2.setText(this.f4678mjFkc);
            textView2.setTextSize(18.0f);
            textView2.setTypeface(typeface);
            textView2.setTextColor(z ? -1842205 : -14737633);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (18.0f * fM4806mz);
            linearLayout.addView(textView2, layoutParams);
            TextView textView3 = new TextView(MainActivity.this);
            textView3.setText(this.f4677AZxh);
            textView3.setTextSize(13.0f);
            textView3.setTextColor(z ? -6643546 : -10525848);
            textView3.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = (int) (10.0f * fM4806mz);
            linearLayout.addView(textView3, layoutParams2);
            TextView textView4 = new TextView(MainActivity.this);
            textView4.setText("退出");
            textView4.setTextSize(14.0f);
            textView4.setTextColor(z ? -6643546 : -10525848);
            textView4.setGravity(17);
            int i3 = (int) (28.0f * fM4806mz);
            int i4 = (int) (11.0f * fM4806mz);
            textView4.setPadding(i3, i4, i3, i4);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(22.0f * fM4806mz);
            gradientDrawable2.setColor(z ? -13881549 : -1512723);
            textView4.setBackground(gradientDrawable2);
            textView4.setOnClickListener(new AZxh());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = (int) (fM4806mz * 24.0f);
            linearLayout.addView(textView4, layoutParams3);
            ((ViewGroup) MainActivity.this.getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            MainActivity.this.f4291uH = frameLayout;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$nxI */
    public class DialogInterfaceOnClickListenerC1060nxI implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1060nxI() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$oCFDzJ */
    public class DialogInterfaceOnClickListenerC1061oCFDzJ implements DialogInterface.OnClickListener {

        /* renamed from: com.jc.code.v3.MainActivity$oCFDzJ$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() throws InterruptedException, IOException {
                MainActivity.this.m4774gYsXfP();
            }
        }

        public DialogInterfaceOnClickListenerC1061oCFDzJ() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            new Thread(new mjFkc()).start();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$oJ */
    public class RunnableC1062oJ implements Runnable {
        public RunnableC1062oJ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().remove("search_bg_uri").apply();
            MainActivity.this.m4733X("搜索页背景已恢复默认");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$oVXlhB */
    public class RunnableC1063oVXlhB implements Runnable {
        public RunnableC1063oVXlhB() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4741YuaD();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$oaI */
    public class RunnableC1064oaI implements Runnable {
        public RunnableC1064oaI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4729V();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$pJeaSR */
    public class RunnableC1065pJeaSR implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4688AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4690mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ String f4691wA;

        /* renamed from: com.jc.code.v3.MainActivity$pJeaSR$AZxh */
        public class AZxh implements View.OnClickListener {
            public AZxh() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.m4772g0();
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$pJeaSR$mjFkc */
        public class mjFkc implements View.OnTouchListener {
            public mjFkc() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$pJeaSR$wA */
        public class wA implements View.OnClickListener {
            public wA() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        }

        public RunnableC1065pJeaSR(boolean z, String str, String str2) {
            this.f4690mjFkc = z;
            this.f4688AZxh = str;
            this.f4691wA = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.isFinishing()) {
                return;
            }
            MainActivity.this.m4760c();
            float fM4806mz = MainActivity.this.m4806mz();
            boolean z = MainActivity.this.f4298xJ;
            FrameLayout frameLayout = new FrameLayout(MainActivity.this);
            frameLayout.setBackgroundColor(z ? -15460839 : -723207);
            frameLayout.setClickable(true);
            frameLayout.setFocusable(true);
            frameLayout.setOnTouchListener(new mjFkc());
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            int i = (int) (32.0f * fM4806mz);
            linearLayout.setPadding(i, i, i, i);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 17));
            if (this.f4690mjFkc) {
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
                int i2 = (int) (52.0f * fM4806mz);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(i2, i2));
            } else {
                int i3 = (int) (40.0f * fM4806mz);
                linearLayout.addView(new ProgressBar(MainActivity.this), new LinearLayout.LayoutParams(i3, i3));
            }
            TextView textView2 = new TextView(MainActivity.this);
            textView2.setText(this.f4688AZxh);
            textView2.setTextSize(17.0f);
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView2.setTypeface(typeface);
            textView2.setTextColor(z ? -1842205 : -14737633);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (18.0f * fM4806mz);
            linearLayout.addView(textView2, layoutParams);
            TextView textView3 = new TextView(MainActivity.this);
            textView3.setText(this.f4691wA);
            textView3.setTextSize(13.0f);
            textView3.setTextColor(z ? -6643546 : -10525848);
            textView3.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = (int) (10.0f * fM4806mz);
            linearLayout.addView(textView3, layoutParams2);
            if (this.f4690mjFkc) {
                LinearLayout linearLayout2 = new LinearLayout(MainActivity.this);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(17);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.topMargin = (int) (24.0f * fM4806mz);
                TextView textView4 = new TextView(MainActivity.this);
                textView4.setText("重试");
                textView4.setTextSize(14.0f);
                textView4.setTypeface(typeface);
                textView4.setTextColor(-1);
                textView4.setGravity(17);
                int i4 = (int) (28.0f * fM4806mz);
                int i5 = (int) (11.0f * fM4806mz);
                textView4.setPadding(i4, i5, i4, i5);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float f = fM4806mz * 22.0f;
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
                layoutParams4.leftMargin = (int) (fM4806mz * 12.0f);
                linearLayout2.addView(textView5, layoutParams4);
                linearLayout.addView(linearLayout2, layoutParams3);
            }
            ((ViewGroup) MainActivity.this.getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            MainActivity.this.f4268fFz = frameLayout;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$peCqC */
    public class ViewOnClickListenerC1066peCqC implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ AlertDialog f4696mjFkc;

        public ViewOnClickListenerC1066peCqC(AlertDialog alertDialog) {
            this.f4696mjFkc = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4696mjFkc.cancel();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$qGY */
    public class DialogInterfaceOnClickListenerC1067qGY implements DialogInterface.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ InterfaceC1050kw f4697AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4698mjFkc;

        public DialogInterfaceOnClickListenerC1067qGY(EditText editText, InterfaceC1050kw interfaceC1050kw) {
            this.f4698mjFkc = editText;
            this.f4697AZxh = interfaceC1050kw;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strReplaceAll = this.f4698mjFkc.getText().toString().trim().replaceAll("[^A-Za-z0-9._]", BuildConfig.f24315FLAVOR);
            if (strReplaceAll.isEmpty()) {
                return;
            }
            this.f4697AZxh.mo4866mjFkc(strReplaceAll);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$qGgY */
    public class RunnableC1068qGgY implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4701mjFkc;

        public RunnableC1068qGgY(boolean z) {
            this.f4701mjFkc = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM4563mYYU;
            String strFetchStatus;
            boolean z;
            String strM4696NU = MainActivity.this.m4696NU();
            boolean z2 = false;
            if (strM4696NU != null) {
                MainActivity.this.m4750aQ("[开关] 检测到" + strM4696NU + "，拒绝验证");
                MainActivity.this.f4235LREOK = false;
                MainActivity.this.m4726UmFn("检测到" + strM4696NU + "，请关闭 VPN / 网络代理后重试");
                return;
            }
            String strM4632Ab = MainActivity.this.m4632Ab();
            if (strM4632Ab != null) {
                MainActivity.this.m4750aQ("[开关] 安全校验失败: " + strM4632Ab);
                MainActivity.this.f4235LREOK = false;
                MainActivity.this.m4839tyXzYJ("安全校验失败", strM4632Ab);
                return;
            }
            if (!MainActivity.this.m4641CBEvIj()) {
                MainActivity.this.m4750aQ("[开关] 安装包签名校验失败（疑似被修改）");
                MainActivity.this.m4839tyXzYJ("完整性校验失败", "应用文件已被修改，请从官方渠道重新安装。");
                return;
            }
            try {
                strFetchStatus = CloudGateClient.fetchStatus("?v=3.2.6&d=" + MainActivity.this.m4850wfQA() + "&_=" + System.currentTimeMillis());
                strM4563mYYU = BuildConfig.f24315FLAVOR;
            } catch (Throwable th) {
                strM4563mYYU = MainActivity.m4563mYYU(th);
                strFetchStatus = null;
            }
            if (strFetchStatus == null) {
                MainActivity.this.m4750aQ("[开关] 验证失败: " + strM4563mYYU);
                MainActivity.this.m4726UmFn(strM4563mYYU);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strFetchStatus);
                if (jSONObject.optBoolean("banned", false)) {
                    MainActivity.this.m4750aQ("[开关] 本设备已被列入黑名单（" + MainActivity.this.m4850wfQA() + "）");
                    MainActivity.this.f4235LREOK = false;
                    MainActivity.this.m4839tyXzYJ("设备已禁用", "此设备已被管理员禁用。\n\n如有疑问请联系处理。");
                    return;
                }
                boolean z3 = jSONObject.has("enabled") && jSONObject.optBoolean("enabled", false);
                String strOptString = jSONObject.optString("latest", "0");
                String strOptString2 = jSONObject.optString("force_min", "0");
                String strOptString3 = jSONObject.optString("url", BuildConfig.f24315FLAVOR);
                String strOptString4 = jSONObject.optString("msg", BuildConfig.f24315FLAVOR);
                if (!z3) {
                    MainActivity.this.m4750aQ("[开关] 服务器已停用本应用");
                    MainActivity.this.f4235LREOK = false;
                    MainActivity.this.m4839tyXzYJ("服务已停止", strOptString4);
                    return;
                }
                String strM4848vdbwS = MainActivity.this.m4848vdbwS(jSONObject.optString("block_pkgs", BuildConfig.f24315FLAVOR));
                if (strM4848vdbwS != null) {
                    MainActivity.this.m4750aQ("[开关] 命中包名黑名单: " + strM4848vdbwS);
                    MainActivity.this.f4235LREOK = false;
                    MainActivity.this.m4839tyXzYJ("无法使用", "检测到不兼容的应用（" + strM4848vdbwS + "），请卸载后重试。\n\n如有疑问请联系处理。");
                    return;
                }
                if (MainActivity.this.m4800lEH()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() + (this.f4701mjFkc ? 2500L : 8000L);
                    while (true) {
                        try {
                            String strM4920bbzow = AdbConnectionManager.m4920bbzow("id");
                            if (strM4920bbzow != null && strM4920bbzow.contains("uid=2000")) {
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
                boolean zM4686KbpP = MainActivity.this.m4686KbpP();
                MainActivity.this.m4750aQ("[开关] 验证通过 · 最新 " + strOptString + " · 强制下限 " + strOptString2);
                MainActivity.this.m4667HBzZAD(z, zM4686KbpP, this.f4701mjFkc);
                MainActivity.this.m4670HPA();
                if (jSONObject.optBoolean("popup_on", false)) {
                    MainActivity.this.m4713S(jSONObject.optString("popup_title", BuildConfig.f24315FLAVOR), jSONObject.optString("popup_msg", BuildConfig.f24315FLAVOR), jSONObject.optString("popup_img", BuildConfig.f24315FLAVOR), jSONObject.optString("popup_buttons", BuildConfig.f24315FLAVOR), jSONObject.optBoolean("popup_dismissable", false), jSONObject.optBoolean("popup_auto_close", false));
                }
                if (this.f4701mjFkc || MainActivity.m4522cOuJ("3.2.6", strOptString) >= 0) {
                    return;
                }
                if (strOptString2 != null && strOptString2.length() > 0 && !"0".equals(strOptString2) && MainActivity.m4522cOuJ("3.2.6", strOptString2) < 0) {
                    z2 = true;
                }
                MainActivity mainActivity = MainActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append("[开关] ");
                sb.append(z2 ? "必须强制更新" : "有新版本");
                sb.append(" → ");
                sb.append(strOptString);
                mainActivity.m4750aQ(sb.toString());
                MainActivity.this.m4748a0(z2, strOptString, strOptString3, strOptString4);
            } catch (Throwable th2) {
                MainActivity.this.m4750aQ("[开关] 响应解析失败: " + MainActivity.m4563mYYU(th2));
                MainActivity.this.m4726UmFn("验证服务器响应异常");
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$qdMbNW */
    public class DialogInterfaceOnClickListenerC1069qdMbNW implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC1069qdMbNW() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4833rtBEoQ();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$qrxT */
    public class RunnableC1070qrxT implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ ImageView f4703AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4704mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$qrxT$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ Bitmap f4707mjFkc;

            public mjFkc(Bitmap bitmap) {
                this.f4707mjFkc = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC1070qrxT.this.f4703AZxh.setImageBitmap(this.f4707mjFkc);
                RunnableC1070qrxT.this.f4703AZxh.setVisibility(0);
            }
        }

        public RunnableC1070qrxT(String str, ImageView imageView) {
            this.f4704mjFkc = str;
            this.f4703AZxh = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4704mjFkc).openConnection();
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
                    MainActivity.this.f4281mjFkc.post(new mjFkc(bitmapDecodeByteArray));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$qtZIjO */
    public static class C1071qtZIjO {

        /* renamed from: AZxh */
        public String f4708AZxh;

        /* renamed from: Dt */
        public String f4709Dt;

        /* renamed from: ETF */
        public boolean f4710ETF;

        /* renamed from: IEE */
        public GradientDrawable f4711IEE;

        /* renamed from: JHa */
        public boolean f4712JHa;

        /* renamed from: KLFTb */
        public Runnable f4713KLFTb;

        /* renamed from: MiMN */
        public View f4714MiMN;

        /* renamed from: VA */
        public boolean f4715VA;

        /* renamed from: YoKzxo */
        public TextView f4716YoKzxo;

        /* renamed from: ZfxDd */
        public int f4717ZfxDd;

        /* renamed from: fehf */
        public ImageView f4718fehf;

        /* renamed from: lgHUyS */
        public boolean f4719lgHUyS;

        /* renamed from: mjFkc */
        public String f4720mjFkc;

        /* renamed from: qGY */
        public ImageView f4721qGY;

        /* renamed from: qdMbNW */
        public boolean f4722qdMbNW;

        /* renamed from: rkYL */
        public TextView f4723rkYL;

        /* renamed from: wA */
        public int f4724wA;

        /* renamed from: xJ */
        public boolean f4725xJ;

        public C1071qtZIjO() {
        }

        public /* synthetic */ C1071qtZIjO(C0953KRckQg c0953KRckQg) {
            this();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$rWxwaT */
    public class DialogInterfaceOnClickListenerC1072rWxwaT implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4727mjFkc;

        public DialogInterfaceOnClickListenerC1072rWxwaT(boolean z) {
            this.f4727mjFkc = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4807n(this.f4727mjFkc ? 1 : 0);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$rdJr */
    public class RunnableC1073rdJr implements Runnable {
        public RunnableC1073rdJr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4833rtBEoQ();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$rkYL */
    public class DialogInterfaceOnClickListenerC1074rkYL implements DialogInterface.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ InterfaceC1050kw f4729AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4730mjFkc;

        public DialogInterfaceOnClickListenerC1074rkYL(EditText editText, InterfaceC1050kw interfaceC1050kw) {
            this.f4730mjFkc = editText;
            this.f4729AZxh = interfaceC1050kw;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.f4730mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.f4729AZxh.mo4866mjFkc(strTrim);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$sRqPfw */
    public class RunnableC1075sRqPfw implements Runnable {
        public RunnableC1075sRqPfw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.f4269fehf != null && MainActivity.this.f4269fehf.isShowing()) {
                    MainActivity.this.f4269fehf.dismiss();
                }
            } catch (Exception unused) {
            }
            MainActivity.this.m4753b();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$sqndV */
    public class RunnableC1076sqndV implements Runnable {
        public RunnableC1076sqndV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4646D();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tAfC */
    public class C1077tAfC implements TextView.OnEditorActionListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Runnable f4735mjFkc;

        public C1077tAfC(Runnable runnable) {
            this.f4735mjFkc = runnable;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2 && i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            this.f4735mjFkc.run();
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tISON */
    public class ViewOnClickListenerC1078tISON implements View.OnClickListener {
        public ViewOnClickListenerC1078tISON() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.f4280mByQ = true;
            MainActivity.this.m4753b();
            MainActivity.this.m4733X("已取消下载");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tPvjn */
    public class RunnableC1079tPvjn implements Runnable {
        public RunnableC1079tPvjn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4831rKxis();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tQ */
    public class RunnableC1080tQ implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$tQ$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4747a(true);
            }
        }

        public RunnableC1080tQ() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentName componentName;
            Method method;
            Object objInvoke;
            MainActivity.this.m4750aQ("\n[*] 取消设备所有者...");
            MainActivity.this.m4737Y("正在取消设备所有者…");
            try {
                MainActivity.this.m4684JtIAgM();
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
                MainActivity.this.m4750aQ("[!] 取消失败: " + th);
                MainActivity.this.m4737Y("✗ 取消失败");
            }
            if (method == null) {
                MainActivity.this.m4750aQ("[!] clearDeviceOwner 接口不存在");
                MainActivity.this.m4737Y("✗ 系统不支持取消");
                return;
            }
            try {
                method.invoke(objInvoke, componentName);
            } catch (IllegalArgumentException unused) {
                method.invoke(objInvoke, "JC.CODE.V3");
            }
            if (MainActivity.this.m4686KbpP()) {
                MainActivity.this.m4750aQ("[!] 取消未生效，仍是设备所有者");
                MainActivity.this.m4737Y("✗ 取消未生效");
            } else {
                MainActivity.this.m4750aQ("[+] 设备所有者已取消 ✓");
                MainActivity.this.m4737Y("✓ 设备所有者已取消");
            }
            MainActivity.this.m4747a(true);
            MainActivity.this.f4281mjFkc.post(new mjFkc());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tjSezt */
    public class RunnableC1081tjSezt implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ boolean f4740AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4741mjFkc;

        public RunnableC1081tjSezt(String str, boolean z) {
            this.f4741mjFkc = str;
            this.f4740AZxh = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService("notification");
                if (notificationManager == null) {
                    return;
                }
                String str = MainActivity.this.f4226IVlxe;
                String str2 = this.f4741mjFkc;
                if (str != null && str.length() > 0) {
                    str2 = this.f4741mjFkc + " · 配对码 " + str;
                }
                Intent intent = new Intent(MainActivity.this, (Class<?>) MainActivity.class);
                intent.setFlags(603979776);
                notificationManager.notify(2002, new Notification.Builder(MainActivity.this, "jc_adb_pair_status_v2").setSmallIcon(AbstractC4524s4.f16419Dt).setContentTitle("无线调试配对").setContentText(str2).setContentIntent(PendingIntent.getActivity(MainActivity.this, 0, intent, 201326592)).setOngoing(this.f4740AZxh).setAutoCancel(!this.f4740AZxh).setOnlyAlertOnce(true).setShowWhen(false).build());
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$tpGcn */
    public class ViewOnClickListenerC1082tpGcn implements View.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ FrameLayout f4743AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ CheckBox f4744mjFkc;

        public ViewOnClickListenerC1082tpGcn(CheckBox checkBox, FrameLayout frameLayout) {
            this.f4744mjFkc = checkBox;
            this.f4743AZxh = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f4744mjFkc.isChecked()) {
                MainActivity.this.m4733X("请先勾选同意《用户协议》");
                return;
            }
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("agreement_accepted_v1", true).apply();
            MainActivity.this.f4275jx = false;
            MainActivity.this.m4750aQ("[*] 用户协议已同意");
            try {
                ((ViewGroup) MainActivity.this.getWindow().getDecorView()).removeView(this.f4743AZxh);
            } catch (Throwable unused) {
            }
            MainActivity.this.m4772g0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$uH */
    public class RunnableC1083uH implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4747mjFkc;

        public RunnableC1083uH(String str) {
            this.f4747mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MainActivity.this.f4269fehf != null && MainActivity.this.f4269fehf.isShowing()) {
                    MainActivity.this.f4269fehf.dismiss();
                }
                if (MainActivity.this.m4832rdtF()) {
                    MainActivity.this.m4664G(this.f4747mjFkc);
                    return;
                }
                MainActivity.this.m4767f();
                MainActivity.this.f4269fehf = new ProgressDialog(MainActivity.this);
                MainActivity.this.f4269fehf.setProgressStyle(1);
                MainActivity.this.f4269fehf.setTitle(this.f4747mjFkc);
                MainActivity.this.f4269fehf.setMessage("正在获取校验信息（应用商店还需下载一次）...");
                MainActivity.this.f4269fehf.setMax(100);
                MainActivity.this.f4269fehf.setProgress(0);
                MainActivity.this.f4269fehf.setCancelable(false);
                MainActivity.this.f4269fehf.show();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$uHVRx */
    public class RunnableC1084uHVRx implements Runnable {
        public RunnableC1084uHVRx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4865zpm();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ub */
    public class RunnableC1085ub implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ boolean f4749AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f4751mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ boolean f4752wA;

        public RunnableC1085ub(boolean z, boolean z2, boolean z3) {
            this.f4751mjFkc = z;
            this.f4749AZxh = z2;
            this.f4752wA = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            boolean z2 = MainActivity.this.f4249Vdz && !this.f4751mjFkc;
            if (MainActivity.this.f4274jm && !this.f4749AZxh) {
                z = true;
            }
            MainActivity.this.f4249Vdz = this.f4751mjFkc;
            MainActivity.this.f4274jm = this.f4749AZxh;
            MainActivity mainActivity = MainActivity.this;
            boolean z3 = this.f4751mjFkc;
            mainActivity.f4227JBhc = (z3 && this.f4749AZxh) ? "ADB+OW" : z3 ? "ADB" : this.f4749AZxh ? "OW" : "漏洞";
            MainActivity.this.m4851wfW();
            MainActivity.this.f4289tQ = true;
            MainActivity.this.m4810nVsW(this.f4752wA);
            if (MainActivity.this.f4256XV != null) {
                MainActivity.this.m4633Abw();
            }
            boolean z4 = this.f4752wA;
            if (z4 && z2) {
                MainActivity.this.m4737Y("ADB 通道已失效，请重新激活");
            } else if (z4 && z) {
                MainActivity.this.m4737Y("设备所有者已失效，请重新激活");
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ui */
    public class C1086ui implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4754mjFkc;

        public C1086ui(TextView textView) {
            this.f4754mjFkc = textView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4754mjFkc.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$uxlM */
    public class RunnableC1087uxlM implements Runnable {
        public RunnableC1087uxlM() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4777gq();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$vI */
    public class C1088vI implements InterfaceC1050kw {

        /* renamed from: AZxh */
        public final /* synthetic */ ScrollView f4756AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ TextView f4757mjFkc;

        public C1088vI(TextView textView, ScrollView scrollView) {
            this.f4757mjFkc = textView;
            this.f4756AZxh = scrollView;
        }

        @Override // com.p091jc.p092code.p093v3.MainActivity.InterfaceC1050kw
        /* renamed from: mjFkc */
        public void mo4866mjFkc(String str) {
            MainActivity.this.m4801m("set-uninstall-blocked " + str + " false", this.f4757mjFkc, this.f4756AZxh);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$vUsV */
    public class RunnableC1089vUsV implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$vUsV$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!"漏洞".equals(MainActivity.this.f4227JBhc) || MainActivity.this.f4266dm || MainActivity.this.getSharedPreferences("jc_code_prefs", 0).getBoolean("vuln_hint_never", false)) {
                    return;
                }
                MainActivity.this.f4266dm = true;
                MainActivity.this.m4754b0();
            }
        }

        public RunnableC1089vUsV() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f4235LREOK = true;
            MainActivity.this.m4699ORe();
            MainActivity.this.f4281mjFkc.removeCallbacks(MainActivity.this.f4250Vgyli);
            MainActivity.this.f4281mjFkc.postDelayed(MainActivity.this.f4250Vgyli, 30000L);
            MainActivity.this.f4281mjFkc.postDelayed(new mjFkc(), 700L);
            if (MainActivity.this.f4257XbiWeM != null) {
                Intent intent = MainActivity.this.f4257XbiWeM;
                MainActivity.this.f4257XbiWeM = null;
                MainActivity.this.m4650DxPQMO(intent);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$vZ */
    public class ViewOnClickListenerC1090vZ implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ Runnable f4762mjFkc;

        public ViewOnClickListenerC1090vZ(Runnable runnable) {
            this.f4762mjFkc = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4762mjFkc.run();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$vadzgd */
    public class RunnableC1091vadzgd implements Runnable {
        public RunnableC1091vadzgd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4645CrDc(true);
            MainActivity.this.m4747a(true);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$vjlshU */
    public class RunnableC1092vjlshU implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ StringBuilder f4764AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String[] f4765mjFkc;

        /* renamed from: com.jc.code.v3.MainActivity$vjlshU$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC1092vjlshU runnableC1092vjlshU = RunnableC1092vjlshU.this;
                MainActivity.this.m4718T("管控探针", runnableC1092vjlshU.f4764AZxh.toString());
            }
        }

        public RunnableC1092vjlshU(String[] strArr, StringBuilder sb) {
            this.f4765mjFkc = strArr;
            this.f4764AZxh = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f4765mjFkc) {
                Cursor cursorQuery = null;
                try {
                    try {
                        cursorQuery = MainActivity.this.getContentResolver().query(Uri.parse("content://com.zuoyebang.iot.pad.supervise" + str), null, null, null, null);
                        if (cursorQuery == null) {
                            StringBuilder sb = this.f4764AZxh;
                            sb.append(str);
                            sb.append(" → null\n\n");
                            MainActivity.this.m4750aQ("[-] " + str + " → null");
                        } else {
                            String[] columnNames = cursorQuery.getColumnNames();
                            StringBuilder sb2 = this.f4764AZxh;
                            sb2.append(str);
                            sb2.append(" (");
                            sb2.append(cursorQuery.getCount());
                            sb2.append(" 行, ");
                            sb2.append(columnNames.length);
                            sb2.append(" 列)\n");
                            this.f4764AZxh.append("  列: ");
                            for (int i = 0; i < Math.min(columnNames.length, 8); i++) {
                                StringBuilder sb3 = this.f4764AZxh;
                                sb3.append(columnNames[i]);
                                sb3.append(", ");
                            }
                            if (columnNames.length > 8) {
                                this.f4764AZxh.append("...");
                            }
                            this.f4764AZxh.append("\n");
                            for (int i2 = 0; cursorQuery.moveToNext() && i2 < 3; i2++) {
                                StringBuilder sb4 = this.f4764AZxh;
                                sb4.append("  [");
                                sb4.append(i2);
                                sb4.append("] ");
                                for (int i3 = 0; i3 < Math.min(columnNames.length, 5); i3++) {
                                    try {
                                        String string = cursorQuery.getString(i3);
                                        if (string != null && string.length() > 50) {
                                            string = string.substring(0, 50) + "...";
                                        }
                                        StringBuilder sb5 = this.f4764AZxh;
                                        sb5.append(columnNames[i3]);
                                        sb5.append("=");
                                        sb5.append(string);
                                        sb5.append(" | ");
                                    } catch (Exception unused) {
                                    }
                                }
                                this.f4764AZxh.append("\n");
                            }
                            this.f4764AZxh.append("\n");
                            MainActivity.this.m4750aQ("[+] " + str + " → " + cursorQuery.getCount() + " 行");
                        }
                    } catch (Exception e) {
                        StringBuilder sb6 = this.f4764AZxh;
                        sb6.append(str);
                        sb6.append(" → 错误: ");
                        sb6.append(e.getMessage());
                        sb6.append("\n\n");
                        MainActivity.this.m4750aQ("[!] " + str + " → " + e.getMessage());
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
            MainActivity.this.f4281mjFkc.post(new mjFkc());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$wA */
    public class RunnableC1093wA implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ Set f4768AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ EditText f4770ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ LinearLayout f4771mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Map f4772wA;

        /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh */
        public class AZxh implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ boolean f4773AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ List f4774mjFkc;

            /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh$AZxh, reason: collision with other inner class name */
            public class C6352AZxh implements CompoundButton.OnCheckedChangeListener {

                /* renamed from: mjFkc */
                public final /* synthetic */ String f4777mjFkc;

                public C6352AZxh(String str) {
                    this.f4777mjFkc = str;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        RunnableC1093wA.this.f4768AZxh.add(this.f4777mjFkc);
                    } else {
                        RunnableC1093wA.this.f4768AZxh.remove(this.f4777mjFkc);
                    }
                }
            }

            /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh$mjFkc */
            public class mjFkc implements View.OnClickListener {

                /* renamed from: mjFkc */
                public final /* synthetic */ CheckBox f4779mjFkc;

                public mjFkc(CheckBox checkBox) {
                    this.f4779mjFkc = checkBox;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f4779mjFkc.setChecked(!r0.isChecked());
                }
            }

            /* renamed from: com.jc.code.v3.MainActivity$wA$AZxh$wA */
            public class wA implements TextWatcher {
                public wA() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String strTrim = editable.toString().toLowerCase().trim();
                    Iterator it = RunnableC1093wA.this.f4772wA.entrySet().iterator();
                    while (it.hasNext()) {
                        View view = (View) ((Map.Entry) it.next()).getValue();
                        view.setVisibility((strTrim.isEmpty() || ((TextView) view.findViewById(AbstractC4658u4.f16789fehf)).getText().toString().toLowerCase().contains(strTrim) || ((TextView) view.findViewById(AbstractC4658u4.f16787diqgf)).getText().toString().toLowerCase().contains(strTrim)) ? 0 : 8);
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
                this.f4774mjFkc = list;
                this.f4773AZxh = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC1093wA.this.f4771mjFkc.removeAllViews();
                for (PackageInfo packageInfo : this.f4774mjFkc) {
                    String string = packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString();
                    String str = packageInfo.packageName;
                    View viewInflate = LayoutInflater.from(MainActivity.this).inflate(AbstractC2071H4.f8529ZfxDd, (ViewGroup) null);
                    ImageView imageView = (ImageView) viewInflate.findViewById(AbstractC4658u4.f16794qdMbNW);
                    TextView textView = (TextView) viewInflate.findViewById(AbstractC4658u4.f16789fehf);
                    TextView textView2 = (TextView) viewInflate.findViewById(AbstractC4658u4.f16787diqgf);
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(AbstractC4658u4.f16780KLFTb);
                    imageView.setImageDrawable(packageInfo.applicationInfo.loadIcon(MainActivity.this.getPackageManager()));
                    textView.setText(string);
                    textView.setTextColor(this.f4773AZxh ? -419430401 : -15066598);
                    textView2.setText(str);
                    textView2.setTextColor(this.f4773AZxh ? -1711276033 : -1728053248);
                    viewInflate.setOnClickListener(new mjFkc(checkBox));
                    checkBox.setOnCheckedChangeListener(new C6352AZxh(str));
                    RunnableC1093wA.this.f4771mjFkc.addView(viewInflate);
                    RunnableC1093wA.this.f4772wA.put(str, viewInflate);
                }
                RunnableC1093wA.this.f4770ZfxDd.addTextChangedListener(new wA());
            }
        }

        /* renamed from: com.jc.code.v3.MainActivity$wA$mjFkc */
        public class mjFkc implements Comparator {
            public mjFkc() {
            }

            @Override // java.util.Comparator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
                return packageInfo.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString().compareToIgnoreCase(packageInfo2.applicationInfo.loadLabel(MainActivity.this.getPackageManager()).toString());
            }
        }

        public RunnableC1093wA(LinearLayout linearLayout, Set set, Map map, EditText editText) {
            this.f4771mjFkc = linearLayout;
            this.f4768AZxh = set;
            this.f4772wA = map;
            this.f4770ZfxDd = editText;
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
            MainActivity.this.runOnUiThread(new AZxh(arrayList, MainActivity.this.f4298xJ));
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$wGscSa */
    public class DialogInterfaceOnDismissListenerC1094wGscSa implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC1094wGscSa() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.m4744ZODYfo();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$wJVbdd */
    public class RunnableC1095wJVbdd implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4783AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4785mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ScrollView f4786wA;

        public RunnableC1095wJVbdd(String str, TextView textView, ScrollView scrollView) {
            this.f4785mjFkc = str;
            this.f4783AZxh = textView;
            this.f4786wA = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strM13767mjFkc = AbstractC4735vEiZJ.m13767mjFkc(MainActivity.this, this.f4785mjFkc);
                MainActivity mainActivity = MainActivity.this;
                TextView textView = this.f4783AZxh;
                ScrollView scrollView = this.f4786wA;
                StringBuilder sb = new StringBuilder();
                if (strM13767mjFkc == null || strM13767mjFkc.trim().length() == 0) {
                    strM13767mjFkc = "(无输出)";
                }
                sb.append(strM13767mjFkc);
                sb.append("\n");
                mainActivity.m4783iEjzEW(textView, scrollView, sb.toString(), -2629912);
            } catch (Throwable th) {
                MainActivity.this.m4783iEjzEW(this.f4783AZxh, this.f4786wA, "✗ " + MainActivity.m4563mYYU(th) + "\n", -1074534);
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$wLtdyQ */
    public class ViewOnTouchListenerC1096wLtdyQ implements View.OnTouchListener {
        public ViewOnTouchListenerC1096wLtdyQ() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xBQUgd */
    public class ViewOnClickListenerC1097xBQUgd implements View.OnClickListener {
        public ViewOnClickListenerC1097xBQUgd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xCVa */
    public class RunnableC1098xCVa implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$xCVa$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.f4235LREOK) {
                    MainActivity.this.m4747a(true);
                    MainActivity.this.m4645CrDc(true);
                }
            }
        }

        public RunnableC1098xCVa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strM4920bbzow = AdbConnectionManager.m4920bbzow("echo ok");
                if (strM4920bbzow != null && strM4920bbzow.indexOf("ok") >= 0) {
                    MainActivity.this.m4750aQ("[ADB] 已自动恢复连接（无需重新配对）");
                    AdbConnectionManager.m4918alEkx();
                    MainActivity.this.f4281mjFkc.post(new mjFkc());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xJ */
    public class DialogInterfaceOnClickListenerC1099xJ implements DialogInterface.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ EditText f4792mjFkc;

        public DialogInterfaceOnClickListenerC1099xJ(EditText editText) {
            this.f4792mjFkc = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String strTrim = this.f4792mjFkc.getText().toString().trim();
            if (strTrim.isEmpty()) {
                return;
            }
            MainActivity.this.m4834s(strTrim);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xROA */
    public class RunnableC1100xROA implements Runnable {
        public RunnableC1100xROA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4663Frh();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xVYW */
    public static final class C1101xVYW {

        /* renamed from: AZxh */
        public final String f4794AZxh;

        /* renamed from: KLFTb */
        public final Runnable f4795KLFTb;

        /* renamed from: ZfxDd */
        public final int f4796ZfxDd;

        /* renamed from: mjFkc */
        public final String f4797mjFkc;

        /* renamed from: wA */
        public final int f4798wA;

        public C1101xVYW(String str, String str2, int i, int i2, Runnable runnable) {
            this.f4797mjFkc = str;
            this.f4794AZxh = str2;
            this.f4798wA = i;
            this.f4796ZfxDd = i2;
            this.f4795KLFTb = runnable;
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xbjHT */
    public class ViewOnClickListenerC1102xbjHT implements View.OnClickListener {
        public ViewOnClickListenerC1102xbjHT() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://app.aibangos.xyz/Jc.Four")));
            } catch (Exception unused) {
                MainActivity.this.m4733X("无法打开浏览器");
            }
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xfXeiC */
    public class RunnableC1103xfXeiC implements Runnable {
        public RunnableC1103xfXeiC() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.getSharedPreferences("jc_code_prefs", 0).edit().putString("search_bg_scale", "stretch").apply();
            MainActivity.this.m4864zo();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$xrEuO */
    public class DialogInterfaceOnClickListenerC1104xrEuO implements DialogInterface.OnClickListener {

        /* renamed from: AZxh */
        public final /* synthetic */ TextView f4801AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ String f4803ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4804mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ScrollView f4805wA;

        public DialogInterfaceOnClickListenerC1104xrEuO(String str, TextView textView, ScrollView scrollView, String str2) {
            this.f4804mjFkc = str;
            this.f4801AZxh = textView;
            this.f4805wA = scrollView;
            this.f4803ZfxDd = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.m4822q(this.f4804mjFkc, this.f4801AZxh, this.f4805wA);
            MainActivity.this.m4737Y(this.f4803ZfxDd + " 执行中...");
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$yP */
    public class ViewOnClickListenerC1105yP implements View.OnClickListener {
        public ViewOnClickListenerC1105yP() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.finishAffinity();
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$yX */
    public class RunnableC1106yX implements Runnable {
        public RunnableC1106yX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4677IxLrZ();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ybBTr */
    public class RunnableC1107ybBTr implements Runnable {
        public RunnableC1107ybBTr() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.m4841u0();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$yfx */
    public class RunnableC1108yfx implements Runnable {

        /* renamed from: com.jc.code.v3.MainActivity$yfx$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.m4733X("✓ 代理已清理");
            }
        }

        public RunnableC1108yfx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdbConnectionManager.m4920bbzow("settings put global http_proxy :0; settings delete global http_proxy");
                MainActivity.this.m4750aQ("[*] 系统代理已清理");
            } catch (Throwable th) {
                MainActivity.this.m4750aQ("[!] 清理系统代理失败: " + MainActivity.m4563mYYU(th));
            }
            C1742CBEvIj.m7783JHa().m7795diqgf();
            MainActivity.this.f4279lti = false;
            MainActivity.this.f4281mjFkc.post(new mjFkc());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$zPp */
    public class C1109zPp extends ViewOutlineProvider {
        public C1109zPp() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$zvd */
    public class RunnableC1110zvd implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ String f4812AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ScrollView f4814ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f4815mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ TextView f4816wA;

        /* renamed from: com.jc.code.v3.MainActivity$zvd$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC1110zvd.this.f4814ZfxDd.fullScroll(130);
            }
        }

        public RunnableC1110zvd(int i, String str, TextView textView, ScrollView scrollView) {
            this.f4815mjFkc = i;
            this.f4812AZxh = str;
            this.f4816wA = textView;
            this.f4814ZfxDd = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4815mjFkc != 0) {
                SpannableString spannableString = new SpannableString(this.f4812AZxh);
                spannableString.setSpan(new ForegroundColorSpan(this.f4815mjFkc), 0, this.f4812AZxh.length(), 33);
                this.f4816wA.append(spannableString);
            } else {
                this.f4816wA.append(this.f4812AZxh);
            }
            this.f4814ZfxDd.post(new mjFkc());
        }
    }

    /* renamed from: EaLbDP */
    public static List m4407EaLbDP(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        ArrayList arrayList = new ArrayList();
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2 && "node".equals(xmlPullParserNewPullParser.getName())) {
                C1040ih c1040ih = new C1040ih(null);
                c1040ih.f4624mjFkc = m4585sMIIyd(xmlPullParserNewPullParser, "text");
                c1040ih.f4618AZxh = m4585sMIIyd(xmlPullParserNewPullParser, "content-desc");
                c1040ih.f4626wA = m4585sMIIyd(xmlPullParserNewPullParser, "class");
                c1040ih.f4622ZfxDd = m4585sMIIyd(xmlPullParserNewPullParser, "package");
                c1040ih.f4621KLFTb = m4585sMIIyd(xmlPullParserNewPullParser, "resource-id");
                c1040ih.f4620JHa = "true".equals(m4585sMIIyd(xmlPullParserNewPullParser, "clickable"));
                m4473RleMQT(m4585sMIIyd(xmlPullParserNewPullParser, "bounds"), c1040ih);
                arrayList.add(c1040ih);
            }
        }
        return arrayList;
    }

    /* renamed from: RleMQT */
    public static void m4473RleMQT(String str, C1040ih c1040ih) {
        Pattern pattern = f4213XD;
        if (str == null) {
            str = BuildConfig.f24315FLAVOR;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            c1040ih.f4627xJ = Integer.parseInt(matcher.group(1));
            c1040ih.f4623lgHUyS = Integer.parseInt(matcher.group(2));
            c1040ih.f4625qdMbNW = Integer.parseInt(matcher.group(3));
            c1040ih.f4619Dt = Integer.parseInt(matcher.group(4));
        }
    }

    /* renamed from: cOuJ */
    public static int m4522cOuJ(String str, String str2) {
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
            int iM4542gy = i < strArrSplit.length ? m4542gy(strArrSplit[i]) : 0;
            int iM4542gy2 = i < strArrSplit2.length ? m4542gy(strArrSplit2[i]) : 0;
            if (iM4542gy != iM4542gy2) {
                return iM4542gy < iM4542gy2 ? -1 : 1;
            }
            i++;
        }
        return 0;
    }

    /* renamed from: gy */
    public static int m4542gy(String str) {
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

    /* renamed from: mYYU */
    public static String m4563mYYU(Throwable th) {
        if (th == null) {
            return "未知错误";
        }
        String message = th.getMessage();
        return (message == null || message.length() <= 0) ? th.getClass().getSimpleName() : message;
    }

    /* renamed from: sMIIyd */
    public static String m4585sMIIyd(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? BuildConfig.f24315FLAVOR : attributeValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r2 = r2 + 1;
     */
    /* renamed from: uAgKP */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1035gjvQ m4598uAgKP(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1040ih c1040ih = (C1040ih) it.next();
            String strTrim = c1040ih.f4624mjFkc.replace(" ", BuildConfig.f24315FLAVOR).trim();
            if (strTrim.matches("\\d{6}")) {
                return new C1035gjvQ(strTrim, c1040ih);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C1040ih c1040ih2 = (C1040ih) it2.next();
            if (c1040ih2.f4624mjFkc.trim().matches("\\d")) {
                arrayList.add(c1040ih2);
            }
        }
        int i = 0;
        while (i + 6 <= arrayList.size()) {
            int i2 = ((C1040ih) arrayList.get(i)).f4623lgHUyS;
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 6; i3++) {
                C1040ih c1040ih3 = (C1040ih) arrayList.get(i + i3);
                if (Math.abs(c1040ih3.f4623lgHUyS - i2) > 24) {
                    break;
                }
                sb.append(c1040ih3.f4624mjFkc.trim());
            }
            return new C1035gjvQ(sb.toString(), (C1040ih) arrayList.get(i));
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C1040ih c1040ih4 = (C1040ih) it3.next();
            Matcher matcher = f4212Dp.matcher(c1040ih4.f4624mjFkc);
            if (matcher.find()) {
                return new C1035gjvQ(matcher.group(), c1040ih4);
            }
        }
        return null;
    }

    /* renamed from: uhQ */
    public static String m4602uhQ(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1040ih c1040ih = (C1040ih) it.next();
            Matcher matcher = f4214gtr.matcher(c1040ih.f4624mjFkc + " " + c1040ih.f4618AZxh);
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

    /* renamed from: w0 */
    public static int[] m4610w0(int i, boolean z) {
        return z ? new int[]{-12168802, -14848406, -1} : new int[]{-10589486, -13916000, -1};
    }

    /* renamed from: wMV */
    public static void m4615wMV(String str) {
        MainActivity mainActivity = f4215sRqPfw;
        if (mainActivity != null) {
            mainActivity.m4750aQ(str);
        } else {
            Log.d("JCCodeV3", str);
        }
    }

    /* renamed from: A */
    public final void m4630A(String str) {
        new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str + " 需要 ADB 权限").setMessage("该功能通过无线调试 ADB 通道执行，当前尚未获得 ADB 权限。\n\n请先到「开发者工具 → 打开无线调试配对页面」完成配对，获得 ADB 权限后此项自动恢复可用。").setPositiveButton("去配对", new DialogInterfaceOnClickListenerC1020cMLeY()).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: A0 */
    public final void m4631A0(int i) {
        runOnUiThread(new RunnableC1034giT(i));
    }

    /* renamed from: Ab */
    public final String m4632Ab() {
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

    /* renamed from: Abw */
    public final void m4633Abw() {
        int i;
        if (this.f4256XV == null) {
            return;
        }
        float fM4806mz = m4806mz();
        boolean z = this.f4298xJ;
        int i2 = z ? -1842205 : -14737633;
        int i3 = z ? -6643546 : -12302522;
        this.f4256XV.removeAllViews();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fM4806mz);
        int i4 = -1;
        if (z) {
            gradientDrawable.setColor(-14408151);
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -12960446);
        } else {
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -1709843);
        }
        this.f4256XV.setBackground(gradientDrawable);
        TextView textView = new TextView(this);
        textView.setText("状态总览");
        textView.setTextSize(12.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(z ? -5919253 : -10589486);
        int i5 = (int) (12.0f * fM4806mz);
        textView.setPadding(0, 0, 0, i5);
        this.f4256XV.addView(textView);
        Iterator it = this.f4251Vnb.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            for (C1071qtZIjO c1071qtZIjO : ((C1032gJsSk) it.next()).f4589ZfxDd) {
                if (!c1071qtZIjO.f4712JHa && !c1071qtZIjO.f4715VA) {
                    i6++;
                }
            }
        }
        String str = this.f4219CqaNbM;
        String str2 = (str == null || str.length() == 0) ? "未检测" : this.f4219CqaNbM;
        String[][] strArr = {new String[]{"服务状态", this.f4231JrJO}, new String[]{"ZYB 版本", str2}, new String[]{"运行状态", this.f4227JBhc}, new String[]{"功能入口", String.valueOf(i6) + " 项"}};
        int i7 = 0;
        while (true) {
            if (i7 >= 2) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            int i8 = -2;
            this.f4256XV.addView(linearLayout, new LinearLayout.LayoutParams(i4, -2));
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
                    LinearLayout linearLayoutM4653Eey = m4653Eey(true);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i8, i8);
                    layoutParams.topMargin = (int) (fM4806mz * 4.0f);
                    linearLayout2.addView(linearLayoutM4653Eey, layoutParams);
                } else {
                    TextView textView3 = new TextView(this);
                    textView3.setText(strArr[i11][1]);
                    textView3.setTextSize(16.0f);
                    textView3.setTypeface(Typeface.DEFAULT_BOLD);
                    textView3.setTextColor(i2);
                    textView3.setPadding(0, (int) (2.0f * fM4806mz), 0, 0);
                    textView3.setMaxLines(1);
                    textView3.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    linearLayout2.addView(textView3);
                    if (i11 == 0) {
                        this.f4263bbzow = textView3;
                    }
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                if (i9 == 1) {
                    layoutParams2.leftMargin = (int) (16.0f * fM4806mz);
                }
                linearLayout.addView(linearLayout2, layoutParams2);
                i9++;
                i8 = -2;
            }
            if (i7 == 0) {
                View view = new View(this);
                i = -1;
                new LinearLayout.LayoutParams(-1, i5);
                this.f4256XV.addView(view);
            } else {
                i = -1;
            }
            i7++;
            i4 = i;
        }
    }

    /* renamed from: B */
    public final void m4634B() {
        float fM4806mz = m4806mz();
        boolean z = this.f4298xJ;
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(z ? -15460839 : -723207);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC1096wLtdyQ());
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (24.0f * fM4806mz);
        linearLayout.setPadding(i, i, i, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
        float f = 18.0f * fM4806mz;
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
        layoutParams2.topMargin = (int) (fM4806mz * 6.0f);
        int i3 = (int) (16.0f * fM4806mz);
        layoutParams2.bottomMargin = i3;
        linearLayout.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(this);
        textView3.setText("欢迎使用 JC Code V3（以下简称「本应用」）。请在使用前仔细阅读以下条款，勾选「我已阅读并同意」并点击「同意并开始使用」，即表示您已理解并接受本协议全部内容。\n\n一、协议性质与适用范围\n1. 本应用是一款面向个人设备的系统管理与应用安装辅助工具。\n2. 本协议适用于您对本应用的下载、安装、启动及全部使用行为。\n3. 若您不同意本协议任何内容，请点击「退出」并停止使用。\n\n二、使用规范\n1. 您应在自己拥有或经合法授权的设备上使用本应用，不得用于他人设备或未经授权的系统。\n2. 您不得利用本应用从事任何违反法律法规、侵犯他人合法权益或破坏计算机信息系统的行为。\n3. 您通过本应用安装、运行的任何第三方软件，其内容与责任由软件提供方及您自行承担。\n\n三、功能与风险提示\n1. 本应用提供应用安装 / 卸载、ADB 调试通道、设备所有者（Device Owner）等系统级操作能力，此类操作可能影响设备保修状态、系统稳定性或数据安全。\n2. 刷写、降级、停用系统组件等操作存在导致设备异常或数据丢失的风险，请提前自行备份重要资料。\n3. 因操作不当、设备差异、系统版本差异导致的任何设备损坏或数据损失，本应用不承担责任。\n\n四、联网与信息收集\n1. 本应用启动时需连接服务器完成服务状态验证，并获取版本更新与公告信息；无法连接服务器时本应用将无法使用。\n2. 为实现设备管理与安全管控，本应用会上报本机的设备码（基于设备标识生成的匿名编号）及应用版本号。上述信息不包含您的姓名、账号等个人身份信息。\n3. 服务端可下发停用、强制更新、兼容性黑名单等管控指令，用于维护软件生态与用户权益。\n\n五、免责声明\n1. 本应用按「现状」提供，不作任何明示或默示的担保，包括但不限于适销性、特定用途适用性。\n2. 在法律允许的最大范围内，开发者不对因使用或无法使用本应用导致的任何直接、间接损失承担责任。\n\n六、协议变更与终止\n1. 开发者可根据需要更新本协议，更新后的协议将随新版本发布；继续使用即视为接受变更。\n2. 您可随时停止使用并卸载本应用；如您违反本协议，开发者有权中止或终止您的使用。\n\n七、联系方式\n对本协议有任何疑问，请联系：aono_saki@outlook.com");
        textView3.setTextSize(12.0f);
        textView3.setLineSpacing(fM4806mz * 3.0f, 1.0f);
        textView3.setTextColor(z ? -3616036 : -12302522);
        textView3.setPadding(i2, i3, i2, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(z ? -14999772 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -14012102);
        }
        textView3.setBackground(gradientDrawable);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(textView3, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, (int) (330.0f * fM4806mz));
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
        int i4 = (int) (28.0f * fM4806mz);
        int i5 = (int) (12.0f * fM4806mz);
        textView4.setPadding(i4, i5, i4, i5);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float f2 = fM4806mz * 22.0f;
        gradientDrawable2.setCornerRadius(f2);
        gradientDrawable2.setColor(z ? -13881549 : -1512723);
        textView4.setBackground(gradientDrawable2);
        textView4.setOnClickListener(new ViewOnClickListenerC1105yP());
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
        checkBox.setOnCheckedChangeListener(new C1086ui(textView5));
        textView5.setOnClickListener(new ViewOnClickListenerC1082tpGcn(checkBox, frameLayout));
        ((ViewGroup) getWindow().getDecorView()).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: B0 */
    public final void m4635B0(int i) {
        boolean z = this.f4298xJ;
        int i2 = z ? -5919253 : -10589486;
        int i3 = z ? -6643546 : -12302522;
        float fM4806mz = m4806mz();
        int i4 = 0;
        while (i4 < this.f4251Vnb.size()) {
            C1032gJsSk c1032gJsSk = (C1032gJsSk) this.f4251Vnb.get(i4);
            if (c1032gJsSk.f4586KLFTb != null) {
                boolean z2 = i4 == i;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(28.0f * fM4806mz);
                if (z2) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    gradientDrawable.setColors(z ? new int[]{-13946542, -15189191} : new int[]{-1775880, -2691094});
                } else {
                    gradientDrawable.setColor(0);
                }
                c1032gJsSk.f4586KLFTb.setBackground(new RippleDrawable(ColorStateList.valueOf(z ? 618914787 : 341732050), gradientDrawable, null));
                c1032gJsSk.f4585JHa.setColorFilter(z2 ? i2 : i3, PorterDuff.Mode.SRC_IN);
                c1032gJsSk.f4594xJ.setTextColor(z2 ? i2 : i3);
                c1032gJsSk.f4594xJ.setTypeface(z2 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            }
            i4++;
        }
    }

    /* renamed from: BEUaYa */
    public final void m4636BEUaYa(String str, String str2, String str3, String str4, InterfaceC1050kw interfaceC1050kw) {
        EditText editText = new EditText(this);
        editText.setHint(str3);
        editText.setTextSize(14.0f);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str).setMessage(str2).setView(editText).setPositiveButton(str4, new DialogInterfaceOnClickListenerC1074rkYL(editText, interfaceC1050kw)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: BOPu */
    public final void m4637BOPu() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(2002);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: BWWRl */
    public final View m4638BWWRl(String str, String str2, int i, int i2) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i3 = (int) (24.0f * fM4806mz);
        linearLayout.setPadding(i3, i3, i3, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fM4806mz);
        gradientDrawable.setColor(this.f4298xJ ? -13881549 : -854792);
        gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), this.f4298xJ ? -12960446 : -1972757);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        FrameLayout frameLayout = new FrameLayout(this);
        int i4 = (int) (54.0f * fM4806mz);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float f = 16.0f * fM4806mz;
        gradientDrawable2.setCornerRadius(f);
        int[] iArrM4610w0 = m4610w0(i2, this.f4298xJ);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrM4610w0[0], iArrM4610w0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        int i5 = (int) (28.0f * fM4806mz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i5, i5, 17));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.bottomMargin = (int) f;
        linearLayout.addView(frameLayout, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(15.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(this.f4298xJ ? -1842205 : -14737633);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(this.f4298xJ ? -6643546 : -10525848);
        textView2.setPadding(0, (int) (fM4806mz * 6.0f), 0, 0);
        linearLayout.addView(textView2);
        return linearLayout;
    }

    /* renamed from: C */
    public final void m4639C() {
        View viewInflate = LayoutInflater.from(this).inflate(AbstractC2071H4.f8528AZxh, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(AbstractC4658u4.f16776Dt);
        EditText editText = (EditText) viewInflate.findViewById(AbstractC4658u4.f16797xJ);
        TextView textView = new TextView(this);
        textView.setText("加载应用列表中...");
        textView.setGravity(17);
        textView.setPadding(0, 60, 0, 60);
        textView.setTextColor(this.f4298xJ ? -1711276033 : -1728053248);
        linearLayout.addView(textView);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        m4836sjsh(viewInflate, alertDialogCreate);
        HashSet hashSet = new HashSet();
        new Thread(new RunnableC1093wA(linearLayout, hashSet, new LinkedHashMap(), editText)).start();
        viewInflate.findViewById(AbstractC4658u4.f16792mjFkc).setOnClickListener(new ViewOnClickListenerC1013ZfxDd(alertDialogCreate));
        viewInflate.findViewById(AbstractC4658u4.f16786ZfxDd).setOnClickListener(new ViewOnClickListenerC0950KLFTb(hashSet, alertDialogCreate));
    }

    /* renamed from: C0 */
    public final void m4640C0(String str, boolean z) {
        this.f4281mjFkc.post(new RunnableC1081tjSezt(str, z));
    }

    /* renamed from: CBEvIj */
    public final boolean m4641CBEvIj() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                byte[] bArrDigest = MessageDigest.getInstance(XMSSKeyParameters.f23621SHA_256).digest(packageInfo.signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(String.format("%02x", Integer.valueOf(b & C1126UByte.MAX_VALUE)));
                }
                return "5f6a730ca823387ce929ed1320f274cc1399722b0965bc551ed85868cf672a56".equalsIgnoreCase(sb.toString());
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* renamed from: CBhInx */
    public final void m4642CBhInx(LinearLayout linearLayout, String[][] strArr, TextView[] textViewArr, ScrollView[] scrollViewArr, boolean[] zArr) {
        float fM4806mz = m4806mz();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            String[] strArr2 = strArr[i2];
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(i);
            int i3 = -2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = (int) (8.0f * fM4806mz);
            int length2 = strArr2.length;
            int i4 = i;
            while (i4 < length2) {
                String str = strArr2[i4];
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i3, 1.0f);
                layoutParams2.rightMargin = (int) (7.0f * fM4806mz);
                linearLayout2.addView(m4732WjcLD(str, new RunnableC1038huTpC(zArr, str, textViewArr, scrollViewArr)), layoutParams2);
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

    /* renamed from: CO */
    public final Method m4643CO(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = this.f4285qdMbNW.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            try {
                for (Method method : this.f4285qdMbNW.getDeclaredMethods()) {
                    if (method.getName().equals(str)) {
                        method.setAccessible(true);
                        return method;
                    }
                }
            } catch (Exception unused2) {
            }
            Method method2 = this.f4241OjSQV;
            if (method2 == null) {
                return null;
            }
            try {
                Method[] methodArr = (Method[]) method2.invoke(this.f4285qdMbNW, Boolean.FALSE);
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

    /* renamed from: CRhd */
    public final Method[] m4644CRhd() throws SecurityException {
        try {
            Method[] declaredMethods = this.f4285qdMbNW.getDeclaredMethods();
            if (declaredMethods.length > 0) {
                return declaredMethods;
            }
        } catch (Exception unused) {
        }
        Method method = this.f4241OjSQV;
        if (method != null) {
            try {
                Method[] methodArr = (Method[]) method.invoke(this.f4285qdMbNW, Boolean.FALSE);
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
    /* renamed from: CrDc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4645CrDc(boolean z) {
        View view;
        boolean zM4795kgk = m4795kgk();
        boolean zM4710RV = m4710RV();
        boolean z2 = getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false);
        Iterator it = this.f4251Vnb.iterator();
        while (it.hasNext()) {
            for (C1071qtZIjO c1071qtZIjO : ((C1032gJsSk) it.next()).f4589ZfxDd) {
                if (c1071qtZIjO.f4725xJ && (view = c1071qtZIjO.f4714MiMN) != null) {
                    boolean z3 = c1071qtZIjO.f4722qdMbNW ? false : false;
                    view.setVisibility((z2 && z3) ? 8 : 0);
                    if (z || z3 != c1071qtZIjO.f4710ETF) {
                        c1071qtZIjO.f4710ETF = z3;
                        m4806mz();
                        if (z3) {
                            c1071qtZIjO.f4714MiMN.setAlpha(0.45f);
                            GradientDrawable gradientDrawable = c1071qtZIjO.f4711IEE;
                            if (gradientDrawable != null) {
                                gradientDrawable.setColors(new int[]{-4735804, -6643546});
                                c1071qtZIjO.f4711IEE.invalidateSelf();
                            }
                            ImageView imageView = c1071qtZIjO.f4721qGY;
                            if (imageView != null) {
                                imageView.setColorFilter(-9736075, PorterDuff.Mode.SRC_IN);
                            }
                            TextView textView = c1071qtZIjO.f4723rkYL;
                            if (textView != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(c1071qtZIjO.f4722qdMbNW ? "等待 ADB 权限 · " : zM4795kgk ? "高版本不可用 · " : "等待绑定 · ");
                                sb.append(c1071qtZIjO.f4709Dt);
                                textView.setText(sb.toString());
                                c1071qtZIjO.f4723rkYL.setTextColor(this.f4298xJ ? -881790 : -3857889);
                            }
                        } else {
                            c1071qtZIjO.f4714MiMN.setAlpha(1.0f);
                            int[] iArrM4610w0 = m4610w0(c1071qtZIjO.f4717ZfxDd, this.f4298xJ);
                            GradientDrawable gradientDrawable2 = c1071qtZIjO.f4711IEE;
                            if (gradientDrawable2 != null) {
                                gradientDrawable2.setColors(new int[]{iArrM4610w0[0], iArrM4610w0[1]});
                                c1071qtZIjO.f4711IEE.invalidateSelf();
                            }
                            ImageView imageView2 = c1071qtZIjO.f4721qGY;
                            if (imageView2 != null) {
                                imageView2.setColorFilter(iArrM4610w0[2], PorterDuff.Mode.SRC_IN);
                            }
                            TextView textView2 = c1071qtZIjO.f4723rkYL;
                            if (textView2 != null) {
                                textView2.setText(c1071qtZIjO.f4709Dt);
                                c1071qtZIjO.f4723rkYL.setTextColor(this.f4298xJ ? -6643546 : -10525848);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: D */
    public final void m4646D() {
        m4687L("自定义背景", new C1101xVYW[]{new C1101xVYW("拉伸填满", "图片拉伸铺满整个背景", AbstractC4524s4.f16437fehf, -10589486, new RunnableC1017bWIyu()), new C1101xVYW("居中原图", "保持原图比例居中显示", AbstractC4524s4.f16440lgHUyS, -13916000, new RunnableC1009XyP()), new C1101xVYW("恢复默认", "清除自定义背景", AbstractC4524s4.f16417BAnRFn, -10525848, new RunnableC0987UDcil())}, 480.0f);
    }

    /* renamed from: D0 */
    public final void m4647D0(String str, boolean z) {
        this.f4231JrJO = str;
        this.f4282nxI = Boolean.valueOf(z);
        TextView textView = this.f4217AZxh;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f4263bbzow;
        int i = -2543579;
        if (textView2 != null) {
            textView2.setText(str);
            TextView textView3 = this.f4263bbzow;
            boolean z2 = this.f4298xJ;
            textView3.setTextColor(z ? z2 ? -9647265 : -15171528 : z2 ? -881790 : -2543579);
        }
        if (this.f4248VA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            if (z) {
                i = this.f4298xJ ? -9647265 : -15171528;
            } else if (this.f4298xJ) {
                i = -881790;
            }
            gradientDrawable.setColor(i);
            this.f4248VA.setBackground(gradientDrawable);
            m4768f0();
        }
        m4659FPcN();
    }

    /* renamed from: DanUFX */
    public final void m4648DanUFX() {
        m4763d0();
        this.f4281mjFkc.postDelayed(new RunnableC0972Qr(), 400L);
    }

    /* renamed from: Dc */
    public final void m4649Dc(Uri uri) {
        m4737Y("正在准备本地 APK...");
        new Thread(new RunnableC1005XbiWeM(uri)).start();
    }

    /* renamed from: DxPQMO */
    public final void m4650DxPQMO(Intent intent) {
        if (intent != null) {
            if (!this.f4235LREOK) {
                this.f4257XbiWeM = intent;
                return;
            }
            Uri data = intent.getData();
            if (data != null) {
                String type = intent.getType();
                String path = data.getPath();
                if ("application/vnd.android.package-archive".equals(type) || ((path != null && path.toLowerCase().endsWith(".apk")) || "INSTALL_PACKAGE".equals(intent.getAction()) || "android.intent.action.INSTALL_PACKAGE".equals(intent.getAction()))) {
                    m4750aQ("\n[*] 收到 APK intent: " + data);
                    this.f4281mjFkc.postDelayed(new RunnableC0918CqAnRZ(data), 600L);
                }
            }
        }
    }

    /* renamed from: E */
    public final boolean m4651E(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                int iMax = Math.max(1, width / 3);
                int iMax2 = Math.max(1, height / 3);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                PixelCopy.request(getWindow(), bitmapCreateBitmap, new PixelCopyOnPixelCopyFinishedListenerC0988UOnCkw(iMax, iMax2, bitmapCreateBitmap), this.f4281mjFkc);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: E0 */
    public final boolean m4652E0(String str, long j, boolean z) throws InterruptedException, PackageManager.NameNotFoundException {
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

    /* renamed from: Eey */
    public final LinearLayout m4653Eey(boolean z) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        if ("检测中...".equals(this.f4227JBhc)) {
            linearLayout.addView(m4692MoUZ("检测中", AbstractC4524s4.f16421Gd, -6643546, -4735804, z));
            return linearLayout;
        }
        if (this.f4249Vdz) {
            linearLayout.addView(m4692MoUZ("ADB", AbstractC4524s4.f16430Ucbh, -13326253, -15171528, z));
        }
        if (this.f4274jm) {
            View viewM4692MoUZ = m4692MoUZ("OW", AbstractC4524s4.f16438huTpC, -7637518, -10337066, z);
            if (this.f4249Vdz) {
                ((LinearLayout.LayoutParams) viewM4692MoUZ.getLayoutParams()).leftMargin = (int) (m4806mz() * 8.0f);
            }
            linearLayout.addView(viewM4692MoUZ);
        }
        if (!this.f4249Vdz && !this.f4274jm) {
            linearLayout.addView(m4692MoUZ("漏洞", AbstractC4524s4.f16421Gd, -1424587, -3857889, z));
        }
        return linearLayout;
    }

    /* renamed from: EqDGZ */
    public final boolean m4654EqDGZ(String str, String str2, String str3) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (m4773gGFLGZ(str, str2, str3) || lowerCase.contains("apk") || lowerCase.contains("%2eapk") || lowerCase.contains("dl=") || lowerCase.contains("download")) {
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

    /* renamed from: F */
    public final void m4655F(String str) {
        runOnUiThread(new RunnableC1083uH(str));
    }

    /* renamed from: F0 */
    public final String m4656F0() {
        return this.f4219CqaNbM.length() > 0 ? this.f4219CqaNbM : "未知";
    }

    /* renamed from: FBR */
    public final boolean m4657FBR() {
        if (this.f4220Dt) {
            return true;
        }
        m4750aQ("[!] 等待绑定");
        return false;
    }

    /* renamed from: FNhf */
    public final void m4658FNhf(String str, String str2, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.f4220Dt || this.f4285qdMbNW == null) {
            m4750aQ("[!] 无可用安装通道：ADB 安装未成功，zybos 也未绑定（高版本不可用）");
            m4737Y("✗ 安装失败：ADB / zybos 通道均不可用");
            m4745ZlB();
            return;
        }
        try {
            Class cls = Boolean.TYPE;
            Method methodM4643CO = m4643CO("setInstallPackageDisallow", cls);
            if (methodM4643CO != null) {
                methodM4643CO.invoke(this.f4278lgHUyS, Boolean.FALSE);
                m4750aQ("[+] setInstallPackageDisallow(false)");
            }
            Method methodM4643CO2 = m4643CO("silentInstallApk", String.class, cls, String.class);
            if (methodM4643CO2 != null) {
                methodM4643CO2.invoke(this.f4278lgHUyS, str, Boolean.TRUE, str2);
                m4750aQ("[+] silentInstallApk 已调用");
                m4737Y("正在安装 " + str2 + "...");
            } else {
                m4750aQ("[!] silentInstallApk 未找到");
                m4733X("✗ silentInstallApk 未找到");
            }
        } catch (Exception e) {
            m4750aQ("[!] 安装异常: " + m4563mYYU(e));
            m4733X("✗ 安装异常: " + m4563mYYU(e));
        }
        this.f4281mjFkc.postDelayed(new RunnableC1026eEOGOh(z, str2), 5000L);
    }

    /* renamed from: FPcN */
    public final void m4659FPcN() {
        String str;
        if (this.f4234KRTLGT == null) {
            return;
        }
        Boolean bool = this.f4282nxI;
        if (bool == null) {
            str = "● 正在连接 zybos…";
        } else if (bool.booleanValue()) {
            str = "● zybos 已连接 · " + m4656F0();
        } else if (m4795kgk()) {
            str = "○ " + m4656F0() + " · 绑定不可用";
        } else {
            str = "○ zybos 未连接";
        }
        this.f4234KRTLGT.setText(str);
        this.f4234KRTLGT.animate().cancel();
        this.f4234KRTLGT.setAlpha(0.0f);
        this.f4234KRTLGT.animate().alpha(1.0f).setDuration(300L).start();
    }

    /* renamed from: FiDh */
    public final void m4660FiDh() {
        boolean z = this.f4298xJ;
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
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("直链安装").setView(linearLayout).setPositiveButton("发送", new DialogInterfaceOnClickListenerC0955LREOK(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        TextView textView2 = new TextView(this);
        textView2.setText("或使用内置浏览器搜索下载 APK");
        textView2.setTextSize(13.0f);
        textView2.setTextColor(z ? -11746561 : -16750656);
        textView2.setGravity(17);
        textView2.setPadding(0, (int) (getResources().getDisplayMetrics().density * 10.0f), 0, 0);
        textView2.setOnClickListener(new ViewOnClickListenerC1029fFz(alertDialogCreate));
        linearLayout.addView(textView2);
        alertDialogCreate.show();
        m4740YfFg(alertDialogCreate);
    }

    /* renamed from: FoO */
    public final void m4661FoO() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ZybSettings"));
            intent.putExtra(":settings:show_fragment", "com.android.settings.development.qstile.DevelopmentTileConfigFragment");
            intent.setFlags(268435456);
            startActivity(intent);
            m4750aQ("[*] 开发者磁贴已跳转");
        } catch (Exception e) {
            m4750aQ("[!] 开发者磁贴: " + e.getMessage());
            m4733X("无法打开开发者磁贴");
        }
    }

    /* renamed from: FoPRDo */
    public final void m4662FoPRDo(C1032gJsSk c1032gJsSk, String str) {
        C1071qtZIjO c1071qtZIjO = new C1071qtZIjO(null);
        c1071qtZIjO.f4720mjFkc = str;
        c1071qtZIjO.f4715VA = true;
        c1032gJsSk.f4589ZfxDd.add(c1071qtZIjO);
    }

    /* renamed from: Frh */
    public final void m4663Frh() {
        m4750aQ("\n[*] 打开无线调试配对页面...");
        new Thread(new RunnableC0962Moer()).start();
    }

    /* renamed from: G */
    public final void m4664G(String str) {
        int i;
        try {
            m4753b();
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
            gradientDrawable.setColor(this.f4298xJ ? -232051925 : -150994945);
            gradientDrawable.setStroke(1, this.f4298xJ ? -12961222 : -1315861);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setVisibility(8);
            this.f4267eyqo = linearLayout;
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams((int) (240.0f * f), -2));
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(this);
            textView.setText("正在获取 APK 校验信息...");
            textView.setTextSize(11.0f);
            textView.setTextColor(this.f4298xJ ? -419430401 : -15066598);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView2 = new TextView(this);
            textView2.setText("取消");
            textView2.setTextSize(11.0f);
            textView2.setTextColor(this.f4298xJ ? -26204 : -3921124);
            textView2.setGravity(17);
            int i5 = (int) (2.0f * f);
            textView2.setPadding(i3, i5, i5, i5);
            textView2.setOnClickListener(new ViewOnClickListenerC1078tISON());
            linearLayout2.addView(textView2);
            ProgressBar progressBar = new ProgressBar(this, null, R.attr.progressBarStyleHorizontal);
            this.f4247Ucbh = progressBar;
            progressBar.setMax(100);
            this.f4247Ucbh.setProgress(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i4);
            layoutParams.topMargin = (int) (6.0f * f);
            linearLayout.addView(this.f4247Ucbh, layoutParams);
            TextView textView3 = new TextView(this);
            this.f4265diqgf = textView3;
            textView3.setText("0%");
            this.f4265diqgf.setTextSize(11.0f);
            this.f4265diqgf.setTextColor(this.f4298xJ ? -16437175 : -1);
            this.f4265diqgf.setGravity(17);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(this.f4298xJ ? -431176961 : -436181056);
            gradientDrawable2.setStroke(1, 1157627903);
            this.f4265diqgf.setBackground(gradientDrawable2);
            int i6 = (int) (52.0f * f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i6);
            layoutParams2.gravity = 17;
            frameLayout.addView(this.f4265diqgf, layoutParams2);
            frameLayout.setOnTouchListener(new ViewOnTouchListenerC1053lti(f));
            this.f4242Pq = frameLayout;
            this.f4225IEE = (WindowManager) getSystemService("window");
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(-2, -2, 2038, 296, -3);
            layoutParams3.gravity = 8388659;
            int i7 = this.f4223Gd;
            if (i7 < 0 || (i = this.f4224HGpJ) < 0) {
                layoutParams3.x = getResources().getDisplayMetrics().widthPixels - ((int) (80.0f * f));
                layoutParams3.y = (int) (f * 140.0f);
            } else {
                layoutParams3.x = i7;
                layoutParams3.y = i;
            }
            this.f4225IEE.addView(this.f4242Pq, layoutParams3);
            this.f4273huTpC = false;
        } catch (Exception unused) {
        }
    }

    /* renamed from: GmK */
    public final void m4665GmK(String str) {
        this.f4281mjFkc.post(new RunnableC1033gYa(str));
    }

    /* renamed from: H */
    public final void m4666H(boolean z, String str, String str2) {
        RunnableC1065pJeaSR runnableC1065pJeaSR = new RunnableC1065pJeaSR(z, str, str2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnableC1065pJeaSR.run();
        } else {
            this.f4281mjFkc.post(runnableC1065pJeaSR);
        }
    }

    /* renamed from: HBzZAD */
    public final void m4667HBzZAD(boolean z, boolean z2, boolean z3) {
        this.f4281mjFkc.post(new RunnableC1085ub(z, z2, z3));
    }

    /* renamed from: HGlNf */
    public final String m4668HGlNf(File file) throws NoSuchAlgorithmException, IOException {
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
            return this.m4814ofUPN();
        }
    }

    /* renamed from: HL */
    public final String m4669HL() {
        return LocalAdbBridge.isReady() ? "本地 ADB 模式（断网可用）" : AdbConnectionManager.m4947xrEuO() ? "已连接（无线调试）" : AdbConnectionManager.m4902NPj() ? "已配对" : getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false) ? "已配对·待连接" : m4826qpjZLY() ? "无线调试已开启·未配对" : "未配对";
    }

    /* renamed from: HPA */
    public final void m4670HPA() {
        this.f4281mjFkc.post(new RunnableC1089vUsV());
    }

    /* renamed from: HRWx */
    public final void m4671HRWx() {
        m4750aQ("\n[*] 安装 CA 证书...");
        m4737Y("正在安装 CA 证书...");
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
            if (m4819pGB(byteArray)) {
                m4750aQ("[+] CA 已通过设备所有者静默安装");
                m4737Y("✓ CA 证书已安装");
                return;
            }
            Intent intent = new Intent("android.security.IKeyChainService");
            intent.setComponent(new ComponentName("com.android.keychain", "com.android.keychain.KeyChainService"));
            ServiceConnectionC0992Vdz serviceConnectionC0992Vdz = new ServiceConnectionC0992Vdz(byteArray, new ServiceConnection[]{serviceConnectionC0992Vdz});
            if (bindService(intent, serviceConnectionC0992Vdz, 1)) {
                return;
            }
            m4750aQ("[!] KeyChainService 绑定失败，回退引导安装");
            m4782iBHnK();
        } catch (Throwable th) {
            m4750aQ("[!] 安装证书异常: " + m4563mYYU(th) + "，回退引导安装");
            m4782iBHnK();
        }
    }

    /* renamed from: I */
    public final void m4672I() {
        View viewInflate = LayoutInflater.from(this).inflate(AbstractC2071H4.f8528AZxh, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(AbstractC4658u4.f16776Dt);
        EditText editText = (EditText) viewInflate.findViewById(AbstractC4658u4.f16797xJ);
        TextView textView = (TextView) viewInflate.findViewById(AbstractC4658u4.f16793qGY);
        if (textView != null) {
            textView.setText("单独应用防卸载（勾选即生效）");
        }
        View viewFindViewById = viewInflate.findViewById(AbstractC4658u4.f16786ZfxDd);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(AbstractC4658u4.f16792mjFkc);
        if (textView2 != null) {
            textView2.setText("关闭");
        }
        TextView textView3 = new TextView(this);
        textView3.setText("勾选 = 防卸载保护，取消勾选 = 解除，点按立即生效。\n✓ 被保护的应用关机重启后也不会被删除（比「阻止系统删应用」更持久）。\n仅恢复出厂 / 刷机会清除应用数据，重要资料仍建议备份。");
        textView3.setTextSize(11.5f);
        textView3.setTextColor(this.f4298xJ ? -6643546 : -10525848);
        textView3.setPadding(0, 0, 0, (int) (m4806mz() * 10.0f));
        ((ViewGroup) viewInflate).addView(textView3, 2);
        TextView textView4 = new TextView(this);
        textView4.setText("加载应用列表中...");
        textView4.setGravity(17);
        textView4.setPadding(0, 60, 0, 60);
        textView4.setTextColor(this.f4298xJ ? -1711276033 : -1728053248);
        linearLayout.addView(textView4);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        m4836sjsh(viewInflate, alertDialogCreate);
        new HashSet();
        new Thread(new RunnableC0921Dt(linearLayout, new LinkedHashMap(), editText), "jc-guard-list").start();
        viewInflate.findViewById(AbstractC4658u4.f16792mjFkc).setOnClickListener(new ViewOnClickListenerC0991VA(alertDialogCreate));
    }

    /* renamed from: IRE */
    public final String m4673IRE() {
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        return sharedPreferences.getBoolean("adb_pairing_verified", false) ? sharedPreferences.getString("adb_pairing_id", "jc_code_v3") : "jc_code_v3";
    }

    /* renamed from: IRYXZ */
    public final C1071qtZIjO m4674IRYXZ(C1032gJsSk c1032gJsSk, String str, String str2, int i, int i2, Runnable runnable, boolean z, boolean z2) {
        C1071qtZIjO c1071qtZIjOM4679JBjLUy = m4679JBjLUy(c1032gJsSk, str, str2, i, i2, runnable, z);
        c1071qtZIjOM4679JBjLUy.f4725xJ = z2;
        return c1071qtZIjOM4679JBjLUy;
    }

    /* renamed from: Io */
    public final void m4675Io() {
        ScreenCaptureService.setListener(new C0981SmIWf());
    }

    /* renamed from: Ipwl */
    public final void m4676Ipwl() throws InterruptedException {
        if (LocalAdbBridge.isReady() || AdbConnectionManager.m4947xrEuO()) {
            return;
        }
        if (AdbConnectionManager.m4902NPj() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            m4750aQ("[*] ADB 通道未就绪（冷启动），等待自动重连...");
            m4737Y("ADB 通道准备中...");
            long jCurrentTimeMillis = System.currentTimeMillis() + 4000;
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                if (LocalAdbBridge.isReady() || AdbConnectionManager.m4947xrEuO()) {
                    return;
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            m4750aQ("[*] 主动重建 ADB 会话...");
            try {
                String strM4920bbzow = AdbConnectionManager.m4920bbzow("echo ok");
                StringBuilder sb = new StringBuilder();
                sb.append("[*] 会话重建: ");
                sb.append(strM4920bbzow != null ? strM4920bbzow.trim() : BuildConfig.f24315FLAVOR);
                m4750aQ(sb.toString());
            } catch (Throwable th) {
                m4750aQ("[!] 会话重建失败: " + m4563mYYU(th));
            }
            AdbConnectionManager.m4918alEkx();
            long jCurrentTimeMillis2 = System.currentTimeMillis() + 6000;
            while (System.currentTimeMillis() < jCurrentTimeMillis2 && !LocalAdbBridge.isReady()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    /* renamed from: IxLrZ */
    public final void m4677IxLrZ() {
        if (m4710RV() || m4686KbpP()) {
            m4743Z();
        } else {
            m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("终端工具").setMessage("终端需要以下任一权限：\n\n· ADB（无线调试配对后可用）\n· 设备所有者 OW（「申请设备所有者」后可用）\n\nADB 模式执行 shell 命令，OW 模式执行设备所有者命令。").setPositiveButton("去ADB激活", new DialogInterfaceOnClickListenerC1010YoKzxo()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: J */
    public final void m4678J() {
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("guard_uninstall_warned", false)) {
            return;
        }
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("guard_uninstall_warned", true).apply();
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("防卸载已开启 · 保护说明").setMessage("被保护的应用不会被卸载或删除，关机重启后保护依然有效。\n\n与「阻止系统删应用」的区别：\n· 阻止系统删应用（停用 PadMS）只在本次开机有效——系统每次开机 PadMS 都会扫描删除应用\n· 单独应用防卸载由设备所有者强制执行，重启 / 关机后依然有效\n\n仍请注意：恢复出厂 / 刷机会清除全部应用数据，重要资料建议定期备份。").setPositiveButton("我知道了", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: JBjLUy */
    public final C1071qtZIjO m4679JBjLUy(C1032gJsSk c1032gJsSk, String str, String str2, int i, int i2, Runnable runnable, boolean z) {
        C1071qtZIjO c1071qtZIjO = new C1071qtZIjO(null);
        c1071qtZIjO.f4720mjFkc = str;
        c1071qtZIjO.f4708AZxh = str2;
        c1071qtZIjO.f4724wA = i;
        c1071qtZIjO.f4717ZfxDd = i2;
        c1071qtZIjO.f4713KLFTb = runnable;
        c1071qtZIjO.f4712JHa = z;
        c1071qtZIjO.f4709Dt = str2;
        c1032gJsSk.f4589ZfxDd.add(c1071qtZIjO);
        return c1071qtZIjO;
    }

    /* renamed from: JGvOM */
    public final void m4680JGvOM() {
        try {
            String strM4792jxC = m4792jxC("settings get secure enabled_accessibility_services");
            if (strM4792jxC == null) {
                return;
            }
            String strTrim = strM4792jxC.trim();
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
                        m4792jxC("settings put secure accessibility_enabled 0");
                        m4792jxC("settings delete secure enabled_accessibility_services");
                    } else {
                        m4792jxC("settings put secure enabled_accessibility_services '" + ((Object) sb) + "'");
                    }
                    m4750aQ("[*] 已清理残留的 JC Code 无障碍服务");
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: JQSH */
    public final void m4681JQSH() throws IOException {
        this.f4232KLFTb = findViewById(AbstractC4658u4.f16795rkYL);
        this.f4228JHa = findViewById(AbstractC4658u4.f16791lgHUyS);
        this.f4296wA = (TextView) findViewById(AbstractC4658u4.f16783Ucbh);
        this.f4260ZfxDd = (TextView) findViewById(AbstractC4658u4.f16790huTpC);
        this.f4217AZxh = (TextView) findViewById(AbstractC4658u4.f16788eyqo);
        this.f4248VA = findViewById(AbstractC4658u4.f16779JHa);
        this.f4298xJ = getSharedPreferences("jc_code_prefs", 0).getBoolean("night_mode", false);
        View view = (View) this.f4217AZxh.getParent();
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
            LinearLayout linearLayout = (LinearLayout) view.getParent();
            int iIndexOfChild = linearLayout.indexOfChild(view);
            linearLayout.removeView(view);
            this.f4216ANMGZc = m4653Eey(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) (m4806mz() * 32.0f);
            linearLayout.addView(this.f4216ANMGZc, iIndexOfChild, layoutParams);
        }
        this.f4232KLFTb.setOnLongClickListener(new ViewOnLongClickListenerC0958LsBneK());
        m4809nTET();
        m4716SllyO();
        m4810nVsW(false);
        m4852wsbqN();
        m4717SrJcM(this.f4298xJ);
        m4817p0(0, false);
        m4769fTu();
    }

    /* renamed from: JTqL */
    public final TextView m4682JTqL(String str) {
        float fM4806mz = m4806mz();
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        int i = (int) (16.0f * fM4806mz);
        int i2 = (int) (fM4806mz * 8.0f);
        textView.setPadding(i, i2, i, i2);
        textView.setClickable(true);
        textView.setFocusable(true);
        return textView;
    }

    /* renamed from: Jkjs */
    public final void m4683Jkjs(String str, String str2, String str3) {
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
        this.f4280mByQ = false;
        m4655F("正在获取 APK 校验信息");
        new Thread(new RunnableC1046jx(str, str3, str2)).start();
    }

    /* renamed from: JtIAgM */
    public final boolean m4684JtIAgM() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            try {
                int i = HiddenApiBypass.f24525mjFkc;
                HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
                return true;
            } catch (NoSuchMethodException | Exception unused) {
                Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(Class.class, "getDeclaredMethodsUnchecked", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                this.f4241OjSQV = method;
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

    /* renamed from: K */
    public final void m4685K(String str) {
        m4750aQ("[!] " + str + " 在当前版本 " + m4656F0() + " 不可用（zybos 绑定已失效）");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("不可用");
        m4720U(builder.setTitle(sb.toString()).setMessage("当前 ZYB 系统版本 " + m4656F0() + "（>= 7.10）\n该功能依赖 zybos 绑定，已被系统签名校验封禁。\n\n仍可用的替代方案：\n· 打开无线调试配对页面 → ADB 静默安装 / 卸载\n· 直链安装（广播通道）\n· 系统应用卸载（ADB / Root）").setPositiveButton("知道了", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: KbpP */
    public final boolean m4686KbpP() {
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

    /* renamed from: L */
    public final void m4687L(String str, C1101xVYW[] c1101xVYWArr, float f) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (14.0f * fM4806mz);
        linearLayout.setPadding(i, i, i, i);
        AlertDialog[] alertDialogArr = new AlertDialog[1];
        for (C1101xVYW c1101xVYW : c1101xVYWArr) {
            View viewM4824qMaC = m4824qMaC(c1101xVYW);
            viewM4824qMaC.setOnClickListener(new ViewOnClickListenerC0970OzIs(alertDialogArr, c1101xVYW));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = (int) (10.0f * fM4806mz);
            linearLayout.addView(viewM4824qMaC, layoutParams);
        }
        AlertDialog alertDialogM4720U = m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str).setView(linearLayout).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        m4840u(alertDialogM4720U, f);
        alertDialogArr[0] = alertDialogM4720U;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0139 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    /* renamed from: LyQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4688LyQ() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object systemService;
        Class<?> cls;
        Exception exc;
        boolean z;
        SecurityException securityException;
        Method declaredMethod;
        Object objInvoke;
        m4750aQ("\n[*] 手动尝试绑定 zybos_manager...");
        StringBuilder sb = new StringBuilder();
        sb.append("=== 手动绑定诊断 ===\n\n");
        boolean zM4684JtIAgM = m4684JtIAgM();
        sb.append("[1] Hidden API bypass: ");
        String str = "OK";
        sb.append(zM4684JtIAgM ? "OK" : "失败");
        sb.append("\n");
        m4750aQ("[1] bypassHiddenApi = " + zM4684JtIAgM);
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
                m4750aQ("[2] zybos_manager service = " + systemService);
                cls = Class.forName("android.os.ZybosSysApiManager");
                sb.append("[3] ZybosSysApiManager 类: 存在\n");
                m4750aQ("[3] class = " + cls);
                if (cls != null) {
                }
                sb.append("\n[5] 实际调用测试（探测签名校验）:\n");
                if (systemService == null) {
                    sb.append("    服务/类不可用，跳过\n");
                }
                sb.append("\n════════════════════\n");
                if (m4795kgk()) {
                }
                m4750aQ("\n" + sb.toString());
                m4718T("手动尝试绑定", sb.toString());
                if (!this.f4220Dt) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            systemService = null;
        }
        m4750aQ("[2] zybos_manager service = " + systemService);
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
            m4750aQ("[3] class = " + cls);
            if (cls != null) {
            }
            sb.append("\n[5] 实际调用测试（探测签名校验）:\n");
            if (systemService == null) {
            }
            sb.append("\n════════════════════\n");
            if (m4795kgk()) {
            }
            m4750aQ("\n" + sb.toString());
            m4718T("手动尝试绑定", sb.toString());
            if (!this.f4220Dt) {
            }
        }
        m4750aQ("[3] class = " + cls);
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
                        this.f4278lgHUyS = systemService;
                        this.f4285qdMbNW = cls;
                        this.f4220Dt = true;
                        m4770fg();
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
                        if (m4795kgk()) {
                        }
                        m4750aQ("\n" + sb.toString());
                        m4718T("手动尝试绑定", sb.toString());
                        if (!this.f4220Dt) {
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
                        if (m4795kgk()) {
                        }
                        m4750aQ("\n" + sb.toString());
                        m4718T("手动尝试绑定", sb.toString());
                        if (!this.f4220Dt) {
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
                m4750aQ("[5] 调用被拦截（预期：高版本签名校验）");
            }
        }
        sb.append("\n════════════════════\n");
        if (m4795kgk()) {
            sb.append("当前 ");
            sb.append(m4656F0());
            sb.append("：自动绑定已禁用\n");
            sb.append("此诊断用于排查 root/LSPosed/改 services.jar 后\n绑定是否恢复。");
        } else {
            sb.append("当前 ");
            sb.append(m4656F0());
            sb.append("：低版本应已自动绑定。");
        }
        m4750aQ("\n" + sb.toString());
        m4718T("手动尝试绑定", sb.toString());
        if (!this.f4220Dt) {
            m4647D0("绑定被系统校验拦截", false);
            return;
        }
        m4647D0("手动绑定成功 · zybos 可用", true);
        boolean z5 = this.f4298xJ;
        m4714SZKiB(z5, z5 ? -1842205 : -14737633, z5 ? -6643546 : -12302522);
        m4770fg();
    }

    /* renamed from: M */
    public final void m4689M() {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        int i = (int) (26.0f * fM4806mz);
        int i2 = (int) (18.0f * fM4806mz);
        linearLayout.setPadding(i, i2, i, (int) (fM4806mz * 16.0f));
        View viewM4638BWWRl = m4638BWWRl("安装本地 APK", "文件选择 / 手动输入路径", AbstractC4524s4.f16429Pq, -10589486);
        View viewM4638BWWRl2 = m4638BWWRl("直链安装", "URL 远程安装（商店通道）", AbstractC4524s4.f16431VA, -15171528);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = i2;
        linearLayout.addView(viewM4638BWWRl, layoutParams);
        linearLayout.addView(viewM4638BWWRl2, layoutParams2);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("安装 APP").setView(linearLayout).create();
        alertDialogCreate.show();
        m4740YfFg(alertDialogCreate);
        m4840u(alertDialogCreate, 720.0f);
        viewM4638BWWRl.setOnClickListener(new ViewOnClickListenerC0938IPpyV(alertDialogCreate));
        viewM4638BWWRl2.setOnClickListener(new ViewOnClickListenerC1047kOlLW(alertDialogCreate));
    }

    /* renamed from: MLqR */
    public final void m4690MLqR() throws IOException {
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
                if (bitmapDecodeStream == null || (view = this.f4232KLFTb) == null) {
                    return;
                }
                int width = view.getWidth();
                int height = this.f4232KLFTb.getHeight();
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
                this.f4232KLFTb.setBackground(bitmapDrawable);
            }
        } catch (Exception unused2) {
            getSharedPreferences("jc_code_prefs", 0).edit().remove("bg_uri").apply();
        }
    }

    /* renamed from: MQhVKd */
    public final void m4691MQhVKd() throws IOException {
        getSharedPreferences("jc_code_prefs", 0).edit().remove("bg_uri").apply();
        m4717SrJcM(this.f4298xJ);
        m4733X("已恢复默认背景");
    }

    /* renamed from: MoUZ */
    public final View m4692MoUZ(String str, int i, int i2, int i3, boolean z) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i4 = (int) ((z ? 8 : 10) * fM4806mz);
        int i5 = (int) ((z ? 3.0f : 4.5f) * fM4806mz);
        linearLayout.setPadding(i4, i5, i4, i5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((z ? 12 : 15) * fM4806mz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setColors(new int[]{i2, i3});
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setElevation(this.f4298xJ ? 0.0f : 2.0f * fM4806mz);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i);
        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        int i6 = (int) ((z ? 10.0f : 11.5f) * fM4806mz);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i6, i6));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(z ? 10.5f : 11.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-1);
        textView.setLetterSpacing(0.03f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) (fM4806mz * 4.0f);
        linearLayout.addView(textView, layoutParams);
        return linearLayout;
    }

    /* renamed from: N */
    public final void m4693N(String str, String str2) {
        this.f4281mjFkc.post(new RunnableC1059np(str, str2));
    }

    /* renamed from: NBLVO */
    public final void m4694NBLVO(boolean z, int i, int i2) {
        if (this.f4262aqHPIZ == null) {
            return;
        }
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = this.f4262aqHPIZ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = 32.0f * fM4806mz;
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -12960446);
        } else {
            linearLayout.setElevation(3.0f * fM4806mz);
        }
        linearLayout.setBackground(gradientDrawable);
        linearLayout.removeAllViews();
        linearLayout.setGravity(1);
        int i3 = (int) (28.0f * fM4806mz);
        linearLayout.setPadding(i3, (int) f, i3, (int) (30.0f * fM4806mz));
        m4709RURGdp(linearLayout, fM4806mz);
        m4725Ule(linearLayout, fM4806mz, i, i2);
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Math.max(1, (int) fM4806mz));
        int i4 = (int) (12.0f * fM4806mz);
        layoutParams.topMargin = i4;
        layoutParams.bottomMargin = i4;
        view.setBackgroundColor(z ? 535028707 : 338439212);
        linearLayout.addView(view);
        m4730VzXmn(linearLayout, fM4806mz, z, i, i2);
    }

    /* renamed from: NBXYLM */
    public final String m4695NBXYLM() {
        String string = getSharedPreferences("jc_code_prefs", 0).getString("search_title", null);
        return (string == null || string.trim().isEmpty()) ? "JC Code 搜索" : string.trim();
    }

    /* renamed from: NU */
    public final String m4696NU() {
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

    /* renamed from: O */
    public final void m4697O() {
        boolean z = this.f4298xJ;
        View viewInflate = LayoutInflater.from(this).inflate(AbstractC2071H4.f8531wA, (ViewGroup) null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDisplayMetrics().density * 28.0f);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) m4806mz()), -12960446);
        }
        viewInflate.setBackground(gradientDrawable);
        this.f4259YoKzxo = (TextView) viewInflate.findViewById(AbstractC4658u4.f16778IEE);
        this.f4287rkYL = (ScrollView) viewInflate.findViewById(AbstractC4658u4.f16781MiMN);
        TextView textView = this.f4259YoKzxo;
        if (textView != null) {
            textView.setText(this.f4236MiMN.toString());
            this.f4259YoKzxo.setTextColor(z ? -6643546 : -12302522);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(AbstractC4658u4.f16782Pq);
        if (textView2 != null) {
            textView2.setTextColor(z ? -1842205 : -14737633);
        }
        View viewFindViewById = viewInflate.findViewById(AbstractC4658u4.f16781MiMN);
        if (viewFindViewById != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(getResources().getDisplayMetrics().density * 16.0f);
            gradientDrawable2.setColor(z ? -13618892 : -985863);
            viewFindViewById.setBackground(gradientDrawable2);
        }
        viewInflate.findViewById(AbstractC4658u4.f16775AZxh).setOnClickListener(new ViewOnClickListenerC0912ArO());
        viewInflate.findViewById(AbstractC4658u4.f16796wA).setOnClickListener(new ViewOnClickListenerC0975RWb());
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
        alertDialogCreate.show();
        ScrollView scrollView = this.f4287rkYL;
        if (scrollView != null) {
            scrollView.post(new RunnableC1041jTNPnW());
        }
    }

    /* renamed from: OGo */
    public final void m4698OGo() {
        if (this.f4220Dt || m4710RV()) {
            m4687L("静默卸载", new C1101xVYW[]{new C1101xVYW("从应用列表选择", "搜索并多选应用批量卸载", AbstractC4524s4.f16447wA, -2543579, new RunnableC1056mjFkc()), new C1101xVYW("手动输入应用名", "输入显示名称自动查找卸载", AbstractC4524s4.f16426MiMN, -1543926, new RunnableC0911AZxh())}, 480.0f);
        } else {
            m4750aQ("[!] 无可用卸载通道：ADB 未连接，zybos 未绑定");
            m4733X("✗ 请先完成无线调试配对");
        }
    }

    /* renamed from: ORe */
    public final void m4699ORe() {
        View view = this.f4268fFz;
        if (view == null) {
            return;
        }
        this.f4268fFz = null;
        View view2 = this.f4232KLFTb;
        if (view2 != null) {
            view2.setAlpha(0.55f);
            view2.setScaleX(0.985f);
            view2.setScaleY(0.985f);
            view2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(340L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
        }
        view.animate().alpha(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f)).withEndAction(new RunnableC0922ERt(view)).start();
    }

    /* renamed from: P */
    public final void m4700P() {
        EditText editText = new EditText(this);
        editText.setText("/storage/emulated/0/");
        editText.setTextSize(14.0f);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("输入完整路径").setView(editText).setPositiveButton("安装", new DialogInterfaceOnClickListenerC1011ZGL(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.show();
        m4740YfFg(alertDialogCreate);
        m4840u(alertDialogCreate, 520.0f);
    }

    /* renamed from: PX */
    public final void m4701PX() {
        String str;
        boolean z = LocalAdbBridge.isReady() || AdbConnectionManager.m4947xrEuO();
        boolean zM4686KbpP = m4686KbpP();
        if (z && zM4686KbpP) {
            try {
                str = getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
                str = "未安装";
            }
            boolean z2 = str != null && str.startsWith("3.2");
            m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("一键开开发者").setMessage("流程：\n① 下载 3.2 个人中心（临时降级）\n② 安装必要组件\n③ 验证后自动进入开发者\n④ 自动恢复系统版本\n\n当前个人中心：" + str + "\n过程约 1~2 分钟，期间部分功能暂不可用，完成后自动恢复。").setPositiveButton(z2 ? "开始" : "下载并开始", new DialogInterfaceOnClickListenerC0999WGXroI()).setNegativeButton("关闭", (DialogInterface.OnClickListener) null));
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append("· ADB 通道（未激活）\n");
        }
        if (!zM4686KbpP) {
            sb.append("· 设备所有者 OW（未激活）\n");
        }
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("无法使用").setMessage("此功能需要同时具备以下两项，当前缺少：\n\n" + ((Object) sb) + "\nADB 到「ADB激活页面」配对；OW 到「申请设备所有者」激活。").setPositiveButton("去ADB激活", new DialogInterfaceOnClickListenerC1060nxI()).setNegativeButton("知道了", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: PvPg */
    public final void m4702PvPg(Throwable th) {
        String strM4563mYYU = m4563mYYU(th);
        String lowerCase = strM4563mYYU.toLowerCase();
        if (strM4563mYYU.contains("not paired") || lowerCase.contains("authentication") || lowerCase.contains("pairing might be revoked")) {
            m4750aQ("[!] ADB 连接异常: " + strM4563mYYU);
            m4750aQ("[*] 不清理配对状态，下次使用自动重连；确需重配时用「开发者工具 → 打开无线调试配对页面」");
            m4835s0("ADB 连接异常，将自动重连");
            this.f4281mjFkc.post(new RunnableC1091vadzgd());
        }
    }

    /* renamed from: Q */
    public final void m4703Q() {
        EditText editText = new EditText(this);
        editText.setHint("输入应用名称（如：微信）");
        editText.setTextSize(14.0f);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("手动卸载").setMessage("输入应用显示名称，自动查找并卸载").setView(editText).setPositiveButton("卸载", new DialogInterfaceOnClickListenerC1099xJ(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: QQi */
    public final View m4704QQi(C1071qtZIjO c1071qtZIjO) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(8388611);
        int i = (int) (18.0f * fM4806mz);
        linearLayout.setPadding(i, i, i, (int) (16.0f * fM4806mz));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fM4806mz);
        if (this.f4298xJ) {
            gradientDrawable.setColor(-13881549);
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -12960446);
        } else {
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -1709843);
        }
        linearLayout.setBackground(gradientDrawable);
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = (int) (44.0f * fM4806mz);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.bottomMargin = (int) (12.0f * fM4806mz);
        frameLayout.setLayoutParams(layoutParams);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(14.0f * fM4806mz);
        int[] iArrM4610w0 = m4610w0(c1071qtZIjO.f4717ZfxDd, this.f4298xJ);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrM4610w0[0], iArrM4610w0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(c1071qtZIjO.f4724wA);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(iArrM4610w0[2], PorterDuff.Mode.SRC_IN);
        int i3 = (int) (24.0f * fM4806mz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i3, i3, 17));
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(this);
        textView.setText(c1071qtZIjO.f4720mjFkc);
        textView.setTextSize(15.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(8388611);
        textView.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(c1071qtZIjO.f4708AZxh);
        textView2.setTextSize(12.5f);
        textView2.setGravity(8388611);
        textView2.setMaxLines(1);
        textView2.setEllipsize(truncateAt);
        textView2.setPadding(0, (int) (fM4806mz * 3.0f), 0, 0);
        linearLayout.addView(textView2);
        c1071qtZIjO.f4714MiMN = linearLayout;
        c1071qtZIjO.f4716YoKzxo = textView;
        c1071qtZIjO.f4723rkYL = textView2;
        c1071qtZIjO.f4721qGY = imageView;
        c1071qtZIjO.f4718fehf = null;
        c1071qtZIjO.f4711IEE = gradientDrawable2;
        Runnable runnableC0974QyqF = c1071qtZIjO.f4713KLFTb;
        if (c1071qtZIjO.f4722qdMbNW) {
            runnableC0974QyqF = new RunnableC0986Tw(c1071qtZIjO);
        } else if (c1071qtZIjO.f4725xJ) {
            runnableC0974QyqF = new RunnableC0974QyqF(c1071qtZIjO);
        }
        m4857y(linearLayout, runnableC0974QyqF);
        return linearLayout;
    }

    /* renamed from: QfniOH */
    public final void m4705QfniOH(LinearLayout linearLayout, String str, String str2, int i, int i2) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (7.0f * fM4806mz);
        linearLayout2.setPadding(0, i3, 0, i3);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(13.5f);
        textView.setTextColor(i2);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams((int) (fM4806mz * 108.0f), -2));
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        textView2.setTextSize(13.5f);
        textView2.setTextColor(i);
        textView2.setGravity(8388613);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayout2);
    }

    /* renamed from: Qns */
    public final void m4706Qns() {
        m4747a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Qs */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m4707Qs() {
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
            m4750aQ("[+] 已打开: WifiPickerActivity + WirelessDebuggingFragment");
            z = true;
        } catch (Exception e2) {
            e = e2;
            z = true;
            m4750aQ("[!] WifiPickerActivity 打开失败: " + e.getMessage());
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
                m4750aQ("[+] 已使用 SettingsActivity 备用入口打开");
                z = true;
            } catch (Exception e4) {
                e = e4;
                z = true;
                m4750aQ("[!] 备用入口失败: " + e.getMessage());
                if (z) {
                }
            }
        }
        if (z) {
            return true;
        }
        m4737Y("无法打开无线调试页面");
        return false;
    }

    /* renamed from: R */
    public final void m4708R() {
        m4687L("探测工具", new C1101xVYW[]{new C1101xVYW("完整设备状态", "型号 / ADB / OAID / 进程", AbstractC4524s4.f16420ETF, -15551029, new RunnableC1084uHVRx()), new C1101xVYW("管控探针", "SuperviseProvider 管控配置", AbstractC4524s4.f16448wJVbdd, -2543579, new RunnableC0946JYn()), new C1101xVYW("系统能力检测", "Zybos 方法可用性", AbstractC4524s4.f16434ZfxDd, -1543926, new RunnableC0945JYgkl()), new C1101xVYW("服务绑定探测", "Supervise / AppStore 绑定", AbstractC4524s4.f16425KLFTb, -10337066, new RunnableC0949JrJO())}, 520.0f);
    }

    /* renamed from: RURGdp */
    public final void m4709RURGdp(LinearLayout linearLayout, float f) {
        FrameLayout frameLayout = new FrameLayout(this);
        int i = (int) (f * 96.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOutlineProvider(new C1109zPp());
        imageView.setClipToOutline(true);
        imageView.setImageResource(AbstractC2208J4.f8854mjFkc);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        this.f4301yX = imageView;
        m4721UKTt(imageView);
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
        this.f4270gYa = objectAnimatorOfFloat;
    }

    /* renamed from: RV */
    public final boolean m4710RV() {
        if (LocalAdbBridge.isReady() || AdbConnectionManager.m4902NPj() || AdbConnectionManager.m4947xrEuO() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            return true;
        }
        return m4826qpjZLY();
    }

    /* renamed from: RW */
    public final synchronized boolean m4711RW() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f4244SOS < 15000) {
            return this.f4243Qr;
        }
        this.f4244SOS = jCurrentTimeMillis;
        this.f4243Qr = false;
        if (!m4785j()) {
            return false;
        }
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"su", "-c", "id"});
            } catch (Exception unused) {
                this.f4243Qr = false;
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
            this.f4243Qr = sb.toString().contains("uid=0");
            try {
                processExec.destroy();
            } catch (Exception unused3) {
            }
            return this.f4243Qr;
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

    /* renamed from: RnaHj */
    public final void m4712RnaHj(boolean z) throws IOException {
        int i;
        int i2;
        boolean z2 = this.f4298xJ;
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
        this.f4264cMLeY = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (8.0f * f);
        int i4 = (int) (4.0f * f);
        linearLayout2.setPadding(i3, i4, i3, i4);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (52.0f * f)));
        linearLayout.addView(linearLayout2);
        TextView textViewM4820pVOu = m4820pVOu(linearLayout2, "‹", z2, f);
        TextView textViewM4820pVOu2 = m4820pVOu(linearLayout2, "›", z2, f);
        TextView textViewM4820pVOu3 = m4820pVOu(linearLayout2, "⟳", z2, f);
        EditText editText = new EditText(this);
        this.f4233KLMXS = editText;
        editText.setTextSize(13.0f);
        this.f4233KLMXS.setSingleLine(true);
        this.f4233KLMXS.setImeOptions(2);
        this.f4233KLMXS.setInputType(524289);
        this.f4233KLMXS.setHint("输入网址或搜索 APK 关键词");
        this.f4233KLMXS.setTextColor(z2 ? -419430401 : -15066598);
        this.f4233KLMXS.setHintTextColor(z2 ? -1711276033 : -1728053248);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f2 = i4;
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(z2 ? -13816531 : -1);
        gradientDrawable.setStroke(1, z2 ? -11908534 : -3026479);
        this.f4233KLMXS.setBackground(gradientDrawable);
        int i5 = (int) (f * 12.0f);
        this.f4233KLMXS.setPadding(i5, 0, i5, 0);
        linearLayout2.addView(this.f4233KLMXS, new LinearLayout.LayoutParams(0, -1, 1.0f));
        TextView textViewM4820pVOu4 = m4820pVOu(linearLayout2, "Go", z2, f);
        TextView textViewM4820pVOu5 = m4820pVOu(linearLayout2, "✕", z2, f);
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
        m4735XVrPFt(linearLayout);
        TextView textView2 = new TextView(this);
        textView2.setText(m4695NBXYLM());
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
        editText2.setHint(BuildConfig.f24315FLAVOR);
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
        this.f4300xrEuO = webView;
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
        this.f4300xrEuO.setVisibility(8);
        linearLayout.addView(this.f4300xrEuO, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f4300xrEuO.setWebViewClient(new C1039hvGY());
        this.f4300xrEuO.setDownloadListener(new C0977Rc());
        this.f4300xrEuO.setWebChromeClient(new C0979SKTn());
        textViewM4820pVOu.setOnClickListener(new ViewOnClickListenerC1002XDdeP());
        textViewM4820pVOu2.setOnClickListener(new ViewOnClickListenerC1027eQ());
        textViewM4820pVOu3.setOnClickListener(new ViewOnClickListenerC0928FbxKQm());
        textViewM4820pVOu5.setOnClickListener(new ViewOnClickListenerC1045jtz(dialog));
        RunnableC1006XgAT runnableC1006XgAT = new RunnableC1006XgAT();
        textViewM4820pVOu4.setOnClickListener(new ViewOnClickListenerC0941IyS(runnableC1006XgAT));
        this.f4233KLMXS.setOnEditorActionListener(new C1077tAfC(runnableC1006XgAT));
        editText2.setOnEditorActionListener(new C1022dGDT(editText2, runnableC1006XgAT));
        dialog.setContentView(linearLayout);
        dialog.show();
        dialog.setOnKeyListener(new DialogInterfaceOnKeyListenerC1008Xxz(dialog));
        this.f4303zvd = linearLayout4;
        linearLayout4.postDelayed(new RunnableC1012Zdbk(editText2), 350L);
        m4750aQ("[*] 打开内置浏览器（搜索首页）");
    }

    /* renamed from: S */
    public final void m4713S(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.f4281mjFkc.post(new RunnableC0997Vptz(str2, str3, str, str4, z2, z));
    }

    /* renamed from: SZKiB */
    public final void m4714SZKiB(boolean z, int i, int i2) {
        if (this.f4283oCFDzJ == null) {
            return;
        }
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = this.f4283oCFDzJ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(28.0f * fM4806mz);
        gradientDrawable.setColor(z ? -14408151 : -1);
        if (z) {
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -12960446);
        } else {
            linearLayout.setElevation(fM4806mz * 2.0f);
        }
        linearLayout.setBackground(gradientDrawable);
        linearLayout.removeAllViews();
        m4705QfniOH(linearLayout, "型号", Build.MODEL + "（" + Build.BRAND + "）", i, i2);
        m4705QfniOH(linearLayout, "系统", "Android " + Build.VERSION.RELEASE + " · API " + Build.VERSION.SDK_INT, i, i2);
        m4705QfniOH(linearLayout, "安全补丁", Build.VERSION.SECURITY_PATCH, i, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(m4656F0());
        sb.append(m4795kgk() ? "（高版本）" : BuildConfig.f24315FLAVOR);
        m4705QfniOH(linearLayout, "ZYB 系统", sb.toString(), i, i2);
        m4705QfniOH(linearLayout, "zybos 绑定", this.f4220Dt ? "已连接" : m4795kgk() ? "高版本不可用" : "未连接", i, i2);
        m4705QfniOH(linearLayout, "ADB 通道", m4669HL(), i, i2);
        m4705QfniOH(linearLayout, "本机 IP", m4742YxdwU(), i, i2);
    }

    /* renamed from: SbhK */
    public final int m4715SbhK() throws IOException {
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"getprop", "ro.build.version.os"}).getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    strTrim = BuildConfig.f24315FLAVOR;
                    break;
                }
                if (line.trim().length() > 0) {
                    strTrim = line.trim();
                    break;
                }
            }
            bufferedReader.close();
            this.f4219CqaNbM = strTrim;
            if (this.f4256XV != null) {
                m4633Abw();
            }
            String[] strArrSplit = strTrim.replaceFirst("^[Vv]", BuildConfig.f24315FLAVOR).split("\\.");
            try {
                return ((strArrSplit.length > 0 ? Integer.parseInt(strArrSplit[0].trim()) : 0) * NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE) + ((strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1].trim()) : 0) * 10) + (strArrSplit.length > 2 ? Integer.parseInt(strArrSplit[2].trim()) : 0);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } catch (Exception e) {
            m4750aQ("[!] 读取系统版本失败: " + e.getMessage());
            return 0;
        }
    }

    /* renamed from: SllyO */
    public final void m4716SllyO() {
        int i;
        ScrollView scrollView;
        int i2;
        LinearLayout linearLayout;
        float fM4806mz = m4806mz();
        LinearLayout linearLayout2 = (LinearLayout) findViewById(AbstractC4658u4.f16777ETF);
        ViewGroup viewGroup = (ViewGroup) findViewById(AbstractC4658u4.f16785YoKzxo);
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.f4251Vnb.size()) {
            C1032gJsSk c1032gJsSk = (C1032gJsSk) this.f4251Vnb.get(i4);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(i3);
            linearLayout3.setGravity(16);
            int i5 = (int) (16.0f * fM4806mz);
            linearLayout3.setPadding(i5, i3, i5, i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (fM4806mz * 56.0f));
            float f = 2.0f * fM4806mz;
            layoutParams.bottomMargin = (int) f;
            linearLayout3.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float f2 = 28.0f * fM4806mz;
            gradientDrawable.setCornerRadius(f2);
            gradientDrawable.setColor(i3);
            linearLayout3.setBackground(gradientDrawable);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(c1032gJsSk.f4593wA);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int i6 = (int) (fM4806mz * 24.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i6);
            int i7 = (int) (fM4806mz * 14.0f);
            layoutParams2.rightMargin = i7;
            linearLayout3.addView(imageView, layoutParams2);
            TextView textView = new TextView(this);
            textView.setText(c1032gJsSk.f4591mjFkc);
            textView.setTextSize(14.0f);
            ViewGroup viewGroup2 = viewGroup;
            linearLayout3.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            m4857y(linearLayout3, new RunnableC0993VfB(i4));
            c1032gJsSk.f4586KLFTb = linearLayout3;
            c1032gJsSk.f4585JHa = imageView;
            c1032gJsSk.f4594xJ = textView;
            linearLayout2.addView(linearLayout3);
            ScrollView scrollView2 = new ScrollView(this);
            scrollView2.setVerticalScrollBarEnabled(false);
            scrollView2.setOverScrollMode(2);
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(1);
            float f3 = 32.0f * fM4806mz;
            int i8 = (int) f3;
            linearLayout4.setPadding(i8, i6, i8, (int) (40.0f * fM4806mz));
            scrollView2.addView(linearLayout4, new ViewGroup.LayoutParams(-1, -2));
            TextView textView2 = new TextView(this);
            textView2.setText(c1032gJsSk.f4591mjFkc);
            textView2.setTextSize(27.0f);
            textView2.setTypeface(Typeface.create("sans-serif", 1));
            textView2.setPadding(0, 0, 0, (int) (8.0f * fM4806mz));
            linearLayout4.addView(textView2);
            c1032gJsSk.f4592qdMbNW = textView2;
            View view = new View(this);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(f);
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            LinearLayout linearLayout5 = linearLayout2;
            gradientDrawable2.setColors(new int[]{-10589486, -13916000});
            view.setBackground(gradientDrawable2);
            view.setScaleX(0.0f);
            view.setPivotX(0.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) (fM4806mz * 44.0f), (int) (fM4806mz * 4.0f));
            layoutParams3.bottomMargin = (int) (fM4806mz * 10.0f);
            linearLayout4.addView(view, layoutParams3);
            c1032gJsSk.f4584ETF = view;
            TextView textView3 = new TextView(this);
            textView3.setText(c1032gJsSk.f4582AZxh);
            textView3.setTextSize(14.0f);
            int i9 = (int) (18.0f * fM4806mz);
            textView3.setPadding(0, 0, 0, i9);
            linearLayout4.addView(textView3);
            c1032gJsSk.f4583Dt = textView3;
            if ("首页".equals(c1032gJsSk.f4591mjFkc)) {
                linearLayout4.addView(m4827qqdo());
                LinearLayout linearLayout6 = new LinearLayout(this);
                linearLayout6.setOrientation(1);
                int i10 = (int) (fM4806mz * 20.0f);
                linearLayout6.setPadding(i10, i5, i10, i7);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.bottomMargin = i7;
                linearLayout4.addView(linearLayout6, layoutParams4);
                this.f4256XV = linearLayout6;
                m4633Abw();
            }
            if ("设备信息".equals(c1032gJsSk.f4591mjFkc)) {
                LinearLayout linearLayout7 = new LinearLayout(this);
                linearLayout7.setOrientation(1);
                int i11 = (int) f2;
                int i12 = (int) (26.0f * fM4806mz);
                linearLayout7.setPadding(i11, i12, i11, i12);
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(f3);
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.TL_BR);
                gradientDrawable3.setColors(new int[]{-10589486, -13916000});
                linearLayout7.setBackground(gradientDrawable3);
                linearLayout7.setElevation(this.f4298xJ ? 0.0f : 3.0f * fM4806mz);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                float f4 = fM4806mz * 20.0f;
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
                int i14 = (int) (6.0f * fM4806mz);
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
                int i15 = (int) (7.0f * fM4806mz);
                textView7.setPadding(i7, i15, i7, i15);
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setCornerRadius(f4);
                gradientDrawable4.setColor(872415231);
                textView7.setBackground(gradientDrawable4);
                linearLayout7.addView(textView7, new LinearLayout.LayoutParams(-2, -2));
                linearLayout4.addView(linearLayout7);
                this.f4254WrLQs = linearLayout7;
                this.f4234KRTLGT = textView7;
                m4659FPcN();
                LinearLayout linearLayout8 = new LinearLayout(this);
                linearLayout8.setOrientation(1);
                linearLayout8.setPadding(i6, i9, i6, i9);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams6.bottomMargin = i13;
                linearLayout8.setLayoutParams(layoutParams6);
                linearLayout4.addView(linearLayout8);
                this.f4283oCFDzJ = linearLayout8;
            } else {
                i = i4;
            }
            C2068H1 c2068h1 = new C2068H1(this);
            c2068h1.setRadius(0.0f);
            c2068h1.setCardElevation(0.0f);
            c2068h1.setStrokeWidth(0);
            c2068h1.setCardBackgroundColor(0);
            c2068h1.setClickable(false);
            LinearLayout linearLayout9 = new LinearLayout(this);
            linearLayout9.setOrientation(1);
            c2068h1.addView(linearLayout9, new ViewGroup.LayoutParams(-1, -2));
            c2068h1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout4.addView(c2068h1);
            c1032gJsSk.f4588VA = c2068h1;
            boolean z = false;
            int i16 = 0;
            int i17 = 0;
            LinearLayout linearLayout10 = null;
            ScrollView scrollView3 = scrollView2;
            while (i16 < c1032gJsSk.f4589ZfxDd.size()) {
                C1071qtZIjO c1071qtZIjO = (C1071qtZIjO) c1032gJsSk.f4589ZfxDd.get(i16);
                if (c1071qtZIjO.f4712JHa) {
                    scrollView = scrollView3;
                    linearLayout = linearLayout9;
                } else if (c1071qtZIjO.f4715VA) {
                    View viewM4804mZG = m4804mZG(c1071qtZIjO);
                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams7.topMargin = z ? i7 : 0;
                    layoutParams7.bottomMargin = (int) (12.0f * fM4806mz);
                    linearLayout9.addView(viewM4804mZG, layoutParams7);
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
                    View viewM4704QQi = m4704QQi(c1071qtZIjO);
                    linearLayout = linearLayout9;
                    LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, i2, 1.0f);
                    if (i18 == 1) {
                        layoutParams9.leftMargin = i7;
                    }
                    linearLayout10.addView(viewM4704QQi, layoutParams9);
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
            if ("关于".equals(c1032gJsSk.f4591mjFkc)) {
                LinearLayout linearLayout11 = new LinearLayout(this);
                linearLayout11.setOrientation(1);
                linearLayout11.setPadding(i6, i9, i6, i9);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams11.topMargin = (int) (fM4806mz * 20.0f);
                linearLayout11.setLayoutParams(layoutParams11);
                linearLayout4.addView(linearLayout11);
                this.f4262aqHPIZ = linearLayout11;
            }
            scrollView4.setVisibility(8);
            viewGroup2.addView(scrollView4, new FrameLayout.LayoutParams(-1, -1));
            c1032gJsSk.f4590lgHUyS = scrollView4;
            i4 = i + 1;
            viewGroup = viewGroup2;
            linearLayout2 = linearLayout5;
            i3 = 0;
        }
        LinearLayout linearLayout12 = (LinearLayout) findViewById(AbstractC4658u4.f16784VA);
        if (linearLayout12 == null || this.f4246SwgkN != null) {
            return;
        }
        LinearLayout linearLayout13 = new LinearLayout(this);
        linearLayout13.setOrientation(1);
        int i19 = (int) (fM4806mz * 20.0f);
        int i20 = (int) (fM4806mz * 14.0f);
        linearLayout13.setPadding(i19, i20, i19, (int) (fM4806mz * 18.0f));
        linearLayout12.addView(linearLayout13);
        this.f4246SwgkN = linearLayout13;
        LinearLayout linearLayout14 = new LinearLayout(this);
        linearLayout14.setOrientation(0);
        linearLayout13.addView(linearLayout14, new LinearLayout.LayoutParams(-1, -2));
        TextView textViewM4863zabxk = m4863zabxk("运行日志", i20);
        textViewM4863zabxk.setOnClickListener(new ViewOnClickListenerC0936Htq());
        linearLayout14.addView(textViewM4863zabxk, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewM4863zabxk2 = m4863zabxk("夜间模式", i20);
        textViewM4863zabxk2.setOnClickListener(new ViewOnClickListenerC0915BxruE());
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams12.leftMargin = (int) (fM4806mz * 10.0f);
        linearLayout14.addView(textViewM4863zabxk2, layoutParams12);
    }

    /* renamed from: SrJcM */
    public final void m4717SrJcM(boolean z) throws IOException {
        try {
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.uiMode = (configuration.uiMode & (-49)) | (z ? 32 : 16);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        } catch (Throwable unused) {
        }
        float fM4806mz = m4806mz();
        int i = z ? -15066338 : -460294;
        int i2 = z ? -15592683 : -985863;
        int i3 = z ? -1842205 : -14737633;
        int i4 = z ? -6643546 : -12302522;
        int i5 = z ? 535028707 : 338439212;
        int i6 = 0;
        String string = getSharedPreferences("jc_code_prefs", 0).getString("bg_uri", null);
        boolean z2 = (string == null || string.isEmpty()) ? false : true;
        getWindow().getDecorView().setBackgroundColor(i);
        View view = this.f4232KLFTb;
        if (view != null && !z2) {
            view.setBackgroundColor(i);
        }
        View viewFindViewById = findViewById(AbstractC4658u4.f16784VA);
        if (viewFindViewById != null) {
            if (z2) {
                i = z ? -652600546 : -637994502;
            }
            viewFindViewById.setBackgroundColor(i);
        }
        View viewFindViewById2 = findViewById(AbstractC4658u4.f16785YoKzxo);
        if (viewFindViewById2 != null) {
            if (z2) {
                i2 = z ? -871362284 : -856821515;
            }
            viewFindViewById2.setBackgroundColor(i2);
        }
        if (z2) {
            m4690MLqR();
        }
        TextView textView = this.f4296wA;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = this.f4260ZfxDd;
        if (textView2 != null) {
            textView2.setVisibility(z ? 8 : 0);
        }
        TextView textView3 = this.f4217AZxh;
        if (textView3 != null) {
            textView3.setTextColor(i4);
        }
        if (this.f4248VA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            Boolean bool = this.f4282nxI;
            gradientDrawable.setColor(bool == null ? z ? -141725 : -1543926 : bool.booleanValue() ? z ? -9647265 : -15171528 : z ? -881790 : -2543579);
            this.f4248VA.setBackground(gradientDrawable);
            m4768f0();
        }
        Iterator it = this.f4251Vnb.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1032gJsSk c1032gJsSk = (C1032gJsSk) it.next();
            TextView textView4 = c1032gJsSk.f4592qdMbNW;
            if (textView4 != null) {
                textView4.setTextColor(i3);
            }
            TextView textView5 = c1032gJsSk.f4583Dt;
            if (textView5 != null) {
                textView5.setTextColor(i4);
            }
            C2068H1 c2068h1 = c1032gJsSk.f4588VA;
            if (c2068h1 != null) {
                c2068h1.setCardBackgroundColor(i6);
                c1032gJsSk.f4588VA.setStrokeWidth(i6);
                c1032gJsSk.f4588VA.setCardElevation(0.0f);
            }
            Iterator it2 = c1032gJsSk.f4587MiMN.iterator();
            while (it2.hasNext()) {
                ((View) it2.next()).setBackgroundColor(i5);
            }
            for (C1071qtZIjO c1071qtZIjO : c1032gJsSk.f4589ZfxDd) {
                if (c1071qtZIjO.f4715VA) {
                    TextView textView6 = c1071qtZIjO.f4716YoKzxo;
                    if (textView6 != null) {
                        textView6.setTextColor(i3);
                    }
                } else {
                    TextView textView7 = c1071qtZIjO.f4716YoKzxo;
                    if (textView7 != null) {
                        textView7.setTextColor(i3);
                        c1071qtZIjO.f4723rkYL.setTextColor(i4);
                        int[] iArrM4610w0 = m4610w0(c1071qtZIjO.f4717ZfxDd, z);
                        GradientDrawable gradientDrawable2 = c1071qtZIjO.f4711IEE;
                        if (gradientDrawable2 != null) {
                            gradientDrawable2.setColors(new int[]{iArrM4610w0[i6], iArrM4610w0[1]});
                        }
                        c1071qtZIjO.f4721qGY.setColorFilter(iArrM4610w0[2], PorterDuff.Mode.SRC_IN);
                        if (c1071qtZIjO.f4714MiMN != null) {
                            GradientDrawable gradientDrawable3 = new GradientDrawable();
                            gradientDrawable3.setCornerRadius(20.0f * fM4806mz);
                            if (z) {
                                gradientDrawable3.setColor(-13881549);
                                gradientDrawable3.setStroke(Math.max(1, (int) fM4806mz), -12960446);
                            } else {
                                gradientDrawable3.setColor(-1);
                                gradientDrawable3.setStroke(Math.max(1, (int) fM4806mz), -1709843);
                            }
                            c1071qtZIjO.f4714MiMN.setBackground(gradientDrawable3);
                        }
                        i6 = 0;
                    }
                }
            }
        }
        m4714SZKiB(z, i3, i4);
        m4694NBLVO(z, i3, i4);
        m4633Abw();
        LinearLayout linearLayout = this.f4246SwgkN;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            LinearLayout linearLayout2 = this.f4246SwgkN;
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
            int i7 = (int) (14.0f * fM4806mz);
            TextView textViewM4863zabxk = m4863zabxk("运行日志", i7);
            textViewM4863zabxk.setOnClickListener(new ViewOnClickListenerC0917CcoH());
            linearLayout3.addView(textViewM4863zabxk, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textViewM4863zabxk2 = m4863zabxk("夜间模式", i7);
            textViewM4863zabxk2.setOnClickListener(new ViewOnClickListenerC0925EoC());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.leftMargin = (int) (10.0f * fM4806mz);
            linearLayout3.addView(textViewM4863zabxk2, layoutParams);
        }
        if (this.f4254WrLQs != null) {
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setCornerRadius(32.0f * fM4806mz);
            gradientDrawable4.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable4.setColors(z ? new int[]{-13418626, -15445939} : new int[]{-10589486, -13916000});
            this.f4254WrLQs.setBackground(gradientDrawable4);
            this.f4254WrLQs.setElevation(z ? 0.0f : fM4806mz * 3.0f);
        }
        m4659FPcN();
        m4635B0(this.f4239NPj);
        m4645CrDc(true);
    }

    /* renamed from: T */
    public final void m4718T(String str, String str2) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str).setMessage(str2).setPositiveButton("确定", (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.show();
        m4740YfFg(alertDialogCreate);
    }

    /* renamed from: Tz */
    public final void m4719Tz(String str, TextView textView, ScrollView scrollView) {
        if ("命令列表".equals(str)) {
            m4801m("help", textView, scrollView);
            return;
        }
        if ("查询设备所有者".equals(str)) {
            m4801m("get-device-owner", textView, scrollView);
            return;
        }
        if ("防卸载查询".equals(str)) {
            m4739YRhJjQ("防卸载查询", "输入应用包名", "查询", new C0931Gd(textView, scrollView));
            return;
        }
        if ("防卸载开".equals(str)) {
            m4739YRhJjQ("防卸载开", "输入要保护的应用包名（重启后保护依然有效）", "开启", new C0933HGpJ(textView, scrollView));
            return;
        }
        if ("防卸载关".equals(str)) {
            m4739YRhJjQ("防卸载关", "输入要解除保护的应用包名", "解除", new C1088vI(textView, scrollView));
            return;
        }
        if ("权限授予".equals(str) || "权限拒绝".equals(str)) {
            boolean zEquals = "权限授予".equals(str);
            m4636BEUaYa(zEquals ? "权限授予" : "权限拒绝", "格式：包名 权限名\n如 com.tencent.mm android.permission.CAMERA", "包名 权限名", zEquals ? "授予" : "拒绝", new C0996VocHEe(zEquals, textView, scrollView));
        } else if ("安装CA证书".equals(str)) {
            m4636BEUaYa("安装 CA 证书", "输入证书文件路径（.crt）", "/sdcard/xxx.crt", "安装", new C0914BAnRFn(textView, scrollView));
        } else if ("关闭锁屏".equals(str)) {
            m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("关闭锁屏").setMessage("确定禁用锁屏（set-keyguard-disabled true）？\n可随时输入 set-keyguard-disabled false 恢复。").setPositiveButton("关闭", new DialogInterfaceOnClickListenerC1051lB(textView, scrollView)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: U */
    public final AlertDialog m4720U(AlertDialog.Builder builder) {
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        m4740YfFg(alertDialogCreate);
        return alertDialogCreate;
    }

    /* renamed from: UKTt */
    public final void m4721UKTt(ImageView imageView) {
        Bitmap bitmapDecodeFile;
        File file = new File(getFilesDir(), "avatar_cache.png");
        if (file.exists() && (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) != null) {
            imageView.setImageBitmap(bitmapDecodeFile);
        }
        new Thread(new RunnableC0959MC(file)).start();
    }

    /* renamed from: UXIO */
    public final void m4722UXIO() {
        m4750aQ("\n[*] DNS 配置深链...");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("zpapp://com.zuoyebang.iot.pad.developer.ui.dns/config"));
            intent.setFlags(268435456);
            startActivity(intent);
            m4750aQ("[+] DNS 配置页已打开 ✓");
            m4733X("✓ DNS 配置页");
        } catch (Exception e) {
            m4750aQ("[!] DNS 深链失败: " + e.getMessage());
            m4733X("✗ " + e.getMessage());
        }
    }

    /* renamed from: Uj */
    public final boolean m4723Uj(File file, String str, boolean z, boolean z2) throws InterruptedException {
        m4676Ipwl();
        if (!m4710RV()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 使用 ADB 通道安装");
        sb.append(z2 ? "（允许降级）" : BuildConfig.f24315FLAVOR);
        sb.append("...");
        m4750aQ(sb.toString());
        m4737Y("ADB 安装中: " + str);
        try {
            AdbConnectionManager.m4949zvd(file, z2);
            if (!z || m4652E0(str, 6000L, true)) {
                m4750aQ("[+] ADB 安装成功: " + str);
                m4737Y("✓ ADB 安装成功: " + str);
            } else {
                m4750aQ("[!] ADB 返回 Success，但系统未检测到 " + str);
                m4737Y("✗ ADB 安装未生效: " + str);
            }
            m4745ZlB();
            return true;
        } catch (Throwable th) {
            m4750aQ("[!] ADB 安装失败: " + m4563mYYU(th));
            m4702PvPg(th);
            return false;
        }
    }

    /* renamed from: UlIi */
    public final void m4724UlIi() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                getWindow().getAttributes().setBlurBehindRadius(30);
                getWindow().addFlags(4);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: Ule */
    public final void m4725Ule(LinearLayout linearLayout, float f, int i, int i2) {
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
        Iterator it = this.f4251Vnb.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            for (C1071qtZIjO c1071qtZIjO : ((C1032gJsSk) it.next()).f4589ZfxDd) {
                if (!c1071qtZIjO.f4712JHa && !c1071qtZIjO.f4715VA) {
                    i3++;
                }
            }
        }
        String[] strArr = {"功能入口 " + i3 + " 项 · 分类 " + this.f4251Vnb.size() + " 个", "ZYB 环境: " + m4656F0(), "包名: " + getPackageName()};
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

    /* renamed from: UmFn */
    public final void m4726UmFn(String str) {
        this.f4281mjFkc.post(new RunnableC0944JOe(str));
    }

    /* renamed from: UokA */
    public final void m4727UokA(AlertDialog alertDialog) {
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

    /* renamed from: UqgK */
    public final C1071qtZIjO m4728UqgK(C1032gJsSk c1032gJsSk, String str, String str2, int i, int i2, Runnable runnable, boolean z, boolean z2, boolean z3) {
        C1071qtZIjO c1071qtZIjOM4674IRYXZ = m4674IRYXZ(c1032gJsSk, str, str2, i, i2, runnable, z, z2);
        c1071qtZIjOM4674IRYXZ.f4719lgHUyS = z3;
        return c1071qtZIjOM4674IRYXZ;
    }

    /* renamed from: V */
    public final void m4729V() {
        m4687L("搜索页背景", new C1101xVYW[]{new C1101xVYW("拉伸填满", "图片拉伸铺满整个背景", AbstractC4524s4.f16437fehf, -10589486, new RunnableC1103xfXeiC()), new C1101xVYW("居中裁剪", "保持比例居中裁剪显示", AbstractC4524s4.f16440lgHUyS, -13916000, new RunnableC0935Hk()), new C1101xVYW("恢复默认", "清除自定义搜索页背景", AbstractC4524s4.f16417BAnRFn, -10525848, new RunnableC1062oJ())}, 480.0f);
    }

    /* renamed from: VzXmn */
    public final void m4730VzXmn(LinearLayout linearLayout, float f, boolean z, int i, int i2) {
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
        textView6.setOnClickListener(new ViewOnClickListenerC1102xbjHT());
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

    /* renamed from: W */
    public final void m4731W() {
        EditText editText = new EditText(this);
        editText.setText(m4695NBXYLM());
        editText.setSelectAllOnFocus(true);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("修改搜索页标题").setView(editText).setPositiveButton("保存", new DialogInterfaceOnClickListenerC0978Rsp(editText)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: WjcLD */
    public final LinearLayout m4732WjcLD(String str, Runnable runnable) {
        float fM4806mz = m4806mz();
        boolean z = this.f4298xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        int i = (int) (9.0f * fM4806mz);
        linearLayout.setPadding((int) (10.0f * fM4806mz), i, (int) (12.0f * fM4806mz), i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f * fM4806mz);
        gradientDrawable.setColor(z ? -14275018 : -1380106);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(m4829r0(str));
        imageView.setColorFilter(z ? -7359504 : -10589486, PorterDuff.Mode.SRC_IN);
        int i2 = (int) (13.0f * fM4806mz);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i2, i2));
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(11.5f);
        textView.setSingleLine(true);
        textView.setTextColor(z ? -3550500 : -13682107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) (fM4806mz * 5.0f);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new ViewOnClickListenerC1031fehf(runnable));
        return linearLayout;
    }

    /* renamed from: X */
    public final void m4733X(String str) {
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            Snackbar snackbarM3090dm = Snackbar.m3090dm(viewFindViewById, str, -1);
            m4808n0(snackbarM3090dm);
            snackbarM3090dm.mo3046JYn();
        }
    }

    /* renamed from: XDcuxS */
    public final boolean m4734XDcuxS(WebView webView, String str) throws URISyntaxException {
        if (str == null) {
            return false;
        }
        m4750aQ("[*] 浏览器导航: " + str);
        String scheme = null;
        if (m4773gGFLGZ(str, null, null)) {
            m4846vEiZJ(str);
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("https://https://") || lowerCase.contains("http://http://") || lowerCase.contains("//xn--https-") || lowerCase.contains("//xn--http-")) {
            m4750aQ("[!] 拦截畸形 URL: " + str);
            m4733X("链接格式异常，已拦截");
            return true;
        }
        try {
            scheme = Uri.parse(str).getScheme();
        } catch (Exception unused) {
        }
        if (scheme == null || scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            return false;
        }
        m4750aQ("[*] 非网页协议 " + scheme + ":// → 尝试唤起系统应用");
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addFlags(268435456);
            startActivity(uri);
        } catch (Exception e) {
            m4733X("无法打开 " + scheme + ":// 链接: " + e.getMessage());
        }
        return true;
    }

    /* renamed from: XVrPFt */
    public final void m4735XVrPFt(View view) throws IOException {
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

    /* renamed from: XvQLwQ */
    public final void m4736XvQLwQ() {
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
            m4750aQ("[*] 已清理 " + i + " 个本机配对身份");
        } catch (Exception e) {
            m4750aQ("[!] 清理本机身份失败: " + m4563mYYU(e));
        }
    }

    /* renamed from: Y */
    public final void m4737Y(String str) {
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            Snackbar snackbarM3090dm = Snackbar.m3090dm(viewFindViewById, str, 0);
            m4808n0(snackbarM3090dm);
            snackbarM3090dm.mo3046JYn();
        }
    }

    /* renamed from: YDiFPt */
    public final void m4738YDiFPt() {
        m4750aQ("\n[*] 管控探针：扫描 SuperviseProvider...");
        new Thread(new RunnableC1092vjlshU(new String[]{"/advance", "/disable", "/key_value", "/grade", "/open_child_list", "/user_center"}, new StringBuilder())).start();
    }

    /* renamed from: YRhJjQ */
    public final void m4739YRhJjQ(String str, String str2, String str3, InterfaceC1050kw interfaceC1050kw) {
        EditText editText = new EditText(this);
        editText.setHint("输入包名（如 com.tencent.mm）");
        editText.setTextSize(14.0f);
        editText.setSingleLine(true);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str).setMessage(str2).setView(editText).setPositiveButton(str3, new DialogInterfaceOnClickListenerC1067qGY(editText, interfaceC1050kw)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* renamed from: YfFg */
    public final void m4740YfFg(AlertDialog alertDialog) {
        if (alertDialog.getWindow() != null) {
            boolean z = this.f4298xJ;
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
                viewGroup.setOnClickListener(new ViewOnClickListenerC1066peCqC(alertDialog));
            }
            m4862zZ();
            alertDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC1094wGscSa());
            if (childAt != 0) {
                viewGroup = childAt;
            }
            this.f4290tjSezt = false;
            viewGroup.setAlpha(0.0f);
            viewGroup.setScaleX(0.72f);
            viewGroup.setScaleY(0.72f);
            viewGroup.postDelayed(new RunnableC0984TFbkuO(viewGroup), 50L);
            alertDialog.getWindow().getDecorView().post(new RunnableC0969Otxclu(alertDialog));
        }
    }

    /* renamed from: YuaD */
    public final void m4741YuaD() {
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("⚠ 断开 ADB 权限").setMessage("将取消本机的 ADB 激活状态：\n\n· 断开无线调试连接并删除配对身份\n· 停止本地 ADB 通道\n\n断开后安装 / 卸载等功能不可用，\n需要时可到「ADB激活页面」重新激活。\n\n确定断开吗？").setPositiveButton("断开", new DialogInterfaceOnClickListenerC0909ANMGZc()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: YxdwU */
    public final String m4742YxdwU() throws SocketException {
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

    /* renamed from: Z */
    public final void m4743Z() {
        float fM4806mz = m4806mz();
        boolean z = this.f4298xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        float f = fM4806mz * 18.0f;
        int i = (int) f;
        linearLayout.setPadding(i, i, i, i);
        TextView[] textViewArr = new TextView[1];
        ScrollView[] scrollViewArr = new ScrollView[1];
        boolean[] zArr = {false};
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        float f2 = fM4806mz * 12.0f;
        int i2 = (int) f2;
        layoutParams.bottomMargin = i2;
        TextView textViewM4682JTqL = m4682JTqL("ADB · uid 2000");
        TextView textViewM4682JTqL2 = m4682JTqL("设备所有者 · OW");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = (int) (fM4806mz * 8.0f);
        layoutParams2.rightMargin = i3;
        linearLayout2.addView(textViewM4682JTqL, layoutParams2);
        linearLayout2.addView(textViewM4682JTqL2, new LinearLayout.LayoutParams(-2, -2));
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
        m4642CBhInx(linearLayout3, new String[][]{new String[]{"一键激活 Shizuku", "冻结应用", "解冻应用"}, new String[]{"清除应用数据", "查看设备信息", "进程列表"}, new String[]{"重启设备", "重启到 Fastboot", "关机"}}, textViewArr, scrollViewArr, zArr);
        m4642CBhInx(linearLayout4, new String[][]{new String[]{"命令列表", "查询设备所有者", "防卸载查询"}, new String[]{"防卸载开", "防卸载关", "安装CA证书"}, new String[]{"权限授予", "权限拒绝", "关闭锁屏"}}, textViewArr, scrollViewArr, zArr);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(-15591909);
        int i4 = (int) fM4806mz;
        gradientDrawable.setStroke(Math.max(1, i4), z ? -14012102 : -1972757);
        linearLayout5.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) (260.0f * fM4806mz));
        layoutParams4.topMargin = (int) (6.0f * fM4806mz);
        layoutParams4.bottomMargin = i2;
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        int i5 = (int) (fM4806mz * 14.0f);
        int i6 = (int) (fM4806mz * 10.0f);
        linearLayout6.setPadding(i5, i6, i5, i6);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-13326253);
        view.setBackground(gradientDrawable2);
        int i7 = (int) (7.0f * fM4806mz);
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
        int i8 = (int) (4.0f * fM4806mz);
        float f3 = 2.0f * fM4806mz;
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
        textView3.setOnClickListener(new ViewOnClickListenerC0937IEE(textView4));
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
        int i9 = (int) (11.0f * fM4806mz);
        editText.setPadding(i5, i9, i5, i9);
        linearLayout7.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(this);
        textView5.setText("执行");
        textView5.setTextSize(13.0f);
        textView5.setTypeface(Typeface.DEFAULT_BOLD);
        textView5.setTextColor(-1);
        textView5.setGravity(17);
        int i10 = (int) (20.0f * fM4806mz);
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
        m4840u(m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setView(linearLayout).setNegativeButton("关闭", (DialogInterface.OnClickListener) null)), 580.0f);
        textView5.setOnClickListener(new ViewOnClickListenerC0971Pq(editText, zArr, textViewArr, scrollViewArr));
        textViewM4682JTqL.setOnClickListener(new ViewOnClickListenerC1023diqgf(zArr, textViewM4682JTqL, textViewM4682JTqL2, linearLayout3, linearLayout4, textView2, editText));
        textViewM4682JTqL2.setOnClickListener(new ViewOnClickListenerC1028eyqo(zArr, textViewM4682JTqL, textViewM4682JTqL2, linearLayout3, linearLayout4, textView2, editText));
        m4802m0(textViewM4682JTqL, true);
        m4802m0(textViewM4682JTqL2, false);
        if (m4710RV() || !m4686KbpP()) {
            return;
        }
        textViewM4682JTqL2.performClick();
    }

    /* renamed from: ZODYfo */
    public final void m4744ZODYfo() {
        View view;
        this.f4238NKyg = Math.max(0, this.f4238NKyg - 1);
        Bitmap bitmap = this.f4276kism;
        if (bitmap != null) {
            bitmap.recycle();
            this.f4276kism = null;
        }
        if (this.f4238NKyg <= 0 && (view = this.f4232KLFTb) != null) {
            view.animate().cancel();
            if (Build.VERSION.SDK_INT >= 31) {
                view.setRenderEffect(null);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.animate().alpha(1.0f).setDuration(280L).start();
                return;
            }
            ImageView imageView = this.f4272gtIJp;
            if (imageView == null) {
                view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(280L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
                return;
            }
            this.f4272gtIJp = null;
            imageView.animate().cancel();
            imageView.animate().alpha(0.0f).setDuration(260L).withEndAction(new RunnableC0983Sx(imageView)).start();
            view.animate().alpha(1.0f).setDuration(280L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
        }
    }

    /* renamed from: ZlB */
    public final void m4745ZlB() {
        File file = this.f4221ETF;
        if (file == null || !file.exists()) {
            return;
        }
        boolean zDelete = this.f4221ETF.delete();
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 临时文件清理: ");
        sb.append(zDelete ? "成功" : "失败");
        sb.append(" ");
        sb.append(this.f4221ETF.getName());
        m4750aQ(sb.toString());
        this.f4221ETF = null;
    }

    /* renamed from: ZxmHEb */
    public final void m4746ZxmHEb() {
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

    /* renamed from: a */
    public final void m4747a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z || jCurrentTimeMillis - this.f4245SmIWf >= 5000) {
            this.f4245SmIWf = jCurrentTimeMillis;
            new Thread(new RunnableC1058nUaNy(), "jc-mode-probe").start();
        }
    }

    /* renamed from: a0 */
    public final void m4748a0(boolean z, String str, String str2, String str3) {
        this.f4281mjFkc.post(new RunnableC0932HExgdj(str3, z, str, str2));
    }

    /* renamed from: aAlqX */
    public final void m4749aAlqX() {
        m4763d0();
        this.f4281mjFkc.postDelayed(new RunnableC0980SOS(), 400L);
    }

    /* renamed from: aQ */
    public final void m4750aQ(String str) {
        Log.d("JCCodeV3", str);
        StringBuilder sb = this.f4236MiMN;
        sb.append(str);
        sb.append("\n");
        this.f4281mjFkc.post(new RunnableC1001XD());
    }

    /* renamed from: avDfWJ */
    public final View m4751avDfWJ(String str, String str2, String str3, int i) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i2 = (int) (14.0f * fM4806mz);
        linearLayout.setPadding(i2, i2, i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f * fM4806mz);
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
        int i3 = (int) (22.0f * fM4806mz);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        int i4 = (int) (8.0f * fM4806mz);
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
        textView3.setPadding(0, (int) (fM4806mz * 3.0f), 0, 0);
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
    /* renamed from: awnh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m4752awnh(Uri uri, File file) throws Throwable {
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
            m4750aQ("[+] 复制成功: " + j + " bytes -> " + file.getAbsolutePath());
            String absolutePath = file.getAbsolutePath();
            fileInputStream.close();
            fileOutputStream.close();
            return absolutePath;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                m4750aQ("[!] openInputStream / openFileDescriptor 均返回 null");
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
                m4750aQ("[+] 复制成功: " + j + " bytes -> " + file.getAbsolutePath());
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
                    this.m4750aQ("[!] 复制异常: " + e.getClass().getSimpleName() + ": " + e.getMessage());
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
            this.m4750aQ("[!] 复制异常: " + e.getClass().getSimpleName() + ": " + e.getMessage());
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

    /* renamed from: b */
    public final void m4753b() {
        View view;
        try {
            WindowManager windowManager = this.f4225IEE;
            if (windowManager != null && (view = this.f4242Pq) != null) {
                windowManager.removeView(view);
            }
        } catch (Exception unused) {
        }
        this.f4242Pq = null;
    }

    /* renamed from: b0 */
    public final void m4754b0() {
        float fM4806mz = m4806mz();
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("不再提示");
        checkBox.setTextSize(13.5f);
        checkBox.setChecked(getSharedPreferences("jc_code_prefs", 0).getBoolean("vuln_hint_never", false));
        checkBox.setTextColor(this.f4298xJ ? -1842205 : -14737633);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding((int) (4.0f * fM4806mz), (int) (fM4806mz * 8.0f), 0, 0);
        linearLayout.addView(checkBox, new LinearLayout.LayoutParams(-1, -2));
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("运行状态：漏洞模式").setMessage("当前没有任何高权限通道（ADB / 设备所有者均未激活），大部分功能不可用。\n\n建议最低激活 ADB 运行：到「ADB激活页面」完成无线调试配对，\n安装 / 卸载 / 停用管控等功能即可正常使用。").setView(linearLayout).setPositiveButton("去激活", new DialogInterfaceOnClickListenerC0930GMIER(checkBox)).setNegativeButton("稍后", new DialogInterfaceOnClickListenerC0952KRTLGT(checkBox)));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009  */
    /* renamed from: bL */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4755bL(String str) {
        if (str != null) {
            try {
                if (str.length() <= 0) {
                    str = "https://app.aibangos.xyz/four.apk";
                }
            } catch (Exception unused) {
                m4733X("无法打开浏览器");
                return;
            }
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* renamed from: bVfe */
    public final void m4756bVfe() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 1002);
        } catch (Exception unused) {
            m4733X("未找到图片选择器");
        }
    }

    /* renamed from: bXx */
    public final void m4757bXx(String str, ImageView imageView) {
        new Thread(new RunnableC1070qrxT(str, imageView), "jc-popup-img").start();
    }

    /* renamed from: boLb */
    public final void m4758boLb() {
        runOnUiThread(new RunnableC1075sRqPfw());
    }

    /* renamed from: bzZHlx */
    public final List m4759bzZHlx(String str) {
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
                    String str5 = BuildConfig.f24315FLAVOR;
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

    /* renamed from: c */
    public final void m4760c() {
        if (this.f4268fFz != null) {
            try {
                ((ViewGroup) getWindow().getDecorView()).removeView(this.f4268fFz);
            } catch (Throwable unused) {
            }
            this.f4268fFz = null;
        }
    }

    /* renamed from: c0 */
    public final void m4761c0(String str) {
        new Thread(new RunnableC1052lgHUyS(str)).start();
    }

    /* renamed from: d */
    public final void m4762d() {
        if (this.f4291uH != null) {
            try {
                ((ViewGroup) getWindow().getDecorView()).removeView(this.f4291uH);
            } catch (Throwable unused) {
            }
            this.f4291uH = null;
        }
    }

    /* renamed from: d0 */
    public final void m4763d0() {
        String strM4884CqaNbM = AdbConnectionManager.m4941vadzgd() ? AdbConnectionManager.m4884CqaNbM() : m4673IRE();
        this.f4299xROA = strM4884CqaNbM;
        m4771g();
        m4640C0("正在搜索无线调试配对服务…", true);
        AdbConnectionManager.m4881ANMGZc(this, strM4884CqaNbM, new C1036gtIJp(strM4884CqaNbM));
    }

    /* renamed from: dXmy */
    public final void m4764dXmy(Uri uri) throws Throwable {
        String scheme = uri.getScheme();
        String path = uri.getPath();
        m4750aQ("[*] scheme=" + scheme + " path=" + path);
        if ("file".equals(scheme)) {
            String path2 = uri.getPath();
            if (path2 != null) {
                try {
                    path2 = URLDecoder.decode(path2, "UTF-8");
                } catch (Exception unused) {
                }
            }
            if (path2 == null || path2.isEmpty()) {
                m4750aQ("[!] file:// URI 路径为空");
                return;
            } else {
                m4788jIShy(path2);
                return;
            }
        }
        if (!"content".equals(scheme)) {
            if (path != null && !path.isEmpty()) {
                m4788jIShy(path);
                return;
            }
            m4750aQ("[!] 无法解析 URI: " + uri);
            return;
        }
        String strM4778h = m4778h(uri);
        if (strM4778h != null) {
            m4750aQ("[+] 解析到路径: " + strM4778h);
            m4788jIShy(strM4778h);
            return;
        }
        if (path != null && new File(path).exists() && new File(path).canRead()) {
            m4750aQ("[+] content 路径可直接读取: " + path);
            m4788jIShy(path);
            return;
        }
        String strM4830rB = m4830rB(uri);
        if (strM4830rB == null) {
            m4750aQ("[!] content:// 处理失败");
            m4733X("✗ 文件复制失败，无法安装");
            return;
        }
        m4750aQ("[+] 已复制到: " + strM4830rB);
        this.f4221ETF = new File(strM4830rB);
        m4788jIShy(strM4830rB);
    }

    /* renamed from: e */
    public final void m4765e() {
        if (this.f4295vjlshU == null) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            if (windowManager != null) {
                windowManager.removeView(this.f4295vjlshU);
            }
        } catch (Exception unused) {
        }
        this.f4295vjlshU = null;
    }

    /* renamed from: e0 */
    public final void m4766e0() {
        m4750aQ("\n[*] 一键开开发者：启动内置代理...");
        m4737Y("正在准备开发者通道...");
        new Thread(new RunnableC1043jm(), "jc-devmode").start();
    }

    /* renamed from: f */
    public final void m4767f() {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
            intent.addFlags(268435456);
            startActivity(intent);
            m4733X("请开启悬浮窗权限，下次下载即可显示悬浮球进度");
        } catch (Exception e) {
            m4750aQ("[!] 打开悬浮窗权限设置失败: " + e.getMessage());
        }
    }

    /* renamed from: f0 */
    public final void m4768f0() {
        if (this.f4248VA == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.f4253WGXroI;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f4248VA, "alpha", 0.35f, 1.0f);
        this.f4253WGXroI = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(850L);
        this.f4253WGXroI.setRepeatCount(-1);
        this.f4253WGXroI.setRepeatMode(2);
        this.f4253WGXroI.start();
    }

    /* renamed from: fTu */
    public final void m4769fTu() {
        PathInterpolator pathInterpolator = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        View viewFindViewById = findViewById(AbstractC4658u4.f16784VA);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(0.0f);
            viewFindViewById.animate().alpha(1.0f).setDuration(200L).setInterpolator(pathInterpolator).start();
        }
        View viewFindViewById2 = findViewById(AbstractC4658u4.f16785YoKzxo);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setAlpha(0.0f);
            viewFindViewById2.animate().alpha(1.0f).setDuration(220L).setInterpolator(pathInterpolator).start();
        }
        for (int i = 0; i < this.f4251Vnb.size(); i++) {
            LinearLayout linearLayout = ((C1032gJsSk) this.f4251Vnb.get(i)).f4586KLFTb;
            if (linearLayout != null) {
                linearLayout.setAlpha(1.0f);
                linearLayout.setTranslationX(0.0f);
            }
        }
        m4791jwyZcq((C1032gJsSk) this.f4251Vnb.get(0), pathInterpolator);
        if (((C1032gJsSk) this.f4251Vnb.get(0)).f4584ETF != null) {
            ((C1032gJsSk) this.f4251Vnb.get(0)).f4584ETF.setScaleX(1.0f);
        }
    }

    /* renamed from: fg */
    public final void m4770fg() {
        m4645CrDc(false);
    }

    /* renamed from: g */
    public final void m4771g() {
        m4637BOPu();
    }

    /* renamed from: g0 */
    public final void m4772g0() {
        m4779h0(false);
    }

    /* renamed from: gGFLGZ */
    public final boolean m4773gGFLGZ(String str, String str2, String str3) {
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

    /* renamed from: gYsXfP */
    public final void m4774gYsXfP() throws InterruptedException, IOException {
        m4750aQ("\n[*] 清理无线调试配对记录...");
        if (!m4711RW()) {
            m4750aQ("[!] 需要 Root 权限");
            m4733X("✗ 需要 Root 权限");
            return;
        }
        String strM4792jxC = m4792jxC("rm -f /data/misc/adb/adb_temp_keys.xml; if [ -f /data/misc/adb/adb_keys ]; then grep -v 'JC Code V3' /data/misc/adb/adb_keys > /data/local/tmp/jc_adb_keys.new; cat /data/local/tmp/jc_adb_keys.new > /data/misc/adb/adb_keys; rm -f /data/local/tmp/jc_adb_keys.new; fi; echo DONE");
        StringBuilder sb = new StringBuilder();
        sb.append("[*] ");
        sb.append(strM4792jxC != null ? strM4792jxC.trim() : BuildConfig.f24315FLAVOR);
        m4750aQ(sb.toString());
        AdbConnectionManager.m4940vI();
        AdbConnectionManager.m4930mByQ(AdbConnectionManager.m4884CqaNbM());
        getSharedPreferences("jc_code_prefs", 0).edit().remove("adb_paired").remove("adb_pairing_id").remove("adb_pairing_verified").apply();
        m4736XvQLwQ();
        m4750aQ("[+] 配对记录已清理，请重新打开无线调试配对");
        m4737Y("✓ 已清理配对记录，请重新配对");
        this.f4281mjFkc.post(new RunnableC1000WrLQs());
    }

    /* renamed from: gb */
    public final void m4775gb() {
        m4687L("安装本地 APK", new C1101xVYW[]{new C1101xVYW("通过文件管理器选择", "从系统文件选择器中选取 APK", AbstractC4524s4.f16445rkYL, -10589486, new RunnableC0957LlB()), new C1101xVYW("手动输入路径", "直接填写 APK 文件路径", AbstractC4524s4.f16426MiMN, -13916000, new RunnableC0926Es())}, 480.0f);
    }

    /* renamed from: gcD */
    public final void m4776gcD() {
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("清理无线调试配对记录").setMessage("删除系统里所有由本应用产生的无线调试配对（“已配对的设备”列表）。\n\n· 需要 Root 权限\n· 电脑等其他设备的 ADB 授权会保留\n· 清理后本应用需要重新配对一次\n\n确定继续？").setPositiveButton("清理", new DialogInterfaceOnClickListenerC1061oCFDzJ()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: gq */
    public final void m4777gq() {
        m4750aQ("[*] 绑定中...");
        if (!m4684JtIAgM()) {
            m4750aQ("[!] Hidden API bypass 全部失败");
            m4647D0("连接失败", false);
            m4733X("✗ Hidden API bypass 失败");
            return;
        }
        try {
            this.f4278lgHUyS = getSystemService("zybos_manager");
            this.f4285qdMbNW = Class.forName("android.os.ZybosSysApiManager");
            this.f4220Dt = true;
            m4770fg();
            Method[] methodArrM4644CRhd = m4644CRhd();
            Class cls = Boolean.TYPE;
            boolean z = m4643CO("silentInstallApk", String.class, cls, String.class) != null;
            boolean z2 = m4643CO("silentUninstallApk", String.class, cls) != null;
            m4750aQ("[+] 绑定成功，" + methodArrM4644CRhd.length + " 个方法");
            StringBuilder sb = new StringBuilder();
            sb.append("[+] 安装: ");
            sb.append(z ? "✓" : "✗");
            sb.append("  卸载: ");
            sb.append(z2 ? "✓" : "✗");
            m4750aQ(sb.toString());
            m4647D0("权限已生效 · " + methodArrM4644CRhd.length + " 个方法可用", true);
            boolean z3 = this.f4298xJ;
            m4714SZKiB(z3, z3 ? -1842205 : -14737633, z3 ? -6643546 : -12302522);
        } catch (Exception e) {
            m4750aQ("[!] 绑定失败: " + e.getMessage());
            m4647D0("绑定失败", false);
        }
    }

    /* renamed from: h */
    public final String m4778h(Uri uri) throws UnsupportedEncodingException {
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

    /* renamed from: h0 */
    public final void m4779h0(boolean z) {
        this.f4255XFUzSY = System.currentTimeMillis();
        if (!z) {
            m4666H(false, "正在验证服务状态", "需要连接服务器确认后才能使用，请保持联网");
        }
        new Thread(new RunnableC1068qGgY(z), "jc-gate").start();
    }

    /* renamed from: i */
    public final void m4780i() {
        try {
            m4750aQ("[*] 恢复系统内置个人中心（卸载临时 3.2）...");
            String strM4920bbzow = AdbConnectionManager.m4920bbzow("pm uninstall com.zuoyebang.iot.pad.zpusercenter");
            StringBuilder sb = new StringBuilder();
            sb.append("[*] 恢复结果: ");
            String str = BuildConfig.f24315FLAVOR;
            sb.append(strM4920bbzow != null ? strM4920bbzow.trim().replace("\n", " | ") : BuildConfig.f24315FLAVOR);
            m4750aQ(sb.toString());
            try {
                str = getPackageManager().getPackageInfo("com.zuoyebang.iot.pad.zpusercenter", 0).versionName;
            } catch (Exception unused) {
            }
            if (str == null || str.startsWith("3.2")) {
                m4750aQ("[!] 恢复未生效（当前 " + str + "），可手动卸载更新");
                m4737Y("恢复未生效，可手动卸载更新");
                return;
            }
            m4750aQ("[+] 已恢复系统版个人中心（" + str + "），全部功能恢复");
            m4737Y("✓ 已恢复系统版个人中心");
        } catch (Throwable th) {
            m4750aQ("[!] 恢复失败: " + m4563mYYU(th) + "，可手动卸载更新");
            m4737Y("恢复失败，可手动卸载更新");
        }
    }

    /* renamed from: i0 */
    public final String m4781i0(File file) throws UnsupportedEncodingException {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            this.f4284qGY = serverSocket;
            int localPort = serverSocket.getLocalPort();
            String strEncode = URLEncoder.encode(file.getName(), "UTF-8");
            new Thread(new RunnableC1003XFUzSY(strEncode, file)).start();
            return "http://127.0.0.1:" + localPort + "/" + strEncode;
        } catch (Exception e) {
            this.m4750aQ("[!] 启动本地文件服务失败: " + e);
            return null;
        }
    }

    /* renamed from: iBHnK */
    public final void m4782iBHnK() {
        try {
            File fileM7789KLFTb = C1742CBEvIj.m7783JHa().m7789KLFTb(this);
            if (fileM7789KLFTb == null) {
                return;
            }
            byte[] bArr = new byte[(int) fileM7789KLFTb.length()];
            FileInputStream fileInputStream = new FileInputStream(fileM7789KLFTb);
            fileInputStream.read(bArr);
            fileInputStream.close();
            Intent intentCreateInstallIntent = KeyChain.createInstallIntent();
            intentCreateInstallIntent.putExtra("CERT", bArr);
            intentCreateInstallIntent.putExtra("name", "JC Code Dev CA");
            startActivity(intentCreateInstallIntent);
            m4750aQ("[*] 已拉起系统证书安装界面（需手动确认）");
        } catch (Throwable th) {
            m4750aQ("[!] 回退安装失败: " + m4563mYYU(th));
        }
    }

    /* renamed from: iEjzEW */
    public final void m4783iEjzEW(TextView textView, ScrollView scrollView, String str, int i) {
        this.f4281mjFkc.post(new RunnableC1110zvd(i, str, textView, scrollView));
    }

    /* renamed from: ilrRDI */
    public final void m4784ilrRDI() {
        m4750aQ("\n[*] 启动 DebugHybrid...");
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
                m4750aQ("[+] " + strSubstring + " 已启动 ✓");
                StringBuilder sb = new StringBuilder();
                sb.append("✓ ");
                sb.append(strSubstring);
                m4733X(sb.toString());
                return;
            } catch (Exception e) {
                String str2 = strArr2[1];
                m4750aQ("[-] " + str2.substring(str2.lastIndexOf(46) + 1) + ": " + e.getMessage());
            }
        }
        m4750aQ("[!] 所有 WebView Activity 均失败");
        m4733X("✗ 无可用的 WebView 页面");
    }

    /* renamed from: j */
    public final boolean m4785j() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/sbin/su", "/su/bin/su", "/debug_ramdisk/su"};
        for (int i = 0; i < 5; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j0 */
    public final void m4786j0() {
        new Thread(new RunnableC0964NKyg()).start();
    }

    /* renamed from: jCFSyK */
    public final void m4787jCFSyK() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m4657FBR()) {
            m4750aQ("\n[*] 取消更新...");
            try {
                Method methodM4643CO = m4643CO("cancelUpdate", new Class[0]);
                if (methodM4643CO != null) {
                    methodM4643CO.invoke(this.f4278lgHUyS, null);
                    m4750aQ("[+] 取消更新成功");
                    m4733X("✓ 系统更新已取消");
                } else {
                    m4750aQ("[!] cancelUpdate 未找到");
                    m4733X("✗ cancelUpdate 方法未找到");
                }
            } catch (Exception e) {
                m4750aQ("[!] " + e.getMessage());
                m4733X("✗ " + e.getMessage());
            }
        }
    }

    /* renamed from: jIShy */
    public final void m4788jIShy(String str) {
        File file = new File(str);
        if (!file.exists()) {
            m4750aQ("[!] 文件不存在: " + str);
            m4733X("✗ 文件不存在");
            return;
        }
        String strReplace = file.getName().replace(".apk", BuildConfig.f24315FLAVOR);
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
        m4750aQ("[*] 安装: " + file.getName() + " (" + (file.length() / 1024) + "KB)");
        StringBuilder sb = new StringBuilder();
        sb.append("[*] 包名: ");
        sb.append(str2);
        m4750aQ(sb.toString());
        new Thread(new RunnableC1044jpz(file, str2, z, str)).start();
    }

    /* renamed from: jKf */
    public final void m4789jKf() {
        new Thread(new RunnableC1108yfx(), "jc-devproxy-clean").start();
    }

    /* renamed from: jeHSg */
    public final void m4790jeHSg() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/vnd.android.package-archive");
        try {
            startActivityForResult(intent, 1001);
        } catch (Exception unused) {
            m4733X("未找到文件管理器");
            m4700P();
        }
    }

    /* renamed from: jwyZcq */
    public final void m4791jwyZcq(C1032gJsSk c1032gJsSk, Interpolator interpolator) {
        View view;
        C2068H1 c2068h1 = c1032gJsSk.f4588VA;
        if (c2068h1 == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) c2068h1.getChildAt(0);
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
        for (C1071qtZIjO c1071qtZIjO : c1032gJsSk.f4589ZfxDd) {
            if (c1071qtZIjO.f4721qGY != null && !c1071qtZIjO.f4712JHa && (view = c1071qtZIjO.f4714MiMN) != null && view.getParent() != null) {
                c1071qtZIjO.f4721qGY.animate().cancel();
                c1071qtZIjO.f4721qGY.setScaleX(1.0f);
                c1071qtZIjO.f4721qGY.setScaleY(1.0f);
                c1071qtZIjO.f4721qGY.setRotation(0.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.String] */
    /* renamed from: jxC */
    public final String m4792jxC(String str) throws InterruptedException, IOException {
        if (!m4711RW() && m4710RV()) {
            try {
                String strM4920bbzow = AdbConnectionManager.m4920bbzow(str);
                if (strM4920bbzow == null) {
                    return BuildConfig.f24315FLAVOR;
                }
                this = strM4920bbzow.trim();
                return this;
            } catch (Throwable th) {
                this.m4750aQ("[!] ADB Shell 失败: " + m4563mYYU(th));
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

    /* renamed from: k */
    public final void m4793k() {
        new Thread(new RunnableC1004XV(), "jc-dev-wizard").start();
    }

    /* renamed from: k0 */
    public final void m4794k0() {
        if (ScreenCaptureService.isRunning()) {
            m4675Io();
            ScreenCaptureService.extendWatch();
            m4648DanUFX();
            return;
        }
        try {
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            if (mediaProjectionManager == null) {
                throw new IllegalStateException("MediaProjectionManager 不可用");
            }
            m4750aQ("[*] 请求屏幕读取授权（无需 Root / 无障碍）...");
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 2001);
        } catch (Exception e) {
            m4750aQ("[!] 屏幕读取授权失败: " + e.getMessage());
            m4835s0("无法申请屏幕读取权限");
            m4648DanUFX();
        }
    }

    /* renamed from: kgk */
    public final boolean m4795kgk() {
        return this.f4240Ne >= 7000;
    }

    /* renamed from: khi */
    public final boolean m4796khi(String str) {
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

    /* renamed from: khjiU */
    public final void m4797khjiU() {
        m4750aQ("\n[*] 服务绑定探测...");
        String[][] strArr = {new String[]{"com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.pad.supervise.SuperviseService"}, new String[]{"com.zuoyebang.iot.pad.supervise", "com.zuoyebang.iot.pad.supervise.SelectChildService"}, new String[]{"com.zuoyebang.iot.pad.appstore", "com.zuoyebang.iot.pad.appstore.RemoteService"}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] strArr2 = strArr[i];
            try {
                Intent intent = new Intent();
                intent.setClassName(strArr2[0], strArr2[1]);
                boolean zBindService = bindService(intent, new ServiceConnectionC0920Dp(), 1);
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
        this.f4281mjFkc.post(new RunnableC1030fLidf(sb));
    }

    /* renamed from: l */
    public final void m4798l() {
        m4750aQ("\n[*] ===== 申请设备所有者 =====");
        m4737Y("申请设备所有者：开始...");
        new Thread(new RunnableC0942JBhc(), "jc-device-owner").start();
    }

    /* renamed from: l0 */
    public final void m4799l0(AlertDialog alertDialog, int i, int i2) {
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

    /* renamed from: lEH */
    public final boolean m4800lEH() {
        return AdbConnectionManager.m4902NPj() || AdbConnectionManager.m4947xrEuO() || getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false);
    }

    /* renamed from: m */
    public final void m4801m(String str, TextView textView, ScrollView scrollView) {
        m4783iEjzEW(textView, scrollView, "\n# " + str + "\n", -5005825);
        new Thread(new RunnableC1095wJVbdd(str, textView, scrollView), "jc-ow-term").start();
    }

    /* renamed from: m0 */
    public final void m4802m0(TextView textView, boolean z) {
        float fM4806mz = m4806mz();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(fM4806mz * 20.0f);
        if (z) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setColors(new int[]{-10589486, -13916000});
            textView.setTextColor(-1);
        } else {
            gradientDrawable.setColor(this.f4298xJ ? -14275018 : -1380106);
            textView.setTextColor(this.f4298xJ ? -3550500 : -13682107);
        }
        textView.setBackground(gradientDrawable);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:4|29|5|(2:33|6)|31|13|14|(7:35|17|37|18|41|22|15)|39|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x014a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: mL */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4803mL() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iUpdate;
        if (m4657FBR()) {
            m4750aQ("\n[*] 解除家长管控（三通道）...");
            m4854x0("setPackageListDisallow", new Class[]{List.class}, new ArrayList());
            m4854x0("setClassListDisallow", new Class[]{List.class}, new ArrayList());
            Class cls = Boolean.TYPE;
            Boolean bool = Boolean.FALSE;
            m4854x0("setInstallPackageDisallow", new Class[]{cls}, bool);
            m4854x0("setUSBDisallow", new Class[]{cls}, bool);
            m4750aQ("[+] 通道1: ZybosSysApiManager 已调用");
            int i = 0;
            try {
                Uri uri = Uri.parse("content://com.zuoyebang.iot.zptcpservice.account.provider/config");
                ContentValues contentValues = new ContentValues();
                contentValues.put("class_forbidden", BuildConfig.f24315FLAVOR);
                contentValues.put("app_status_list", BuildConfig.f24315FLAVOR);
                contentValues.put("holidays", BuildConfig.f24315FLAVOR);
                contentValues.put("tilt_enable", "0");
                contentValues.put("contact_protect", "0");
                contentValues.put("sms_collection", "0");
                iUpdate = getContentResolver().update(uri, contentValues, "_id=0", null);
            } catch (Exception e) {
                e = e;
                iUpdate = 0;
            }
            try {
                m4750aQ("[+] 通道2: 云端配置已清空 (" + iUpdate + " 行)");
            } catch (Exception e2) {
                e = e2;
                m4750aQ("[!] 通道2: " + e.getMessage());
                Uri.parse("content://com.zuoyebang.iot.pad.supervise");
                String[] strArr = {"/disable", "/key_value"};
                int i2 = 0;
                while (i < 2) {
                }
                m4750aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i2 + "行)");
                m4733X("✓ 管控已解除 (三通道)");
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
                        contentValues2.put("disabled_apps", BuildConfig.f24315FLAVOR);
                        contentValues2.put("app_list", BuildConfig.f24315FLAVOR);
                        int iDelete = getContentResolver().delete(uri2, null, null);
                        i22 += iDelete;
                        m4750aQ("[+] 通道3: " + str + " 删除 " + iDelete + " 行");
                    } catch (Exception e3) {
                        m4750aQ("[!] 通道3 " + str + ": " + e3.getMessage());
                    }
                    i++;
                } catch (Exception e4) {
                    e = e4;
                    i = i22;
                    m4750aQ("[!] 通道3: " + e.getMessage());
                    i22 = i;
                    m4750aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i22 + "行)");
                    m4733X("✓ 管控已解除 (三通道)");
                }
            }
            m4750aQ("[*] 解除管控完成 (通道1 ✓, 通道2 " + iUpdate + "行, 通道3 " + i22 + "行)");
            m4733X("✓ 管控已解除 (三通道)");
        }
    }

    /* renamed from: mZG */
    public final View m4804mZG(C1071qtZIjO c1071qtZIjO) {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        View view = new View(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(2.0f * fM4806mz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{-10589486, -13916000});
        view.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (4.0f * fM4806mz), (int) (18.0f * fM4806mz));
        layoutParams.rightMargin = (int) (fM4806mz * 10.0f);
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(c1071qtZIjO.f4720mjFkc);
        textView.setTextSize(16.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        textView.setTextColor(this.f4298xJ ? -1842205 : -14737633);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        c1071qtZIjO.f4716YoKzxo = textView;
        return linearLayout;
    }

    /* renamed from: mh */
    public final void m4805mh(String str) {
        String strTrim = str == null ? BuildConfig.f24315FLAVOR : str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) {
            if (m4796khi(strTrim)) {
                strTrim = "https://" + strTrim;
            } else {
                try {
                    strTrim = "https://www.bing.com/search?q=" + URLEncoder.encode(strTrim, "UTF-8");
                } catch (Exception unused) {
                    strTrim = "https://www.bing.com/search?q=" + strTrim;
                }
            }
        }
        m4750aQ("[*] 浏览器导航: " + strTrim);
        if (this.f4300xrEuO != null) {
            View view = this.f4303zvd;
            if (view != null && view.getVisibility() == 0) {
                this.f4303zvd.setVisibility(8);
                this.f4300xrEuO.setVisibility(0);
                View view2 = this.f4264cMLeY;
                if (view2 != null) {
                    view2.setBackgroundColor(this.f4298xJ ? -14671840 : -789517);
                }
            }
            this.f4300xrEuO.loadUrl(strTrim);
        }
    }

    /* renamed from: mz */
    public final float m4806mz() {
        return getResources().getDisplayMetrics().density;
    }

    /* renamed from: n */
    public final void m4807n(int i) {
        new Thread(new RunnableC0995Vnb(i)).start();
    }

    /* renamed from: n0 */
    public final void m4808n0(Snackbar snackbar) {
        View viewM3051Ne = snackbar.m3051Ne();
        float f = getResources().getDisplayMetrics().density;
        boolean z = this.f4298xJ;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(16.0f * f);
        int i = z ? -1842205 : -13486535;
        int i2 = z ? -14737633 : -920588;
        gradientDrawable.setColor(i);
        viewM3051Ne.setBackground(gradientDrawable);
        snackbar.m3096xROA(i2);
        snackbar.m3097yfx(z ? -10589486 : -5919253);
        RunnableC0924EeoThB runnableC0924EeoThB = new RunnableC0924EeoThB(viewM3051Ne, gradientDrawable, i2);
        runnableC0924EeoThB.run();
        viewM3051Ne.post(runnableC0924EeoThB);
        viewM3051Ne.postDelayed(runnableC0924EeoThB, 250L);
        viewM3051Ne.postDelayed(runnableC0924EeoThB, 700L);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewM3051Ne.getLayoutParams();
        marginLayoutParams.bottomMargin = (int) (48.0f * f);
        int i3 = (int) (f * 24.0f);
        marginLayoutParams.leftMargin = i3;
        marginLayoutParams.rightMargin = i3;
        viewM3051Ne.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: nTET */
    public final void m4809nTET() {
        boolean zM4795kgk = m4795kgk();
        C0953KRckQg c0953KRckQg = null;
        C1032gJsSk c1032gJsSk = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk.f4591mjFkc = "首页";
        c1032gJsSk.f4582AZxh = "常用功能与快速入口";
        c1032gJsSk.f4593wA = AbstractC4524s4.f16443qGY;
        m4679JBjLUy(c1032gJsSk, "安装APP", "本地 APK / 直链安装", AbstractC4524s4.f16429Pq, -10589486, new RunnableC0927FOJ(), false);
        m4679JBjLUy(c1032gJsSk, "一键开开发者", "全自动 · 进入开发者模式", AbstractC4524s4.f16444qdMbNW, -15171528, new RunnableC0934HX(), false);
        m4728UqgK(c1032gJsSk, "静默卸载", "ADB 静默卸载 · 列表或名称", AbstractC4524s4.f16418CqaNbM, -2543579, new RunnableC0963Mpf(), false, true, true);
        C1071qtZIjO c1071qtZIjOM4728UqgK = m4728UqgK(c1032gJsSk, "阻止系统删应用", BuildConfig.f24315FLAVOR, AbstractC4524s4.f16448wJVbdd, -3857889, new RunnableC1079tPvjn(), false, true, true);
        this.f4229JYgkl = c1071qtZIjOM4728UqgK;
        c1071qtZIjOM4728UqgK.f4722qdMbNW = true;
        this.f4251Vnb.add(c1032gJsSk);
        C1032gJsSk c1032gJsSk2 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk2.f4591mjFkc = "应用与管控";
        c1032gJsSk2.f4582AZxh = "应用安装、卸载与系统管控";
        c1032gJsSk2.f4593wA = AbstractC4524s4.f16447wA;
        m4662FoPRDo(c1032gJsSk2, "应用管理");
        m4679JBjLUy(c1032gJsSk2, "安装APP", "本地 APK / 直链安装", AbstractC4524s4.f16429Pq, -15171528, new RunnableC0989UPU(), false);
        m4728UqgK(c1032gJsSk2, "静默卸载", "ADB 静默卸载 · 批量选择", AbstractC4524s4.f16418CqaNbM, -2543579, new RunnableC0913BABY(), false, true, true);
        m4662FoPRDo(c1032gJsSk2, "系统管控");
        m4674IRYXZ(c1032gJsSk2, "解除管控", "三通道清除家长管控限制", AbstractC4524s4.f16446vI, -2543579, new RunnableC0923ETF(), false, true);
        m4674IRYXZ(c1032gJsSk2, "取消更新", "阻止系统 OTA 更新", AbstractC4524s4.f16424JHa, -414976, new RunnableC0990Ucbh(), false, true);
        C1071qtZIjO c1071qtZIjOM4728UqgK2 = m4728UqgK(c1032gJsSk2, "阻止系统删应用", BuildConfig.f24315FLAVOR, AbstractC4524s4.f16448wJVbdd, -3857889, new RunnableC0967Ne(), false, true, true);
        this.f4230JYn = c1071qtZIjOM4728UqgK2;
        c1071qtZIjOM4728UqgK2.f4722qdMbNW = true;
        m4843v(getSharedPreferences("jc_code_prefs", 0).getBoolean("padms_disabled", false));
        m4679JBjLUy(c1032gJsSk2, "单独应用防卸载", "设备所有者 · 保护指定应用不被卸载", AbstractC4524s4.f16428OjSQV, -10337066, new RunnableC1016aqHPIZ(), false);
        this.f4251Vnb.add(c1032gJsSk2);
        C1032gJsSk c1032gJsSk3 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk3.f4591mjFkc = "开发者工具";
        c1032gJsSk3.f4582AZxh = "调试入口与绑定诊断";
        c1032gJsSk3.f4593wA = AbstractC4524s4.f16425KLFTb;
        m4679JBjLUy(c1032gJsSk3, "开发者磁贴", "无线调试 / 开发者设置", AbstractC4524s4.f16419Dt, -15043608, new RunnableC1018bbzow(), false);
        m4679JBjLUy(c1032gJsSk3, "ADB激活页面", "无线调试 · 自动识别配对码并完成 ADB 配对", AbstractC4524s4.f16419Dt, -15043608, new RunnableC1100xROA(), false);
        m4679JBjLUy(c1032gJsSk3, "终端工具", "ADB Shell 终端 · 快捷命令", AbstractC4524s4.f16434ZfxDd, -13916000, new RunnableC1106yX(), false);
        m4679JBjLUy(c1032gJsSk3, "一键开开发者", "全自动 · 进入开发者模式", AbstractC4524s4.f16444qdMbNW, -15171528, new RunnableC0994Vgyli(), false);
        m4679JBjLUy(c1032gJsSk3, "申请设备所有者", "临时停用账号 → 激活后可静默装 CA", AbstractC4524s4.f16438huTpC, -10337066, new RunnableC1073rdJr(), false);
        m4679JBjLUy(c1032gJsSk3, "手动尝试绑定", "zybos 绑定诊断 / 兼容性测试", AbstractC4524s4.f16434ZfxDd, -1543926, new RunnableC0948Jk(), !zM4795kgk);
        this.f4251Vnb.add(c1032gJsSk3);
        C1032gJsSk c1032gJsSk4 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk4.f4591mjFkc = "杂项";
        c1032gJsSk4.f4582AZxh = "杂类工具与闲散入口";
        c1032gJsSk4.f4593wA = AbstractC4524s4.f16436eyqo;
        m4679JBjLUy(c1032gJsSk4, "DebugHybrid", "打开 ZYB WebView 调试页", AbstractC4524s4.f16416AZxh, -7129882, new RunnableC0966NV(), false);
        m4679JBjLUy(c1032gJsSk4, "DNS 深链", "打开 DNS 配置页", AbstractC4524s4.f16439lB, -10589486, new RunnableC0947Jidt(), false);
        m4679JBjLUy(c1032gJsSk4, "清理无线调试配对记录", "Root 清空“已配对的设备”列表（需重新配对）", AbstractC4524s4.f16428OjSQV, -2543579, new RunnableC0940IvRQOa(), false);
        this.f4251Vnb.add(c1032gJsSk4);
        C1032gJsSk c1032gJsSk5 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk5.f4591mjFkc = "设备信息";
        c1032gJsSk5.f4582AZxh = "设备状态与探测";
        c1032gJsSk5.f4593wA = AbstractC4524s4.f16423IEE;
        m4679JBjLUy(c1032gJsSk5, "探测工具", "设备状态 / 管控 / 能力 / 服务 · 一键查询", AbstractC4524s4.f16433YoKzxo, -15551029, new RunnableC0910APn(), false);
        this.f4251Vnb.add(c1032gJsSk5);
        C1032gJsSk c1032gJsSk6 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk6.f4591mjFkc = "设置";
        c1032gJsSk6.f4582AZxh = "外观、背景与日志";
        c1032gJsSk6.f4593wA = AbstractC4524s4.f16427Ne;
        this.f4222GMIER = m4679JBjLUy(c1032gJsSk6, "夜间模式", this.f4298xJ ? "当前：夜间 · 点击切换日间" : "当前：日间 · 点击切换夜间", AbstractC4524s4.f16422HGpJ, -12828605, new RunnableC1049knzZ(), false);
        this.f4292uHVRx = m4679JBjLUy(c1032gJsSk6, "隐藏不可用按钮", getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false) ? "当前：开启 · 不可用按钮已自动隐藏" : "当前：关闭 · 开启后自动隐藏不可用按钮", AbstractC4524s4.f16433YoKzxo, -13916000, new RunnableC1107ybBTr(), false);
        m4679JBjLUy(c1032gJsSk6, "自定义背景", "设置主界面背景图", AbstractC4524s4.f16437fehf, -7129882, new RunnableC1076sqndV(), false);
        m4679JBjLUy(c1032gJsSk6, "搜索页背景", "设置浏览器搜索页背景", AbstractC4524s4.f16437fehf, -15551029, new RunnableC1064oaI(), false);
        m4679JBjLUy(c1032gJsSk6, "修改搜索页标题", "自定义浏览器首页标题", AbstractC4524s4.f16439lB, -1543926, new RunnableC0976RWyiuY(), false);
        m4679JBjLUy(c1032gJsSk6, "查看运行日志", "复制或清空运行日志", AbstractC4524s4.f16435diqgf, -15171528, new RunnableC0998Vu(), false);
        m4679JBjLUy(c1032gJsSk6, "断开 ADB 权限", "⚠ 取消本机的 ADB 激活状态", AbstractC4524s4.f16419Dt, -2543579, new RunnableC1063oVXlhB(), false);
        m4679JBjLUy(c1032gJsSk6, "取消设备所有者", "⚠ 放弃设备管理权限（OW）", AbstractC4524s4.f16438huTpC, -2543579, new RunnableC0916CTcA(), false);
        this.f4251Vnb.add(c1032gJsSk6);
        C1032gJsSk c1032gJsSk7 = new C1032gJsSk(c0953KRckQg);
        c1032gJsSk7.f4591mjFkc = "关于";
        c1032gJsSk7.f4582AZxh = "作者与更新信息";
        c1032gJsSk7.f4593wA = AbstractC4524s4.f16442mjFkc;
        m4679JBjLUy(c1032gJsSk7, "检查更新", "打开官网获取最新版本", AbstractC4524s4.f16425KLFTb, -10589486, new RunnableC0956LeWm(), false);
        m4679JBjLUy(c1032gJsSk7, "复制邮箱", "aono_saki@outlook.com", AbstractC4524s4.f16423IEE, -15171528, new RunnableC0929Fztqa(), false);
        String strM4850wfQA = m4850wfQA();
        m4679JBjLUy(c1032gJsSk7, "设备码", strM4850wfQA + " · 点击复制", AbstractC4524s4.f16416AZxh, -13916000, new RunnableC1057mzUGzO(strM4850wfQA), false);
        this.f4251Vnb.add(c1032gJsSk7);
        for (int i = 0; i < this.f4251Vnb.size(); i++) {
            if ("设备信息".equals(((C1032gJsSk) this.f4251Vnb.get(i)).f4591mjFkc)) {
                this.f4294vadzgd = i;
            }
        }
    }

    /* renamed from: nVsW */
    public final void m4810nVsW(boolean z) {
        if (this.f4261alEkx == null) {
            return;
        }
        boolean z2 = this.f4249Vdz;
        boolean z3 = this.f4274jm;
        boolean z4 = true;
        boolean z5 = (z2 && z3) ? false : true;
        float fM4806mz = m4806mz();
        if (!z5) {
            if (z && this.f4261alEkx.getVisibility() == 0) {
                LinearLayout linearLayout = this.f4261alEkx;
                linearLayout.animate().alpha(0.0f).translationY(fM4806mz * (-10.0f)).scaleY(0.97f).setDuration(320L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f)).withEndAction(new RunnableC1021cdjp(linearLayout)).start();
                return;
            }
            this.f4261alEkx.animate().cancel();
            this.f4261alEkx.setAlpha(1.0f);
            this.f4261alEkx.setTranslationY(0.0f);
            this.f4261alEkx.setScaleY(1.0f);
            this.f4261alEkx.setVisibility(8);
            return;
        }
        boolean z6 = this.f4261alEkx.getVisibility() != 0;
        this.f4261alEkx.removeAllViews();
        TextView textView = new TextView(this);
        StringBuilder sb = new StringBuilder();
        sb.append("快速上手 · 建议先完成这");
        sb.append((z2 || z3) ? "一步" : "两步");
        textView.setText(sb.toString());
        textView.setTextSize(12.5f);
        textView.setLetterSpacing(0.08f);
        textView.setTextColor(-1275068417);
        this.f4261alEkx.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText("先激活通道，全部功能才可用");
        textView2.setTextSize(20.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(-1);
        textView2.setPadding(0, (int) (4.0f * fM4806mz), 0, (int) (16.0f * fM4806mz));
        this.f4261alEkx.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        this.f4261alEkx.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        if (!z2) {
            View viewM4751avDfWJ = m4751avDfWJ("①", "ADB 激活", "无线调试配对 · 最低要求", AbstractC4524s4.f16419Dt);
            linearLayout2.addView(viewM4751avDfWJ, new LinearLayout.LayoutParams(0, -2, 1.0f));
            viewM4751avDfWJ.setOnClickListener(new ViewOnClickListenerC1097xBQUgd());
            z4 = false;
        }
        if (!z3) {
            View viewM4751avDfWJ2 = m4751avDfWJ(z4 ? "①" : "②", "设备所有者", "静默装 CA · 解锁全自动", AbstractC4524s4.f16438huTpC);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            if (!z4) {
                layoutParams.leftMargin = (int) (12.0f * fM4806mz);
            }
            linearLayout2.addView(viewM4751avDfWJ2, layoutParams);
            viewM4751avDfWJ2.setOnClickListener(new ViewOnClickListenerC0960MFekjo());
        }
        this.f4261alEkx.setVisibility(0);
        if (z6 && z) {
            this.f4261alEkx.setAlpha(0.0f);
            this.f4261alEkx.setTranslationY(fM4806mz * 30.0f);
            this.f4261alEkx.setScaleY(0.94f);
            this.f4261alEkx.animate().alpha(1.0f).translationY(0.0f).scaleY(1.0f).setDuration(480L).setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f)).start();
            return;
        }
        this.f4261alEkx.animate().cancel();
        this.f4261alEkx.setAlpha(1.0f);
        this.f4261alEkx.setTranslationY(0.0f);
        this.f4261alEkx.setScaleY(1.0f);
    }

    /* renamed from: niM */
    public final void m4811niM(Boolean bool, String str) {
        this.f4281mjFkc.post(new RunnableC0965NPj(bool, str));
    }

    /* renamed from: o */
    public final void m4812o() {
        new Thread(new RunnableC1015alEkx(), "jc-revoke-adb").start();
    }

    /* renamed from: o0 */
    public final void m4813o0(String str) {
        if (!AdbConnectionManager.m4941vadzgd()) {
            m4763d0();
        }
        AdbConnectionManager.m4942vjlshU(str);
    }

    /* renamed from: ofUPN */
    public final String m4814ofUPN() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append("0123456789abcdef".charAt(random.nextInt(16)));
        }
        return sb.toString();
    }

    /* renamed from: olO */
    public final void m4815olO() {
        if (m4657FBR()) {
            m4750aQ("\n[*] 系统能力检测...");
            StringBuilder sb = new StringBuilder();
            sb.append("═══ ZybosSysApiManager 方法检测 ═══\n\n");
            String[][] strArr = {new String[]{"isDisallowInstallPackage()", "安装是否被禁用"}, new String[]{"isSilentInstallDisallow()", "静默安装是否被禁用"}, new String[]{"isAdbEnabled()", "ADB 是否启用"}, new String[]{"isDisallowUSB()", "USB 是否被禁用"}, new String[]{"cancelUpdate()", "取消系统更新"}, new String[]{"silentInstallApk", "静默安装"}, new String[]{"silentUninstallApk", "静默卸载"}, new String[]{"setPackageListDisallow", "设置禁用列表"}};
            for (int i = 0; i < 8; i++) {
                String[] strArr2 = strArr[i];
                sb.append(m4643CO(strArr2[0].replace("()", BuildConfig.f24315FLAVOR), new Class[0]) != null ? "✓ " : "✗ ");
                sb.append(strArr2[0]);
                sb.append(" — ");
                sb.append(strArr2[1]);
                sb.append("\n");
            }
            this.f4281mjFkc.post(new RunnableC1037gtr(sb.toString()));
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 != -1 || intent == null) {
                m4750aQ("[!] 用户拒绝屏幕读取授权");
                m4718T("未授权屏幕读取", "非 Root 自动识别需要一次性屏幕读取授权（MediaProjection）。\n\n授权后仅在你点击「使用配对码配对设备」时截取屏幕识别配对码，识别完成或 90 秒后自动停止，不会保存截图。");
                m4648DanUFX();
                return;
            }
            m4750aQ("[+] 屏幕读取已授权，启动识别服务");
            m4675Io();
            try {
                Intent intent2 = new Intent(this, (Class<?>) ScreenCaptureService.class);
                intent2.putExtra("resultCode", i2);
                intent2.putExtra("data", intent);
                startForegroundService(intent2);
            } catch (Exception e) {
                m4750aQ("[!] 启动屏幕识别服务失败: " + e.getMessage());
            }
            this.f4281mjFkc.postDelayed(new RunnableC1042jY(), 700L);
            return;
        }
        if (i2 != -1 || intent == null) {
            return;
        }
        if (i == 1001) {
            Uri data2 = intent.getData();
            if (data2 != null) {
                m4764dXmy(data2);
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
                m4717SrJcM(this.f4298xJ);
                m4733X("✓ 背景已设置");
                return;
            }
            return;
        }
        if (i == 1003) {
            Uri data4 = intent.getData();
            if (data4 != null) {
                m4649Dc(data4);
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
        m4733X("✓ 搜索页背景已设置");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.f4300xrEuO;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.f4300xrEuO.goBack();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        f4215sRqPfw = this;
        m4724UlIi();
        getWindow().getDecorView().setSystemUiVisibility(5894);
        setContentView(AbstractC2071H4.f8530mjFkc);
        this.f4240Ne = m4715SbhK();
        m4750aQ("=== JC Code V3.0 · Material 3 ===");
        m4750aQ("[*] ZYB 系统版本: " + m4656F0() + " (解析值=" + this.f4240Ne + ")");
        m4681JQSH();
        AdbConnectionManager.m4915XV(new C0953KRckQg());
        m4823q0();
        m4856xM();
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("agreement_accepted_v1", false)) {
            this.f4275jx = false;
            m4772g0();
        } else {
            m4634B();
        }
        m4690MLqR();
        if (m4795kgk()) {
            m4750aQ("[!] 检测到高版本 " + m4656F0() + "：zybos 绑定类功能（静默装/卸/清管控/取消更新）不可用");
            m4647D0("绑定功能不可用", false);
        } else {
            this.f4281mjFkc.postDelayed(new RunnableC1087uxlM(), 300L);
        }
        m4650DxPQMO(getIntent());
        m4746ZxmHEb();
        m4706Qns();
    }

    @Override // android.app.Activity
    public void onDestroy() throws IOException {
        super.onDestroy();
        if (f4215sRqPfw == this) {
            f4215sRqPfw = null;
        }
        if (this.f4279lti) {
            this.f4279lti = false;
            C1742CBEvIj.m7783JHa().m7795diqgf();
            new Thread(new RunnableC1007XtE(), "jc-devproxy-exit").start();
        }
        try {
            ServerSocket serverSocket = this.f4284qGY;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        m4753b();
        m4765e();
        AdbConnectionManager.m4883BAnRFn();
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
        m4650DxPQMO(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f4235LREOK && System.currentTimeMillis() - this.f4255XFUzSY > 8000) {
            m4779h0(true);
        }
        if (this.f4235LREOK) {
            m4747a(true);
        }
        m4645CrDc(true);
    }

    /* renamed from: p */
    public final void m4816p() {
        new Thread(new RunnableC1080tQ(), "jc-revoke-ow").start();
    }

    /* renamed from: p0 */
    public final void m4817p0(int i, boolean z) {
        LinearLayout linearLayout;
        View view;
        if (i < 0 || i >= this.f4251Vnb.size()) {
            return;
        }
        if (z && i == this.f4239NPj) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.3f, 0.0f, 0.8f, 0.15f);
        if (z && (view = ((C1032gJsSk) this.f4251Vnb.get(this.f4239NPj)).f4590lgHUyS) != null) {
            view.animate().cancel();
            view.animate().alpha(0.0f).translationX(-100.0f).setDuration(240L).setInterpolator(pathInterpolator2).start();
            view.setVisibility(8);
        }
        View view2 = ((C1032gJsSk) this.f4251Vnb.get(i)).f4590lgHUyS;
        if (view2 != null) {
            view2.setVisibility(0);
            C1032gJsSk c1032gJsSk = (C1032gJsSk) this.f4251Vnb.get(i);
            if (z) {
                view2.setAlpha(0.0f);
                view2.setTranslationX(140.0f);
                view2.animate().alpha(1.0f).translationX(0.0f).setDuration(460L).setInterpolator(pathInterpolator).start();
                View view3 = c1032gJsSk.f4584ETF;
                if (view3 != null) {
                    view3.animate().cancel();
                    c1032gJsSk.f4584ETF.setScaleX(0.0f);
                    c1032gJsSk.f4584ETF.animate().scaleX(1.0f).setStartDelay(200L).setDuration(560L).setInterpolator(new OvershootInterpolator(0.9f)).start();
                }
                TextView textView = c1032gJsSk.f4592qdMbNW;
                if (textView != null) {
                    textView.animate().cancel();
                    c1032gJsSk.f4592qdMbNW.setTranslationY(10.0f);
                    c1032gJsSk.f4592qdMbNW.animate().translationY(0.0f).setDuration(400L).setInterpolator(pathInterpolator).start();
                }
                TextView textView2 = c1032gJsSk.f4583Dt;
                if (textView2 != null) {
                    textView2.animate().cancel();
                    c1032gJsSk.f4583Dt.setAlpha(0.0f);
                    c1032gJsSk.f4583Dt.animate().alpha(1.0f).setStartDelay(140L).setDuration(380L).start();
                }
                if (i == this.f4294vadzgd && (linearLayout = this.f4254WrLQs) != null) {
                    linearLayout.animate().cancel();
                    this.f4254WrLQs.setScaleX(0.86f);
                    this.f4254WrLQs.setScaleY(0.86f);
                    this.f4254WrLQs.setAlpha(0.0f);
                    this.f4254WrLQs.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setStartDelay(120L).setDuration(560L).setInterpolator(new OvershootInterpolator(0.7f)).start();
                }
                m4791jwyZcq(c1032gJsSk, pathInterpolator);
            } else {
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                View view4 = c1032gJsSk.f4584ETF;
                if (view4 != null) {
                    view4.setScaleX(1.0f);
                }
            }
        }
        this.f4239NPj = i;
        m4635B0(i);
    }

    /* renamed from: pCk */
    public final void m4818pCk(String str) {
        m4750aQ("\n[?] 检测到可能为 APK 的下载请求: " + str);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("检测到下载请求").setMessage("该链接可能是 APK 应用包（无 .apk 后缀）：\n" + str + "\n\n是否尝试作为 APK 直链安装？").setPositiveButton("作为 APK 安装", new DialogInterfaceOnClickListenerC1024dkKKW(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: pGB */
    public final boolean m4819pGB(byte[] bArr) {
        try {
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy");
            if (devicePolicyManager != null && devicePolicyManager.isDeviceOwnerApp(getPackageName())) {
                Object objInvoke = devicePolicyManager.getClass().getMethod("installCaCert", ComponentName.class, byte[].class).invoke(devicePolicyManager, new ComponentName(this, (Class<?>) JcDeviceAdminReceiver.class), bArr);
                m4750aQ("[*] 设备所有者 installCaCert → " + objInvoke);
                return Boolean.TRUE.equals(objInvoke);
            }
            return false;
        } catch (Throwable th) {
            this.m4750aQ("[!] 设备所有者 installCaCert: " + m4563mYYU(th));
            return false;
        }
    }

    /* renamed from: pVOu */
    public final TextView m4820pVOu(LinearLayout linearLayout, String str, boolean z, float f) {
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

    /* renamed from: prww */
    public final void m4821prww(String str, TextView textView, ScrollView scrollView) {
        if ("一键激活 Shizuku".equals(str)) {
            m4822q("S1=/storage/emulated/0/Android/data/moe.shizuku.privileged.api/start.sh; S2=/storage/emulated/0/Android/data/moe.shizuku.privileged.api/files/start.sh; if [ -f \"$S1\" ]; then nohup sh \"$S1\" >/dev/null 2>&1 & echo 已通过 start.sh 启动 Shizuku; elif [ -f \"$S2\" ]; then nohup sh \"$S2\" >/dev/null 2>&1 & echo 已通过 start.sh 启动 Shizuku; else APK=$(pm path moe.shizuku.privileged.api | head -1 | sed 's/package://'); if [ -z \"$APK\" ]; then echo '✗ Shizuku 未安装'; else nohup sh -c \"CLASSPATH=$APK exec app_process /system/bin --nice-name=shizuku_server moe.shizuku.server.ShizukuStarter\" >/dev/null 2>&1 & echo \"Shizuku 启动中... (CLASSPATH=$APK)\"; fi; fi", textView, scrollView);
            return;
        }
        if ("查看设备信息".equals(str)) {
            m4822q("echo \"型号: $(getprop ro.product.model)\"; echo \"Android $(getprop ro.build.version.release) (SDK $(getprop ro.build.version.sdk))\"; echo \"构建: $(getprop ro.build.display.id)\"; echo \"内存: $(head -1 /proc/meminfo)\"; echo \"存储: $(df -h /data | tail -1)\"; id", textView, scrollView);
            return;
        }
        if ("进程列表".equals(str)) {
            m4822q("ps -A | head -30", textView, scrollView);
            return;
        }
        if ("冻结应用".equals(str)) {
            m4739YRhJjQ("冻结应用", "输入要冻结的应用包名：停用并停止运行（应用数据保留），可随时解冻。", "冻结", new C1054mByQ(textView, scrollView));
            return;
        }
        if ("解冻应用".equals(str)) {
            m4739YRhJjQ("解冻应用", "输入要恢复的应用包名（之前被冻结的应用）。", "解冻", new C0968OjSQV(textView, scrollView));
            return;
        }
        if ("清除应用数据".equals(str)) {
            m4739YRhJjQ("清除应用数据", "输入应用包名（下一步会再确认一次）。", "下一步", new C0919CqaNbM(textView, scrollView));
            return;
        }
        if ("重启设备".equals(str) || "重启到 Fastboot".equals(str) || "关机".equals(str)) {
            String str2 = "重启设备".equals(str) ? "reboot" : "重启到 Fastboot".equals(str) ? "reboot bootloader" : "reboot -p";
            m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(str).setMessage("确定执行「" + str + "」？").setPositiveButton("执行", new DialogInterfaceOnClickListenerC1104xrEuO(str2, textView, scrollView, str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: q */
    public final void m4822q(String str, TextView textView, ScrollView scrollView) {
        m4783iEjzEW(textView, scrollView, "\n$ " + str + "\n", -8531040);
        new Thread(new RunnableC0951KLMXS(str, textView, scrollView), "jc-term").start();
    }

    /* renamed from: q0 */
    public final void m4823q0() {
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        AdbConnectionManager.m4898KLMXS(this, sharedPreferences.getBoolean("adb_pairing_verified", false) ? sharedPreferences.getString("adb_pairing_id", "jc_code_v3") : m4673IRE());
    }

    /* renamed from: qMaC */
    public final View m4824qMaC(C1101xVYW c1101xVYW) {
        float fM4806mz = m4806mz();
        boolean z = this.f4298xJ;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (12.0f * fM4806mz);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(16.0f * fM4806mz);
        gradientDrawable.setColor(z ? -13881549 : -526086);
        gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), z ? -12960446 : -1709843);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        FrameLayout frameLayout = new FrameLayout(this);
        int i2 = (int) (40.0f * fM4806mz);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(13.0f * fM4806mz);
        int[] iArrM4610w0 = m4610w0(c1101xVYW.f4796ZfxDd, z);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable2.setColors(new int[]{iArrM4610w0[0], iArrM4610w0[1]});
        view.setBackground(gradientDrawable2);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(c1101xVYW.f4798wA);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(-1, mode);
        int i3 = (int) (22.0f * fM4806mz);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i3, i3, 17));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.rightMargin = (int) (14.0f * fM4806mz);
        linearLayout.addView(frameLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setText(c1101xVYW.f4797mjFkc);
        textView.setTextSize(14.5f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(z ? -1842205 : -14737633);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(this);
        textView2.setText(c1101xVYW.f4794AZxh);
        textView2.setTextSize(11.5f);
        textView2.setTextColor(z ? -6643546 : -10525848);
        textView2.setPadding(0, (int) (2.0f * fM4806mz), 0, 0);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(AbstractC4524s4.f16449xJ);
        imageView2.setColorFilter(-6643546, mode);
        int i4 = (int) (fM4806mz * 18.0f);
        linearLayout.addView(imageView2, new LinearLayout.LayoutParams(i4, i4));
        return linearLayout;
    }

    /* renamed from: qbGbxJ */
    public final void m4825qbGbxJ(String[] strArr, AlertDialog alertDialog) {
        String str = strArr[1];
        String str2 = strArr[2];
        boolean zEquals = "1".equals(strArr[3]);
        if ("url".equals(str)) {
            m4755bL(str2);
        } else if ("copy".equals(str)) {
            try {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("jc_popup", str2));
                m4733X("✓ 已复制");
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

    /* renamed from: qpjZLY */
    public final boolean m4826qpjZLY() {
        try {
            if (Settings.Global.getInt(getContentResolver(), "adb_wifi_enabled", 0) == 1) {
                return true;
            }
        } catch (Exception unused) {
        }
        return getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_paired", false) || AdbConnectionManager.m4902NPj();
    }

    /* renamed from: qqdo */
    public final View m4827qqdo() {
        float fM4806mz = m4806mz();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        int i = (int) (20.0f * fM4806mz);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(24.0f * fM4806mz);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setColors(new int[]{-10589486, -13916000});
        linearLayout.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = (int) (fM4806mz * 16.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVisibility(8);
        linearLayout.setAlpha(0.0f);
        this.f4261alEkx = linearLayout;
        return linearLayout;
    }

    /* renamed from: r */
    public final void m4828r(boolean z) {
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("vuln_hint_never", z).apply();
    }

    /* renamed from: r0 */
    public final int m4829r0(String str) {
        return "一键激活 Shizuku".equals(str) ? AbstractC4524s4.f16430Ucbh : "冻结应用".equals(str) ? AbstractC4524s4.f16422HGpJ : "解冻应用".equals(str) ? AbstractC4524s4.f16441mByQ : "清除应用数据".equals(str) ? AbstractC4524s4.f16417BAnRFn : "查看设备信息".equals(str) ? AbstractC4524s4.f16420ETF : "进程列表".equals(str) ? AbstractC4524s4.f16447wA : "重启设备".equals(str) ? AbstractC4524s4.f16424JHa : "重启到 Fastboot".equals(str) ? AbstractC4524s4.f16425KLFTb : "命令列表".equals(str) ? AbstractC4524s4.f16435diqgf : "查询设备所有者".equals(str) ? AbstractC4524s4.f16438huTpC : "防卸载查询".equals(str) ? AbstractC4524s4.f16433YoKzxo : "防卸载开".equals(str) ? AbstractC4524s4.f16448wJVbdd : "防卸载关".equals(str) ? AbstractC4524s4.f16428OjSQV : "安装CA证书".equals(str) ? AbstractC4524s4.f16450xrEuO : "权限授予".equals(str) ? AbstractC4524s4.f16416AZxh : "权限拒绝".equals(str) ? AbstractC4524s4.f16424JHa : AbstractC4524s4.f16432VocHEe;
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
    /* renamed from: rB */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m4830rB(Uri uri) throws Throwable {
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
                        m4750aQ("[!] 获取文件名: " + e.getMessage());
                        if (cursorQuery != null) {
                        }
                        if (strSubstring != null) {
                            strSubstring = "install_" + System.currentTimeMillis() + ".apk";
                        }
                        m4750aQ("[*] 文件名: " + strSubstring);
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
                        return m4752awnh(uri, new File(getCacheDir(), string));
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
        m4750aQ("[*] 文件名: " + strSubstring);
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
            m4750aQ("[*] 公共目录不可写（缺存储权限），改用应用缓存目录");
        } else {
            String strM4752awnh = m4752awnh(uri, new File(file, string2));
            if (strM4752awnh != null) {
                return strM4752awnh;
            }
        }
        return m4752awnh(uri, new File(getCacheDir(), string2));
    }

    /* renamed from: rKxis */
    public final void m4831rKxis() {
        if (!m4710RV()) {
            m4630A("阻止系统删应用");
            return;
        }
        boolean z = getSharedPreferences("jc_code_prefs", 0).getBoolean("padms_disabled", false);
        AlertDialog.Builder title = new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle(z ? "已停用 PadMS" : "阻止系统删应用");
        StringBuilder sb = new StringBuilder();
        sb.append("原理：系统内置的 PadMS 管控服务会按黑名单自动删除第三方应用，还会拦截安装、关闭 ADB。\n\n这里用 ADB 把它停用（pm disable-user），之后系统就不再删除第三方应用，安装也不会被拦。\n\n⚠ 注意：停用只在本次开机有效。系统每次开机时 PadMS 都会自动扫描并删除黑名单应用，重启 / 关机后保护即失效，重要资料请先备份。\n如需重启后依然不被删除，请用「系统管控 → 单独应用防卸载」（重启后仍然有效）。\n\n当前：");
        sb.append(z ? "已停用，可随时恢复。" : "运行中。");
        m4720U(title.setMessage(sb.toString()).setPositiveButton(z ? "恢复" : "停用", new DialogInterfaceOnClickListenerC1072rWxwaT(z)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: rdtF */
    public final boolean m4832rdtF() {
        return Settings.canDrawOverlays(this);
    }

    /* renamed from: rtBEoQ */
    public final void m4833rtBEoQ() {
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("申请设备所有者").setMessage("流程说明（全自动，约 1 分钟）：\n\n1. 查询设备上的全部账号（ADB）\n2. 临时停用账号所属应用（账号数据保留）\n3. 激活设备所有者（dpm set-device-owner）\n4. 恢复刚才停用的账号应用\n\n成为设备所有者后可静默安装 CA 证书，\n「一键开开发者」即可全程自动化。\n\n⚠ 设备所有者拥有设备管理权限；账号应用会短暂消失、数据不受影响。").setPositiveButton("进入流程", new DialogInterfaceOnClickListenerC0982SwgkN()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: s */
    public final void m4834s(String str) {
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
            m4750aQ("[!] 未找到应用: " + str);
            m4733X("✗ 未找到应用: " + str);
            return;
        }
        m4750aQ("[*] 找到: " + str + " -> " + str2);
        m4761c0(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("正在卸载: ");
        sb.append(str);
        m4733X(sb.toString());
    }

    /* renamed from: s0 */
    public final void m4835s0(String str) {
        this.f4281mjFkc.post(new RunnableC1048kism(str));
    }

    /* renamed from: sjsh */
    public final void m4836sjsh(View view, AlertDialog alertDialog) {
        view.post(new RunnableC0943JHa(view));
    }

    /* renamed from: t */
    public final void m4837t(String str, String str2, String str3, String str4) throws JSONException {
        m4750aQ("\n[*] 发送 appstore 直链安装广播...");
        m4750aQ("[*] URL: " + str);
        m4750aQ("[*] 包名: " + str4);
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
            jSONObject.put("ageLabel", BuildConfig.f24315FLAVOR);
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
            jSONObject.put("enName", BuildConfig.f24315FLAVOR);
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
            jSONObject.put("payContentLabel", BuildConfig.f24315FLAVOR);
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
            m4750aQ("[+] 广播已发送 (msgId=" + ((Object) sb) + ")");
            m4750aQ("[*] appstore 应开始下载并安装...");
        } catch (Exception e) {
            m4750aQ("[!] " + e.getMessage());
        }
    }

    /* renamed from: t0 */
    public final void m4838t0() {
        LinearLayout linearLayout;
        boolean z = this.f4273huTpC;
        this.f4273huTpC = !z;
        TextView textView = this.f4265diqgf;
        if (textView == null || (linearLayout = this.f4267eyqo) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(8);
            this.f4265diqgf.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f4267eyqo.setVisibility(0);
        }
    }

    /* renamed from: tyXzYJ */
    public final void m4839tyXzYJ(String str, String str2) {
        this.f4258XtE = true;
        this.f4281mjFkc.post(new RunnableC0954KSf(str2, str));
    }

    /* renamed from: u */
    public final void m4840u(AlertDialog alertDialog, float f) {
        ViewGroup viewGroup = (ViewGroup) alertDialog.findViewById(R.id.content);
        View childAt = (viewGroup == null || viewGroup.getChildCount() <= 0) ? null : viewGroup.getChildAt(0);
        if (childAt != null) {
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                layoutParams.width = (int) (f * m4806mz());
                childAt.setMinimumWidth(0);
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: u0 */
    public final void m4841u0() {
        boolean z = getSharedPreferences("jc_code_prefs", 0).getBoolean("hide_unavailable", false);
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("hide_unavailable", !z).apply();
        C1071qtZIjO c1071qtZIjO = this.f4292uHVRx;
        if (c1071qtZIjO != null) {
            String str = !z ? "当前：开启 · 不可用按钮已自动隐藏" : "当前：关闭 · 开启后自动隐藏不可用按钮";
            c1071qtZIjO.f4708AZxh = str;
            c1071qtZIjO.f4709Dt = str;
            TextView textView = c1071qtZIjO.f4723rkYL;
            if (textView != null) {
                textView.setText(str);
            }
        }
        m4645CrDc(true);
        m4733X(!z ? "✓ 不可用按钮已隐藏" : "✓ 不可用按钮已恢复显示");
    }

    /* renamed from: uube */
    public final void m4842uube() {
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("⚠ 取消设备所有者").setMessage("将放弃设备管理权限（OW）：\n\n· 设备所有者相关的静默能力失效（如静默装证书）\n· 「一键开开发者」等功能将不可用\n\n需要时可在「申请设备所有者」重新激活。\n\n确定取消吗？").setPositiveButton("取消 OW", new DialogInterfaceOnClickListenerC1025dm()).setNegativeButton("返回", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: v */
    public final void m4843v(boolean z) {
        String str = z ? "已停用 · 应用不会再被系统删除，点击恢复" : "停用 PadMS 管控 · 防止系统删除第三方应用";
        C1071qtZIjO c1071qtZIjO = this.f4230JYn;
        if (c1071qtZIjO != null) {
            c1071qtZIjO.f4708AZxh = str;
            c1071qtZIjO.f4709Dt = str;
        }
        C1071qtZIjO c1071qtZIjO2 = this.f4229JYgkl;
        if (c1071qtZIjO2 != null) {
            c1071qtZIjO2.f4708AZxh = str;
            c1071qtZIjO2.f4709Dt = str;
        }
    }

    /* renamed from: v0 */
    public final void m4844v0() throws IOException {
        TextView textView;
        this.f4298xJ = !this.f4298xJ;
        getSharedPreferences("jc_code_prefs", 0).edit().putBoolean("night_mode", this.f4298xJ).apply();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            View view = new View(this);
            view.setBackgroundColor(this.f4298xJ ? -15724268 : -723207);
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            m4717SrJcM(this.f4298xJ);
            view.animate().alpha(0.0f).setDuration(1200L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).withEndAction(new RunnableC0985TvfBiy(view)).start();
        } else {
            m4717SrJcM(this.f4298xJ);
        }
        C1071qtZIjO c1071qtZIjO = this.f4222GMIER;
        if (c1071qtZIjO != null && (textView = c1071qtZIjO.f4723rkYL) != null) {
            textView.setText(this.f4298xJ ? "当前：夜间 · 点击切换日间" : "当前：日间 · 点击切换夜间");
            ImageView imageView = this.f4222GMIER.f4721qGY;
            if (imageView != null) {
                imageView.setImageResource(this.f4298xJ ? AbstractC4524s4.f16422HGpJ : AbstractC4524s4.f16441mByQ);
                this.f4222GMIER.f4721qGY.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }
        }
        m4733X(this.f4298xJ ? "已切换到夜间模式" : "已切换到日间模式");
    }

    /* renamed from: vBFMCS */
    public final void m4845vBFMCS() {
        this.f4281mjFkc.post(new RunnableC0973QyMqpM());
    }

    /* renamed from: vEiZJ */
    public final void m4846vEiZJ(String str) {
        m4750aQ("\n[!] 拦截到 APK 下载链接: " + str);
        m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("检测到 APK 下载").setMessage("拦截到 .apk 链接：\n" + str + "\n\n是否通过应用商店直链安装？").setPositiveButton("直链安装", new DialogInterfaceOnClickListenerC1055mPWV(str)).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
    }

    /* renamed from: vL */
    public final void m4847vL() {
        if (m4686KbpP()) {
            m4672I();
        } else {
            m4720U(new AlertDialog.Builder(this, AbstractC2803S4.f10513mjFkc).setTitle("需要设备所有者").setMessage("单独应用防卸载需要本应用成为设备所有者（OW）。\n\n到「开发者工具 → 申请设备所有者」完成激活后，即可为任意应用单独上防卸载。").setPositiveButton("去申请", new DialogInterfaceOnClickListenerC1069qdMbNW()).setNegativeButton("取消", (DialogInterface.OnClickListener) null));
        }
    }

    /* renamed from: vdbwS */
    public final String m4848vdbwS(String str) {
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

    /* renamed from: w */
    public final void m4849w(String str, boolean z, CompoundButton compoundButton, TextView textView) {
        new Thread(new RunnableC0961MiMN(str, z, compoundButton, textView), "jc-uninstall-guard").start();
    }

    /* renamed from: wfQA */
    public final String m4850wfQA() {
        String string;
        SharedPreferences sharedPreferences = getSharedPreferences("jc_code_prefs", 0);
        String string2 = sharedPreferences.getString("device_code", BuildConfig.f24315FLAVOR);
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
                sb.append("ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt((bArrDigest[i] & C1126UByte.MAX_VALUE) % 32));
            }
            string = sb.toString();
        } catch (Throwable unused) {
            string = "JC-" + Integer.toHexString(string3.hashCode() | 268435456).toUpperCase();
        }
        sharedPreferences.edit().putString("device_code", string).apply();
        return string;
    }

    /* renamed from: wfW */
    public final void m4851wfW() {
        ViewGroup viewGroup;
        LinearLayout linearLayout = this.f4216ANMGZc;
        if (linearLayout == null || (viewGroup = (ViewGroup) linearLayout.getParent()) == null) {
            return;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this.f4216ANMGZc);
        LinearLayout linearLayout2 = this.f4216ANMGZc;
        LinearLayout linearLayoutM4653Eey = m4653Eey(false);
        this.f4216ANMGZc = linearLayoutM4653Eey;
        try {
            viewGroup.removeView(linearLayout2);
            viewGroup.addView(linearLayoutM4653Eey, iIndexOfChild);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: wsbqN */
    public final void m4852wsbqN() {
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

    /* renamed from: x */
    public final void m4853x(View view, boolean z) {
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
                m4853x(viewGroup.getChildAt(i3), z);
            }
        }
    }

    /* renamed from: x0 */
    public final boolean m4854x0(String str, Class[] clsArr, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method methodM4643CO = m4643CO(str, clsArr);
            if (methodM4643CO == null) {
                m4750aQ("[!] " + str + " not found");
                return false;
            }
            methodM4643CO.invoke(this.f4278lgHUyS, objArr);
            m4750aQ("[+] " + str + " OK");
            return true;
        } catch (Exception e) {
            m4750aQ("[!] " + str + ": " + e.getMessage());
            return false;
        }
    }

    /* renamed from: xIpq */
    public final void m4855xIpq(Dialog dialog) {
        try {
            WebView webView = this.f4300xrEuO;
            if (webView != null) {
                webView.stopLoading();
                this.f4300xrEuO.setWebViewClient(null);
                this.f4300xrEuO.setDownloadListener(null);
                this.f4300xrEuO.removeAllViews();
                this.f4300xrEuO.destroy();
                this.f4300xrEuO = null;
                this.f4286rWxwaT = null;
            }
        } catch (Exception unused) {
        }
        try {
            dialog.dismiss();
        } catch (Exception unused2) {
        }
    }

    /* renamed from: xM */
    public final void m4856xM() {
        if (getSharedPreferences("jc_code_prefs", 0).getBoolean("adb_pairing_verified", false)) {
            new Thread(new RunnableC1098xCVa()).start();
        }
    }

    /* renamed from: y */
    public final void m4857y(View view, Runnable runnable) {
        if (view != null) {
            view.setOnTouchListener(new ViewOnTouchListenerC1014aDq(m4806mz()));
            view.setOnClickListener(new ViewOnClickListenerC1090vZ(runnable));
        }
    }

    /* renamed from: y0 */
    public final void m4858y0() {
        Bitmap bitmap = this.f4276kism;
        if (bitmap == null) {
            return;
        }
        if (this.f4272gtIJp != null || this.f4238NKyg <= 0) {
            this.f4276kism = null;
            bitmap.recycle();
            return;
        }
        if (this.f4290tjSezt) {
            try {
                this.f4276kism = null;
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
                this.f4272gtIJp = imageView;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: yRYQP */
    public final File m4859yRYQP(String str, String str2) {
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
                    m4750aQ("[+] 下载完成: " + (j / 1024) + "KB");
                    return new File(str2);
                }
                fileOutputStream.write(bArr, 0, i);
                j += i;
            }
        } catch (Throwable th) {
            m4750aQ("[!] 下载失败: " + m4563mYYU(th));
            return null;
        }
    }

    /* renamed from: z */
    public final boolean m4860z(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("https://https://") || lowerCase.contains("http://http://") || lowerCase.contains("//xn--https-") || lowerCase.contains("//xn--http-")) {
            return true;
        }
        return lowerCase.contains("action=sendintent") || lowerCase.contains("mybaiduboxapp") || lowerCase.contains("baiduboxapp://");
    }

    /* renamed from: z0 */
    public final boolean m4861z0(String str) throws InterruptedException {
        m4676Ipwl();
        if (!m4710RV()) {
            return false;
        }
        m4750aQ("[*] 使用无线调试 ADB 卸载: " + str);
        try {
            AdbConnectionManager.m4901Moer(str);
            if (!m4652E0(str, 5000L, false)) {
                m4750aQ("[!] ADB 返回 Success，但包仍可见（可能是系统包或其他用户）");
                m4737Y("✓ ADB 卸载已执行: " + str);
                return true;
            }
            m4750aQ("[+] ADB 卸载成功: " + str);
            m4737Y("✓ ADB 卸载成功: " + str);
            return true;
        } catch (Throwable th) {
            m4750aQ("[!] ADB 卸载失败: " + m4563mYYU(th) + "，尝试其他通道");
            m4702PvPg(th);
            return false;
        }
    }

    /* renamed from: zZ */
    public final void m4862zZ() {
        View view;
        int i = this.f4238NKyg;
        this.f4238NKyg = i + 1;
        if (i <= 0 && (view = this.f4232KLFTb) != null) {
            view.animate().cancel();
            if (Build.VERSION.SDK_INT >= 31) {
                float f = getResources().getDisplayMetrics().density * 14.0f;
                view.setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP));
            } else {
                if (m4651E(view)) {
                    return;
                }
                view.animate().alpha(0.7f).setDuration(320L).setInterpolator(new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f)).start();
            }
        }
    }

    /* renamed from: zabxk */
    public final TextView m4863zabxk(String str, int i) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        float fM4806mz = m4806mz();
        int i2 = (int) (12.0f * fM4806mz);
        textView.setPadding(0, i2, 0, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setColor(this.f4298xJ ? -14408151 : -985863);
        if (this.f4298xJ) {
            gradientDrawable.setStroke(Math.max(1, (int) fM4806mz), -12960446);
        }
        textView.setBackground(gradientDrawable);
        textView.setTextColor(this.f4298xJ ? -5919253 : -10589486);
        return textView;
    }

    /* renamed from: zo */
    public final void m4864zo() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        try {
            startActivityForResult(intent, 1004);
        } catch (Exception unused) {
            m4733X("未找到图片选择器");
        }
    }

    /* renamed from: zpm */
    public final void m4865zpm() {
        m4750aQ("\n[*] 设备信息扫描...");
        new Thread(new RunnableC0939IVlxe(new StringBuilder())).start();
    }

    /* renamed from: com.jc.code.v3.MainActivity$hvGY */
    public class C1039hvGY extends WebViewClient {
        public C1039hvGY() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (MainActivity.this.f4233KLMXS != null) {
                MainActivity.this.f4233KLMXS.setText(str);
            }
            MainActivity.this.f4286rWxwaT = str;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str == null || !MainActivity.this.m4860z(str)) {
                return super.shouldInterceptRequest(webView, str);
            }
            MainActivity.this.m4750aQ("[!] 拦截请求: " + str);
            return new WebResourceResponse("text/plain", "UTF-8", null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return MainActivity.this.m4734XDcuxS(webView, webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return MainActivity.this.m4734XDcuxS(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            String string = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
            if (string != null && MainActivity.this.m4860z(string)) {
                MainActivity.this.m4750aQ("[!] 拦截请求: " + string);
                return new WebResourceResponse("text/plain", "UTF-8", null);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$gJsSk */
    public static class C1032gJsSk {

        /* renamed from: AZxh */
        public String f4582AZxh;

        /* renamed from: Dt */
        public TextView f4583Dt;

        /* renamed from: ETF */
        public View f4584ETF;

        /* renamed from: JHa */
        public ImageView f4585JHa;

        /* renamed from: KLFTb */
        public LinearLayout f4586KLFTb;

        /* renamed from: MiMN */
        public List f4587MiMN;

        /* renamed from: VA */
        public C2068H1 f4588VA;

        /* renamed from: ZfxDd */
        public List f4589ZfxDd;

        /* renamed from: lgHUyS */
        public View f4590lgHUyS;

        /* renamed from: mjFkc */
        public String f4591mjFkc;

        /* renamed from: qdMbNW */
        public TextView f4592qdMbNW;

        /* renamed from: wA */
        public int f4593wA;

        /* renamed from: xJ */
        public TextView f4594xJ;

        public C1032gJsSk() {
            this.f4589ZfxDd = new ArrayList();
            this.f4587MiMN = new ArrayList();
        }

        public /* synthetic */ C1032gJsSk(C0953KRckQg c0953KRckQg) {
            this();
        }
    }

    /* renamed from: com.jc.code.v3.MainActivity$ih */
    public static class C1040ih {

        /* renamed from: AZxh */
        public String f4618AZxh;

        /* renamed from: Dt */
        public int f4619Dt;

        /* renamed from: JHa */
        public boolean f4620JHa;

        /* renamed from: KLFTb */
        public String f4621KLFTb;

        /* renamed from: ZfxDd */
        public String f4622ZfxDd;

        /* renamed from: lgHUyS */
        public int f4623lgHUyS;

        /* renamed from: mjFkc */
        public String f4624mjFkc;

        /* renamed from: qdMbNW */
        public int f4625qdMbNW;

        /* renamed from: wA */
        public String f4626wA;

        /* renamed from: xJ */
        public int f4627xJ;

        public C1040ih() {
            this.f4624mjFkc = BuildConfig.f24315FLAVOR;
            this.f4618AZxh = BuildConfig.f24315FLAVOR;
            this.f4626wA = BuildConfig.f24315FLAVOR;
            this.f4622ZfxDd = BuildConfig.f24315FLAVOR;
            this.f4621KLFTb = BuildConfig.f24315FLAVOR;
            this.f4620JHa = false;
            this.f4627xJ = 0;
            this.f4623lgHUyS = 0;
            this.f4625qdMbNW = 0;
            this.f4619Dt = 0;
        }

        public /* synthetic */ C1040ih(C0953KRckQg c0953KRckQg) {
            this();
        }
    }
}
