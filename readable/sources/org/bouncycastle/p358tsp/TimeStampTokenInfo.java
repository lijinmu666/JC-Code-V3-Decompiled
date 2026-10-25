package org.bouncycastle.p358tsp;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p169tsp.Accuracy;
import org.bouncycastle.p133asn1.p169tsp.C5186TSTInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* loaded from: classes2.dex */
public class TimeStampTokenInfo {

    /* renamed from: genTime */
    Date f24169genTime;

    /* renamed from: tstInfo */
    C5186TSTInfo f24170tstInfo;

    public TimeStampTokenInfo(C5186TSTInfo c5186TSTInfo) throws TSPException {
        this.f24170tstInfo = c5186TSTInfo;
        try {
            this.f24169genTime = c5186TSTInfo.getGenTime().m14427getDate();
        } catch (ParseException unused) {
            throw new TSPException("unable to parse genTime field");
        }
    }

    public Accuracy getAccuracy() {
        return this.f24170tstInfo.getAccuracy();
    }

    public byte[] getEncoded() {
        return this.f24170tstInfo.getEncoded();
    }

    public Extensions getExtensions() {
        return this.f24170tstInfo.getExtensions();
    }

    public Date getGenTime() {
        return this.f24169genTime;
    }

    public GenTimeAccuracy getGenTimeAccuracy() {
        if (getAccuracy() != null) {
            return new GenTimeAccuracy(getAccuracy());
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.f24170tstInfo.getMessageImprint().getHashAlgorithm();
    }

    public ASN1ObjectIdentifier getMessageImprintAlgOID() {
        return this.f24170tstInfo.getMessageImprint().getHashAlgorithm().getAlgorithm();
    }

    public byte[] getMessageImprintDigest() {
        return this.f24170tstInfo.getMessageImprint().getHashedMessage();
    }

    public BigInteger getNonce() {
        if (this.f24170tstInfo.getNonce() != null) {
            return this.f24170tstInfo.getNonce().getValue();
        }
        return null;
    }

    public ASN1ObjectIdentifier getPolicy() {
        return this.f24170tstInfo.getPolicy();
    }

    public BigInteger getSerialNumber() {
        return this.f24170tstInfo.getSerialNumber().getValue();
    }

    /* renamed from: getTsa */
    public GeneralName m18210getTsa() {
        return this.f24170tstInfo.m14651getTsa();
    }

    public boolean isOrdered() {
        return this.f24170tstInfo.getOrdering().m14419isTrue();
    }

    public C5186TSTInfo toASN1Structure() {
        return this.f24170tstInfo;
    }

    public C5186TSTInfo toTSTInfo() {
        return this.f24170tstInfo;
    }
}
