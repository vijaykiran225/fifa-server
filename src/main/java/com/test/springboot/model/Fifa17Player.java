package com.test.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fifa17Player {
    @JsonProperty("name")
    private String name;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("national_position")
    private String nationalPosition;

    @JsonProperty("national_kit")
    private long nationalKit;

    @JsonProperty("club")
    private String club;

    @JsonProperty("club_position")
    private String clubPosition;

    @JsonProperty("club_kit")
    private long clubKit;

    @JsonProperty("club_joining")
    private String clubJoining;

    @JsonProperty("contract_expiry")
    private String contractExpiry;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("preffered_foot")
    private String prefferedFoot;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("age")
    private String age;

    @JsonProperty("preffered_position")
    private String prefferedPosition;

    @JsonProperty("work_rate")
    private String workRate;

    @JsonProperty("weak_foot")
    private String weakFoot;

    @JsonProperty("skill_moves")
    private String skillMoves;

    @JsonProperty("ball_control")
    private String ballControl;

    @JsonProperty("dribbling")
    private String dribbling;

    @JsonProperty("marking")
    private String marking;

    @JsonProperty("sliding_tackle")
    private String slidingTackle;

    @JsonProperty("standing_tackle")
    private String standingTackle;

    @JsonProperty("aggression")
    private String aggression;

    @JsonProperty("reactions")
    private String reactions;

    @JsonProperty("attacking_position")
    private String attackingPosition;

    @JsonProperty("interceptions")
    private String interceptions;

    @JsonProperty("vision")
    private String vision;

    @JsonProperty("composure")
    private String composure;

    @JsonProperty("crossing")
    private String crossing;

    @JsonProperty("short_pass")
    private String shortPass;

    @JsonProperty("long_pass")
    private String longPass;

    @JsonProperty("acceleration")
    private String acceleration;

    @JsonProperty("speed")
    private String speed;

    @JsonProperty("stamina")
    private String stamina;

    @JsonProperty("strength")
    private String strength;

    @JsonProperty("balance")
    private String balance;

    @JsonProperty("agility")
    private String agility;

    @JsonProperty("jumping")
    private String jumping;

    @JsonProperty("heading")
    private String heading;

    @JsonProperty("shot_power")
    private String shotPower;

    @JsonProperty("finishing")
    private String finishing;

    @JsonProperty("long_shots")
    private String longShots;

    @JsonProperty("curve")
    private String curve;

    @JsonProperty("freekick_accuracy")
    private String freekickAccuracy;

    @JsonProperty("penalties")
    private String penalties;

    @JsonProperty("volleys")
    private String volleys;

    @JsonProperty("gk_positioning")
    private String gkPositioning;

    @JsonProperty("gk_diving")
    private String gkDiving;

    @JsonProperty("gk_kicking")
    private String gkKicking;

    @JsonProperty("gk_handling")
    private String gkHandling;

    @JsonProperty("GK_reflexes")
    private String GKReflexes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalPosition() {
        return nationalPosition;
    }

    public void setNationalPosition(String nationalPosition) {
        this.nationalPosition = nationalPosition;
    }

    public long getNationalKit() {
        return nationalKit;
    }

    public void setNationalKit(long nationalKit) {
        this.nationalKit = nationalKit;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClubPosition() {
        return clubPosition;
    }

    public void setClubPosition(String clubPosition) {
        this.clubPosition = clubPosition;
    }

    public long getClubKit() {
        return clubKit;
    }

    public void setClubKit(long clubKit) {
        this.clubKit = clubKit;
    }

    public String getClubJoining() {
        return clubJoining;
    }

    public void setClubJoining(String clubJoining) {
        this.clubJoining = clubJoining;
    }

    public String getContractExpiry() {
        return contractExpiry;
    }

    public void setContractExpiry(String contractExpiry) {
        this.contractExpiry = contractExpiry;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrefferedFoot() {
        return prefferedFoot;
    }

    public void setPrefferedFoot(String prefferedFoot) {
        this.prefferedFoot = prefferedFoot;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrefferedPosition() {
        return prefferedPosition;
    }

    public void setPrefferedPosition(String prefferedPosition) {
        this.prefferedPosition = prefferedPosition;
    }

    public String getWorkRate() {
        return workRate;
    }

    public void setWorkRate(String workRate) {
        this.workRate = workRate;
    }

    public String getWeakFoot() {
        return weakFoot;
    }

    public void setWeakFoot(String weakFoot) {
        this.weakFoot = weakFoot;
    }

    public String getSkillMoves() {
        return skillMoves;
    }

    public void setSkillMoves(String skillMoves) {
        this.skillMoves = skillMoves;
    }

    public String getBallControl() {
        return ballControl;
    }

    public void setBallControl(String ballControl) {
        this.ballControl = ballControl;
    }

    public String getDribbling() {
        return dribbling;
    }

    public void setDribbling(String dribbling) {
        this.dribbling = dribbling;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public String getSlidingTackle() {
        return slidingTackle;
    }

    public void setSlidingTackle(String slidingTackle) {
        this.slidingTackle = slidingTackle;
    }

    public String getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(String standingTackle) {
        this.standingTackle = standingTackle;
    }

    public String getAggression() {
        return aggression;
    }

    public void setAggression(String aggression) {
        this.aggression = aggression;
    }

    public String getReactions() {
        return reactions;
    }

    public void setReactions(String reactions) {
        this.reactions = reactions;
    }

    public String getAttackingPosition() {
        return attackingPosition;
    }

    public void setAttackingPosition(String attackingPosition) {
        this.attackingPosition = attackingPosition;
    }

    public String getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(String interceptions) {
        this.interceptions = interceptions;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getComposure() {
        return composure;
    }

    public void setComposure(String composure) {
        this.composure = composure;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getShortPass() {
        return shortPass;
    }

    public void setShortPass(String shortPass) {
        this.shortPass = shortPass;
    }

    public String getLongPass() {
        return longPass;
    }

    public void setLongPass(String longPass) {
        this.longPass = longPass;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStamina() {
        return stamina;
    }

    public void setStamina(String stamina) {
        this.stamina = stamina;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getJumping() {
        return jumping;
    }

    public void setJumping(String jumping) {
        this.jumping = jumping;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getShotPower() {
        return shotPower;
    }

    public void setShotPower(String shotPower) {
        this.shotPower = shotPower;
    }

    public String getFinishing() {
        return finishing;
    }

    public void setFinishing(String finishing) {
        this.finishing = finishing;
    }

    public String getLongShots() {
        return longShots;
    }

    public void setLongShots(String longShots) {
        this.longShots = longShots;
    }

    public String getCurve() {
        return curve;
    }

    public void setCurve(String curve) {
        this.curve = curve;
    }

    public String getFreekickAccuracy() {
        return freekickAccuracy;
    }

    public void setFreekickAccuracy(String freekickAccuracy) {
        this.freekickAccuracy = freekickAccuracy;
    }

    public String getPenalties() {
        return penalties;
    }

    public void setPenalties(String penalties) {
        this.penalties = penalties;
    }

    public String getVolleys() {
        return volleys;
    }

    public void setVolleys(String volleys) {
        this.volleys = volleys;
    }

    public String getGkPositioning() {
        return gkPositioning;
    }

    public void setGkPositioning(String gkPositioning) {
        this.gkPositioning = gkPositioning;
    }

    public String getGkDiving() {
        return gkDiving;
    }

    public void setGkDiving(String gkDiving) {
        this.gkDiving = gkDiving;
    }

    public String getGkKicking() {
        return gkKicking;
    }

    public void setGkKicking(String gkKicking) {
        this.gkKicking = gkKicking;
    }

    public String getGkHandling() {
        return gkHandling;
    }

    public void setGkHandling(String gkHandling) {
        this.gkHandling = gkHandling;
    }

    public String getGKReflexes() {
        return GKReflexes;
    }

    public void setGKReflexes(String GKReflexes) {
        this.GKReflexes = GKReflexes;
    }

    @Override
    public String toString() {
        return "Fifa17Player{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationalPosition='" + nationalPosition + '\'' +
                ", nationalKit='" + nationalKit + '\'' +
                ", club='" + club + '\'' +
                ", clubPosition='" + clubPosition + '\'' +
                ", clubKit='" + clubKit + '\'' +
                ", clubJoining='" + clubJoining + '\'' +
                ", contractExpiry='" + contractExpiry + '\'' +
                ", rating='" + rating + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", prefferedFoot='" + prefferedFoot + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", age='" + age + '\'' +
                ", prefferedPosition='" + prefferedPosition + '\'' +
                ", workRate='" + workRate + '\'' +
                ", weakFoot='" + weakFoot + '\'' +
                ", skillMoves='" + skillMoves + '\'' +
                ", ballControl='" + ballControl + '\'' +
                ", dribbling='" + dribbling + '\'' +
                ", marking='" + marking + '\'' +
                ", slidingTackle='" + slidingTackle + '\'' +
                ", standingTackle='" + standingTackle + '\'' +
                ", aggression='" + aggression + '\'' +
                ", reactions='" + reactions + '\'' +
                ", attackingPosition='" + attackingPosition + '\'' +
                ", interceptions='" + interceptions + '\'' +
                ", vision='" + vision + '\'' +
                ", composure='" + composure + '\'' +
                ", crossing='" + crossing + '\'' +
                ", shortPass='" + shortPass + '\'' +
                ", longPass='" + longPass + '\'' +
                ", acceleration='" + acceleration + '\'' +
                ", speed='" + speed + '\'' +
                ", stamina='" + stamina + '\'' +
                ", strength='" + strength + '\'' +
                ", balance='" + balance + '\'' +
                ", agility='" + agility + '\'' +
                ", jumping='" + jumping + '\'' +
                ", heading='" + heading + '\'' +
                ", shotPower='" + shotPower + '\'' +
                ", finishing='" + finishing + '\'' +
                ", longShots='" + longShots + '\'' +
                ", curve='" + curve + '\'' +
                ", freekickAccuracy='" + freekickAccuracy + '\'' +
                ", penalties='" + penalties + '\'' +
                ", volleys='" + volleys + '\'' +
                ", gkPositioning='" + gkPositioning + '\'' +
                ", gkDiving='" + gkDiving + '\'' +
                ", gkKicking='" + gkKicking + '\'' +
                ", gkHandling='" + gkHandling + '\'' +
                ", GKReflexes='" + GKReflexes + '\'' +
                '}';
    }
}
