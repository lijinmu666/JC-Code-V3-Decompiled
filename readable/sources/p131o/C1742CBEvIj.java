package p131o;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.bouncycastle.p133asn1.p174x509.DisplayText;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

/* renamed from: o.CBEvIj */
/* loaded from: classes.dex */
public final class C1742CBEvIj {

    /* renamed from: qdMbNW */
    public static C1742CBEvIj f7578qdMbNW;

    /* renamed from: AZxh */
    public SSLContext f7580AZxh;

    /* renamed from: mjFkc */
    public ServerSocket f7584mjFkc;

    /* renamed from: xJ */
    public static final String[] f7579xJ = {"iot-admin.zuoyebang.com", "iot-api.zybang.com"};

    /* renamed from: lgHUyS */
    public static final String[] f7577lgHUyS = {"/iot-server/api/pad/device/mode/code/verify", "/iot-device/devmode/codeVerify"};

    /* renamed from: wA */
    public volatile boolean f7585wA = false;

    /* renamed from: ZfxDd */
    public volatile int f7583ZfxDd = 0;

    /* renamed from: KLFTb */
    public volatile boolean f7582KLFTb = false;

    /* renamed from: JHa */
    public volatile boolean f7581JHa = false;

    /* renamed from: o.CBEvIj$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ OutputStream f7586AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ Socket f7587mjFkc;

        public AZxh(Socket socket, OutputStream outputStream) {
            this.f7587mjFkc = socket;
            this.f7586AZxh = outputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1742CBEvIj c1742CBEvIj = C1742CBEvIj.this;
            Socket socket = this.f7587mjFkc;
            c1742CBEvIj.m7793VA(socket, this.f7586AZxh, socket);
        }
    }

    /* renamed from: o.CBEvIj$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: o.CBEvIj$mjFkc$mjFkc, reason: collision with other inner class name */
        public class RunnableC6358mjFkc implements Runnable {

            /* renamed from: mjFkc */
            public final /* synthetic */ Socket f7591mjFkc;

