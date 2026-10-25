package p131o;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.conscrypt.BuildConfig;
import p094kotlin.p117text.Typography;

/* renamed from: o.My */
/* loaded from: classes.dex */
public abstract class AbstractC2474My {

    /* renamed from: mjFkc */
    public static final char[] f9624mjFkc;

    static {
        char[] cArr = new char[80];
        f9624mjFkc = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* renamed from: AZxh */
    public static void m9562AZxh(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m9562AZxh(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m9562AZxh(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        m9565wA(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(AbstractC3856hz.m12260mjFkc(new C4917xx(((String) obj).getBytes(AbstractC4183my.f15287mjFkc))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof AbstractC4981yx) {
            sb.append(": \"");
            sb.append(AbstractC3856hz.m12260mjFkc((AbstractC4981yx) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof AbstractC3595dy) {
            sb.append(" {");
            m9563ZfxDd((AbstractC3595dy) obj, sb, i + 2);
            sb.append("\n");
            m9565wA(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        m9562AZxh(sb, i3, "key", entry.getKey());
        m9562AZxh(sb, i3, "value", entry.getValue());
        sb.append("\n");
        m9565wA(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /* renamed from: ZfxDd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m9563ZfxDd(InterfaceC2341Ky interfaceC2341Ky, StringBuilder sb, int i) throws SecurityException {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = interfaceC2341Ky.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                m9562AZxh(sb, i, strSubstring.substring(0, strSubstring.length() - 4), AbstractC3595dy.m11757mByQ(method2, interfaceC2341Ky, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                m9562AZxh(sb, i, strSubstring.substring(0, strSubstring.length() - 3), AbstractC3595dy.m11757mByQ(method, interfaceC2341Ky, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objM11757mByQ = AbstractC3595dy.m11757mByQ(method4, interfaceC2341Ky, new Object[0]);
                    if (method5 == null) {
                        if (objM11757mByQ instanceof Boolean) {
                            if (((Boolean) objM11757mByQ).booleanValue()) {
                                m9562AZxh(sb, i, strSubstring, objM11757mByQ);
                            }
                        } else if (objM11757mByQ instanceof Integer) {
                            if (((Integer) objM11757mByQ).intValue() != 0) {
                            }
                        } else if (objM11757mByQ instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objM11757mByQ).floatValue()) != 0) {
                            }
                        } else if (!(objM11757mByQ instanceof Double)) {
                            if (objM11757mByQ instanceof String) {
                                zEquals = objM11757mByQ.equals(BuildConfig.f24315FLAVOR);
                            } else if (objM11757mByQ instanceof AbstractC4981yx) {
                                zEquals = objM11757mByQ.equals(AbstractC4981yx.f17599AZxh);
                            } else if (objM11757mByQ instanceof InterfaceC2341Ky) {
                                if (objM11757mByQ != ((InterfaceC2341Ky) objM11757mByQ).mo9399lgHUyS()) {
                                }
                            } else if (!(objM11757mByQ instanceof Enum) || ((Enum) objM11757mByQ).ordinal() != 0) {
                            }
                            if (!zEquals) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objM11757mByQ).doubleValue()) != 0) {
                        }
                    } else if (((Boolean) AbstractC3595dy.m11757mByQ(method5, interfaceC2341Ky, new Object[0])).booleanValue()) {
                    }
                }
            }
            i2 = 3;
        }
        if (interfaceC2341Ky instanceof AbstractC3330Zx) {
            Iterator itM9989xJ = ((AbstractC3330Zx) interfaceC2341Ky).f12261zbb.m9989xJ();
            while (itM9989xJ.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itM9989xJ.next();
                m9562AZxh(sb, i, "[32149011]", entry2.getValue());
            }
        }
        C4055kz c4055kz = ((AbstractC3595dy) interfaceC2341Ky).f13418zbc;
        if (c4055kz != null) {
            c4055kz.m12645qdMbNW(sb, i);
        }
    }

    /* renamed from: mjFkc */
    public static String m9564mjFkc(InterfaceC2341Ky interfaceC2341Ky, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        m9563ZfxDd(interfaceC2341Ky, sb, 0);
        return sb.toString();
    }

    /* renamed from: wA */
    public static void m9565wA(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(f9624mjFkc, 0, i2);
            i -= i2;
        }
    }
}
