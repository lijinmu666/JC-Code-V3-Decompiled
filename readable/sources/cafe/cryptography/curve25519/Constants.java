package cafe.cryptography.curve25519;

import cafe.cryptography.curve25519.AffineNielsPoint;

/* loaded from: classes.dex */
public final class Constants {
    static final AffineNielsPoint.NafLookupTable AFFINE_ODD_MULTIPLES_OF_BASEPOINT;
    static final C0186Scalar BASEPOINT_ORDER;
    static final FieldElement D_MINUS_ONE_SQ;
    public static final EdwardsPoint ED25519_BASEPOINT;
    public static final EdwardsBasepointTable ED25519_BASEPOINT_TABLE;
    static final FieldElement EDWARDS_2D;
    static final FieldElement EDWARDS_D;
    static final FieldElement INVSQRT_A_MINUS_D;

    /* renamed from: L */
    static final UnpackedScalar f1966L;

    /* renamed from: LFACTOR */
    static final int f1967LFACTOR = 307527195;
    static final FieldElement NEG_EDWARDS_D;
    static final FieldElement ONE_MINUS_D_SQ;

    /* renamed from: R */
    static final UnpackedScalar f1968R;
    public static final RistrettoElement RISTRETTO_GENERATOR;
    public static final RistrettoGeneratorTable RISTRETTO_GENERATOR_TABLE;

    /* renamed from: RR */
    static final UnpackedScalar f1969RR;
    static final FieldElement SQRT_AD_MINUS_ONE;

    /* renamed from: SQRT_M1 */
    static final FieldElement f1970SQRT_M1;

    static {
        C0186Scalar c0186Scalar = new C0186Scalar(new byte[]{-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16});
        BASEPOINT_ORDER = c0186Scalar;
        f1966L = UnpackedScalar.fromByteArray(c0186Scalar.toByteArray());
        f1968R = new UnpackedScalar(new int[]{290322925, 442594051, 259787148, 377041255, 536700270, 536870911, 536870911, 536870911, 1048575});
        f1969RR = new UnpackedScalar(new int[]{190815506, 504634135, 361594685, 339687255, 426956673, 70249340, 485410621, 504909086, 328813});
        FieldElement fieldElement = new FieldElement(new int[]{-10913610, 13857413, -15372611, 6949391, 114729, -8787816, -6275908, -3247719, -18696448, -12055116});
        EDWARDS_D = fieldElement;
        NEG_EDWARDS_D = fieldElement.m2119negate();
        EDWARDS_2D = new FieldElement(new int[]{-21827239, -5839606, -30745221, 13898782, 229458, 15978800, -12551817, -6495438, 29715968, 9444199});
        FieldElement fieldElement2 = FieldElement.f1976ONE;
        ONE_MINUS_D_SQ = fieldElement2.subtract(fieldElement.m2121square());
        D_MINUS_ONE_SQ = fieldElement.subtract(fieldElement2).m2121square();
        SQRT_AD_MINUS_ONE = new FieldElement(new int[]{24849947, -153582, -23613485, 6347715, -21072328, -667138, -25271143, -15367704, -870347, 14525639});
        INVSQRT_A_MINUS_D = new FieldElement(new int[]{6111485, 4156064, -27798727, 12243468, -25904040, 120897, 20826367, -7060776, 6093568, -1986012});
        f1970SQRT_M1 = new FieldElement(new int[]{-32595792, -7943725, 9377950, 3500415, 12389472, -272473, -25146209, -2005654, 326686, 11406482});
        EdwardsPoint edwardsPoint = new EdwardsPoint(new FieldElement(new int[]{-14297830, -7645148, 16144683, -16471763, 27570974, -2696100, -26142465, 8378389, 20764389, 8758491}), new FieldElement(new int[]{-26843541, -6710886, 13421773, -13421773, 26843546, 6710886, -13421773, 13421773, -26843546, -6710886}), new FieldElement(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new FieldElement(new int[]{28827062, -6116119, -27349572, 244363, 8635006, 11264893, 19351346, 13413597, 16611511, -6414980}));
        ED25519_BASEPOINT = edwardsPoint;
        ED25519_BASEPOINT_TABLE = new EdwardsBasepointTable(edwardsPoint);
        AFFINE_ODD_MULTIPLES_OF_BASEPOINT = AffineNielsPoint.buildNafLookupTable(edwardsPoint);
        RistrettoElement ristrettoElement = new RistrettoElement(edwardsPoint);
        RISTRETTO_GENERATOR = ristrettoElement;
        RISTRETTO_GENERATOR_TABLE = new RistrettoGeneratorTable(ristrettoElement);
    }
}
