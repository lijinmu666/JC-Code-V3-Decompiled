package org.bouncycastle.p358tsp.p360ers;

import java.util.Date;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class ERSEvidenceRecordSelector implements Selector<ERSEvidenceRecord> {

    /* renamed from: data */
    private final InterfaceC6235ERSData f24182data;

    /* renamed from: date */
    private final Date f24183date;

    public ERSEvidenceRecordSelector(InterfaceC6235ERSData interfaceC6235ERSData) {
        this(interfaceC6235ERSData, new Date());
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return this;
    }

    /* renamed from: getData */
    public InterfaceC6235ERSData m18215getData() {
        return this.f24182data;
    }

    public ERSEvidenceRecordSelector(InterfaceC6235ERSData interfaceC6235ERSData, Date date) {
        this.f24182data = interfaceC6235ERSData;
        this.f24183date = new Date(date.getTime());
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo14742match(ERSEvidenceRecord eRSEvidenceRecord) {
        try {
            if (eRSEvidenceRecord.isContaining(this.f24182data, this.f24183date)) {
                eRSEvidenceRecord.validatePresent(this.f24182data, this.f24183date);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
