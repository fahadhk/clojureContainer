FROM clojure:latest

RUN useradd -m newuser

COPY .tmp/dart-sass /sass
ENV PATH="/sass:${PATH}"

WORKDIR /project

CMD ["lein", "repl", ":headless", ":port", "50000"]
