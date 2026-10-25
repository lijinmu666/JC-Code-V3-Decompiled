package com.p038google.p039android.libraries.p055vision.visionkit.pipeline.p056alt;

import androidx.annotation.InterfaceC0000Keep;
import com.google.android.apps.common.proguard.UsedByNative;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p131o.AbstractC1790Cs;
import p131o.AbstractC2919Ts;
import p131o.C1640Af;
import p131o.C2267Js;
import p131o.C2340Kx;
import p131o.C3522cp;
import p131o.EnumC4106ln;

@InterfaceC0000Keep
@UsedByNative("pipeline_jni.cc")
/* loaded from: classes.dex */
public class PipelineException extends Exception {
    private static final String ROOT_CAUSE_DELIMITER = "#vk ";
    private final EnumC4106ln statusCode;
    private final String statusMessage;
    private final C3522cp visionkitStatus;

    public PipelineException(int i, String str) {
        super(EnumC4106ln.m12710values()[i].m12711KLFTb() + ": " + str);
        this.statusCode = EnumC4106ln.m12710values()[i];
        this.statusMessage = str;
        this.visionkitStatus = null;
    }

    public List<C1640Af> getComponentStatuses() {
        C3522cp c3522cp = this.visionkitStatus;
        return c3522cp != null ? c3522cp.m11622KLMXS() : AbstractC2919Ts.m10439Dt();
    }

    public AbstractC1790Cs getRootCauseMessage() {
        Object next;
        Object obj;
        if (!this.statusMessage.contains(ROOT_CAUSE_DELIMITER)) {
            return AbstractC1790Cs.m7936ZfxDd();
        }
        List listM9067AZxh = C2267Js.m9066mjFkc(ROOT_CAUSE_DELIMITER).m9067AZxh(this.statusMessage);
        if (listM9067AZxh == null) {
            Iterator it = listM9067AZxh.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (listM9067AZxh.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = listM9067AZxh.get(listM9067AZxh.size() - 1);
        }
        return AbstractC1790Cs.m7935KLFTb((String) obj);
    }

    public EnumC4106ln getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    private PipelineException(C3522cp c3522cp) {
        super(EnumC4106ln.m12710values()[c3522cp.m11623OjSQV()].m12711KLFTb() + ": " + c3522cp.m11624xrEuO());
        this.statusCode = EnumC4106ln.m12710values()[c3522cp.m11623OjSQV()];
        this.statusMessage = c3522cp.m11624xrEuO();
        this.visionkitStatus = c3522cp;
    }

    @InterfaceC0000Keep
    @UsedByNative("pipeline_jni.cc")
    public PipelineException(byte[] bArr) {
        this(C3522cp.m11620CqaNbM(bArr, C2340Kx.m9291mjFkc()));
    }
}
