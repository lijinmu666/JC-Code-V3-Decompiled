package p132okio.internal;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.ArrayDeque;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.sequences.SequenceScope;
import p132okio.C5055Path;
import p132okio.FileSystem;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", m6124f = "FileSystem.kt", m6125i = {}, m6126l = {C5125EACTags.DEPRECATED}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
/* renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* loaded from: classes.dex */
public final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super C5055Path>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ C5055Path $fileOrDirectory;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;

    /* renamed from: L$0 */
    private /* synthetic */ Object f17868L$0;

    /* renamed from: label */
    int f17869label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, C5055Path c5055Path, Continuation<? super FileSystem$commonDeleteRecursively$sequence$1> continuation) {
        super(2, continuation);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = c5055Path;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, continuation);
        fileSystem$commonDeleteRecursively$sequence$1.f17868L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f17869label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f17868L$0;
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            ArrayDeque arrayDeque = new ArrayDeque();
            C5055Path c5055Path = this.$fileOrDirectory;
            this.f17869label = 1;
            if (FileSystem.collectRecursively(sequenceScope, fileSystem, arrayDeque, c5055Path, false, true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(SequenceScope<? super C5055Path> sequenceScope, Continuation<? super C1133Unit> continuation) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
