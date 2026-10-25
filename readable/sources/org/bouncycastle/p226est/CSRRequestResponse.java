package org.bouncycastle.p226est;

/* loaded from: classes2.dex */
public class CSRRequestResponse {
    private final CSRAttributesResponse attributesResponse;

    /* renamed from: source */
    private final InterfaceC5444Source f21165source;

    public CSRRequestResponse(CSRAttributesResponse cSRAttributesResponse, InterfaceC5444Source interfaceC5444Source) {
        this.attributesResponse = cSRAttributesResponse;
        this.f21165source = interfaceC5444Source;
    }

    public CSRAttributesResponse getAttributesResponse() {
        CSRAttributesResponse cSRAttributesResponse = this.attributesResponse;
        if (cSRAttributesResponse != null) {
            return cSRAttributesResponse;
        }
        throw new IllegalStateException("Response has no CSRAttributesResponse.");
    }

    public Object getSession() {
        return this.f21165source.getSession();
    }

    public InterfaceC5444Source getSource() {
        return this.f21165source;
    }

    public boolean hasAttributesResponse() {
        return this.attributesResponse != null;
    }
}
