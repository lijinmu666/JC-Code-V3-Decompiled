package p132okio.internal;

import com.p091jc.p092code.p093v3.GateNative;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.ArrayDeque;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequenceScope;
import p094kotlin.sequences.SequencesKt;
import p132okio.BufferedSink;
import p132okio.C5053Okio;
import p132okio.C5055Path;
import p132okio.FileMetadata;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0000\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0000\u001aF\u0010\u0014\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u001c"}, m4988d2 = {"commonMetadata", "Lokio/FileMetadata;", "Lokio/FileSystem;", "path", "Lokio/Path;", "commonExists", BuildConfig.f24315FLAVOR, "commonCreateDirectories", BuildConfig.f24315FLAVOR, "dir", "mustCreate", "commonCopy", "source", "target", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonListRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "collectRecursively", "Lkotlin/sequences/SequenceScope;", "fileSystem", "stack", "Lkotlin/collections/ArrayDeque;", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-FileSystem")
@SourceDebugExtension(m6344value = {"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n58#2,4:156\n58#2,22:160\n66#2,10:182\n62#2,3:192\n77#2,3:195\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,4\n66#1:160,22\n65#1:182,10\n65#1:192,3\n65#1:195,3\n*E\n"})
/* renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* loaded from: classes.dex */
public final class FileSystem {

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "okio.internal.-FileSystem", m6124f = "FileSystem.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m6126l = {116, 135, 145}, m6127m = "collectRecursively", m6128n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"}, m6131v = 1)
    /* renamed from: okio.internal.-FileSystem$collectRecursively$1 */
    public static final class C50681 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f17859L$0;

        /* renamed from: L$1 */
        Object f17860L$1;

        /* renamed from: L$2 */
        Object f17861L$2;

        /* renamed from: L$3 */
        Object f17862L$3;

        /* renamed from: L$4 */
        Object f17863L$4;

        /* renamed from: Z$0 */
        boolean f17864Z$0;

        /* renamed from: Z$1 */
        boolean f17865Z$1;

        /* renamed from: label */
        int f17866label;

        /* renamed from: result */
        /* synthetic */ Object f17867result;

        public C50681(Continuation<? super C50681> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f17867result = obj;
            this.f17866label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "okio.internal.-FileSystem$commonListRecursively$1", m6124f = "FileSystem.kt", m6125i = {0, 0}, m6126l = {GateNative.SOFT_MASK}, m6127m = "invokeSuspend", m6128n = {"$this$sequence", "stack"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: okio.internal.-FileSystem$commonListRecursively$1 */
    public static final class C50691 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super C5055Path>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $dir */
        final /* synthetic */ C5055Path f17870$dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ p132okio.FileSystem $this_commonListRecursively;

        /* renamed from: L$0 */
        private /* synthetic */ Object f17871L$0;

        /* renamed from: L$1 */
        Object f17872L$1;

        /* renamed from: L$2 */
        Object f17873L$2;

        /* renamed from: label */
        int f17874label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C50691(C5055Path c5055Path, p132okio.FileSystem fileSystem, boolean z, Continuation<? super C50691> continuation) {
            super(2, continuation);
            this.f17870$dir = c5055Path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C50691 c50691 = new C50691(this.f17870$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
            c50691.f17871L$0 = obj;
            return c50691;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope;
            ArrayDeque arrayDeque;
            Iterator<C5055Path> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f17874label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope2 = (SequenceScope) this.f17871L$0;
                ArrayDeque arrayDeque2 = new ArrayDeque();
                arrayDeque2.m5123addLast(this.f17870$dir);
                sequenceScope = sequenceScope2;
                arrayDeque = arrayDeque2;
                it = this.$this_commonListRecursively.mo14286list(this.f17870$dir).iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.f17873L$2;
                ArrayDeque arrayDeque3 = (ArrayDeque) this.f17872L$1;
                SequenceScope sequenceScope3 = (SequenceScope) this.f17871L$0;
                ResultKt.throwOnFailure(obj);
                arrayDeque = arrayDeque3;
                sequenceScope = sequenceScope3;
            }
            while (it.hasNext()) {
                C5055Path next = it.next();
                p132okio.FileSystem fileSystem = this.$this_commonListRecursively;
                boolean z = this.$followSymlinks;
                this.f17871L$0 = sequenceScope;
                this.f17872L$1 = arrayDeque;
                this.f17873L$2 = it;
                this.f17874label = 1;
                if (FileSystem.collectRecursively(sequenceScope, fileSystem, arrayDeque, next, z, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super C5055Path> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C50691) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dd, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        if (r7 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        r6.m5123addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e8, code lost:
    
        r7 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0123, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0124, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(SequenceScope<? super C5055Path> sequenceScope, p132okio.FileSystem fileSystem, ArrayDeque<C5055Path> arrayDeque, C5055Path c5055Path, boolean z, boolean z2, Continuation<? super C1133Unit> continuation) throws Throwable {
        C50681 c50681;
        p132okio.FileSystem fileSystem2;
        ArrayDeque<C5055Path> arrayDeque2;
        boolean z3;
        p132okio.FileSystem fileSystem3;
        SequenceScope<? super C5055Path> sequenceScope2;
        boolean z4;
        C5055Path c5055Path2 = c5055Path;
        boolean z5 = z2;
        if (continuation instanceof C50681) {
            c50681 = (C50681) continuation;
            int i = c50681.f17866label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c50681.f17866label = i - Integer.MIN_VALUE;
            } else {
                c50681 = new C50681(continuation);
            }
        }
        Object obj = c50681.f17867result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c50681.f17866label;
        int i3 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (z5) {
                fileSystem2 = fileSystem;
                arrayDeque2 = arrayDeque;
                z3 = z;
            } else {
                c50681.f17859L$0 = sequenceScope;
                fileSystem2 = fileSystem;
                c50681.f17860L$1 = fileSystem2;
                arrayDeque2 = arrayDeque;
                c50681.f17861L$2 = arrayDeque2;
                c50681.f17862L$3 = c5055Path2;
                z3 = z;
                c50681.f17864Z$0 = z3;
                c50681.f17865Z$1 = z5;
                c50681.f17866label = 1;
                if (sequenceScope.mo6559yield(c5055Path2, c50681) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            fileSystem3 = fileSystem2;
            boolean z6 = z3;
            sequenceScope2 = sequenceScope;
            z4 = z6;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return C1133Unit.INSTANCE;
                }
                boolean z7 = c50681.f17865Z$1;
                boolean z8 = c50681.f17864Z$0;
                Iterator<C5055Path> it = (Iterator) c50681.f17863L$4;
                C5055Path c5055Path3 = (C5055Path) c50681.f17862L$3;
                ArrayDeque<C5055Path> arrayDeque3 = (ArrayDeque) c50681.f17861L$2;
                fileSystem3 = (p132okio.FileSystem) c50681.f17860L$1;
                sequenceScope2 = (SequenceScope) c50681.f17859L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        C5055Path next = it.next();
                        c50681.f17859L$0 = sequenceScope2;
                        c50681.f17860L$1 = fileSystem3;
                        c50681.f17861L$2 = arrayDeque3;
                        c50681.f17862L$3 = c5055Path3;
                        c50681.f17863L$4 = it;
                        c50681.f17864Z$0 = z8;
                        c50681.f17865Z$1 = z7;
                        c50681.f17866label = 2;
                        if (collectRecursively(sequenceScope2, fileSystem3, arrayDeque3, next, z8, z7, c50681) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    arrayDeque3.removeLast();
                    z5 = z7;
                    c5055Path2 = c5055Path3;
                    if (z5) {
                        return C1133Unit.INSTANCE;
                    }
                    c50681.f17859L$0 = null;
                    c50681.f17860L$1 = null;
                    c50681.f17861L$2 = null;
                    c50681.f17862L$3 = null;
                    c50681.f17863L$4 = null;
                    c50681.f17866label = 3;
                    if (sequenceScope2.mo6559yield(c5055Path2, c50681) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    arrayDeque3.removeLast();
                    throw th;
                }
            }
            boolean z9 = c50681.f17865Z$1;
            boolean z10 = c50681.f17864Z$0;
            C5055Path c5055Path4 = (C5055Path) c50681.f17862L$3;
            arrayDeque2 = (ArrayDeque) c50681.f17861L$2;
            fileSystem3 = (p132okio.FileSystem) c50681.f17860L$1;
            sequenceScope2 = (SequenceScope) c50681.f17859L$0;
            ResultKt.throwOnFailure(obj);
            z5 = z9;
            z4 = z10;
            c5055Path2 = c5055Path4;
        }
        List<C5055Path> listListOrNull = fileSystem3.listOrNull(c5055Path2);
        if (listListOrNull == null) {
            listListOrNull = CollectionsKt.emptyList();
        }
        if (!listListOrNull.isEmpty()) {
            C5055Path c5055Path5 = c5055Path2;
            while (true) {
                if (z4 && arrayDeque2.contains(c5055Path5)) {
                    throw new IOException("symlink cycle at " + c5055Path2);
                }
                C5055Path c5055PathSymlinkTarget = symlinkTarget(fileSystem3, c5055Path5);
                if (c5055PathSymlinkTarget == null) {
                    break;
                }
                i3++;
                c5055Path5 = c5055PathSymlinkTarget;
            }
        }
        if (z5) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #5 {all -> 0x003c, blocks: (B:3:0x0016, B:21:0x0042, B:27:0x004d, B:16:0x0038, B:4:0x001e, B:13:0x0033), top: B:47:0x0016, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d A[Catch: all -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x003c, blocks: (B:3:0x0016, B:21:0x0042, B:27:0x004d, B:16:0x0038, B:4:0x001e, B:13:0x0033), top: B:47:0x0016, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void commonCopy(p132okio.FileSystem fileSystem, C5055Path source, C5055Path target) {
        Throwable th;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        InterfaceC5062Source interfaceC5062SourceMo14289source = fileSystem.mo14289source(source);
        Throwable th2 = null;
        try {
            BufferedSink bufferedSinkM14315buffer = C5053Okio.m14315buffer(p132okio.FileSystem.sink$default(fileSystem, target, false, 2, null));
            try {
                lValueOf = Long.valueOf(bufferedSinkM14315buffer.writeAll(interfaceC5062SourceMo14289source));
            } catch (Throwable th3) {
                if (bufferedSinkM14315buffer != null) {
                    try {
                        bufferedSinkM14315buffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                lValueOf = null;
            }
            if (bufferedSinkM14315buffer != null) {
                try {
                    bufferedSinkM14315buffer.close();
                    th = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (th == null) {
                    throw th;
                }
                lValueOf.longValue();
                if (interfaceC5062SourceMo14289source != null) {
                    try {
                        interfaceC5062SourceMo14289source.close();
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                }
            } else {
                th = null;
                if (th == null) {
                }
            }
        } catch (Throwable th7) {
            if (interfaceC5062SourceMo14289source != null) {
                try {
                    interfaceC5062SourceMo14289source.close();
                } catch (Throwable th8) {
                    ExceptionsKt.addSuppressed(th7, th8);
                }
            }
            th2 = th7;
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public static final void commonCreateDirectories(p132okio.FileSystem fileSystem, C5055Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (C5055Path c5055PathM14356parent = dir; c5055PathM14356parent != null && !fileSystem.m14285exists(c5055PathM14356parent); c5055PathM14356parent = c5055PathM14356parent.m14356parent()) {
            arrayDeque.addFirst(c5055PathM14356parent);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            p132okio.FileSystem.createDirectory$default(fileSystem, (C5055Path) it.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(p132okio.FileSystem fileSystem, C5055Path fileOrDirectory, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.mo14284delete((C5055Path) it.next(), z && !it.hasNext());
        }
    }

    public static final boolean commonExists(p132okio.FileSystem fileSystem, C5055Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final Sequence<C5055Path> commonListRecursively(p132okio.FileSystem fileSystem, C5055Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new C50691(dir, fileSystem, z, null));
    }

    public static final FileMetadata commonMetadata(p132okio.FileSystem fileSystem, C5055Path path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final C5055Path symlinkTarget(p132okio.FileSystem fileSystem, C5055Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        C5055Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        C5055Path c5055PathM14356parent = path.m14356parent();
        Intrinsics.checkNotNull(c5055PathM14356parent);
        return c5055PathM14356parent.m14361resolve(symlinkTarget);
    }
}
