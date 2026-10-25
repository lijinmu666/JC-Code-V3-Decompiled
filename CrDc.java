package o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import kotlin.UByte;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class CrDc {

    public static class AZxh extends SSLSocketFactory {
        public final String AZxh;
        public final SSLSocketFactory mjFkc = HttpsURLConnection.getDefaultSSLSocketFactory();
        public final String wA;

        public AZxh(String str, String str2) {
            this.AZxh = str;
            this.wA = str2;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) {
            return mjFkc();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.mjFkc.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.mjFkc.getSupportedCipherSuites();
        }

        public final Socket mjFkc() throws IOException {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(this.AZxh, 443), 6000);
            return this.mjFkc.createSocket(socket, this.wA, 443, true);
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
            return mjFkc();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) {
            return mjFkc();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
            return mjFkc();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() {
            return new Socket();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
            return mjFkc();
        }
    }

    public class mjFkc implements HostnameVerifier {
        public final /* synthetic */ HostnameVerifier mjFkc;

        public mjFkc(HostnameVerifier hostnameVerifier) {
            this.mjFkc = hostnameVerifier;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return "gk.aibangos.xyz".equalsIgnoreCase(str) && this.mjFkc.verify(str, sSLSession);
        }
    }

    public static String AZxh(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\"data\"\\s*:\\s*\"(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\"").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        Matcher matcher2 = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static String JHa(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                inputStream.close();
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static String KLFTb(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "application/dns-json");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            String strJHa = JHa(httpURLConnection.getInputStream());
            httpURLConnection.disconnect();
            return strJHa;
        }
        throw new IOException("HTTP " + responseCode);
    }

    public static String ZfxDd(String str, String str2) throws IOException {
        if (str == null || str.length() == 0) {
            throw new IOException("解析服务器地址失败");
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://gk.aibangos.xyz" + str2).openConnection(Proxy.NO_PROXY);
        httpsURLConnection.setSSLSocketFactory(new AZxh(str, "gk.aibangos.xyz"));
        httpsURLConnection.setHostnameVerifier(new mjFkc(HttpsURLConnection.getDefaultHostnameVerifier()));
        httpsURLConnection.setConnectTimeout(6000);
        httpsURLConnection.setReadTimeout(6000);
        httpsURLConnection.setRequestMethod("GET");
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode == 200) {
            String strJHa = JHa(httpsURLConnection.getInputStream());
            httpsURLConnection.disconnect();
            return strJHa;
        }
        throw new IOException("HTTP " + responseCode);
    }

    public static void lgHUyS(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        long jOptLong = jSONObject.optLong("time", 0L);
        if (jOptLong <= 0 || Math.abs(System.currentTimeMillis() - jOptLong) > 300000) {
            throw new Exception("响应时间戳异常（疑似重放）");
        }
        boolean zOptBoolean = jSONObject.optBoolean("enabled", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("banned", false);
        String strWA = wA((zOptBoolean ? 1 : 0) + "|" + (zOptBoolean2 ? 1 : 0) + "|" + jSONObject.optString("d", BuildConfig.FLAVOR) + "|" + jOptLong);
        String strOptString = jSONObject.optString("sign", BuildConfig.FLAVOR);
        if (strOptString.length() == 0 || !strWA.equalsIgnoreCase(strOptString)) {
            throw new Exception("响应签名校验失败（疑似篡改）");
        }
    }

    public static String mjFkc(String str) throws Exception {
        String strZfxDd = ZfxDd(xJ("gk.aibangos.xyz"), "/api/status" + str);
        lgHUyS(strZfxDd);
        return strZfxDd;
    }

    public static String wA(String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec("jc-gate-sign-2026".getBytes("UTF-8"), "HmacSHA256"));
        byte[] bArrDoFinal = mac.doFinal(str.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDoFinal) {
            sb.append(String.format("%02x", Integer.valueOf(b & UByte.MAX_VALUE)));
        }
        return sb.toString();
    }

    public static String xJ(String str) {
        String strAZxh;
        String[] strArr = {"https://1.1.1.1/dns-query?name=" + str + "&type=A", "https://dns.alidns.com/resolve?name=" + str + "&type=A"};
        for (int i = 0; i < 2; i++) {
            try {
                strAZxh = AZxh(KLFTb(strArr[i]));
            } catch (Throwable unused) {
            }
            if (strAZxh != null) {
                return strAZxh;
            }
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable unused2) {
            return null;
        }
    }
}