            public RunnableC6358mjFkc(Socket socket) {
                this.f7591mjFkc = socket;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1742CBEvIj.this.m7798lgHUyS(this.f7591mjFkc);
            }
        }

        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (C1742CBEvIj.this.f7585wA) {
                try {
                    new Thread(new RunnableC6358mjFkc(C1742CBEvIj.this.f7584mjFkc.accept()), "devproxy-conn").start();
                } catch (Throwable th) {
                    if (C1742CBEvIj.this.f7585wA) {
                        Log.w("DevModeProxy", "accept: " + th);
                    }
                }
            }
        }
    }

    /* renamed from: Dt */
    public static boolean m7781Dt(String str) {
        for (String str2 : f7577lgHUyS) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ETF */
    public static boolean m7782ETF(String str) {
        for (String str2 : f7579xJ) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: JHa */
    public static synchronized C1742CBEvIj m7783JHa() {
        try {
            if (f7578qdMbNW == null) {
                f7578qdMbNW = new C1742CBEvIj();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7578qdMbNW;
    }

    /* renamed from: qGY */
    public static byte[] m7786qGY(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i <= 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        inputStreamOpen.close();
        String string = byteArrayOutputStream.toString("UTF-8");
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str2 : string.split("\n")) {
            String strTrim = str2.trim();
            if (strTrim.startsWith("-----BEGIN")) {
                z = true;
            } else if (strTrim.startsWith("-----END")) {
                z = false;
            } else if (z && !strTrim.isEmpty()) {
                sb.append(strTrim);
            }
        }
        return Base64.decode(sb.toString(), 0);
    }

    /* renamed from: IEE */
    public final byte[] m7788IEE(String str, byte[] bArr) {
        byte[] byteArray;
        String strReplaceFirst;
        try {
            if (str.toLowerCase().contains("content-encoding: gzip")) {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                gZIPInputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                byteArray = bArr;
            }
            String str2 = new String(byteArray, "UTF-8");
            try {
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("code", DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
                jSONObject.put("errNo", 0);
                strReplaceFirst = jSONObject.toString();
            } catch (Throwable unused) {
                strReplaceFirst = str2.replaceFirst("\"code\"\\s*:\\s*-?\\d+", "\"code\":200").replaceFirst("\"errNo\"\\s*:\\s*-?\\d+", "\"errNo\":0");
            }
            Log.i("DevModeProxy", "改写响应体: code→200, errNo→0");
            return strReplaceFirst.getBytes("UTF-8");
        } catch (Throwable th) {
            Log.w("DevModeProxy", "响应体改写失败: " + th);
            return bArr;
        }
    }

    /* renamed from: KLFTb */
    public File m7789KLFTb(Context context) {
        try {
            InputStream inputStreamOpen = context.getAssets().open("devca.crt");
            File file = new File(context.getCacheDir(), "jc_dev_ca.crt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    return file;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            Log.e("DevModeProxy", "导出 CA 失败", th);
            return null;
        }
    }

    /* renamed from: MiMN */
    public final byte[] m7790MiMN(InputStream inputStream, String str) throws IOException {
        String strM7800rkYL;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (String str2 : str.split("\r\n")) {
            int iIndexOf = str2.indexOf(58);
            if (iIndexOf >= 0) {
                String lowerCase = str2.substring(0, iIndexOf).trim().toLowerCase();
                String strTrim = str2.substring(iIndexOf + 1).trim();
                if (lowerCase.equals("content-length")) {
                    try {
                        i2 = Integer.parseInt(strTrim);
                    } catch (Throwable unused) {
                    }
                } else if (lowerCase.equals("transfer-encoding") && strTrim.toLowerCase().contains("chunked")) {
                    z = true;
                }
            }
        }
        if (!z) {
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int i3 = inputStream.read(bArr, i, i2 - i);
                if (i3 < 0) {
                    break;
                }
                i += i3;
            }
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            String strM7800rkYL2 = m7800rkYL(inputStream);
            if (strM7800rkYL2 == null) {
                break;
            }
            String strTrim2 = strM7800rkYL2.trim();
            int iIndexOf2 = strTrim2.indexOf(59);
            if (iIndexOf2 > 0) {
                strTrim2 = strTrim2.substring(0, iIndexOf2);
            }
            try {
                int i4 = Integer.parseInt(strTrim2, 16);
                if (i4 == 0) {
                    do {
                        strM7800rkYL = m7800rkYL(inputStream);
                        if (strM7800rkYL == null) {
                            break;
                        }
                    } while (!strM7800rkYL.trim().isEmpty());
                } else {
                    byte[] bArr2 = new byte[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = inputStream.read(bArr2, i5, i4 - i5);
                        if (i6 < 0) {
                            break;
                        }
                        i5 += i6;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i5);
                    m7800rkYL(inputStream);
                }
            } catch (Throwable unused2) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: Pq */
    public synchronized boolean m7791Pq(Context context) {
        if (this.f7585wA) {
            return true;
        }
        try {
            byte[] bArrM7786qGY = m7786qGY(context, "leaf_key.pem");
            byte[] bArrM7786qGY2 = m7786qGY(context, "leaf_cert.pem");
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArrM7786qGY));
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrM7786qGY2));
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setKeyEntry("leaf", privateKeyGeneratePrivate, "jccode123".toCharArray(), new Certificate[]{certificateGenerateCertificate});
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "jccode123".toCharArray());
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.f7580AZxh = sSLContext;
            sSLContext.init(keyManagerFactory.getKeyManagers(), null, null);
            ServerSocket serverSocket = new ServerSocket();
            this.f7584mjFkc = serverSocket;
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
            this.f7585wA = true;
            this.f7583ZfxDd = 0;
            new Thread(new mjFkc(), "devproxy-accept").start();
            Log.i("DevModeProxy", "代理已启动 127.0.0.1:8888");
            return true;
        } catch (Throwable th) {
            Log.e("DevModeProxy", "代理启动失败", th);
            this.f7585wA = false;
            return false;
        }
    }

    /* renamed from: Ucbh */
    public final void m7792Ucbh(Socket socket, InputStream inputStream, OutputStream outputStream, String str, int i) {
        try {
            Socket socket2 = new Socket();
            socket2.connect(new InetSocketAddress(str, i), 8000);
            Log.i("DevModeProxy", "隧道: " + str + ":" + i);
            Thread thread = new Thread(new AZxh(socket2, outputStream), "devproxy-up");
            thread.setDaemon(true);
            thread.start();
            byte[] bArr = new byte[8192];
            OutputStream outputStream2 = socket2.getOutputStream();
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 <= 0) {
                    return;
                } else {
                    outputStream2.write(bArr, 0, i2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: VA */
    public final void m7793VA(Socket socket, OutputStream outputStream, Socket socket2) {
        byte[] bArr;
        InputStream inputStream;
        try {
            bArr = new byte[8192];
            inputStream = socket2.getInputStream();
        } catch (Throwable unused) {
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                outputStream.write(bArr, 0, i);
            }
            try {
                socket2.close();
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
    }

    /* renamed from: YoKzxo */
    public final String m7794YoKzxo(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        loop0: while (true) {
            int i = 0;
            while (true) {
                int i2 = inputStream.read();
                if (i2 < 0) {
                    break loop0;
                }
                byteArrayOutputStream.write(i2);
                if ((i == 0 || i == 2) && i2 == 13) {
                    i++;
                } else if ((i == 1 || i == 3) && i2 == 10) {
                    i++;
                    if (i == 4) {
                        break loop0;
                    }
                }
            }
        }
        return byteArrayOutputStream.toString("UTF-8");
    }

    /* renamed from: diqgf */
    public synchronized void m7795diqgf() {
        this.f7585wA = false;
        try {
            ServerSocket serverSocket = this.f7584mjFkc;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Throwable unused) {
        }
        this.f7584mjFkc = null;
    }

    /* renamed from: eyqo */
    public final void m7796eyqo(Socket socket, InputStream inputStream, OutputStream outputStream, String str, int i) {
        SSLSocket sSLSocket;
        int i2;
        String strM7794YoKzxo;
        String str2 = str;
        int i3 = 1;
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) this.f7580AZxh.getSocketFactory().createSocket(socket, str2, i, true);
                i2 = 0;
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            sSLSocket.setUseClientMode(false);
            sSLSocket.startHandshake();
            Log.i("DevModeProxy", "TLS 终结: " + str2);
            InputStream inputStream2 = sSLSocket.getInputStream();
            OutputStream outputStream2 = sSLSocket.getOutputStream();
            while (this.f7585wA && (strM7794YoKzxo = m7794YoKzxo(inputStream2)) != null && !strM7794YoKzxo.isEmpty()) {
                byte[] bArrM7790MiMN = m7790MiMN(inputStream2, strM7794YoKzxo);
                String strSubstring = strM7794YoKzxo.substring(i2, strM7794YoKzxo.indexOf(13));
                String str3 = strSubstring.split(" ").length > i3 ? strSubstring.split(" ")[i3] : BuildConfig.f24315FLAVOR;
                boolean zM7781Dt = m7781Dt(str3);
                SSLSocket sSLSocket3 = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket();
                sSLSocket3.connect(new InetSocketAddress(str2, i), 8000);
                sSLSocket3.setSoTimeout(15000);
                OutputStream outputStream3 = sSLSocket3.getOutputStream();
                outputStream3.write(strM7794YoKzxo.getBytes("UTF-8"));
                if (bArrM7790MiMN.length > 0) {
                    outputStream3.write(bArrM7790MiMN);
                }
                outputStream3.flush();
                InputStream inputStream3 = sSLSocket3.getInputStream();
                String strM7794YoKzxo2 = m7794YoKzxo(inputStream3);
                byte[] bArrM7790MiMN2 = m7790MiMN(inputStream3, strM7794YoKzxo2);
                sSLSocket3.close();
                if (zM7781Dt && strM7794YoKzxo2 != null) {
                    int iIndexOf = strM7794YoKzxo2.indexOf(13);
                    String strSubstring2 = iIndexOf > 0 ? strM7794YoKzxo2.substring(0, iIndexOf) : strM7794YoKzxo2;
                    String str4 = "HTTP/1.1 200 OK" + strM7794YoKzxo2.substring(iIndexOf);
                    Log.i("DevModeProxy", "改写响应码: [" + strSubstring2 + "] -> [HTTP/1.1 200 OK] " + str3);
                    bArrM7790MiMN2 = m7788IEE(str4, bArrM7790MiMN2);
                    strM7794YoKzxo2 = m7797fehf(str4, bArrM7790MiMN2.length);
                    this.f7583ZfxDd = this.f7583ZfxDd + 1;
                } else if (strM7794YoKzxo2 != null && strM7794YoKzxo2.toLowerCase().contains("transfer-encoding: chunked")) {
                    strM7794YoKzxo2 = m7797fehf(strM7794YoKzxo2, bArrM7790MiMN2.length);
                }
                outputStream2.write(strM7794YoKzxo2.getBytes("UTF-8"));
                if (bArrM7790MiMN2.length > 0) {
                    outputStream2.write(bArrM7790MiMN2);
                }
                outputStream2.flush();
                str2 = str;
                i3 = 1;
                i2 = 0;
            }
            sSLSocket.close();
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            try {
                String strValueOf = String.valueOf(th);
                if (strValueOf.contains("CERT") || strValueOf.contains("cert") || strValueOf.contains("SSL") || strValueOf.contains("Handshake") || strValueOf.contains("I/O")) {
                    this.f7581JHa = true;
                }
                Log.w("DevModeProxy", "TLS 终结: " + th);
                if (sSLSocket2 != null) {
                    sSLSocket2.close();
                }
            } catch (Throwable th3) {
                if (sSLSocket2 != null) {
                    try {
                        sSLSocket2.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
    }

    /* renamed from: fehf */
    public final String m7797fehf(String str, int i) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("\r\n")) {
            if (!str2.trim().isEmpty()) {
                String lowerCase = str2.toLowerCase();
                if (!lowerCase.startsWith("transfer-encoding:") && !lowerCase.startsWith("content-length:") && !lowerCase.startsWith("content-encoding:")) {
                    sb.append(str2);
                    sb.append("\r\n");
                }
            }
        }
        sb.append("Content-Length: ");
        sb.append(i);
        sb.append("\r\n\r\n");
        return sb.toString();
    }

    /* renamed from: lgHUyS */
    public final void m7798lgHUyS(Socket socket) {
        InputStream inputStream;
        OutputStream outputStream;
        String strM7794YoKzxo;
        int i;
        String str;
        int i2;
        try {
            socket.setSoTimeout(30000);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            strM7794YoKzxo = m7794YoKzxo(inputStream);
        } finally {
            try {
                try {
                    socket.close();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } finally {
                try {
                    socket.close();
                } catch (Throwable unused2) {
                }
            }
        }
        if (strM7794YoKzxo != null && !strM7794YoKzxo.isEmpty()) {
            String[] strArrSplit = strM7794YoKzxo.substring(0, strM7794YoKzxo.indexOf(13)).split(" ");
            if (strArrSplit.length < 2) {
                socket.close();
                try {
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            if ("CONNECT".equalsIgnoreCase(strArrSplit[0])) {
                String str2 = strArrSplit[1];
                int iLastIndexOf = str2.lastIndexOf(58);
                if (iLastIndexOf > 0) {
                    String strSubstring = str2.substring(0, iLastIndexOf);
                    i2 = Integer.parseInt(str2.substring(iLastIndexOf + 1));
                    str = strSubstring;
                } else {
                    str = str2;
                    i2 = 443;
                }
                outputStream.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes("UTF-8"));
                outputStream.flush();
                if (m7782ETF(str)) {
                    this.f7582KLFTb = true;
                    m7796eyqo(socket, inputStream, outputStream, str, i2);
                } else {
                    m7792Ucbh(socket, inputStream, outputStream, str, i2);
                }
            } else {
                String strReplaceFirst = strArrSplit[1].replaceFirst("https?://", BuildConfig.f24315FLAVOR);
                int iIndexOf = strReplaceFirst.indexOf(47);
                if (iIndexOf > 0) {
                    strReplaceFirst = strReplaceFirst.substring(0, iIndexOf);
                }
                int iLastIndexOf2 = strReplaceFirst.lastIndexOf(58);
                if (iLastIndexOf2 > 0) {
                    i = Integer.parseInt(strReplaceFirst.substring(iLastIndexOf2 + 1));
                    strReplaceFirst = strReplaceFirst.substring(0, iLastIndexOf2);
                } else {
                    i = 80;
                }
                Socket socket2 = new Socket();
                socket2.connect(new InetSocketAddress(strReplaceFirst, i), 8000);
                socket2.setSoTimeout(15000);
                byte[] bArrM7790MiMN = m7790MiMN(inputStream, strM7794YoKzxo);
                OutputStream outputStream2 = socket2.getOutputStream();
                outputStream2.write(strM7794YoKzxo.getBytes("UTF-8"));
                if (bArrM7790MiMN.length > 0) {
                    outputStream2.write(bArrM7790MiMN);
                }
                outputStream2.flush();
                InputStream inputStream2 = socket2.getInputStream();
                String strM7794YoKzxo2 = m7794YoKzxo(inputStream2);
                byte[] bArrM7790MiMN2 = m7790MiMN(inputStream2, strM7794YoKzxo2);
                socket2.close();
                outputStream.write(strM7794YoKzxo2.getBytes("UTF-8"));
                if (bArrM7790MiMN2.length > 0) {
                    outputStream.write(bArrM7790MiMN2);
                }
                outputStream.flush();
            }
            socket.close();
            return;
        }
        socket.close();
        try {
            socket.close();
        } catch (Throwable unused4) {
        }
    }

    /* renamed from: qdMbNW */
    public boolean m7799qdMbNW() {
        return this.f7581JHa;
    }

    /* renamed from: rkYL */
    public final String m7800rkYL(InputStream inputStream) throws IOException {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        do {
            i = inputStream.read();
            if (i < 0) {
                break;
            }
            byteArrayOutputStream.write(i);
        } while (i != 10);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        return byteArrayOutputStream.toString("UTF-8");
    }

    /* renamed from: xJ */
    public int m7801xJ() {
        return this.f7583ZfxDd;
    }
}
