package labelingStudy.nctu.minuku.model.DataRecord;

import com.google.android.gms.location.DetectedActivity;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import labelingStudy.nctu.minuku.config.Constants;
import labelingStudy.nctu.minukucore.model.DataRecord;

/**
 * Created by Lawrence on 2017/5/15.
 */

public class ActivityRecognitionDataRecord implements DataRecord {

    public long creationTime;
    private static DetectedActivity MostProbableActivity;
    private List<DetectedActivity> mProbableActivities;
    private static long Detectedtime;

    //create for ActivityRecognitionDataRecord Pool
    private int taskDayCount;
    private long hour;
    protected long _id;
    protected JSONObject mData;
    protected long _timestamp;
    protected String mTimestring;

    public ActivityRecognitionDataRecord(){

    }

    public ActivityRecognitionDataRecord(DetectedActivity MostProbableActivity, List<DetectedActivity> mProbableActivities){
        this.creationTime = new Date().getTime();
//        this.taskDayCount = Constants.TaskDayCount;
//        this.hour = getmillisecondToHour(creationTime);
        this.MostProbableActivity = MostProbableActivity;
        this.mProbableActivities = mProbableActivities;

    }

    public ActivityRecognitionDataRecord(DetectedActivity MostProbableActivity,long Detectedtime){
        this.creationTime = new Date().getTime();
//        this.taskDayCount = Constants.TaskDayCount;
//        this.hour = getmillisecondToHour(creationTime);
        this.MostProbableActivity = MostProbableActivity;
        this.Detectedtime = Detectedtime;

    }

    public DetectedActivity getMostProbableActivity(){return MostProbableActivity;}

    public void setProbableActivities(List<DetectedActivity> probableActivities) {
        mProbableActivities = probableActivities;

    }

    public void setMostProbableActivity(DetectedActivity mostProbableActivity) {
        MostProbableActivity = mostProbableActivity;

    }

    public void setDetectedtime(long detectedtime){
        Detectedtime = detectedtime;

    }

    private long getmillisecondToHour(long timeStamp){

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);

        long mhour = calendar.get(Calendar.HOUR_OF_DAY);

        return mhour;

    }

    public long getHour(){
        return hour;
    }

    public int getTaskDayCount(){
        return taskDayCount;
    }

    public void setID(long id){
        _id = id;
    }

    public long getID(){
        return _id;
    }

    public long getDetectedtime(){return Detectedtime;}

    @Override
    public long getCreationTime() {
        return creationTime;
    }

    //create for ActivityRecognitionDataRecord Pool
    public void setTimestamp(long t){
        _timestamp = t;
    }

    public long getTimestamp(){
        return _timestamp;
    }

    public JSONObject getData() {
        return mData;
    }

    public void setData(JSONObject data) {
        this.mData = data;
    }

    public String getTimeString(){

        SimpleDateFormat sdf_now = new SimpleDateFormat(Constants.DATE_FORMAT_NOW);
        mTimestring = sdf_now.format(_timestamp);

        return mTimestring;
    }

    public List<DetectedActivity> getProbableActivities() {
        return mProbableActivities;
    }

}
