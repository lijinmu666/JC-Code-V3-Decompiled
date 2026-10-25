package p094kotlin.p101io.p102path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.ArrayDeque;
import p094kotlin.collections.ArraysKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequenceScope;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0082\u0004JC\u0010\u0017\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 \u0012\u0004\u0012\u00020\u00180\u001fH\u0082È\u0004¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004J\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004R\u000f\u0010\u0003\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, m4988d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", BuildConfig.f24315FLAVOR, "Lkotlin/io/path/PathWalkOption;", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "[Lkotlin/io/path/PathWalkOption;", "followLinks", BuildConfig.f24315FLAVOR, "getFollowLinks", "()Z", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "includeDirectories", "getIncludeDirectories", "isBFS", "iterator", BuildConfig.f24315FLAVOR, "yieldIfNeeded", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dfsIterator", "bfsIterator", "kotlin-stdlib-jdk7"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", m6124f = "PathTreeWalk.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {191, 197}, m6127m = "invokeSuspend", m6128n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv"}, m6129nl = {193, 199}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, m6131v = 2)
    @SourceDebugExtension(m6344value = {"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n101#1:181,19\n*E\n"})
    /* renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1 */
    public static final class C12221 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: L$0 */
        private /* synthetic */ Object f5119L$0;

        /* renamed from: L$1 */
        Object f5120L$1;

        /* renamed from: L$2 */
        Object f5121L$2;

        /* renamed from: L$3 */
        Object f5122L$3;

        /* renamed from: L$4 */
        Object f5123L$4;

        /* renamed from: L$5 */
        Object f5124L$5;

        /* renamed from: L$6 */
        Object f5125L$6;

        /* renamed from: L$7 */
        Object f5126L$7;

        /* renamed from: L$8 */
        Object f5127L$8;

        /* renamed from: label */
        int f5128label;

        public C12221(Continuation<? super C12221> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C12221 c12221 = PathTreeWalk.this.new C12221(continuation);
            c12221.f5119L$0 = obj;
            return c12221;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        
            r11 = p094kotlin.C1133Unit.INSTANCE;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws FileSystemLoopException {
            DirectoryEntriesReader directoryEntriesReader;
            ArrayDeque arrayDeque;
            Path path;
            DirectoryEntriesReader directoryEntriesReader2;
            PathTreeWalk pathTreeWalk;
            PathNode pathNode;
            LinkOption[] linkOptionArr;
            ArrayDeque arrayDeque2;
            DirectoryEntriesReader directoryEntriesReader3;
            Path path2;
            SequenceScope sequenceScope = (SequenceScope) this.f5119L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5128label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque3 = new ArrayDeque();
                directoryEntriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                arrayDeque3.m5123addLast(new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.m6233keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null));
                arrayDeque = arrayDeque3;
            } else if (i == 1) {
                path2 = (Path) this.f5127L$8;
                directoryEntriesReader3 = (DirectoryEntriesReader) this.f5126L$7;
                pathNode = (PathNode) this.f5125L$6;
                pathTreeWalk = (PathTreeWalk) this.f5123L$4;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.f5121L$2;
                arrayDeque2 = (ArrayDeque) this.f5120L$1;
                ResultKt.throwOnFailure(obj);
                path = path2;
                directoryEntriesReader = directoryEntriesReader3;
                arrayDeque = arrayDeque2;
                LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    arrayDeque.addAll(directoryEntriesReader.readEntries(pathNode));
                }
                directoryEntriesReader = directoryEntriesReader2;
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                directoryEntriesReader = (DirectoryEntriesReader) this.f5121L$2;
                arrayDeque = (ArrayDeque) this.f5120L$1;
                ResultKt.throwOnFailure(obj);
            }
            while (!arrayDeque.isEmpty()) {
                pathNode = (PathNode) arrayDeque.removeFirst();
                pathTreeWalk = PathTreeWalk.this;
                path = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
                }
                LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        this.f5119L$0 = sequenceScope;
                        this.f5120L$1 = arrayDeque;
                        this.f5121L$2 = directoryEntriesReader;
                        this.f5122L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.f5123L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk);
                        this.f5124L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.f5125L$6 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.f5126L$7 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader);
                        this.f5127L$8 = SpillingKt.nullOutSpilledVariable(path);
                        this.f5128label = 2;
                        if (sequenceScope.mo6559yield(path, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                    while (!arrayDeque.isEmpty()) {
                    }
                } else {
                    if (PathTreeWalkKt.createsCycle(pathNode)) {
                        throw new FileSystemLoopException(path.toString());
                    }
                    if (pathTreeWalk.getIncludeDirectories()) {
                        this.f5119L$0 = sequenceScope;
                        this.f5120L$1 = arrayDeque;
                        this.f5121L$2 = directoryEntriesReader;
                        this.f5122L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.f5123L$4 = pathTreeWalk;
                        this.f5124L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.f5125L$6 = pathNode;
                        this.f5126L$7 = directoryEntriesReader;
                        this.f5127L$8 = path;
                        this.f5128label = 1;
                        if (sequenceScope.mo6559yield(path, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        directoryEntriesReader2 = directoryEntriesReader;
                        arrayDeque2 = arrayDeque;
                        path2 = path;
                        directoryEntriesReader3 = directoryEntriesReader2;
                        path = path2;
                        directoryEntriesReader = directoryEntriesReader3;
                        arrayDeque = arrayDeque2;
                        LinkOption[] linkOptions3 = pathTreeWalk.getLinkOptions();
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        directoryEntriesReader = directoryEntriesReader2;
                        C1133Unit c1133Unit22 = C1133Unit.INSTANCE;
                        while (!arrayDeque.isEmpty()) {
                        }
                    } else {
                        directoryEntriesReader2 = directoryEntriesReader;
                        LinkOption[] linkOptions32 = pathTreeWalk.getLinkOptions();
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        directoryEntriesReader = directoryEntriesReader2;
                        C1133Unit c1133Unit222 = C1133Unit.INSTANCE;
                        while (!arrayDeque.isEmpty()) {
                        }
                    }
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C12221) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", m6124f = "PathTreeWalk.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, m6126l = {191, 197, 210, 216}, m6127m = "invokeSuspend", m6128n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv"}, m6129nl = {193, 199, 212, 218}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, m6131v = 2)
    @SourceDebugExtension(m6344value = {"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n44#2,19:200\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n70#1:181,19\n81#1:200,19\n*E\n"})
    /* renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1 */
    public static final class C12231 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: L$0 */
        private /* synthetic */ Object f5130L$0;

        /* renamed from: L$1 */
        Object f5131L$1;

        /* renamed from: L$10 */
        Object f5132L$10;

        /* renamed from: L$11 */
        Object f5133L$11;

        /* renamed from: L$2 */
        Object f5134L$2;

        /* renamed from: L$3 */
        Object f5135L$3;

        /* renamed from: L$4 */
        Object f5136L$4;

        /* renamed from: L$5 */
        Object f5137L$5;

        /* renamed from: L$6 */
        Object f5138L$6;

        /* renamed from: L$7 */
        Object f5139L$7;

        /* renamed from: L$8 */
        Object f5140L$8;

        /* renamed from: L$9 */
        Object f5141L$9;

        /* renamed from: label */
        int f5142label;

        public C12231(Continuation<? super C12231> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C12231 c12231 = PathTreeWalk.this.new C12231(continuation);
            c12231.f5130L$0 = obj;
            return c12231;
        }

        /* JADX WARN: Code restructure failed: missing block: B:77:0x01d1, code lost:
        
            r9 = p094kotlin.C1133Unit.INSTANCE;
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x027e  */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws FileSystemLoopException {
            ArrayDeque arrayDeque;
            DirectoryEntriesReader directoryEntriesReader;
            PathNode pathNode;
            PathTreeWalk pathTreeWalk;
            Path path;
            DirectoryEntriesReader directoryEntriesReader2;
            PathNode pathNode2;
            DirectoryEntriesReader directoryEntriesReader3;
            ArrayDeque arrayDeque2;
            PathNode pathNode3;
            Path path2;
            PathTreeWalk pathTreeWalk2;
            DirectoryEntriesReader directoryEntriesReader4;
            PathNode pathNode4;
            LinkOption[] linkOptionArr;
            SequenceScope sequenceScope = (SequenceScope) this.f5130L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5142label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                arrayDeque = new ArrayDeque();
                directoryEntriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                pathNode = new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.m6233keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null);
                PathTreeWalk pathTreeWalk3 = PathTreeWalk.this;
                Path path3 = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path3);
                }
                LinkOption[] linkOptions = pathTreeWalk3.getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (!Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    if (Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        this.f5130L$0 = sequenceScope;
                        this.f5131L$1 = arrayDeque;
                        this.f5134L$2 = directoryEntriesReader;
                        this.f5135L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.f5136L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk3);
                        this.f5137L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.f5138L$6 = SpillingKt.nullOutSpilledVariable(pathNode);
                        this.f5139L$7 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader);
                        this.f5140L$8 = SpillingKt.nullOutSpilledVariable(path3);
                        this.f5142label = 2;
                        if (sequenceScope.mo6559yield(path3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    }
                    directoryEntriesReader4 = directoryEntriesReader;
                    pathNode4 = pathNode;
                    while (!arrayDeque.isEmpty()) {
                    }
                    return C1133Unit.INSTANCE;
                }
                if (PathTreeWalkKt.createsCycle(pathNode)) {
                    throw new FileSystemLoopException(path3.toString());
                }
                if (!pathTreeWalk3.getIncludeDirectories()) {
                    pathTreeWalk = pathTreeWalk3;
                    path = path3;
                    directoryEntriesReader2 = directoryEntriesReader;
                    pathNode2 = pathNode;
                    LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                    if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        pathNode2.setContentIterator(directoryEntriesReader.readEntries(pathNode).iterator());
                        arrayDeque.m5123addLast(pathNode2);
                    }
                    pathNode = pathNode2;
                    directoryEntriesReader = directoryEntriesReader2;
                    C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                    directoryEntriesReader4 = directoryEntriesReader;
                    pathNode4 = pathNode;
                    while (!arrayDeque.isEmpty()) {
                    }
                    return C1133Unit.INSTANCE;
                }
                this.f5130L$0 = sequenceScope;
                this.f5131L$1 = arrayDeque;
                this.f5134L$2 = directoryEntriesReader;
                this.f5135L$3 = pathNode;
                this.f5136L$4 = pathTreeWalk3;
                this.f5137L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.f5138L$6 = pathNode;
                this.f5139L$7 = directoryEntriesReader;
                this.f5140L$8 = path3;
                this.f5142label = 1;
                if (sequenceScope.mo6559yield(path3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                directoryEntriesReader3 = directoryEntriesReader;
                arrayDeque2 = arrayDeque;
                pathNode3 = pathNode;
                path2 = path3;
                directoryEntriesReader2 = directoryEntriesReader3;
                pathTreeWalk2 = pathTreeWalk3;
                pathNode2 = pathNode3;
            } else {
                if (i != 1) {
                    if (i == 2) {
                    } else {
                        if (i == 3) {
                            Path path4 = (Path) this.f5133L$11;
                            directoryEntriesReader4 = (DirectoryEntriesReader) this.f5132L$10;
                            PathNode pathNode5 = (PathNode) this.f5141L$9;
                            PathTreeWalk pathTreeWalk4 = (PathTreeWalk) this.f5139L$7;
                            PathNode pathNode6 = (PathNode) this.f5138L$6;
                            PathNode pathNode7 = (PathNode) this.f5135L$3;
                            DirectoryEntriesReader directoryEntriesReader5 = (DirectoryEntriesReader) this.f5134L$2;
                            ArrayDeque arrayDeque3 = (ArrayDeque) this.f5131L$1;
                            ResultKt.throwOnFailure(obj);
                            ArrayDeque arrayDeque4 = arrayDeque3;
                            Path path5 = path4;
                            pathNode4 = pathNode7;
                            PathNode next = pathNode5;
                            arrayDeque = arrayDeque4;
                            LinkOption[] linkOptions3 = pathTreeWalk4.getLinkOptions();
                            LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                            if (Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                                pathNode6.setContentIterator(directoryEntriesReader4.readEntries(next).iterator());
                                arrayDeque.m5123addLast(pathNode6);
                            }
                            directoryEntriesReader4 = directoryEntriesReader5;
                            C1133Unit c1133Unit3 = C1133Unit.INSTANCE;
                            while (!arrayDeque.isEmpty()) {
                                PathNode pathNode8 = (PathNode) arrayDeque.m5125last();
                                Iterator<PathNode> contentIterator = pathNode8.getContentIterator();
                                Intrinsics.checkNotNull(contentIterator);
                                if (contentIterator.hasNext()) {
                                    next = contentIterator.next();
                                    PathTreeWalk pathTreeWalk5 = PathTreeWalk.this;
                                    path5 = next.getPath();
                                    if (next.getParent() != null) {
                                        PathsKt__PathRecursiveFunctionsKt.checkFileName(path5);
                                    }
                                    LinkOption[] linkOptions4 = pathTreeWalk5.getLinkOptions();
                                    LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                                    if (!Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                                        if (Files.exists(path5, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                                            this.f5130L$0 = sequenceScope;
                                            this.f5131L$1 = arrayDeque;
                                            this.f5134L$2 = directoryEntriesReader4;
                                            this.f5135L$3 = SpillingKt.nullOutSpilledVariable(pathNode4);
                                            this.f5136L$4 = SpillingKt.nullOutSpilledVariable(pathNode8);
                                            this.f5137L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                            this.f5138L$6 = SpillingKt.nullOutSpilledVariable(next);
                                            this.f5139L$7 = SpillingKt.nullOutSpilledVariable(pathTreeWalk5);
                                            this.f5140L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                            this.f5141L$9 = SpillingKt.nullOutSpilledVariable(next);
                                            this.f5132L$10 = SpillingKt.nullOutSpilledVariable(directoryEntriesReader4);
                                            this.f5133L$11 = SpillingKt.nullOutSpilledVariable(path5);
                                            this.f5142label = 4;
                                            if (sequenceScope.mo6559yield(path5, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                        C1133Unit c1133Unit32 = C1133Unit.INSTANCE;
                                        while (!arrayDeque.isEmpty()) {
                                        }
                                    } else {
                                        if (PathTreeWalkKt.createsCycle(next)) {
                                            throw new FileSystemLoopException(path5.toString());
                                        }
                                        if (pathTreeWalk5.getIncludeDirectories()) {
                                            this.f5130L$0 = sequenceScope;
                                            this.f5131L$1 = arrayDeque;
                                            this.f5134L$2 = directoryEntriesReader4;
                                            this.f5135L$3 = SpillingKt.nullOutSpilledVariable(pathNode4);
                                            this.f5136L$4 = SpillingKt.nullOutSpilledVariable(pathNode8);
                                            this.f5137L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                            this.f5138L$6 = next;
                                            this.f5139L$7 = pathTreeWalk5;
                                            this.f5140L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                            this.f5141L$9 = next;
                                            this.f5132L$10 = directoryEntriesReader4;
                                            this.f5133L$11 = path5;
                                            this.f5142label = 3;
                                            if (sequenceScope.mo6559yield(path5, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            pathNode6 = next;
                                            pathTreeWalk4 = pathTreeWalk5;
                                            pathNode7 = pathNode4;
                                            directoryEntriesReader5 = directoryEntriesReader4;
                                            path4 = path5;
                                            arrayDeque3 = arrayDeque;
                                            pathNode5 = pathNode6;
                                            ArrayDeque arrayDeque42 = arrayDeque3;
                                            Path path52 = path4;
                                            pathNode4 = pathNode7;
                                            PathNode next2 = pathNode5;
                                            arrayDeque = arrayDeque42;
                                            LinkOption[] linkOptions32 = pathTreeWalk4.getLinkOptions();
                                            LinkOption[] linkOptionArr32 = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                                            if (Files.isDirectory(path52, (LinkOption[]) Arrays.copyOf(linkOptionArr32, linkOptionArr32.length))) {
                                            }
                                            directoryEntriesReader4 = directoryEntriesReader5;
                                            C1133Unit c1133Unit322 = C1133Unit.INSTANCE;
                                            while (!arrayDeque.isEmpty()) {
                                            }
                                        } else {
                                            pathNode6 = next2;
                                            pathTreeWalk4 = pathTreeWalk5;
                                            directoryEntriesReader5 = directoryEntriesReader4;
                                            LinkOption[] linkOptions322 = pathTreeWalk4.getLinkOptions();
                                            LinkOption[] linkOptionArr322 = (LinkOption[]) Arrays.copyOf(linkOptions322, linkOptions322.length);
                                            if (Files.isDirectory(path52, (LinkOption[]) Arrays.copyOf(linkOptionArr322, linkOptionArr322.length))) {
                                            }
                                            directoryEntriesReader4 = directoryEntriesReader5;
                                            C1133Unit c1133Unit3222 = C1133Unit.INSTANCE;
                                            while (!arrayDeque.isEmpty()) {
                                            }
                                        }
                                    }
                                } else {
                                    arrayDeque.removeLast();
                                }
                            }
                            return C1133Unit.INSTANCE;
                        }
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    pathNode4 = (PathNode) this.f5135L$3;
                    directoryEntriesReader4 = (DirectoryEntriesReader) this.f5134L$2;
                    arrayDeque = (ArrayDeque) this.f5131L$1;
                    ResultKt.throwOnFailure(obj);
                    while (!arrayDeque.isEmpty()) {
                    }
                    return C1133Unit.INSTANCE;
                }
                path2 = (Path) this.f5140L$8;
                directoryEntriesReader3 = (DirectoryEntriesReader) this.f5139L$7;
                pathNode3 = (PathNode) this.f5138L$6;
                pathTreeWalk2 = (PathTreeWalk) this.f5136L$4;
                pathNode2 = (PathNode) this.f5135L$3;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.f5134L$2;
                arrayDeque2 = (ArrayDeque) this.f5131L$1;
                ResultKt.throwOnFailure(obj);
            }
            ArrayDeque arrayDeque5 = arrayDeque2;
            path = path2;
            directoryEntriesReader = directoryEntriesReader3;
            pathTreeWalk = pathTreeWalk2;
            pathNode = pathNode3;
            arrayDeque = arrayDeque5;
            LinkOption[] linkOptions22 = pathTreeWalk.getLinkOptions();
            linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            }
            pathNode = pathNode2;
            directoryEntriesReader = directoryEntriesReader2;
            C1133Unit c1133Unit22 = C1133Unit.INSTANCE;
            directoryEntriesReader4 = directoryEntriesReader;
            pathNode4 = pathNode;
            while (!arrayDeque.isEmpty()) {
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C12231) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public PathTreeWalk(Path start, PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new C12221(null));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C12231(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    /* renamed from: isBFS */
    private final boolean m6232isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, C1133Unit> function1, Continuation<? super C1133Unit> continuation) throws FileSystemLoopException {
        Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
        }
        LinkOption[] linkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (PathTreeWalkKt.createsCycle(pathNode)) {
                throw new FileSystemLoopException(path.toString());
            }
            if (getIncludeDirectories()) {
                InlineMarker.m6315mark(0);
                InlineMarker.m6315mark(11);
                sequenceScope.mo6559yield(path, continuation);
                InlineMarker.m6315mark(1);
            }
            LinkOption[] linkOptions2 = getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                function1.mo2237invoke(directoryEntriesReader.readEntries(pathNode));
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            InlineMarker.m6315mark(0);
            InlineMarker.m6315mark(11);
            Object objMo6559yield = sequenceScope.mo6559yield(path, continuation);
            InlineMarker.m6315mark(1);
            return objMo6559yield;
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        return m6232isBFS() ? bfsIterator() : dfsIterator();
    }
}
