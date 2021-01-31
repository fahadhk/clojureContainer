current_dir := $(shell pwd)

build:
	mkdir -p .tmp
	wget -qO - https://github.com/sass/dart-sass/releases/download/1.32.0/dart-sass-1.32.0-linux-x64.tar.gz | tar xvz -C .tmp
	@docker build . -t clojure-dev

setup:
	mkdir -p ~/.m2 ~/.lein ~/.emacs.d
	git clone https://github.com/flyingmachine/emacs-for-clojure.git ~/.emacs.d --depth 1

repl:
	@mkdir -p project
	@docker container run --rm \
	--name clojure-dev \
	--net host \
	-u 1000:1000 \
	-v $(current_dir)/project:/project \
	-v ~/.m2:/home/newuser/.m2 \
	-v ~/.lein:/home/newuser/.lein \
	clojure-dev:latest &

shell:
	@docker exec -it clojure-dev /bin/bash

new-app:
	@docker exec -it clojure-dev lein new app $(NAME)

new-lib:
	@docker exec -it clojure-dev lein new $(NAME)

kill:
	@docker kill clojure-dev
