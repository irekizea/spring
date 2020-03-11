package com.kh.sts28.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 카카오페이 결제 취소시 반환 값 저장 VO
@Data @Builder @NoArgsConstructor@AllArgsConstructor
public class KakaoPayRevokeReturnVO {
	private String aid, tid, cid, status;
	private String partner_order_id;
	private String partner_user_id;
	private String paytment_method_type;
	private KakaoPayAmountVO amount;
	private KakaoPayAmountVO canceled_amount;
	private KakaoPayAmountVO cancel_availiable_amount;
	private String item_name;
	private String item_code;
	private int quantity;
	private String created_at, approved_at, canceled_at;
	private String payload;
}
