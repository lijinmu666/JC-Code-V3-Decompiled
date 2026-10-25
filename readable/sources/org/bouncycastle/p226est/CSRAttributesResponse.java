package org.bouncycastle.p226est;

import java.util.Collection;
import java.util.HashMap;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p147est.AttrOrOID;
import org.bouncycastle.p133asn1.p147est.CsrAttrs;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CSRAttributesResponse implements Encodable {
    private final CsrAttrs csrAttrs;

    /* renamed from: index */
    private final HashMap<ASN1ObjectIdentifier, AttrOrOID> f21164index;

    public CSRAttributesResponse(CsrAttrs csrAttrs) {
        HashMap<ASN1ObjectIdentifier, AttrOrOID> map;
        ASN1ObjectIdentifier attrType;
        this.csrAttrs = csrAttrs;
        this.f21164index = new HashMap<>(csrAttrs.m14609size());
        AttrOrOID[] attrOrOIDs = csrAttrs.getAttrOrOIDs();
        for (int i = 0; i != attrOrOIDs.length; i++) {
            AttrOrOID attrOrOID = attrOrOIDs[i];
            if (attrOrOID.m14608isOid()) {
                map = this.f21164index;
                attrType = attrOrOID.m14607getOid();
            } else {
                map = this.f21164index;
                attrType = attrOrOID.getAttribute().getAttrType();
            }
            map.put(attrType, attrOrOID);
        }
    }

    private static CsrAttrs parseBytes(byte[] bArr) throws ESTException {
        try {
            return CsrAttrs.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (Exception e) {
            throw new ESTException("malformed data: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.csrAttrs.getEncoded();
    }

    public Collection<ASN1ObjectIdentifier> getRequirements() {
        return this.f21164index.keySet();
    }

    public boolean hasRequirement(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f21164index.containsKey(aSN1ObjectIdentifier);
    }

    public boolean isAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.f21164index.containsKey(aSN1ObjectIdentifier)) {
            return !this.f21164index.get(aSN1ObjectIdentifier).m14608isOid();
        }
        return false;
    }

    /* renamed from: isEmpty */
    public boolean m15956isEmpty() {
        return this.csrAttrs.m14609size() == 0;
    }

    public CSRAttributesResponse(byte[] bArr) {
        this(parseBytes(bArr));
    }
}
