var Feed = {};
var isPost = true;

Feed.init = function(){}

Feed.check = function(){
	//input value check
}

Feed.goList = function(no){//differentiated by category 
	location.href = "/board?action=listFeed&category="+no;
}

Feed.goView = function(no){
	location.href = "/board?action=viewFeed&no="+ no + "&ref=list";
}

Feed.more = function(category, type, no){
	if(!isPost){//?
		return false;
	}
	
	if(no < 0){//?
		return false;
	}
	
	var action = "/feed?action=listFeed";
	var form_data = {
			category : category,
			inputNextFeedNo : no
	};
	
	$.ajax({
		url: action,
		type: "POST",
		data: form_data,
		dataType: "json",
		success: function(response){
			var posts = "";
			
			if(response.outputIsNextFeed == false) {
				isPost = false;
			}
			for(i=0; i <response.outputFeedList.length; i++){
				var post = "<div class='post' onclick=\"Feed.goView("+ response.outputFeedNo+")\"><div class='profileImg background-fit' style=\"background-image:url('"
					+ response.outputFeedList[i].outputMemberProfileImg + "');\"></div></div><div class='right'><div class='subject'><span class='category'>[" + response.outputFeedList[i].outputFeedTypeName + "]</span> "
					+ response.outputFeedList[i].outputFeedSubject + "</div><div='info'><div class='text'><span class='name'>" + response.outputFeedList[i].outputMemberName + "</span>";
				if(response.outputFeedList[i].outputFeedLikeCount > 0){
					post += "<span class='like'>좋아요" + response.outputFeedList[i].outputFeedLikeCount + "개</span>";
				} else if(response.outputFeedList[i].outputFeedLikeCount == 0){
					post += "<span class='like'>좋아요</span>";
				}
				
				if(response.outputFeedList[i].outputFeedCommentCount > 0) {
					post += "<span class='comment'>덧글 " + response.outputFeedList[i].outputFeedCommentCount + "개</span>";
				} else if(response.outputFeedList[i].outputFeedCommentCount == 0){
					post += "<span class='comment'>덧글</span>";
				}
				
				post += "</div></div></div></div>";
				
				posts += post;
			}
			
			$("#Feed-list .body").append(posts);
			$("#Feed-list .more").attr("onclick", "Feed ")
			
		
		}, error: function(xhr, status, error){
			alert(error);
		}
		
	});
	
	return false;
}