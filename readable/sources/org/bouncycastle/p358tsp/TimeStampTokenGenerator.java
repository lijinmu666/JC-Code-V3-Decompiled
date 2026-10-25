package org.bouncycastle.p358tsp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.LocaleUtil;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p146ess.ESSCertID;
import org.bouncycastle.p133asn1.p146ess.ESSCertIDv2;
import org.bouncycastle.p133asn1.p146ess.SigningCertificate;
import org.bouncycastle.p133asn1.p146ess.SigningCertificateV2;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p169tsp.Accuracy;
import org.bouncycastle.p133asn1.p169tsp.C5186TSTInfo;
import org.bouncycastle.p133asn1.p169tsp.MessageImprint;
import org.bouncycastle.p133asn1.p169tsp.TimeStampReq;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSProcessableByteArray;
import org.bouncycastle.p191cms.CMSSignedDataGenerator;
import org.bouncycastle.p191cms.SignerInfoGenerator;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class TimeStampTokenGenerator {
    public static final int R_HUNDREDTHS_OF_SECONDS = 2;
    public static final int R_MICROSECONDS = 2;
    public static final int R_MILLISECONDS = 3;
    public static final int R_SECONDS = 0;
    public static final int R_TENTHS_OF_SECONDS = 1;
    private int accuracyMicros;
    private int accuracyMillis;
    private int accuracySeconds;
    private List attrCerts;

    /* renamed from: certs */
    private List f24163certs;

    /* renamed from: crls */
    private List f24164crls;

    /* renamed from: locale */
    private Locale f24165locale;
    boolean ordering;
    private Map otherRevoc;
    private int resolution;
    private SignerInfoGenerator signerInfoGen;

    /* renamed from: tsa */
    GeneralName f24166tsa;
    private ASN1ObjectIdentifier tsaPolicyOID;

    public TimeStampTokenGenerator(SignerInfoGenerator signerInfoGenerator, DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(signerInfoGenerator, digestCalculator, aSN1ObjectIdentifier, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[PHI: r0
      0x006b: PHI (r0v5 int) = (r0v4 int), (r0v7 int) binds: [B:23:0x0079, B:20:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ASN1GeneralizedTime createGeneralizedTime(Date date) throws TSPException {
        int i;
        SimpleDateFormat simpleDateFormat = this.f24165locale == null ? new SimpleDateFormat("yyyyMMddHHmmss.SSS", LocaleUtil.EN_Locale) : new SimpleDateFormat("yyyyMMddHHmmss.SSS", this.f24165locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        StringBuilder sb = new StringBuilder(simpleDateFormat.format(date));
        int iIndexOf = sb.indexOf(".");
        if (iIndexOf < 0) {
            sb.append("Z");
            return new ASN1GeneralizedTime(sb.toString());
        }
        int i2 = this.resolution;
        if (i2 == 1) {
            i = iIndexOf + 2;
            if (sb.length() > i) {
            }
        } else if (i2 == 2) {
            i = iIndexOf + 3;
            if (sb.length() > i) {
                sb.delete(i, sb.length());
            }
        } else if (i2 != 3) {
            throw new TSPException("unknown time-stamp resolution: " + this.resolution);
        }
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() - 1 == iIndexOf) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("Z");
        return new ASN1GeneralizedTime(sb.toString());
    }

    public void addAttributeCertificates(InterfaceC6249Store interfaceC6249Store) {
        this.attrCerts.addAll(interfaceC6249Store.getMatches(null));
    }

    /* renamed from: addCRLs */
    public void m18208addCRLs(InterfaceC6249Store interfaceC6249Store) {
        this.f24164crls.addAll(interfaceC6249Store.getMatches(null));
    }

    public void addCertificates(InterfaceC6249Store interfaceC6249Store) {
        this.f24163certs.addAll(interfaceC6249Store.getMatches(null));
    }

    public void addOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC6249Store interfaceC6249Store) {
        this.otherRevoc.put(aSN1ObjectIdentifier, interfaceC6249Store.getMatches(null));
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date) {
        return generate(timeStampRequest, bigInteger, date, null);
    }

    public void setAccuracyMicros(int i) {
        this.accuracyMicros = i;
    }

    public void setAccuracyMillis(int i) {
        this.accuracyMillis = i;
    }

    public void setAccuracySeconds(int i) {
        this.accuracySeconds = i;
    }

    public void setLocale(Locale locale) {
        this.f24165locale = locale;
    }

    public void setOrdering(boolean z) {
        this.ordering = z;
    }

    public void setResolution(int i) {
        this.resolution = i;
    }

    /* renamed from: setTSA */
    public void m18209setTSA(GeneralName generalName) {
        this.f24166tsa = generalName;
    }

    public TimeStampTokenGenerator(final SignerInfoGenerator signerInfoGenerator, DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) throws TSPException, IOException {
        this.resolution = 0;
        this.f24165locale = null;
        this.accuracySeconds = -1;
        this.accuracyMillis = -1;
        this.accuracyMicros = -1;
        this.ordering = false;
        this.f24166tsa = null;
        this.f24163certs = new ArrayList();
        this.f24164crls = new ArrayList();
        this.attrCerts = new ArrayList();
        this.otherRevoc = new HashMap();
        this.signerInfoGen = signerInfoGenerator;
        this.tsaPolicyOID = aSN1ObjectIdentifier;
        if (!signerInfoGenerator.hasAssociatedCertificate()) {
            throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
        }
        X509CertificateHolder associatedCertificate = signerInfoGenerator.getAssociatedCertificate();
        C6230TSPUtil.validateCertificate(associatedCertificate);
        ASN1ObjectIdentifier algorithm = digestCalculator.getAlgorithmIdentifier().getAlgorithm();
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(associatedCertificate.getEncoded());
            outputStream.close();
            DEROctetString dEROctetString = new DEROctetString(digestCalculator.getDigest());
            IssuerSerial issuerSerial = z ? new IssuerSerial(new GeneralNames(new GeneralName(associatedCertificate.getIssuer())), associatedCertificate.toASN1Structure().getSerialNumber()) : null;
            if (OIWObjectIdentifiers.f18459idSHA1.m14446equals((ASN1Primitive) algorithm)) {
                final ESSCertID eSSCertID = new ESSCertID(dEROctetString, issuerSerial);
                this.signerInfoGen = new SignerInfoGenerator(signerInfoGenerator, new CMSAttributeTableGenerator(this) { // from class: org.bouncycastle.tsp.TimeStampTokenGenerator.1

                    /* renamed from: this$0 */
                    final /* synthetic */ TimeStampTokenGenerator f24167this$0;

                    {
                        this.f24167this$0 = this;
                    }

                    @Override // org.bouncycastle.p191cms.CMSAttributeTableGenerator
                    public AttributeTable getAttributes(Map map) {
                        AttributeTable attributes = signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map);
                        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_aa_signingCertificate;
                        return attributes.m14530get(aSN1ObjectIdentifier2) == null ? attributes.m14529add(aSN1ObjectIdentifier2, new SigningCertificate(eSSCertID)) : attributes;
                    }
                }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
            } else {
                final ESSCertIDv2 eSSCertIDv2 = new ESSCertIDv2(new AlgorithmIdentifier(algorithm), dEROctetString, issuerSerial);
                this.signerInfoGen = new SignerInfoGenerator(signerInfoGenerator, new CMSAttributeTableGenerator(this) { // from class: org.bouncycastle.tsp.TimeStampTokenGenerator.2

                    /* renamed from: this$0 */
                    final /* synthetic */ TimeStampTokenGenerator f24168this$0;

                    {
                        this.f24168this$0 = this;
                    }

                    @Override // org.bouncycastle.p191cms.CMSAttributeTableGenerator
                    public AttributeTable getAttributes(Map map) {
                        AttributeTable attributes = signerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(map);
                        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_aa_signingCertificateV2;
                        return attributes.m14530get(aSN1ObjectIdentifier2) == null ? attributes.m14529add(aSN1ObjectIdentifier2, new SigningCertificateV2(eSSCertIDv2)) : attributes;
                    }
                }, signerInfoGenerator.getUnsignedAttributeTableGenerator());
            }
        } catch (IOException e) {
            throw new TSPException("Exception processing certificate.", e);
        }
    }

    public TimeStampToken generate(TimeStampRequest timeStampRequest, BigInteger bigInteger, Date date, Extensions extensions) throws TSPException {
        Accuracy accuracy;
        Extensions extensionsGenerate;
        TimeStampReq aSN1Structure = timeStampRequest.toASN1Structure();
        MessageImprint messageImprint = aSN1Structure.getMessageImprint();
        int i = this.accuracySeconds;
        if (i > 0 || this.accuracyMillis > 0 || this.accuracyMicros > 0) {
            ASN1Integer aSN1IntegerM14429valueOf = i > 0 ? ASN1Integer.m14429valueOf(i) : null;
            int i2 = this.accuracyMillis;
            ASN1Integer aSN1IntegerM14429valueOf2 = i2 > 0 ? ASN1Integer.m14429valueOf(i2) : null;
            int i3 = this.accuracyMicros;
            accuracy = new Accuracy(aSN1IntegerM14429valueOf, aSN1IntegerM14429valueOf2, i3 > 0 ? ASN1Integer.m14429valueOf(i3) : null);
        } else {
            accuracy = null;
        }
        boolean z = this.ordering;
        ASN1Boolean aSN1Boolean = z ? ASN1Boolean.getInstance(z) : null;
        ASN1Integer nonce = aSN1Structure.getNonce();
        ASN1ObjectIdentifier reqPolicy = aSN1Structure.getReqPolicy();
        if (reqPolicy == null) {
            reqPolicy = this.tsaPolicyOID;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = reqPolicy;
        Extensions extensions2 = timeStampRequest.getExtensions();
        if (extensions != null) {
            ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
            if (extensions2 != null) {
                Enumeration enumerationM14687oids = extensions2.m14687oids();
                while (enumerationM14687oids.hasMoreElements()) {
                    extensionsGenerator.addExtension(extensions2.getExtension(ASN1ObjectIdentifier.getInstance(enumerationM14687oids.nextElement())));
                }
            }
            Enumeration enumerationM14687oids2 = extensions.m14687oids();
            while (enumerationM14687oids2.hasMoreElements()) {
                extensionsGenerator.addExtension(extensions.getExtension(ASN1ObjectIdentifier.getInstance(enumerationM14687oids2.nextElement())));
            }
            extensionsGenerate = extensionsGenerator.generate();
        } else {
            extensionsGenerate = extensions2;
        }
        C5186TSTInfo c5186TSTInfo = new C5186TSTInfo(aSN1ObjectIdentifier, messageImprint, new ASN1Integer(bigInteger), this.resolution == 0 ? this.f24165locale == null ? new ASN1GeneralizedTime(date) : new ASN1GeneralizedTime(date, this.f24165locale) : createGeneralizedTime(date), accuracy, aSN1Boolean, nonce, this.f24166tsa, extensionsGenerate);
        try {
            CMSSignedDataGenerator cMSSignedDataGenerator = new CMSSignedDataGenerator();
            if (timeStampRequest.getCertReq()) {
                cMSSignedDataGenerator.addCertificates(new CollectionStore(this.f24163certs));
                cMSSignedDataGenerator.addAttributeCertificates(new CollectionStore(this.attrCerts));
            }
            cMSSignedDataGenerator.m14875addCRLs(new CollectionStore(this.f24164crls));
            if (!this.otherRevoc.isEmpty()) {
                for (ASN1ObjectIdentifier aSN1ObjectIdentifier2 : this.otherRevoc.keySet()) {
                    cMSSignedDataGenerator.addOtherRevocationInfo(aSN1ObjectIdentifier2, new CollectionStore((Collection) this.otherRevoc.get(aSN1ObjectIdentifier2)));
                }
            }
            cMSSignedDataGenerator.addSignerInfoGenerator(this.signerInfoGen);
            return new TimeStampToken(cMSSignedDataGenerator.generate(new CMSProcessableByteArray(PKCSObjectIdentifiers.id_ct_TSTInfo, c5186TSTInfo.getEncoded(ASN1Encoding.f17902DER)), true));
        } catch (IOException e) {
            throw new TSPException("Exception encoding info", e);
        } catch (CMSException e2) {
            throw new TSPException("Error generating time-stamp token", e2);
        }
    }
}
