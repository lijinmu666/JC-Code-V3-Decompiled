package p131o;

import android.os.IBinder;
import java.lang.reflect.Field;
import p131o.InterfaceC1929F;

/* renamed from: o.T2 */
/* loaded from: classes.dex */
public final class BinderC2869T2 extends InterfaceC1929F.mjFkc {

    /* renamed from: mjFkc */
    public final Object f10637mjFkc;

    public BinderC2869T2(Object obj) {
        this.f10637mjFkc = obj;
    }

    /* renamed from: Ucbh */
    public static InterfaceC1929F m10213Ucbh(Object obj) {
        return new BinderC2869T2(obj);
    }

    /* renamed from: xJ */
    public static Object m10214xJ(InterfaceC1929F interfaceC1929F) throws SecurityException {
        if (interfaceC1929F instanceof BinderC2869T2) {
            return ((BinderC2869T2) interfaceC1929F).f10637mjFkc;
        }
        IBinder iBinderAsBinder = interfaceC1929F.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC2138I3.m8648xJ(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
