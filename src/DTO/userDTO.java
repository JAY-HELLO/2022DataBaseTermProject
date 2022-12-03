package DTO;

//DTO는 데이터 를실어나르는 객체
//2018038006 이정주
public class userDTO {
    private Integer ussn;
    private String name;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUssn() {
        return ussn;
    }

    public void setUssn(Integer ussn) {
        this.ussn = ussn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
