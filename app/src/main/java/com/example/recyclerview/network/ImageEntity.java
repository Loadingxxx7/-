package com.example.recyclerview.network;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/25
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class ImageEntity {


    /**
     * code : 1
     * msg : 数据返回成功！
     * data : {"page":2,"totalCount":999,"totalPage":100,"limit":10,"list":[{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1usf35qmtj31c00u0jw9.jpg","imageSize":"1728x1080","imageFileLength":172914},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpggy1g1uq1a5fmrj31400p0wg9.jpg","imageSize":"1440x900","imageFileLength":75657},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut4v5ldjj31c00u077q.jpg","imageSize":"1728x1080","imageFileLength":134186},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1urphzevej31hc0u0dpo.jpg","imageSize":"1920x1080","imageFileLength":319985},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1us8z7l5ej31hc0u044j.jpg","imageSize":"1920x1080","imageFileLength":235538},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpggy1g1uq58noj7j31c00u0tdi.jpg","imageSize":"1728x1080","imageFileLength":146924},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1us97zs5kj31c00u0n2s.jpg","imageSize":"1728x1080","imageFileLength":206456},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1ut8v42bsj31c00u0q5g.jpg","imageSize":"1728x1080","imageFileLength":103187},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpggy1g3jt5q2p7tj315o0rtwri.jpg","imageSize":"1500x1001","imageFileLength":382351},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpggy1g1uqffq7doj31hc0u0aib.jpg","imageSize":"1920x1080","imageFileLength":261938}]}
     */

    private Integer code;
    private String msg;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * page : 2
         * totalCount : 999
         * totalPage : 100
         * limit : 10
         * list : [{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1usf35qmtj31c00u0jw9.jpg","imageSize":"1728x1080","imageFileLength":172914},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpggy1g1uq1a5fmrj31400p0wg9.jpg","imageSize":"1440x900","imageFileLength":75657},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1ut4v5ldjj31c00u077q.jpg","imageSize":"1728x1080","imageFileLength":134186},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpgly1g1urphzevej31hc0u0dpo.jpg","imageSize":"1920x1080","imageFileLength":319985},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1us8z7l5ej31hc0u044j.jpg","imageSize":"1920x1080","imageFileLength":235538},{"imageUrl":"https://tvax3.sinaimg.cn/large/005BYqpggy1g1uq58noj7j31c00u0tdi.jpg","imageSize":"1728x1080","imageFileLength":146924},{"imageUrl":"https://tvax1.sinaimg.cn/large/005BYqpgly1g1us97zs5kj31c00u0n2s.jpg","imageSize":"1728x1080","imageFileLength":206456},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1ut8v42bsj31c00u0q5g.jpg","imageSize":"1728x1080","imageFileLength":103187},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpggy1g3jt5q2p7tj315o0rtwri.jpg","imageSize":"1500x1001","imageFileLength":382351},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpggy1g1uqffq7doj31hc0u0aib.jpg","imageSize":"1920x1080","imageFileLength":261938}]
         */

        private Integer page;
        private Integer totalCount;
        private Integer totalPage;
        private Integer limit;
        private List<ListDTO> list;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class ListDTO {
            /**
             * imageUrl : https://tvax1.sinaimg.cn/large/005BYqpgly1g1usf35qmtj31c00u0jw9.jpg
             * imageSize : 1728x1080
             * imageFileLength : 172914
             */

            private String imageUrl;
            private String imageSize;
            private Integer imageFileLength;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageSize() {
                return imageSize;
            }

            public void setImageSize(String imageSize) {
                this.imageSize = imageSize;
            }

            public Integer getImageFileLength() {
                return imageFileLength;
            }

            public void setImageFileLength(Integer imageFileLength) {
                this.imageFileLength = imageFileLength;
            }
        }
    }
}
