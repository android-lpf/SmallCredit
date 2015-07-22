package  com.geo.smallcredit.MainApplication;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;

public class MainApplication extends Application {
	
	private static MainApplication app;
	ArrayList<Activity> list;
	
	public MainApplication(){
		list = new ArrayList<Activity>();
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}
	public static synchronized MainApplication getInstance(){
		if(app==null){
			app = new MainApplication();
		}
		return app;
	}
	public void addActivity(Activity activity){
		list.add(activity);
	}
	public void removeActivity(){
		for (int i = 0; i < list.size(); i++) {
			Activity activity = list.get(i);
			activity.finish();
		}
	}
}
