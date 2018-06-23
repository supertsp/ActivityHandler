package br.com.pedrosocompany.meuprimeiroappdahora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityHandler {

    private Intent intent;
    private AppCompatActivity currentActivity;
    private Class<?> nextActivity;

    //region ActivityHandler(...)
    public ActivityHandler(AppCompatActivity currentActivity, Class<?> nextActivity){
        this.currentActivity = currentActivity;
        this.nextActivity = nextActivity;
        intent = new Intent(currentActivity, nextActivity);
    }

    public ActivityHandler(AppCompatActivity currentActivity){
        this(currentActivity, currentActivity.getClass());
    }
    //endregion

    public void changeActivity(){
        currentActivity.startActivity(intent);
    }

    //region getStringFromResource(...)
    public String getStringFromResource(int resourceId){
        return currentActivity.getString(resourceId);
    }

    public String getStringFromResource(int resourceId, Object... argsToModifyString){
        return currentActivity.getString(resourceId, argsToModifyString);
    }
    //endregion

    //region get...FromView(int id)
    public String getStringFromView(int id){
        String temp;

        try {
            temp = ((TextView)(currentActivity.findViewById(id))).getText().toString();
        } catch (Exception e) {
            temp = "";
        }

        return temp;
    }

    public int getIntegerFromView(int id){
        int temp;

        try {
            temp = Integer.parseInt(((TextView)(currentActivity.findViewById(id))).getText().toString());
        } catch (Exception e) {
            temp = 0;
        }

        return temp;
    }

    public float getFloatFromView(int id){
        float temp;

        try {
            temp = Float.parseFloat(((TextView)(currentActivity.findViewById(id))).getText().toString());
        } catch (Exception e) {
            temp = 0;
        }

        return temp;
    }
    //endregion

    //region setText...ToView(...)
    public void setTextToView(int id, Object newText){
        ((TextView)(currentActivity.findViewById(id))).setText(newText.toString());
    }

    public void setTextFromResourceToView(int idView, int idResource){
        setTextToView(idView, getStringFromResource(idResource));
    }

    public void setTextFromResourceToView(int idView, int idResource, Object... argsToModifyString){
        setTextToView(idView, getStringFromResource(idResource, argsToModifyString));
    }
    //endregion

    //region preserveData(...)

    //region Strings
    public void preserveData(String id, String data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, String data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }

    public void preserveData(String id, String[] data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, String[] data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }
    //endregion

    //region Integers
    public void preserveData(String id, int data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, int data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }

    public void preserveData(String id, int[] data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, int[] data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }
    //endregion

    //region Floats
    public void preserveData(String id, float data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, float data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }

    public void preserveData(String id, float[] data){
        currentActivity.getIntent().putExtra(id, data);
        intent.putExtra(id, data);
    }

    public void preserveData(int resourceId, float[] data){
        currentActivity.getIntent().putExtra(getStringFromResource(resourceId), data);
        intent.putExtra(getStringFromResource(resourceId), data);
    }
    //endregion

    //endregion

    //region recoverData(...)

    //region Strings
    public String recoverData(String id, String defaultData){
        String temp = "";

        try {
            temp = currentActivity.getIntent().getStringExtra(id);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public String recoverData(int resourceId, String defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }

    public String[] recoverData(String id, String[] defaultData){
        String[] temp;

        try {
            temp = currentActivity.getIntent().getStringArrayExtra(id);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public String[] recoverData(int resourceId, String[] defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }
    //endregion

    //region Integers
    public int recoverData(String id, int defaultData){
        int temp = 0;

        try {
            temp = currentActivity.getIntent().getIntExtra(id, defaultData);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public int recoverData(int resourceId, int defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }

    public int[] recoverData(String id, int[] defaultData){
        int[] temp;

        try {
            temp = currentActivity.getIntent().getIntArrayExtra(id);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public int[] recoverData(int resourceId, int[] defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }
    //endregion

    //region Floats
    public float recoverData(String id, float defaultData){
        float temp = 0;

        try {
            temp = currentActivity.getIntent().getFloatExtra(id, defaultData);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public float recoverData(int resourceId, float defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }

    public float[] recoverData(String id, float[] defaultData){
        float[] temp;

        try {
            temp = currentActivity.getIntent().getFloatArrayExtra(id);
        } catch (Exception e) {
            temp = defaultData;
        }

        return temp;
    }

    public float[] recoverData(int resourceId, float[] defaultData){
        return recoverData(getStringFromResource(resourceId), defaultData);
    }
    //endregion

    //endregion

    //region hasData(...)
    public boolean hasData(String id){
        return currentActivity.getIntent().hasExtra(id);
    }

    public boolean hasData(int resourceId){
        return hasData(getStringFromResource(resourceId));
    }
    //endregion

    //region showToast(...)
    public void showToast(String message, byte binaryDuration){
        Toast.makeText(
                currentActivity,
                message,
                binaryDuration
        ).show();
    }

    public void showToast(String message){
        showToast(message, (byte)Toast.LENGTH_SHORT);
    }
    //endregion

    public void printLog(Object message){
        Log.println(Log.ASSERT, "\\<DEBUG>", " " + message.toString());
    }

}
