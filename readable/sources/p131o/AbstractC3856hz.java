package p131o;

/* renamed from: o.hz */
/* loaded from: classes.dex */
public abstract class AbstractC3856hz {
    /* renamed from: mjFkc */
    public static String m12260mjFkc(AbstractC4981yx abstractC4981yx) {
        StringBuilder sb = new StringBuilder(abstractC4981yx.mo13326JHa());
        for (int i = 0; i < abstractC4981yx.mo13326JHa(); i++) {
            byte bMo13329mjFkc = abstractC4981yx.mo13329mjFkc(i);
            if (bMo13329mjFkc == 34) {
                sb.append("\\\"");
            } else if (bMo13329mjFkc == 39) {
                sb.append("\\'");
            } else if (bMo13329mjFkc != 92) {
                switch (bMo13329mjFkc) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bMo13329mjFkc < 32 || bMo13329mjFkc > 126) {
                            sb.append('\\');
                            sb.append((char) (((bMo13329mjFkc >>> 6) & 3) + 48));
                            sb.append((char) (((bMo13329mjFkc >>> 3) & 7) + 48));
                            sb.append((char) ((bMo13329mjFkc & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bMo13329mjFkc);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
