var eb = vertx.eventBus();

// Send a message every second

vertx.setPeriodic(1000, function (v) {

	var data={
		lang: 'JS',
		content : 'JS ping!'
	}
  eb.send("feed", data);

});
