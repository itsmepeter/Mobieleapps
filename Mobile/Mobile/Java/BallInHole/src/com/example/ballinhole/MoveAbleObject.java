package com.example.ballinhole;


public class MoveAbleObject {
	//mate waarin de bal gaat vertragen als hij tegen een muur botst
	private static final float elasticiteit = (float)0.01;
	
    public float positieX;
    public float positieY;
    private float snelheidX;
    private float snelheidY;
	private int balgrootte = 32;
	private int gatgrootte = 40; 
    
    public void updatePositie(float sx, float sy, float sz, long timestamp) {
    	float seconden = (System.nanoTime() - timestamp) / 1000000000.0f;
    	snelheidX += -sx * seconden;
    	snelheidY += sy * seconden;
    	//*0.1 om het wat trager te laten gaan.
    	
    	positieX += snelheidX * seconden;
    	positieY += snelheidY * seconden;
    	

    }
    
    public void Botsing(int breedte, int lengte, int groottebal) {
    	//System.out.println("lengte" + lengte + " moveableobject" + positieX + " " + positieY + " snelheidx:" + snelheidX + " snelheid y: " + snelheidY);
        if (positieX > breedte - groottebal + 10 ) {
            positieX = breedte - groottebal + 10;
            snelheidX = -snelheidX * elasticiteit;
        } else if (positieX < -10) {
            positieX = -10;
            snelheidX = snelheidX * elasticiteit;
        }
        if (positieY > lengte - groottebal + 8) {
            positieY = lengte - groottebal + 8;
            snelheidY = -snelheidY * elasticiteit;
        } else if (positieY < -10) {
            positieY = -10;
            snelheidY = snelheidY * elasticiteit;
        }
        
    }
    
    public String getInfo(){
    	return  positieX + " " + positieY + " snelheidx:" + snelheidX + " snelheid y: " + snelheidY;
    }

	public int getBalgrootte() {
		return balgrootte;
	}

	public int getGatgrootte() {
		return gatgrootte;
	}

	public float getPositieX() {
		return positieX;
	}

	public void setPositieX(float positieX) {
		this.positieX = positieX;
	}

	public float getPositieY() {
		return positieY;
	}

	public void setPositieY(float positieY) {
		this.positieY = positieY;
	}
}
