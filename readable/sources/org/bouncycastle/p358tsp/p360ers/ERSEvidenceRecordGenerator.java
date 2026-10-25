package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.p169tsp.CryptoInfos;
import org.bouncycastle.p133asn1.p169tsp.EncryptionInfo;
import org.bouncycastle.p133asn1.p169tsp.EvidenceRecord;

/* loaded from: classes2.dex */
public class ERSEvidenceRecordGenerator {
    private final DigestCalculatorProvider digCalcProv;

    public ERSEvidenceRecordGenerator(DigestCalculatorProvider digestCalculatorProvider) {
        this.digCalcProv = digestCalculatorProvider;
    }

    public List<ERSEvidenceRecord> generate(List<ERSArchiveTimeStamp> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i != list.size(); i++) {
            arrayList.add(new ERSEvidenceRecord(new EvidenceRecord((CryptoInfos) null, (EncryptionInfo) null, list.get(i).toASN1Structure()), this.digCalcProv));
        }
        return arrayList;
    }

    public ERSEvidenceRecord generate(ERSArchiveTimeStamp eRSArchiveTimeStamp) {
        return new ERSEvidenceRecord(new EvidenceRecord((CryptoInfos) null, (EncryptionInfo) null, eRSArchiveTimeStamp.toASN1Structure()), this.digCalcProv);
    }
}
