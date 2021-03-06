package easy.go.skel.exception

import retrofit2.Response

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for easy_go_skel on 03.04.20 0:55.
 */
open class ApiResponseException(response: Response<*>) : Exception("Api Response: $response")
