package com.flyfishxu.p028kadb.p036stream;

import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.C1159SetsKt;

@Metadata(m4987d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m4988d2 = {"ID_LSTAT_V1", BuildConfig.f24315FLAVOR, "ID_STAT_V2", "ID_LSTAT_V2", "ID_LIST_V1", "ID_LIST_V2", "ID_DENT_V1", "ID_DENT_V2", "ID_SEND_V1", "ID_SEND_V2", "ID_RECV_V1", "ID_RECV_V2", "ID_DATA", "ID_DONE", "ID_OKAY", "ID_FAIL", "ID_QUIT", "FEATURE_STAT_V2", "FEATURE_LS_V2", "FEATURE_SENDRECV_V2", "SYNC_PATH_MAX", BuildConfig.f24315FLAVOR, "NAME_MAX", "LIST_V1_DONE_TAIL_BYTES", BuildConfig.f24315FLAVOR, "LIST_V2_DONE_TAIL_BYTES", "SYNC_DATA_MAX", "SYNC_IDS", BuildConfig.f24315FLAVOR, "getSYNC_IDS", "()Ljava/util/Set;", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbSyncStreamKt {
    private static final String FEATURE_LS_V2 = "ls_v2";
    private static final String FEATURE_SENDRECV_V2 = "sendrecv_v2";
    private static final String FEATURE_STAT_V2 = "stat_v2";
    private static final long LIST_V1_DONE_TAIL_BYTES = 16;
    private static final long LIST_V2_DONE_TAIL_BYTES = 72;
    private static final int NAME_MAX = 255;
    private static final int SYNC_DATA_MAX = 65536;
    private static final int SYNC_PATH_MAX = 1024;
    private static final String ID_LSTAT_V1 = "STAT";
    private static final String ID_STAT_V2 = "STA2";
    private static final String ID_LSTAT_V2 = "LST2";
    private static final String ID_LIST_V1 = "LIST";
    private static final String ID_LIST_V2 = "LIS2";
    private static final String ID_DENT_V1 = "DENT";
    private static final String ID_DENT_V2 = "DNT2";
    private static final String ID_SEND_V1 = "SEND";
    private static final String ID_SEND_V2 = "SND2";
    private static final String ID_RECV_V1 = "RECV";
    private static final String ID_RECV_V2 = "RCV2";

    /* renamed from: ID_DATA */
    private static final String f2150ID_DATA = "DATA";

    /* renamed from: ID_DONE */
    private static final String f2151ID_DONE = "DONE";

    /* renamed from: ID_OKAY */
    private static final String f2153ID_OKAY = "OKAY";

    /* renamed from: ID_FAIL */
    private static final String f2152ID_FAIL = "FAIL";

    /* renamed from: ID_QUIT */
    private static final String f2154ID_QUIT = "QUIT";
    private static final Set<String> SYNC_IDS = C1159SetsKt.m5995setOf((Object[]) new String[]{ID_LSTAT_V1, ID_STAT_V2, ID_LSTAT_V2, ID_LIST_V1, ID_LIST_V2, ID_DENT_V1, ID_DENT_V2, ID_SEND_V1, ID_SEND_V2, ID_RECV_V1, ID_RECV_V2, f2150ID_DATA, f2151ID_DONE, f2153ID_OKAY, f2152ID_FAIL, f2154ID_QUIT});

    public static final Set<String> getSYNC_IDS() {
        return SYNC_IDS;
    }
}
