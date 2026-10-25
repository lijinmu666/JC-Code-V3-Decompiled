package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
class MapGroup2 {

    /* renamed from: f11 */
    public final byte[][][][] f23535f11;

    /* renamed from: f12 */
    public final byte[][][][] f23536f12;

    /* renamed from: f21 */
    public final byte[][][][] f23537f21;

    public MapGroup2(SnovaParameters snovaParameters) {
        int iM17866getM = snovaParameters.m17866getM();
        int iM17870getV = snovaParameters.m17870getV();
        int iM17869getO = snovaParameters.m17869getO();
        int iM17865getLsq = snovaParameters.m17865getLsq();
        Class cls = Byte.TYPE;
        this.f23535f11 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17870getV, iM17870getV, iM17865getLsq);
        this.f23536f12 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17870getV, iM17869getO, iM17865getLsq);
        this.f23537f21 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17869getO, iM17870getV, iM17865getLsq);
    }
}
