package sand.entity;


import com.baomidou.mybatisplus.annotations.TableName;

@TableName("lsys_user")
public class User  {


    private Integer id;

    private String name;

    private String username;

    private String userpass;

    private Integer statue;

    private String udesc;

    private String seller_bn;

    private String mer_no;

    private Integer p_id;

    private String level;

    private String store_bn;

    //@TableField(exist = false)//实体类上有，数据库中没有，需要改注解排除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getUdesc() {
        return udesc;
    }

    public void setUdesc(String udesc) {
        this.udesc = udesc;
    }

    public String getSeller_bn() {
        return seller_bn;
    }

    public void setSeller_bn(String seller_bn) {
        this.seller_bn = seller_bn;
    }

    public String getMer_no() {
        return mer_no;
    }

    public void setMer_no(String mer_no) {
        this.mer_no = mer_no;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStore_bn() {
        return store_bn;
    }

    public void setStore_bn(String store_bn) {
        this.store_bn = store_bn;
    }

}
