package com.flyfishxu.p028kadb;

import com.flyfishxu.p028kadb.C0187Kadb;
import com.flyfishxu.p028kadb.forwarding.TcpForwarder;
import com.flyfishxu.p028kadb.p029cert.CertUtils;
import com.flyfishxu.p028kadb.p029cert.HostKeySet;
import com.flyfishxu.p028kadb.p029cert.platform.DefaultDeviceName_androidKt;
import com.flyfishxu.p028kadb.p030core.AdbConnection;
import com.flyfishxu.p028kadb.p035shell.AdbPtyShellSession;
import com.flyfishxu.p028kadb.p035shell.AdbShellResponse;
import com.flyfishxu.p028kadb.p035shell.AdbShellStream;
import com.flyfishxu.p028kadb.p036stream.AdbStream;
import com.flyfishxu.p028kadb.p036stream.AdbSyncStream;
import com.flyfishxu.p028kadb.transport.TransportChannel;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.TuplesKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p103jdk7.AutoCloseableKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.SpreadBuilder;
import p094kotlin.p117text.C1312Regex;
import p094kotlin.p117text.Charsets;
import p094kotlin.p117text.MatchResult;
import p094kotlin.p117text.StringsKt;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.Dispatchers;
import p132okio.C5053Okio;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 t2\u00060\u0001j\u0002`\u0002:\u0002stB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB1\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004J*\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020(J&\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u0016\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u0016\u0010+\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010/\u001a\u000200J'\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020$2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u00104J/\u00101\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u00105\u001a\u00020(2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u00106J)\u00107\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00042\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u00108J)\u00109\u001a\u00020\"2\u0006\u00102\u001a\u00020$2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u00104J-\u0010:\u001a\u00020\"2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020$0<2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u0004J\u001f\u0010@\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010AJ\u001f\u0010B\u001a\u00020\u00152\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010AJ\u0006\u0010C\u001a\u00020\u0004J\u0006\u0010D\u001a\u00020\u0004J\b\u0010E\u001a\u00020\"H\u0016J\u0006\u0010F\u001a\u00020\"J\b\u0010\u000e\u001a\u00020\u0010H\u0002J\u0014\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J&\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0013H\u0002J\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0002J\b\u0010Q\u001a\u00020RH\u0002J&\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020(2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040<2\u0006\u0010V\u001a\u00020RH\u0002J \u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010V\u001a\u00020RH\u0002J)\u0010Z\u001a\u00020\u00152\u0006\u0010V\u001a\u00020R2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u0010[J \u0010\\\u001a\u00020\u00042\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0006H\u0002J\u0010\u0010^\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0004H\u0002J\"\u0010_\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00042\u0006\u0010V\u001a\u00020RH\u0002J#\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040<2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000403H\u0002¢\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020\u00042\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040<H\u0002J\u0016\u0010d\u001a\u00020\u00042\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040<H\u0002J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0004H\u0002J\u0010\u0010h\u001a\u00020\"2\u0006\u0010i\u001a\u00020\u0004H\u0002J\u0010\u0010j\u001a\u00020\"2\u0006\u0010k\u001a\u00020\u0004H\u0002J0\u0010l\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010o\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010p\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u0006J\u0010\u0010r\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, m4988d2 = {"Lcom/flyfishxu/kadb/Kadb;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "host", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "connectTimeout", "socketTimeout", "<init>", "(Ljava/lang/String;III)V", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "(Ljava/lang/String;IIILcom/flyfishxu/kadb/KadbOptions;)V", "connection", "Lkotlin/Pair;", "Lcom/flyfishxu/kadb/core/AdbConnection;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "connectionCheck", BuildConfig.f24315FLAVOR, "open", "Lcom/flyfishxu/kadb/stream/AdbStream;", "destination", "supportsFeature", "feature", C0187Kadb.SHELL_SERVICE_BASE, "Lcom/flyfishxu/kadb/shell/AdbShellResponse;", "command", "openShell", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "openPtyShellSession", "Lcom/flyfishxu/kadb/shell/AdbPtyShellSession;", "term", "push", BuildConfig.f24315FLAVOR, "src", "Ljava/io/File;", "remotePath", "mode", "lastModifiedMs", BuildConfig.f24315FLAVOR, "source", "Lokio/Source;", "pull", "dst", "sink", "Lokio/Sink;", "openSync", "Lcom/flyfishxu/kadb/stream/AdbSyncStream;", "install", "file", BuildConfig.f24315FLAVOR, "(Ljava/io/File;[Ljava/lang/String;)V", "size", "(Lokio/Source;J[Ljava/lang/String;)V", "pmInstallRemote", "(Ljava/lang/String;[Ljava/lang/String;)V", "pmInstall", "installMultiple", "apks", BuildConfig.f24315FLAVOR, "(Ljava/util/List;[Ljava/lang/String;)V", "uninstall", "packageName", "execCmd", "([Ljava/lang/String;)Lcom/flyfishxu/kadb/stream/AdbStream;", "abbExec", "root", "unroot", "close", "resetConnection", "newConnection", "openStream", "retryOnStaleTransport", "discardConnection", "failedConnection", "isRecoverableTransportOpenFailure", "error", BuildConfig.f24315FLAVOR, "extractSessionId", "response", "installSessionMode", "Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;", "createInstallSession", "totalLength", "installOptions", "sessionMode", "streamInstallWrite", "apk", "sessionId", "openInstallCommand", "(Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;[Ljava/lang/String;)Lcom/flyfishxu/kadb/stream/AdbStream;", "pushAndWrite", "index", "cleanupRemoteTempFile", "finalizeSession", "nonBlankOptions", "([Ljava/lang/String;)Ljava/util/List;", "buildShellCommand", "parts", "buildExecCmdService", "buildDeleteDeviceFileCommand", "escapeArg", "arg", "enforceLegacyShellServiceLength", "service", "requireShellV2", "apiName", "buildShellService", "useShellProtocol", "typeArg", "tcpForward", "hostPort", "targetPort", "restartAdb", "InstallSessionMode", "Companion", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nKadb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kadb.kt\ncom/flyfishxu/kadb/Kadb\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,532:1\n1#2:533\n1#2:538\n1759#3:534\n1770#3:535\n2077#3,2:536\n2079#3:539\n1771#3:540\n1960#3,3:541\n777#3:549\n873#3,2:550\n777#3:552\n873#3,2:553\n37#4,2:544\n3938#5:546\n4474#5,2:547\n*S KotlinDebug\n*F\n+ 1 Kadb.kt\ncom/flyfishxu/kadb/Kadb\n*L\n168#1:538\n168#1:534\n168#1:535\n168#1:536,2\n168#1:539\n168#1:540\n265#1:541,3\n389#1:549\n389#1:550,2\n394#1:552\n394#1:553,2\n295#1:544,2\n386#1:546\n386#1:547,2\n*E\n"})
/* renamed from: com.flyfishxu.kadb.Kadb */
/* loaded from: classes.dex */
public final class C0187Kadb implements AutoCloseable {
    private static final String DEFAULT_TERM_TYPE = "xterm-256color";
    private static final String SHELL_ARG_TERM_PREFIX = "TERM=";
    private static final String SHELL_ARG_V2 = "v2";
    private static final String SHELL_SERVICE_BASE = "shell";
    private static final String SHELL_TYPE_PTY = "pty";
    private static final String SHELL_TYPE_RAW = "raw";
    private static final String SHELL_V2_FEATURE = "shell_v2";
    private final int connectTimeout;
    private C1122Pair<AdbConnection, ? extends TransportChannel> connection;
    private final String host;
    private KadbOptions options;
    private final int port;
    private final int socketTimeout;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> OPEN_TRANSPORT_FAILURE_MARKERS = CollectionsKt.m5806listOf((Object[]) new String[]{"broken pipe", "connection reset", "connection aborted", "socket closed", "stream closed", "transport closed", "closed", "eof", "disconnected", "connection closed"});

    @Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0015J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, m4988d2 = {"Lcom/flyfishxu/kadb/Kadb$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "OPEN_TRANSPORT_FAILURE_MARKERS", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "SHELL_V2_FEATURE", "SHELL_SERVICE_BASE", "SHELL_ARG_V2", "SHELL_ARG_TERM_PREFIX", "SHELL_TYPE_RAW", "SHELL_TYPE_PTY", "DEFAULT_TERM_TYPE", "pair", BuildConfig.f24315FLAVOR, "host", "port", BuildConfig.f24315FLAVOR, "pairingCode", "name", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lcom/flyfishxu/kadb/Kadb;", "connectTimeout", "socketTimeout", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "tryConnection", "tcpForward", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "targetPort", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nKadb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kadb.kt\ncom/flyfishxu/kadb/Kadb$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,532:1\n1#2:533\n*E\n"})
    /* renamed from: com.flyfishxu.kadb.Kadb$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ C0187Kadb create$default(Companion companion, String str, int i, int i2, int i3, KadbOptions kadbOptions, int i4, Object obj) {
            int i5 = (i4 & 4) != 0 ? 0 : i2;
            int i6 = (i4 & 8) != 0 ? 0 : i3;
            if ((i4 & 16) != 0) {
                kadbOptions = new KadbOptions(null, 1, null);
            }
            return companion.m2164create(str, i, i5, i6, kadbOptions);
        }

        public static /* synthetic */ Object pair$default(Companion companion, String str, int i, String str2, String str3, Continuation continuation, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                str3 = DefaultDeviceName_androidKt.defaultDeviceName$default(null, 1, null);
            }
            return companion.m2165pair(str, i, str2, str3, continuation);
        }

        public static /* synthetic */ C0187Kadb tryConnection$default(Companion companion, String str, int i, KadbOptions kadbOptions, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                kadbOptions = new KadbOptions(null, 1, null);
            }
            return companion.tryConnection(str, i, kadbOptions);
        }

        /* renamed from: create */
        public final C0187Kadb m2164create(String host, int port, int connectTimeout, int socketTimeout, KadbOptions options) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(options, "options");
            return new C0187Kadb(host, port, connectTimeout, socketTimeout, options, (DefaultConstructorMarker) null);
        }

        /* renamed from: pair */
        public final Object m2165pair(String str, int i, String str2, String str3, Continuation<? super C1133Unit> continuation) {
            Object objWithContext = BuildersKt.withContext(Dispatchers.getDefault(), new Kadb$Companion$pair$2(str, i, str2, str3, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : C1133Unit.INSTANCE;
        }

        public final AutoCloseable tcpForward(String host, int port, int targetPort) {
            Intrinsics.checkNotNullParameter(host, "host");
            return new C0187Kadb(host, port, 0, 0, 12, (DefaultConstructorMarker) null).tcpForward(port, targetPort);
        }

        public final C0187Kadb tryConnection(String host, int port, KadbOptions options) {
            Object objM18546constructorimpl;
            C0187Kadb c0187KadbCreate$default;
            Object objM18546constructorimpl2;
            Throwable thM18549exceptionOrNullimpl;
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(options, "options");
            try {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                c0187KadbCreate$default = create$default(this, host, port, 0, 0, options, 12, null);
                try {
                    objM18546constructorimpl2 = C1124Result.m18546constructorimpl(Boolean.valueOf(Intrinsics.areEqual(c0187KadbCreate$default.m2162shell("echo success").getAllOutput(), "success\n")));
                } catch (Throwable th) {
                    C1124Result.Companion companion2 = C1124Result.INSTANCE;
                    objM18546constructorimpl2 = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
                }
                thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl2);
            } catch (Throwable th2) {
                C1124Result.Companion companion3 = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th2));
            }
            if (thM18549exceptionOrNullimpl != null) {
                c0187KadbCreate$default.close();
                throw thM18549exceptionOrNullimpl;
            }
            if (!((Boolean) objM18546constructorimpl2).booleanValue()) {
                c0187KadbCreate$default.close();
                c0187KadbCreate$default = null;
            }
            objM18546constructorimpl = C1124Result.m18546constructorimpl(c0187KadbCreate$default);
            return (C0187Kadb) (C1124Result.m18552isFailureimpl(objM18546constructorimpl) ? null : objM18546constructorimpl);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m4988d2 = {"Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;", BuildConfig.f24315FLAVOR, "usesStreaming", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;IZ)V", "getUsesStreaming", "()Z", "ABB_EXEC", "EXEC_CMD", "PM_SHELL", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.Kadb$InstallSessionMode */
    public static final class InstallSessionMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ InstallSessionMode[] f2012$VALUES;
        public static final InstallSessionMode ABB_EXEC = new InstallSessionMode("ABB_EXEC", 0, true);
        public static final InstallSessionMode EXEC_CMD = new InstallSessionMode("EXEC_CMD", 1, true);
        public static final InstallSessionMode PM_SHELL = new InstallSessionMode("PM_SHELL", 2, false);
        private final boolean usesStreaming;

        /* renamed from: $values */
        private static final /* synthetic */ InstallSessionMode[] m2168$values() {
            return new InstallSessionMode[]{ABB_EXEC, EXEC_CMD, PM_SHELL};
        }

        static {
            InstallSessionMode[] installSessionModeArrM2168$values = m2168$values();
            f2012$VALUES = installSessionModeArrM2168$values;
            $ENTRIES = EnumEntriesKt.enumEntries(installSessionModeArrM2168$values);
        }

        private InstallSessionMode(String str, int i, boolean z) {
            this.usesStreaming = z;
        }

        public static EnumEntries<InstallSessionMode> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static InstallSessionMode m2169valueOf(String str) {
            return (InstallSessionMode) Enum.valueOf(InstallSessionMode.class, str);
        }

        /* renamed from: values */
        public static InstallSessionMode[] m2170values() {
            return (InstallSessionMode[]) f2012$VALUES.clone();
        }

        public final boolean getUsesStreaming() {
            return this.usesStreaming;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.Kadb$WhenMappings */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InstallSessionMode.m2170values().length];
            try {
                iArr[InstallSessionMode.ABB_EXEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InstallSessionMode.EXEC_CMD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InstallSessionMode.PM_SHELL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, m4988d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/flyfishxu/kadb/core/AdbConnection;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.flyfishxu.kadb.Kadb$newConnection$1", m6124f = "Kadb.kt", m6125i = {}, m6126l = {221}, m6127m = "invokeSuspend", m6128n = {}, m6129nl = {228}, m6130s = {}, m6131v = 2)
    /* renamed from: com.flyfishxu.kadb.Kadb$newConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1122Pair<? extends AdbConnection, ? extends TransportChannel>>, Object> {

        /* renamed from: label */
        int f2013label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return C0187Kadb.this.new AnonymousClass1(continuation);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1122Pair<? extends AdbConnection, ? extends TransportChannel>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super C1122Pair<AdbConnection, ? extends TransportChannel>>) continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2013label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AdbConnection.Companion companion = AdbConnection.INSTANCE;
                String str = C0187Kadb.this.host;
                int i2 = C0187Kadb.this.port;
                HostKeySet hostKeySetLoadKeySet = CertUtils.INSTANCE.loadKeySet();
                KadbOptions kadbOptions = C0187Kadb.this.options;
                int i3 = C0187Kadb.this.connectTimeout;
                int i4 = C0187Kadb.this.socketTimeout;
                this.f2013label = 1;
                obj = companion.m2205connect(str, i2, hostKeySetLoadKeySet, kadbOptions, i3, i4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super C1122Pair<AdbConnection, ? extends TransportChannel>> continuation) {
            return ((AnonymousClass1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public /* synthetic */ C0187Kadb(String str, int i, int i2, int i3, KadbOptions kadbOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, kadbOptions);
    }

    private final String buildDeleteDeviceFileCommand(String remotePath) {
        return "rm " + escapeArg(remotePath) + " </dev/null";
    }

    private final String buildExecCmdService(List<String> parts) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : parts) {
            if (!StringsKt.m6766isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, new Function1() { // from class: o.C0
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj2) {
                return C0187Kadb.buildExecCmdService$lambda$1(this.f7545mjFkc, (String) obj2);
            }
        }, 30, null);
        if (strJoinToString$default.length() == 0) {
            return "exec:cmd";
        }
        return "exec:cmd " + strJoinToString$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildExecCmdService$lambda$1(C0187Kadb c0187Kadb, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return c0187Kadb.escapeArg(it);
    }

    private final String buildShellCommand(List<String> parts) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : parts) {
            if (!StringsKt.m6766isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, new Function1() { // from class: o.D0
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj2) {
                return C0187Kadb.buildShellCommand$lambda$1(this.f7777mjFkc, (String) obj2);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildShellCommand$lambda$1(C0187Kadb c0187Kadb, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return c0187Kadb.escapeArg(it);
    }

    private final String buildShellService(String command, boolean useShellProtocol, String term, String typeArg) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (useShellProtocol) {
            arrayList.add(SHELL_ARG_V2);
            if (term != null && !StringsKt.m6766isBlank(term)) {
                arrayList.add(SHELL_ARG_TERM_PREFIX + term);
            }
        }
        if (typeArg != null && !StringsKt.m6766isBlank(typeArg)) {
            arrayList.add(typeArg);
        }
        if (arrayList.isEmpty()) {
            str = SHELL_SERVICE_BASE;
        } else {
            str = "shell," + CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        }
        return str + ":" + command;
    }

    public static /* synthetic */ String buildShellService$default(C0187Kadb c0187Kadb, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return c0187Kadb.buildShellService(str, z, str2, str3);
    }

    private final void cleanupRemoteTempFile(String remotePath) {
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            C1124Result.m18546constructorimpl(m2162shell(buildDeleteDeviceFileCommand(remotePath)));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final AdbConnection connection() {
        C1122Pair<AdbConnection, ? extends TransportChannel> c1122Pair = this.connection;
        if (c1122Pair != null && c1122Pair.getSecond().mo2349isOpen()) {
            return c1122Pair.getFirst();
        }
        C1122Pair<AdbConnection, TransportChannel> c1122PairNewConnection = newConnection();
        this.connection = c1122PairNewConnection;
        return c1122PairNewConnection.getFirst();
    }

    private final String createInstallSession(long totalLength, List<String> installOptions, InstallSessionMode sessionMode) {
        String allOutput;
        int i = WhenMappings.$EnumSwitchMapping$0[sessionMode.ordinal()];
        if (i == 1 || i == 2) {
            SpreadBuilder spreadBuilder = new SpreadBuilder(5);
            spreadBuilder.m6345add("package");
            spreadBuilder.m6345add("install-create");
            spreadBuilder.m6345add("-S");
            spreadBuilder.m6345add(String.valueOf(totalLength));
            spreadBuilder.addSpread(installOptions.toArray(new String[0]));
            AdbStream adbStreamOpenInstallCommand = openInstallCommand(sessionMode, (String[]) spreadBuilder.m6347toArray(new String[spreadBuilder.m6346size()]));
            try {
                String utf8 = adbStreamOpenInstallCommand.getSource().readUtf8();
                AutoCloseableKt.closeFinally(adbStreamOpenInstallCommand, null);
                allOutput = utf8;
            } finally {
            }
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            allOutput = m2162shell(buildShellCommand(CollectionsKt.m5881plus((Collection) CollectionsKt.m5806listOf((Object[]) new String[]{"pm", "install-create", "-S", String.valueOf(totalLength)}), (Iterable) installOptions))).getAllOutput();
        }
        return extractSessionId(allOutput);
    }

    private final void discardConnection(AdbConnection failedConnection) {
        Object objM18546constructorimpl;
        C1122Pair<AdbConnection, ? extends TransportChannel> c1122Pair = this.connection;
        if ((c1122Pair != null ? c1122Pair.getFirst() : null) == failedConnection) {
            resetConnection();
            return;
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            failedConnection.close();
            objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        C1124Result.m18545boximpl(objM18546constructorimpl);
    }

    private final void enforceLegacyShellServiceLength(String service) {
        if (StringsKt.encodeToByteArray(service).length > 4096) {
            throw new IllegalArgumentException("error: shell command too long");
        }
    }

    private final String escapeArg(String arg) {
        return "'" + StringsKt.replace$default(arg, "'", "'\\''", false, 4, (Object) null) + "'";
    }

    private final String extractSessionId(String response) throws IOException {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = C1312Regex.find$default(new C1312Regex("\\[(\\w+)]"), response, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
            throw new IOException("Failed to create session");
        }
        return str;
    }

    private final void finalizeSession(String sessionId, String error, InstallSessionMode sessionMode) throws IOException {
        String allOutput;
        String str = error == null ? "install-commit" : "install-abandon";
        int i = WhenMappings.$EnumSwitchMapping$0[sessionMode.ordinal()];
        if (i == 1 || i == 2) {
            AdbStream adbStreamOpenInstallCommand = openInstallCommand(sessionMode, "package", str, sessionId);
            try {
                String utf8 = adbStreamOpenInstallCommand.getSource().readUtf8();
                AutoCloseableKt.closeFinally(adbStreamOpenInstallCommand, null);
                allOutput = utf8;
            } finally {
            }
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            allOutput = m2162shell(buildShellCommand(CollectionsKt.m5806listOf((Object[]) new String[]{"pm", str, sessionId}))).getAllOutput();
        }
        if (!StringsKt.startsWith$default(allOutput, "Success", false, 2, (Object) null)) {
            throw new IllegalStateException(("Failed to finalize session: " + allOutput).toString());
        }
        if (error == null) {
            return;
        }
        throw new IOException("Install failed: " + error);
    }

    private final InstallSessionMode installSessionMode() {
        return supportsFeature("abb_exec") ? InstallSessionMode.ABB_EXEC : supportsFeature("cmd") ? InstallSessionMode.EXEC_CMD : InstallSessionMode.PM_SHELL;
    }

    private final boolean isRecoverableTransportOpenFailure(Throwable error) {
        if (error instanceof EOFException) {
            return true;
        }
        if ((error instanceof IOException) || (error instanceof IllegalStateException)) {
            String message = error.getMessage();
            if (message == null) {
                message = BuildConfig.f24315FLAVOR;
            }
            String lowerCase = message.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<String> list = OPEN_TRANSPORT_FAILURE_MARKERS;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            Throwable cause = error.getCause();
            if (cause != null && isRecoverableTransportOpenFailure(cause)) {
                return true;
            }
        } else {
            Throwable cause2 = error.getCause();
            if (cause2 != null && isRecoverableTransportOpenFailure(cause2)) {
                return true;
            }
        }
        return false;
    }

    private final C1122Pair<AdbConnection, TransportChannel> newConnection() {
        return (C1122Pair) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass1(null), 1, null);
    }

    private final List<String> nonBlankOptions(String[] options) {
        ArrayList arrayList = new ArrayList();
        for (String str : options) {
            if (!StringsKt.m6766isBlank(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final AdbStream openInstallCommand(InstallSessionMode sessionMode, String... command) {
        int i = WhenMappings.$EnumSwitchMapping$0[sessionMode.ordinal()];
        if (i == 1) {
            return m2152abbExec((String[]) Arrays.copyOf(command, command.length));
        }
        if (i == 2) {
            return m2153execCmd((String[]) Arrays.copyOf(command, command.length));
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("Legacy pm shell path does not open streamed install commands");
    }

    public static /* synthetic */ AdbPtyShellSession openPtyShellSession$default(C0187Kadb c0187Kadb, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BuildConfig.f24315FLAVOR;
        }
        if ((i & 2) != 0) {
            str2 = DEFAULT_TERM_TYPE;
        }
        return c0187Kadb.openPtyShellSession(str, str2);
    }

    public static /* synthetic */ AdbShellStream openShell$default(C0187Kadb c0187Kadb, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BuildConfig.f24315FLAVOR;
        }
        return c0187Kadb.openShell(str);
    }

    private final C1122Pair<AdbConnection, AdbStream> openStream(String destination, boolean retryOnStaleTransport) {
        AdbConnection adbConnectionConnection = connection();
        try {
            return TuplesKt.m5076to(adbConnectionConnection, adbConnectionConnection.m2203open(destination));
        } catch (Throwable th) {
            if (!this.isRecoverableTransportOpenFailure(th)) {
                throw th;
            }
            this.discardConnection(adbConnectionConnection);
            if (retryOnStaleTransport) {
                return this.openStream(destination, false);
            }
            throw th;
        }
    }

    public static /* synthetic */ C1122Pair openStream$default(C0187Kadb c0187Kadb, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return c0187Kadb.openStream(str, z);
    }

    private final void pmInstall(File file, String... options) {
        String str = "/data/local/tmp/" + file.getName();
        try {
            m2159push(file, str, Kadb_androidKt.readMode(this, file), file.lastModified());
            pmInstallRemote(str, (String[]) Arrays.copyOf(options, options.length));
        } finally {
            cleanupRemoteTempFile(str);
        }
    }

    private final void pmInstallRemote(String remotePath, String... options) {
        AdbShellResponse adbShellResponseM2162shell = m2162shell(buildShellCommand(CollectionsKt.m5882plus((Collection<? extends String>) CollectionsKt.m5881plus((Collection) CollectionsKt.m5806listOf((Object[]) new String[]{"pm", "install"}), (Iterable) nonBlankOptions(options)), remotePath)));
        if (StringsKt.startsWith$default(adbShellResponseM2162shell.getAllOutput(), "Success", false, 2, (Object) null)) {
            return;
        }
        throw new IllegalStateException(("Install failed: " + adbShellResponseM2162shell.getAllOutput()).toString());
    }

    public static /* synthetic */ void push$default(C0187Kadb c0187Kadb, File file, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Kadb_androidKt.readMode(c0187Kadb, file);
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = file.lastModified();
        }
        c0187Kadb.m2159push(file, str, i3, j);
    }

    private final String pushAndWrite(File apk, String sessionId, int index) {
        String str = "/data/local/tmp/" + apk.getName();
        try {
            m2159push(apk, str, Kadb_androidKt.readMode(this, apk), apk.lastModified());
            return m2162shell(buildShellCommand(CollectionsKt.m5806listOf((Object[]) new String[]{"pm", "install-write", "-S", String.valueOf(apk.length()), sessionId, String.valueOf(index), str}))).getAllOutput();
        } finally {
            cleanupRemoteTempFile(str);
        }
    }

    private final void requireShellV2(String apiName) {
        if (supportsFeature(SHELL_V2_FEATURE)) {
            return;
        }
        throw new IllegalStateException((apiName + " requires peer feature 'shell_v2'; use shell(command) for legacy shell fallback.").toString());
    }

    private final String restartAdb(String destination) {
        AdbStream adbStreamM2156open = m2156open(destination);
        try {
            String string = C0188KadbKt.readUntil(adbStreamM2156open.getSource(), (byte) 10).readString(Charsets.UTF_8);
            AutoCloseableKt.closeFinally(adbStreamM2156open, null);
            return string;
        } finally {
        }
    }

    private final String streamInstallWrite(File apk, String sessionId, InstallSessionMode sessionMode) {
        String strValueOf = String.valueOf(apk.length());
        String name = apk.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        AdbStream adbStreamOpenInstallCommand = openInstallCommand(sessionMode, "package", "install-write", "-S", strValueOf, sessionId, name, "-");
        try {
            adbStreamOpenInstallCommand.getSink().writeAll(C5053Okio.m14324source(apk));
            adbStreamOpenInstallCommand.getSink().flush();
            String utf8 = adbStreamOpenInstallCommand.getSource().readUtf8();
            AutoCloseableKt.closeFinally(adbStreamOpenInstallCommand, null);
            return utf8;
        } finally {
        }
    }

    /* renamed from: abbExec */
    public final AdbStream m2152abbExec(String... command) {
        Intrinsics.checkNotNullParameter(command, "command");
        return m2156open("abb_exec:" + ArraysKt.joinToString$default(command, "\u0000", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        AdbConnection first;
        C1122Pair<AdbConnection, ? extends TransportChannel> c1122Pair = this.connection;
        if (c1122Pair != null && (first = c1122Pair.getFirst()) != null) {
            first.close();
        }
        this.connection = null;
    }

    public final boolean connectionCheck() {
        TransportChannel second;
        C1122Pair<AdbConnection, ? extends TransportChannel> c1122Pair = this.connection;
        return (c1122Pair == null || (second = c1122Pair.getSecond()) == null || !second.mo2349isOpen()) ? false : true;
    }

    /* renamed from: execCmd */
    public final AdbStream m2153execCmd(String... command) {
        Intrinsics.checkNotNullParameter(command, "command");
        return m2156open(buildExecCmdService(ArraysKt.m5136asList(command)));
    }

    /* renamed from: install */
    public final void m2154install(File file, String... options) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        if (supportsFeature("cmd")) {
            m2155install(C5053Okio.m14324source(file), file.length(), (String[]) Arrays.copyOf(options, options.length));
        } else {
            pmInstall(file, (String[]) Arrays.copyOf(options, options.length));
        }
    }

    public final void installMultiple(List<? extends File> apks, String... options) throws IOException {
        Intrinsics.checkNotNullParameter(apks, "apks");
        Intrinsics.checkNotNullParameter(options, "options");
        List<String> listNonBlankOptions = nonBlankOptions(options);
        InstallSessionMode installSessionMode = installSessionMode();
        Iterator<T> it = apks.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += ((File) it.next()).length();
        }
        String strCreateInstallSession = createInstallSession(length, listNonBlankOptions, installSessionMode);
        String str = null;
        if (installSessionMode.getUsesStreaming()) {
            Iterator<T> it2 = apks.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String strStreamInstallWrite = streamInstallWrite((File) it2.next(), strCreateInstallSession, installSessionMode);
                if (StringsKt.startsWith$default(strStreamInstallWrite, "Success", false, 2, (Object) null)) {
                    strStreamInstallWrite = null;
                }
                if (strStreamInstallWrite != null) {
                    str = strStreamInstallWrite;
                    break;
                }
            }
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : apks) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String strPushAndWrite = pushAndWrite((File) obj, strCreateInstallSession, i);
                if (StringsKt.startsWith$default(strPushAndWrite, "Success", false, 2, (Object) null)) {
                    strPushAndWrite = null;
                }
                if (strPushAndWrite != null) {
                    arrayList.add(strPushAndWrite);
                }
                i = i2;
            }
            str = (String) CollectionsKt.firstOrNull((List) arrayList);
        }
        finalizeSession(strCreateInstallSession, str, installSessionMode);
    }

    /* renamed from: open */
    public final AdbStream m2156open(String destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return (AdbStream) openStream$default(this, destination, false, 2, null).getSecond();
    }

    public final AdbPtyShellSession openPtyShellSession(String command, String term) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(term, "term");
        requireShellV2("openPtyShellSession");
        return new AdbPtyShellSession(new AdbShellStream(m2156open(buildShellService(command, true, term, SHELL_TYPE_PTY))));
    }

    public final AdbShellStream openShell(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        requireShellV2("openShell");
        return new AdbShellStream(m2156open(buildShellService$default(this, command, true, null, SHELL_TYPE_RAW, 4, null)));
    }

    public final AdbSyncStream openSync() {
        C1122Pair c1122PairOpenStream$default = openStream$default(this, "sync:", false, 2, null);
        return new AdbSyncStream((AdbStream) c1122PairOpenStream$default.component2(), ((AdbConnection) c1122PairOpenStream$default.component1()).featureSnapshot$com_github_IndiTheo_kadb());
    }

    /* renamed from: pull */
    public final void m2157pull(File dst, String remotePath) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        m2158pull(C5053Okio.m14319sink(dst, false), remotePath);
    }

    /* renamed from: push */
    public final void m2159push(File src, String remotePath, int mode, long lastModifiedMs) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        m2160push(C5053Okio.m14324source(src), remotePath, mode, lastModifiedMs);
    }

    public final void resetConnection() {
        AdbConnection first;
        C1122Pair<AdbConnection, ? extends TransportChannel> c1122Pair = this.connection;
        if (c1122Pair != null && (first = c1122Pair.getFirst()) != null) {
            first.close();
        }
        this.connection = null;
    }

    /* renamed from: root */
    public final String m2161root() {
        return restartAdb("root:");
    }

    /* renamed from: shell */
    public final AdbShellResponse m2162shell(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (supportsFeature(SHELL_V2_FEATURE)) {
            AdbShellStream adbShellStreamOpenShell = openShell(command);
            try {
                AdbShellResponse adbShellResponseM2295readAll = adbShellStreamOpenShell.m2295readAll();
                AutoCloseableKt.closeFinally(adbShellStreamOpenShell, null);
                return adbShellResponseM2295readAll;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(adbShellStreamOpenShell, th);
                    throw th2;
                }
            }
        }
        String strBuildShellService$default = buildShellService$default(this, command, false, null, null, 12, null);
        enforceLegacyShellServiceLength(strBuildShellService$default);
        AdbStream adbStreamM2156open = m2156open(strBuildShellService$default);
        try {
            AdbShellResponse adbShellResponse = new AdbShellResponse(adbStreamM2156open.getSource().readUtf8(), BuildConfig.f24315FLAVOR, 0);
            AutoCloseableKt.closeFinally(adbStreamM2156open, null);
            return adbShellResponse;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(adbStreamM2156open, th3);
                throw th4;
            }
        }
    }

    public final boolean supportsFeature(String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return connection().supportsFeature(feature);
    }

    public final AutoCloseable tcpForward(int hostPort, int targetPort) {
        TcpForwarder tcpForwarder = new TcpForwarder(this, hostPort, targetPort);
        tcpForwarder.m2224start();
        return tcpForwarder;
    }

    public final void uninstall(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        AdbShellResponse adbShellResponseM2162shell = m2162shell(buildShellCommand(supportsFeature("cmd") ? CollectionsKt.m5806listOf((Object[]) new String[]{"cmd", "package", "uninstall", packageName}) : CollectionsKt.m5806listOf((Object[]) new String[]{"pm", "uninstall", packageName})));
        if (adbShellResponseM2162shell.getExitCode() == 0) {
            return;
        }
        throw new IllegalStateException(("Uninstall failed: " + adbShellResponseM2162shell.getAllOutput()).toString());
    }

    /* renamed from: unroot */
    public final String m2163unroot() {
        return restartAdb("unroot:");
    }

    public C0187Kadb(String host, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.port = i;
        this.connectTimeout = i2;
        this.socketTimeout = i3;
        this.options = new KadbOptions(null, 1, null);
    }

    /* renamed from: pull */
    public final void m2158pull(InterfaceC5060Sink sink, String remotePath) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        AdbSyncStream adbSyncStreamOpenSync = openSync();
        try {
            adbSyncStreamOpenSync.m2333recv(sink, remotePath);
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            AutoCloseableKt.closeFinally(adbSyncStreamOpenSync, null);
        } finally {
        }
    }

    /* renamed from: push */
    public final void m2160push(InterfaceC5062Source source, String remotePath, int mode, long lastModifiedMs) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        AdbSyncStream adbSyncStreamOpenSync = openSync();
        try {
            adbSyncStreamOpenSync.m2334send(source, remotePath, mode, lastModifiedMs);
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            AutoCloseableKt.closeFinally(adbSyncStreamOpenSync, null);
        } finally {
        }
    }

    /* renamed from: install */
    public final void m2155install(InterfaceC5062Source source, long size, String... options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        if (supportsFeature("cmd")) {
            SpreadBuilder spreadBuilder = new SpreadBuilder(5);
            spreadBuilder.m6345add("package");
            spreadBuilder.m6345add("install");
            spreadBuilder.m6345add("-S");
            spreadBuilder.m6345add(String.valueOf(size));
            spreadBuilder.addSpread(options);
            AdbStream adbStreamM2153execCmd = m2153execCmd((String[]) spreadBuilder.m6347toArray(new String[spreadBuilder.m6346size()]));
            try {
                adbStreamM2153execCmd.getSink().writeAll(source);
                adbStreamM2153execCmd.getSink().flush();
                String utf8 = adbStreamM2153execCmd.getSource().readUtf8();
                if (StringsKt.startsWith$default(utf8, "Success", false, 2, (Object) null)) {
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(adbStreamM2153execCmd, null);
                    return;
                } else {
                    throw new IllegalStateException(("Install failed: " + utf8).toString());
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(adbStreamM2153execCmd, th);
                    throw th2;
                }
            }
        }
        String str = "/data/local/tmp/kadb-install-" + System.nanoTime() + ".apk";
        try {
            m2160push(source, str, 420, System.currentTimeMillis());
            pmInstallRemote(str, (String[]) Arrays.copyOf(options, options.length));
        } finally {
            cleanupRemoteTempFile(str);
        }
    }

    public /* synthetic */ C0187Kadb(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    private C0187Kadb(String str, int i, int i2, int i3, KadbOptions kadbOptions) {
        this(str, i, i2, i3);
        this.options = kadbOptions;
    }
}
