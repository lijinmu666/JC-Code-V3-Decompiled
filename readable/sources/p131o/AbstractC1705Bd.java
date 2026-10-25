package p131o;

import android.os.Build;
import com.flyfishxu.p028kadb.p030core.AdbProtocol;

/* renamed from: o.Bd */
/* loaded from: classes.dex */
public abstract class AbstractC1705Bd {

    /* renamed from: mjFkc */
    public static final int f7502mjFkc;

    static {
        f7502mjFkc = Build.VERSION.SDK_INT >= 31 ? AdbProtocol.INITIAL_DELAYED_ACK_BYTES : 0;
    }
}
