package com.sach.multilanguagesample

import android.content.ContentUris
import android.content.Context
import android.content.ContextWrapper
import android.os.LocaleList
import java.util.Locale

class ContextUtils(base: Context) : ContextWrapper(base) {
    companion object {
        fun updateLocalLang(context: Context, localToSwitchTo: Locale): ContextUtils {
            val resource = context.resources
            val configuration = resource.configuration

            val localeList = LocaleList(localToSwitchTo)
            LocaleList.setDefault(localeList)
            configuration.setLocales(localeList)
            val updateContext = context.createConfigurationContext(configuration)
            return ContextUtils(updateContext)
        }
    }
}