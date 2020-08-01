package easy.go.library.repository

import com.google.firebase.crashlytics.FirebaseCrashlytics
import easy.go.library.exception.ApiResponseException
import easy.go.library.exception.NullableApiResponseException
import io.reactivex.CompletableEmitter
import io.reactivex.ObservableEmitter
import io.reactivex.SingleEmitter
import retrofit2.Response

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for easy_go_library on 08.04.20 22:22.
 */

inline fun <T: Response<R>, R> T.checkResponse(block: (R) -> Unit) {
  if (isSuccessful) {
    val result = body() ?: throw NullableApiResponseException(this)

    block(result)
  } else {
    throw ApiResponseException(this)
  }
}

inline fun <T: Response<R>, R> T.useResponse(emitter: ObservableEmitter<*>, block: (R) -> Unit) {
  try {
    checkResponse(block)
  } catch (exception: Exception) {
    FirebaseCrashlytics.getInstance().recordException(exception)
    emitter.onError(exception)
  }
}

inline fun <T: Response<R>, R> T.useResponse(emitter: SingleEmitter<*>, block: (R) -> Unit) {
  try {
    checkResponse(block)
  } catch (exception: Exception) {
    FirebaseCrashlytics.getInstance().recordException(exception)
    emitter.onError(exception)
  }
}

inline fun <T: Response<R>, R> T.useResponse(emitter: CompletableEmitter, block: (R) -> Unit) {
  try {
    checkResponse(block)
  } catch (exception: Exception) {
    FirebaseCrashlytics.getInstance().recordException(exception)
    emitter.onError(exception)
  }
}
