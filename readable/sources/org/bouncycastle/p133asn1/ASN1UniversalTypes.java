package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
final class ASN1UniversalTypes {
    private ASN1UniversalTypes() {
    }

    /* renamed from: get */
    public static ASN1UniversalType m14463get(int i) {
        switch (i) {
            case 1:
                return ASN1Boolean.f17899TYPE;
            case 2:
                return ASN1Integer.f17921TYPE;
            case 3:
                return ASN1BitString.f17895TYPE;
            case 4:
                return ASN1OctetString.f17931TYPE;
            case 5:
                return ASN1Null.f17925TYPE;
            case 6:
                return ASN1ObjectIdentifier.f17928TYPE;
            case 7:
                return ASN1ObjectDescriptor.f17927TYPE;
            case 8:
                return ASN1External.f17908TYPE;
            case 9:
            case 11:
            case 14:
            case 15:
            case 29:
            default:
                return null;
            case 10:
                return ASN1Enumerated.f17904TYPE;
            case 12:
                return ASN1UTF8String.f17955TYPE;
            case 13:
                return ASN1RelativeOID.f17936TYPE;
            case 16:
                return ASN1Sequence.f17938TYPE;
            case 17:
                return AbstractC5093ASN1Set.f17943TYPE;
            case 18:
                return ASN1NumericString.f17926TYPE;
            case 19:
                return ASN1PrintableString.f17935TYPE;
            case 20:
                return ASN1T61String.f17951TYPE;
            case 21:
                return ASN1VideotexString.f17959TYPE;
            case 22:
                return ASN1IA5String.f17913TYPE;
            case 23:
                return ASN1UTCTime.f17954TYPE;
            case 24:
                return ASN1GeneralizedTime.f17910TYPE;
            case 25:
                return ASN1GraphicString.f17912TYPE;
            case 26:
                return ASN1VisibleString.f17960TYPE;
            case 27:
                return ASN1GeneralString.f17909TYPE;
            case 28:
                return ASN1UniversalString.f17956TYPE;
            case 30:
                return ASN1BMPString.f17893TYPE;
        }
    }
}
