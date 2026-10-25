package org.bouncycastle.p365voms;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p174x509.Attribute;
import org.bouncycastle.p133asn1.p174x509.IetfAttrSyntax;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class VOMSAttribute {
    public static final String VOMS_ATTR_OID = "1.3.6.1.4.1.8005.100.100.4";

    /* renamed from: myAC */
    private X509AttributeCertificateHolder f24271myAC;
    private String myHostPort;

    /* renamed from: myVo */
    private String f24273myVo;
    private List myStringList = new ArrayList();

    /* renamed from: myFQANs */
    private List f24272myFQANs = new ArrayList();

    /* renamed from: org.bouncycastle.voms.VOMSAttribute$FQAN */
    public static class C6262FQAN {
        String capability;

        /* renamed from: fqan */
        String f24274fqan;

        /* renamed from: group */
        String f24275group;

        /* renamed from: role */
        String f24276role;

        public C6262FQAN(String str) {
            this.f24274fqan = str;
        }

        public String getCapability() {
            if (this.f24275group == null && this.f24274fqan != null) {
                m18385split();
            }
            return this.capability;
        }

        /* renamed from: getFQAN */
        public String m18383getFQAN() {
            String str = this.f24274fqan;
            if (str != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24275group);
            sb.append("/Role=");
            String str2 = this.f24276role;
            String str3 = BuildConfig.f24315FLAVOR;
            if (str2 == null) {
                str2 = BuildConfig.f24315FLAVOR;
            }
            sb.append(str2);
            if (this.capability != null) {
                str3 = "/Capability=" + this.capability;
            }
            sb.append(str3);
            String string = sb.toString();
            this.f24274fqan = string;
            return string;
        }

        public String getGroup() {
            if (this.f24275group == null && this.f24274fqan != null) {
                m18385split();
            }
            return this.f24275group;
        }

        /* renamed from: getRole */
        public String m18384getRole() {
            if (this.f24275group == null && this.f24274fqan != null) {
                m18385split();
            }
            return this.f24276role;
        }

        /* renamed from: split */
        public void m18385split() {
            this.f24274fqan.length();
            int iIndexOf = this.f24274fqan.indexOf("/Role=");
            if (iIndexOf < 0) {
                return;
            }
            this.f24275group = this.f24274fqan.substring(0, iIndexOf);
            int i = iIndexOf + 6;
            int iIndexOf2 = this.f24274fqan.indexOf("/Capability=", i);
            String str = this.f24274fqan;
            String strSubstring = iIndexOf2 < 0 ? str.substring(i) : str.substring(i, iIndexOf2);
            String str2 = null;
            if (strSubstring.length() == 0) {
                strSubstring = null;
            }
            this.f24276role = strSubstring;
            String strSubstring2 = iIndexOf2 < 0 ? null : this.f24274fqan.substring(iIndexOf2 + 12);
            if (strSubstring2 != null && strSubstring2.length() != 0) {
                str2 = strSubstring2;
            }
            this.capability = str2;
        }

        public String toString() {
            return m18383getFQAN();
        }

        public C6262FQAN(String str, String str2, String str3) {
            this.f24275group = str;
            this.f24276role = str2;
            this.capability = str3;
        }
    }

    public VOMSAttribute(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        if (x509AttributeCertificateHolder == null) {
            throw new IllegalArgumentException("VOMSAttribute: AttributeCertificate is NULL");
        }
        this.f24271myAC = x509AttributeCertificateHolder;
        Attribute[] attributes = x509AttributeCertificateHolder.getAttributes(new ASN1ObjectIdentifier(VOMS_ATTR_OID));
        if (attributes == null) {
            return;
        }
        for (int i = 0; i != attributes.length; i++) {
            try {
                IetfAttrSyntax ietfAttrSyntax = IetfAttrSyntax.getInstance(attributes[i].getAttributeValues()[0]);
                String string = ((ASN1IA5String) ietfAttrSyntax.getPolicyAuthority().getNames()[0].m14690getName()).getString();
                int iIndexOf = string.indexOf("://");
                if (iIndexOf < 0 || iIndexOf == string.length() - 1) {
                    throw new IllegalArgumentException("Bad encoding of VOMS policyAuthority : [" + string + "]");
                }
                this.f24273myVo = string.substring(0, iIndexOf);
                this.myHostPort = string.substring(iIndexOf + 3);
                if (ietfAttrSyntax.getValueType() != 1) {
                    throw new IllegalArgumentException("VOMS attribute values are not encoded as octet strings, policyAuthority = " + string);
                }
                ASN1OctetString[] aSN1OctetStringArr = (ASN1OctetString[]) ietfAttrSyntax.getValues();
                for (int i2 = 0; i2 != aSN1OctetStringArr.length; i2++) {
                    String str = new String(aSN1OctetStringArr[i2].getOctets());
                    C6262FQAN c6262fqan = new C6262FQAN(str);
                    if (!this.myStringList.contains(str)) {
                        if (str.startsWith("/" + this.f24273myVo + "/")) {
                            this.myStringList.add(str);
                            this.f24272myFQANs.add(c6262fqan);
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception unused) {
                throw new IllegalArgumentException("Badly encoded VOMS extension in AC issued by " + x509AttributeCertificateHolder.getIssuer());
            }
        }
    }

    /* renamed from: getAC */
    public X509AttributeCertificateHolder m18381getAC() {
        return this.f24271myAC;
    }

    public List getFullyQualifiedAttributes() {
        return this.myStringList;
    }

    public String getHostPort() {
        return this.myHostPort;
    }

    public List getListOfFQAN() {
        return this.f24272myFQANs;
    }

    /* renamed from: getVO */
    public String m18382getVO() {
        return this.f24273myVo;
    }

    public String toString() {
        return "VO      :" + this.f24273myVo + "\nHostPort:" + this.myHostPort + "\nFQANs   :" + this.f24272myFQANs;
    }
}
