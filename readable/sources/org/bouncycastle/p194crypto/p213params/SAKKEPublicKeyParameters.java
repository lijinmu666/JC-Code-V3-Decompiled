package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SAKKEPublicKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: P */
    static final AbstractC5820ECPoint f20830P;

    /* renamed from: Px */
    private static final BigInteger f20831Px;

    /* renamed from: Py */
    private static final BigInteger f20832Py;

    /* renamed from: curve */
    private static final AbstractC5817ECCurve.Fp f20833curve;

    /* renamed from: g */
    private static final BigInteger f20834g;

    /* renamed from: n */
    private static final int f20835n = 128;

    /* renamed from: p */
    static final BigInteger f20836p;

    /* renamed from: q */
    static final BigInteger f20837q;

    /* renamed from: Z */
    private final AbstractC5820ECPoint f20838Z;

    /* renamed from: digest */
    private final InterfaceC5277Digest f20839digest;
    private final BigInteger identifier;

    static {
        BigInteger bigInteger = new BigInteger("997ABB1F0A563FDA65C61198DAD0657A416C0CE19CB48261BE9AE358B3E01A2EF40AAB27E2FC0F1B228730D531A59CB0E791B39FF7C88A19356D27F4A666A6D0E26C6487326B4CD4512AC5CD65681CE1B6AFF4A831852A82A7CF3C521C3C09AA9F94D6AF56971F1FFCE3E82389857DB080C5DF10AC7ACE87666D807AFEA85FEB", 16);
        f20836p = bigInteger;
        BigInteger bigInteger2 = new BigInteger("265EAEC7C2958FF69971846636B4195E905B0338672D20986FA6B8D62CF8068BBD02AAC9F8BF03C6C8A1CC354C69672C39E46CE7FDF222864D5B49FD2999A9B4389B1921CC9AD335144AB173595A07386DABFD2A0C614AA0A9F3CF14870F026AA7E535ABD5A5C7C7FF38FA08E2615F6C203177C42B1EB3A1D99B601EBFAA17FB", 16);
        f20837q = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("53FC09EE332C29AD0A7990053ED9B52A2B1A2FD60AEC69C698B2F204B6FF7CBFB5EDB6C0F6CE2308AB10DB9030B09E1043D5F22CDB9DFA55718BD9E7406CE8909760AF765DD5BCCB337C86548B72F2E1A702C3397A60DE74A7C1514DBA66910DD5CFB4CC80728D87EE9163A5B63F73EC80EC46C4967E0979880DC8ABEAE63895", 16);
        f20831Px = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("0A8249063F6009F1F9F1F0533634A135D3E82016029906963D778D821E141178F5EA69F4654EC2B9E7F7F5E5F0DE55F66B598CCF9A140B2E416CFF0CA9E032B970DAE117AD547C6CCAD696B5B7652FE0AC6F1E80164AA989492D979FC5A4D5F213515AD7E9CB99A980BDAD5AD5BB4636ADB9B5706A67DCDE75573FD71BEF16D7", 16);
        f20832Py = bigInteger4;
        f20834g = new BigInteger(1, C6255Hex.m18338decode("66FC2A43 2B6EA392 148F1586 7D623068\n               C6A87BD1 FB94C41E 27FABE65 8E015A87\n               371E9474 4C96FEDA 449AE956 3F8BC446\n               CBFDA85D 5D00EF57 7072DA8F 541721BE\n               EE0FAED1 828EAB90 B99DFB01 38C78433\n               55DF0460 B4A9FD74 B4F1A32B CAFA1FFA\n               D682C033 A7942BCC E3720F20 B9B7B040\n               3C8CAE87 B7A0042A CDE0FAB3 6461EA46"));
        AbstractC5817ECCurve.Fp fp = new AbstractC5817ECCurve.Fp(bigInteger, bigInteger.subtract(BigInteger.valueOf(3L)), BigInteger.ZERO, bigInteger2, BigInteger.valueOf(4L));
        f20833curve = fp;
        f20830P = configureBasepoint(fp, bigInteger3, bigInteger4);
    }

    public SAKKEPublicKeyParameters(BigInteger bigInteger, AbstractC5820ECPoint abstractC5820ECPoint) {
        super(false);
        this.f20839digest = new SHA256Digest();
        this.identifier = bigInteger;
        this.f20838Z = abstractC5820ECPoint;
    }

    private static AbstractC5820ECPoint configureBasepoint(AbstractC5817ECCurve abstractC5817ECCurve, BigInteger bigInteger, BigInteger bigInteger2) {
        AbstractC5820ECPoint abstractC5820ECPointCreatePoint = abstractC5817ECCurve.createPoint(bigInteger, bigInteger2);
        WNafUtil.configureBasepoint(abstractC5820ECPointCreatePoint);
        return abstractC5820ECPointCreatePoint;
    }

    public AbstractC5817ECCurve getCurve() {
        return f20833curve;
    }

    public InterfaceC5277Digest getDigest() {
        return this.f20839digest;
    }

    /* renamed from: getG */
    public BigInteger m15811getG() {
        return f20834g;
    }

    public BigInteger getIdentifier() {
        return this.identifier;
    }

    /* renamed from: getN */
    public int m15812getN() {
        return 128;
    }

    public AbstractC5820ECPoint getPoint() {
        return f20830P;
    }

    public BigInteger getPrime() {
        return f20836p;
    }

    /* renamed from: getQ */
    public BigInteger m15813getQ() {
        return f20837q;
    }

    /* renamed from: getZ */
    public AbstractC5820ECPoint m15814getZ() {
        return this.f20838Z;
    }
}
