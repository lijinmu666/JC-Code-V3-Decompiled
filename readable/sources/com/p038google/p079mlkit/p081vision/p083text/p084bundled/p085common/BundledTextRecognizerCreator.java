package com.p038google.p079mlkit.p081vision.p083text.p084bundled.p085common;

import android.content.Context;
import android.os.RemoteException;
import com.p038google.p039android.p042gms.p046common.p048util.DynamiteApi;
import p131o.AbstractBinderC2470Mu;
import p131o.AbstractC2138I3;
import p131o.BinderC2706Qd;
import p131o.BinderC2869T2;
import p131o.C3192Xu;
import p131o.InterfaceC1929F;

@DynamiteApi
/* loaded from: classes.dex */
public class BundledTextRecognizerCreator extends AbstractBinderC2470Mu {
    @Override // p131o.InterfaceC2534Nu
    public BinderC2706Qd newTextRecognizer(InterfaceC1929F interfaceC1929F) throws RemoteException {
        throw new RemoteException("Please use newTextRecognizerWithOptions instead.");
    }

    @Override // p131o.InterfaceC2534Nu
    public BinderC2706Qd newTextRecognizerWithOptions(InterfaceC1929F interfaceC1929F, C3192Xu c3192Xu) {
        return new BinderC2706Qd((Context) AbstractC2138I3.m8648xJ((Context) BinderC2869T2.m10214xJ(interfaceC1929F)), c3192Xu.m10995mjFkc(), c3192Xu.m10996wA(), c3192Xu.m10993AZxh(), c3192Xu.m10994ZfxDd());
    }
}
