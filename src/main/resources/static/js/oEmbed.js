let index ={
	init:function(){
		$('#srch-btn').on('click', ()=>{
			this.srch();
		});
	},
	
	srch:function(){
		let data = $("#srch-txt").val();
		$.ajax({
			type: 'post',
			url: `oeb/`,
			contentType: "application/json;charset=utf-8",
			dataType: "json",
			data : JSON.stringify(data)
		}).done(function(res){
			console.log(res);
			$('.table').empty();
			$.each(res, function(id, item) {
				$('.table').append('<tr><th>title</th><td> ' + item.title + '</td></tr>'
					+ '<tr><th>type</th><td>' + item.type +  '</td></tr>'
					+ '<tr><th>version</th><td>' + item.type +  '</td></tr>'
					+ '<tr><th>provider_name</th><td>' + item.provider_name +  '</td></tr>'
					+ '<tr><th>provider_url</th><td>' + item.provider_url +  '</td></tr>'
					+ '<tr><th>author_name</th><td>' + item.author_name +  '</td></tr>'
					+ '<tr><th>author_url</th><td>' + item.author_url +  '</td></tr>'
					+ '<tr><th>is_plus</th><td>' + item.is_plus +  '</td></tr>'
					+ '<tr><th>html</th><td>' + item.html +  '</td></tr>'
					+ '<tr><th>width</th><td>' + item.width +  '</td></tr>'
					+ '<tr><th>height</th><td>' + item.height +  '</td></tr>'
					+ '<tr><th>description</th><td>' + item.description +  '</td></tr>'
					+ '<tr><th>thumbnail_url</th><td><img src="'+item.thumbnail_url+'"/></td></tr>'
					+ '<tr><th>thumbnail_width</th><td>' + item.thumbnail_width +  '</td></tr>'
					+ '<tr><th>thumbnail_height</th><td>' + item.thumbnail_height +  '</td></tr>'
					+ '<tr><th>thumbnail_url_with_play_button</th><td>' + item.thumbnail_url_with_play_button +  '</td></tr>'
					+ '<tr><th>upload_date</th><td>' + item.upload_date +  '</td></tr>'
					+ '<tr><th>video_id</th><td>' + item.video_id +  '</td></tr>'
					+ '<tr><th>uri</th><td>' + item.uri +  '</td></tr>'
				);
			});
		}).fail(function(err){
			alert(JSON.stringify(err));
		});
	}
}
index.init();