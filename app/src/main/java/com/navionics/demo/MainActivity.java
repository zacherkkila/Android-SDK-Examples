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

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new MapFragment())
                .commit();
    }
}
