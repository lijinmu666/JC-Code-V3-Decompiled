package p131o;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.conscrypt.BuildConfig;

/* renamed from: o.R0 */
/* loaded from: classes.dex */
public class C2733R0 {

    /* renamed from: AZxh */
    public static final C3401b f10355AZxh = new C3401b("LibraryVersion", BuildConfig.f24315FLAVOR);

    /* renamed from: wA */
    public static final C2733R0 f10356wA = new C2733R0();

    /* renamed from: mjFkc */
    public final ConcurrentHashMap f10357mjFkc = new ConcurrentHashMap();

    /* renamed from: mjFkc */
    public static C2733R0 m10035mjFkc() {
        return f10356wA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: AZxh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m10036AZxh(String str) throws Throwable {
        Object obj;
        InputStream resourceAsStream;
        AbstractC2138I3.m8641JHa(str, "Please provide a valid libraryName");
        if (this.f10357mjFkc.containsKey(str)) {
            return (String) this.f10357mjFkc.get(str);
        }
        Properties properties = new Properties();
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        InputStream inputStream = null;
        try {
            try {
                resourceAsStream = C2733R0.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            obj = null;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                String property = properties.getProperty("version", null);
                f10355AZxh.m11440KLFTb("LibraryVersion", str + " version is " + property);
                r3 = property;
            } else {
                f10355AZxh.m11439JHa("LibraryVersion", "Failed to get app version for libraryName: " + str);
            }
        } catch (IOException e2) {
            e = e2;
            obj = r3;
            inputStream = resourceAsStream;
            f10355AZxh.m11441ZfxDd("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
            Object obj2 = obj;
            resourceAsStream = inputStream;
            r3 = obj2;
            if (resourceAsStream != null) {
            }
            if (r3 == 0) {
            }
            this.f10357mjFkc.put(str, r3);
            return r3;
        } catch (Throwable th2) {
            th = th2;
            r3 = resourceAsStream;
            if (r3 != 0) {
                AbstractC1860E.m8100mjFkc(r3);
            }
            throw th;
        }
        if (resourceAsStream != null) {
            AbstractC1860E.m8100mjFkc(resourceAsStream);
        }
        if (r3 == 0) {
            f10355AZxh.m11438AZxh("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            r3 = "UNKNOWN";
        }
        this.f10357mjFkc.put(str, r3);
        return r3;
    }
}
