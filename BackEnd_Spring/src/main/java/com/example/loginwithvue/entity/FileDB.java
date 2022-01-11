package com.example.loginwithvue.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity /* JPA와 테이블이 매핑한다고 JPA에게 선언 */
@Table(name = "files") /* entity & table 매핑 */
public class FileDB {
    @Id /* 기본키 생성 필수 */
    @GeneratedValue(generator = "uuid") /* 기본키 생성 필수 */
    @GenericGenerator(name = "uuid" // @GeneratedValue의 generator modifier에서 사용할 이름
            , strategy = "uuid2")  // IdentifierGenerator 인터페이스를 구현한 클래스 이름. 전체 패키지를 포함한 클래스 이름을 적어야 합니다.
    private String id;

    private String name;

    private String type;

    @Lob /* 데이터베이스 매핑 */
    private byte[] data;

    public FileDB() {
    }

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
