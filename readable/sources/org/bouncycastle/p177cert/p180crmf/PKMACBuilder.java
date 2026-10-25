package org.bouncycastle.p177cert.p180crmf;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.PBEMacCalculatorProvider;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p138cmp.CMPObjectIdentifiers;
import org.bouncycastle.p133asn1.p138cmp.PBMParameter;
import org.bouncycastle.p133asn1.p150iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class PKMACBuilder implements PBEMacCalculatorProvider {
    private PKMACValuesCalculator calculator;
    private int iterationCount;

    /* renamed from: mac */
    private AlgorithmIdentifier f18833mac;
    private int maxIterations;

    /* renamed from: owf */
    private AlgorithmIdentifier f18834owf;
    private PBMParameter parameters;

    /* renamed from: random */
    private SecureRandom f18835random;
    private int saltLength;

    private PKMACBuilder(AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2, PKMACValuesCalculator pKMACValuesCalculator) {
        this.saltLength = 20;
        this.f18834owf = algorithmIdentifier;
        this.iterationCount = i;
        this.f18833mac = algorithmIdentifier2;
        this.calculator = pKMACValuesCalculator;
    }

    private void checkIterationCountCeiling(int i) {
        int i2 = this.maxIterations;
        if (i2 <= 0 || i <= i2) {
            return;
        }
        throw new IllegalArgumentException("iteration count exceeds limit (" + i + " > " + this.maxIterations + ")");
    }

    private MacCalculator genCalculator(final PBMParameter pBMParameter, char[] cArr) {
        byte[] uTF8ByteArray = C6250Strings.toUTF8ByteArray(cArr);
        byte[] octets = pBMParameter.m14516getSalt().getOctets();
        final byte[] bArrCalculateDigest = new byte[uTF8ByteArray.length + octets.length];
        System.arraycopy(uTF8ByteArray, 0, bArrCalculateDigest, 0, uTF8ByteArray.length);
        System.arraycopy(octets, 0, bArrCalculateDigest, uTF8ByteArray.length, octets.length);
        this.calculator.mo14792setup(pBMParameter.m14515getOwf(), pBMParameter.m14514getMac());
        int iIntValueExact = pBMParameter.getIterationCount().intValueExact();
        do {
            bArrCalculateDigest = this.calculator.calculateDigest(bArrCalculateDigest);
            iIntValueExact--;
        } while (iIntValueExact > 0);
        return new MacCalculator(this) { // from class: org.bouncycastle.cert.crmf.PKMACBuilder.1

            /* renamed from: bOut */
            ByteArrayOutputStream f18836bOut = new ByteArrayOutputStream();

            /* renamed from: this$0 */
            final /* synthetic */ PKMACBuilder f18837this$0;

            {
                this.f18837this$0 = this;
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, pBMParameter);
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getKey */
            public GenericKey mo14789getKey() {
                return new GenericKey(getAlgorithmIdentifier(), bArrCalculateDigest);
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getMac */
            public byte[] mo14790getMac() {
                try {
                    return this.f18837this$0.calculator.calculateMac(bArrCalculateDigest, this.f18836bOut.toByteArray());
                } catch (CRMFException e) {
                    throw new RuntimeOperatorException("exception calculating mac: " + e.getMessage(), e);
                }
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public OutputStream getOutputStream() {
                return this.f18836bOut;
            }
        };
    }

    private PBMParameter genParameters() {
        byte[] bArr = new byte[this.saltLength];
        if (this.f18835random == null) {
            this.f18835random = new SecureRandom();
        }
        this.f18835random.nextBytes(bArr);
        return new PBMParameter(bArr, this.f18834owf, this.iterationCount, this.f18833mac);
    }

    /* renamed from: build */
    public MacCalculator m14787build(char[] cArr) {
        PBMParameter pBMParameterGenParameters = this.parameters;
        if (pBMParameterGenParameters == null) {
            pBMParameterGenParameters = genParameters();
        }
        return genCalculator(pBMParameterGenParameters, cArr);
    }

    @Override // org.bouncycastle.operator.PBEMacCalculatorProvider
    /* renamed from: get */
    public MacCalculator mo14788get(AlgorithmIdentifier algorithmIdentifier, char[] cArr) throws OperatorCreationException {
        if (!CMPObjectIdentifiers.passwordBasedMac.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
            throw new OperatorCreationException("protection algorithm not mac based");
        }
        setParameters(PBMParameter.getInstance(algorithmIdentifier.getParameters()));
        try {
            return m14787build(cArr);
        } catch (CRMFException e) {
            throw new OperatorCreationException(e.getMessage(), e.getCause());
        }
    }

    public PKMACBuilder setIterationCount(int i) {
        if (i < 100) {
            throw new IllegalArgumentException("iteration count must be at least 100");
        }
        checkIterationCountCeiling(i);
        this.iterationCount = i;
        return this;
    }

    public PKMACBuilder setParameters(PBMParameter pBMParameter) {
        checkIterationCountCeiling(pBMParameter.getIterationCount().intValueExact());
        this.parameters = pBMParameter;
        return this;
    }

    public PKMACBuilder setSaltLength(int i) {
        if (i < 8) {
            throw new IllegalArgumentException("salt length must be at least 8 bytes");
        }
        this.saltLength = i;
        return this;
    }

    public PKMACBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f18835random = secureRandom;
        return this;
    }

    public PKMACBuilder(PKMACValuesCalculator pKMACValuesCalculator) {
        this(new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1), NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, new AlgorithmIdentifier(IANAObjectIdentifiers.hmacSHA1, C5103DERNull.INSTANCE), pKMACValuesCalculator);
    }

    public PKMACBuilder(PKMACValuesCalculator pKMACValuesCalculator, int i) {
        this.saltLength = 20;
        this.maxIterations = i;
        this.calculator = pKMACValuesCalculator;
    }
}
