package org.bouncycastle.p133asn1.p171util;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1BMPString;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1External;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1GraphicString;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1NumericString;
import org.bouncycastle.p133asn1.ASN1ObjectDescriptor;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p133asn1.ASN1RelativeOID;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1T61String;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.ASN1VideotexString;
import org.bouncycastle.p133asn1.ASN1VisibleString;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.C5101BERSet;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DLBitString;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;

    /* renamed from: TAB */
    private static final String f18580TAB = "    ";

    public static void _dumpAsString(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuilder sb) {
        StringBuilder sb2;
        String str2;
        ASN1Primitive externalContent;
        String string;
        BigInteger value;
        String strM14448getId;
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append(str);
        if (aSN1Primitive instanceof ASN1Null) {
            sb.append("NULL");
            sb.append(strLineSeparator);
            return;
        }
        int i = 0;
        if (aSN1Primitive instanceof ASN1Sequence) {
            sb.append(aSN1Primitive instanceof BERSequence ? "BER Sequence" : aSN1Primitive instanceof DERSequence ? "DER Sequence" : "Sequence");
            sb.append(strLineSeparator);
            ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
            String str3 = str + f18580TAB;
            int iMo14450size = aSN1Sequence.mo14450size();
            while (i < iMo14450size) {
                _dumpAsString(str3, z, aSN1Sequence.getObjectAt(i).toASN1Primitive(), sb);
                i++;
            }
            return;
        }
        if (aSN1Primitive instanceof AbstractC5093ASN1Set) {
            sb.append(aSN1Primitive instanceof C5101BERSet ? "BER Set" : aSN1Primitive instanceof C5104DERSet ? "DER Set" : "Set");
            sb.append(strLineSeparator);
            AbstractC5093ASN1Set abstractC5093ASN1Set = (AbstractC5093ASN1Set) aSN1Primitive;
            String str4 = str + f18580TAB;
            int iM14454size = abstractC5093ASN1Set.m14454size();
            while (i < iM14454size) {
                _dumpAsString(str4, z, abstractC5093ASN1Set.getObjectAt(i).toASN1Primitive(), sb);
                i++;
            }
            return;
        }
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                sb2 = new StringBuilder();
                sb2.append("ObjectIdentifier(");
                strM14448getId = ((ASN1ObjectIdentifier) aSN1Primitive).m14433getId();
            } else {
                if (!(aSN1Primitive instanceof ASN1RelativeOID)) {
                    if (aSN1Primitive instanceof ASN1Boolean) {
                        sb2 = new StringBuilder();
                        sb2.append("Boolean(");
                        sb2.append(((ASN1Boolean) aSN1Primitive).m14419isTrue());
                    } else {
                        if (!(aSN1Primitive instanceof ASN1Integer)) {
                            if (aSN1Primitive instanceof ASN1OctetString) {
                                ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
                                sb.append(aSN1Primitive instanceof BEROctetString ? "BER Constructed Octet String[" : "DER Octet String[");
                                sb.append(aSN1OctetString.getOctetsLength() + "]" + strLineSeparator);
                                if (z) {
                                    dumpBinaryDataAsString(sb, str, aSN1OctetString.getOctets());
                                    return;
                                }
                                return;
                            }
                            if (aSN1Primitive instanceof ASN1BitString) {
                                ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
                                sb.append(aSN1BitString instanceof DERBitString ? "DER Bit String[" : aSN1BitString instanceof DLBitString ? "DL Bit String[" : "BER Bit String[");
                                sb.append(aSN1BitString.getBytesLength() + ", " + aSN1BitString.getPadBits() + "]" + strLineSeparator);
                                if (z) {
                                    dumpBinaryDataAsString(sb, str, aSN1BitString.getBytes());
                                    return;
                                }
                                return;
                            }
                            if (aSN1Primitive instanceof ASN1IA5String) {
                                sb2 = new StringBuilder();
                                sb2.append("IA5String(");
                                string = ((ASN1IA5String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1UTF8String) {
                                sb2 = new StringBuilder();
                                sb2.append("UTF8String(");
                                string = ((ASN1UTF8String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1NumericString) {
                                sb2 = new StringBuilder();
                                sb2.append("NumericString(");
                                string = ((ASN1NumericString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1PrintableString) {
                                sb2 = new StringBuilder();
                                sb2.append("PrintableString(");
                                string = ((ASN1PrintableString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1VisibleString) {
                                sb2 = new StringBuilder();
                                sb2.append("VisibleString(");
                                string = ((ASN1VisibleString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1BMPString) {
                                sb2 = new StringBuilder();
                                sb2.append("BMPString(");
                                string = ((ASN1BMPString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1T61String) {
                                sb2 = new StringBuilder();
                                sb2.append("T61String(");
                                string = ((ASN1T61String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1GraphicString) {
                                sb2 = new StringBuilder();
                                sb2.append("GraphicString(");
                                string = ((ASN1GraphicString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1VideotexString) {
                                sb2 = new StringBuilder();
                                sb2.append("VideotexString(");
                                string = ((ASN1VideotexString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1UTCTime) {
                                sb2 = new StringBuilder();
                                sb2.append("UTCTime(");
                                string = ((ASN1UTCTime) aSN1Primitive).m14461getTime();
                            } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
                                sb2 = new StringBuilder();
                                sb2.append("GeneralizedTime(");
                                string = ((ASN1GeneralizedTime) aSN1Primitive).m14428getTime();
                            } else if (aSN1Primitive instanceof ASN1Enumerated) {
                                sb2 = new StringBuilder();
                                sb2.append("DER Enumerated(");
                                value = ((ASN1Enumerated) aSN1Primitive).getValue();
                            } else if (aSN1Primitive instanceof ASN1ObjectDescriptor) {
                                sb2 = new StringBuilder();
                                sb2.append("ObjectDescriptor(");
                                string = ((ASN1ObjectDescriptor) aSN1Primitive).getBaseGraphicString().getString();
                            } else {
                                if (!(aSN1Primitive instanceof ASN1External)) {
                                    sb2 = new StringBuilder();
                                    sb2.append(aSN1Primitive.toString());
                                    sb2.append(strLineSeparator);
                                    sb.append(sb2.toString());
                                    return;
                                }
                                ASN1External aSN1External = (ASN1External) aSN1Primitive;
                                sb.append("External " + strLineSeparator);
                                str2 = str + f18580TAB;
                                if (aSN1External.getDirectReference() != null) {
                                    sb.append(str2 + "Direct Reference: " + aSN1External.getDirectReference().m14433getId() + strLineSeparator);
                                }
                                if (aSN1External.getIndirectReference() != null) {
                                    sb.append(str2 + "Indirect Reference: " + aSN1External.getIndirectReference().toString() + strLineSeparator);
                                }
                                if (aSN1External.getDataValueDescriptor() != null) {
                                    _dumpAsString(str2, z, aSN1External.getDataValueDescriptor(), sb);
                                }
                                sb.append(str2 + "Encoding: " + aSN1External.getEncoding() + strLineSeparator);
                                externalContent = aSN1External.getExternalContent();
                            }
                            sb2.append(string);
                            sb2.append(") ");
                            sb2.append(strLineSeparator);
                            sb.append(sb2.toString());
                            return;
                        }
                        sb2 = new StringBuilder();
                        sb2.append("Integer(");
                        value = ((ASN1Integer) aSN1Primitive).getValue();
                        sb2.append(value);
                    }
                    sb2.append(")");
                    sb2.append(strLineSeparator);
                    sb.append(sb2.toString());
                    return;
                }
                sb2 = new StringBuilder();
                sb2.append("RelativeOID(");
                strM14448getId = ((ASN1RelativeOID) aSN1Primitive).m14448getId();
            }
            sb2.append(strM14448getId);
            sb2.append(")");
            sb2.append(strLineSeparator);
            sb.append(sb2.toString());
            return;
        }
        sb.append(aSN1Primitive instanceof BERTaggedObject ? "BER Tagged " : aSN1Primitive instanceof DERTaggedObject ? "DER Tagged " : "Tagged ");
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        sb.append(ASN1Util.getTagText(aSN1TaggedObject));
        if (!aSN1TaggedObject.isExplicit()) {
            sb.append(" IMPLICIT");
        }
        sb.append(strLineSeparator);
        str2 = str + f18580TAB;
        externalContent = aSN1TaggedObject.getBaseObject().toASN1Primitive();
        _dumpAsString(str2, z, externalContent, sb);
    }

    private static void appendAscString(StringBuilder sb, byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 != i + i2; i3++) {
            byte b = bArr[i3];
            if (b >= 32 && b <= 126) {
                sb.append((char) b);
            }
        }
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    private static void dumpBinaryDataAsString(StringBuilder sb, String str, byte[] bArr) {
        if (bArr.length < 1) {
            return;
        }
        String strLineSeparator = C6250Strings.lineSeparator();
        String str2 = str + f18580TAB;
        for (int i = 0; i < bArr.length; i += 32) {
            int iMin = Math.min(bArr.length - i, 32);
            sb.append(str2);
            sb.append(C6255Hex.toHexString(bArr, i, iMin));
            for (int i2 = iMin; i2 < 32; i2++) {
                sb.append("  ");
            }
            sb.append(f18580TAB);
            appendAscString(sb, bArr, i, iMin);
            sb.append(strLineSeparator);
        }
    }

    public static String dumpAsString(Object obj, boolean z) {
        ASN1Primitive aSN1Primitive;
        if (obj instanceof ASN1Primitive) {
            aSN1Primitive = (ASN1Primitive) obj;
        } else {
            if (!(obj instanceof ASN1Encodable)) {
                return "unknown object type " + obj.toString();
            }
            aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
        }
        StringBuilder sb = new StringBuilder();
        _dumpAsString(BuildConfig.f24315FLAVOR, z, aSN1Primitive, sb);
        return sb.toString();
    }
}
