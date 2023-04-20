package com.shoppi.app

import android.content.Context

class AssetLoader {

    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available() // inputStream에 데이터가 존재하는지 크기 확인
            val bytes = ByteArray(size) // inputStream에서 전달받는 데이터 타입이 ByteArray이므로 해당 크기만큼 초기화
            inputStream.read(bytes) // inputStream의 ByteArray를 읽어와서 bytes에 복사
            String(bytes) // String타입으로 변환
        }
    }
}