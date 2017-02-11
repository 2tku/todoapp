package com.example.thuattq1.global;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Luu tru cac bien su dung chung trong chuong trinh
 *
 * @author:
 * @version: 1.0
 * @since: 1.0
 */
public class GlobalInfo extends Application {
    private static volatile GlobalInfo instance = null;

    public static GlobalInfo getInstance() {
        return instance;
    }

    public Context getAppContext() {
        return instance;
    }

    private String deviceIMEI;
    private int sysDecimalPoint;
    private int sysDigitDecimal;
    private int sysNumRounding;
    private int sysCurrencyDivide;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        /*TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        this.deviceIMEI = telephonyManager.getDeviceId();*/

        this.sysDecimalPoint = 2;
        this.sysDigitDecimal = 2;
        this.sysNumRounding = 3;
        this.sysCurrencyDivide = 1;

		/* OAuthRequestManager.setOAuthInfo(ServerPath.SERVER_PATH_OAUTH, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET);
        SqlCipherUtil.ensureSecurePreference(this);
		LanguagesDTO dtoLang = loadLanguages();
		if (dtoLang != null) {
			updateLanguageConfig(dtoLang.getValue());
		}*/

        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // MultiDex.install(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // ---------------------------------------------------------------------------------------------
    public int getSysDecimalPoint() {
        return sysDecimalPoint;
    }

    public int getSysDigitDecimal() {
        return sysDigitDecimal;
    }

    public String getDeviceIMEI() {
        return deviceIMEI;
    }

    public int getSysNumRounding() {
        return sysNumRounding;
    }

    public int getSysCurrencyDivide() {
        return sysCurrencyDivide;
    }
}