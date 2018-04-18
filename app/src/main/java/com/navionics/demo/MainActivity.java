package com.navionics.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.navionics.android.nms.NMSCameraPosition;
import com.navionics.android.nms.NMSCircle;
import com.navionics.android.nms.NMSCoordinateBounds;
import com.navionics.android.nms.NMSEnum;
import com.navionics.android.nms.NMSGroundOverlay;
import com.navionics.android.nms.NMSMapView;
import com.navionics.android.nms.NMSMarker;
import com.navionics.android.nms.NMSMutablePath;
import com.navionics.android.nms.NMSPolygon;
import com.navionics.android.nms.NMSPolyline;
import com.navionics.android.nms.NMSSettings;
import com.navionics.android.nms.NavionicsMobileServices;
import com.navionics.android.nms.core.NSError;
import com.navionics.android.nms.model.CGPoint;
import com.navionics.android.nms.model.NMSColor;
import com.navionics.android.nms.model.NMSLocationCoordinate2D;
import com.navionics.android.nms.ui.NMSMapFragment;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NMSSettings settings = NMSSettings.settings();
        settings.setLanguage(NMSEnum.NMSLanguage.NMSLanguageEnglish);
        settings.setMode(NMSEnum.NMSFrameworkMode.NMSFrameworkModeSandbox);
        settings.setProjectToken("M2TQZA3cxh7LATcPSe68/lFNVj+Jl82IezRxqU/3hI/xafKebYBE/SyY/p2F4BhP/qpY01Enq9gak4pz4jY/WYpZN4L7Vq8bY7DpJdxIuAzcRGpNQN3BrtwuEItjA75fgDp4IJxSdKlI7ad3LX0aiZeoSkMH3BjOKX6GKUgWl91in1p2sBLieBlvSpK94E/EO5dKResFtLMlLx+WUrLAtAY28FPsqVdQkZktzS3nT5WPlBGydP2NcW5fRLcyuTYHTTUS7oyT1i6PbMOrcofHocgahpMT0dyVauXyXhm1+uiIk3LqlGtudy6fDs7GJTs99o3UxcslQaQNW0WKTgk0o/Qg12ASnkgw6rL8hVKee8iCzTio50B7KUyrYfaB7ELTNeLfGbPitw0BeaeC03Gv478pUr+y2xEy+OsTgsNllJaEzsUBG6UTxlDdWRT+SHKIkJVN1mp63/h4eRBshmxfJo6JtF/P6Esv41SkI9rduDC6BfzafjwoxLxZWqxVp2nIP8S6X/0/twmBZn4kd2Ni7DQ+9R50YEQvEoTxOfcT9Ukqf16pRVJbJKhEcl0z/ptMObrUdU3Q8oJaO3FUuR3rkJVKbTfYTzQlhMHY9UBAZJjKcgreXn8Jzh5yTrin8trPkmkSruf4k9su7vJOP4I23oT6aCahRGFXAs/lMHo2/IE=");
        settings.setPrivateKey("-----BEGIN RSA PRIVATE KEY-----\n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\n-----END RSA PRIVATE KEY-----\n");

        NSError error = new NSError();
        NavionicsMobileServices.initializeWithSettings(settings, error);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new MapFragment())
                .commit();

    }
}
