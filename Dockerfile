# Используем официальный образ OpenJDK 17 как базовый образ
FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Устанавливаем Maven
RUN apk add --no-cache maven

# Копируем все файлы проекта в рабочую директорию
COPY . .

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "target/library-0.0.1-SNAPSHOT.jar"]
