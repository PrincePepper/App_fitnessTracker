from fastapi import FastAPI

from app.database import engine, Model
from app.dependencies import get_db
from app.routers import speedsters

Model.metadata.create_all(bind=engine)

app = FastAPI()
app.include_router(speedsters.router)


@app.get("/")
async def read_root():
    return {"hello": "world"}

@app.on_event("startup")
async def startup():
    # когда приложение запускается устанавливаем соединение с БД
    print(get_db)

# from os import environ
#
# import databases
# # берем параметры БД из переменных окружения
# from fastapi import FastAPI
# from sqlalchemy import select, desc
#
# from models.posts import posts_table
# from models.users import users_table
#
# DB_USER = environ.get("DB_USER", "user")
# DB_PASSWORD = environ.get("DB_PASSWORD", "password")
# DB_HOST = environ.get("DB_HOST", "localhost")
# DB_NAME = "async-blogs"
# SQLALCHEMY_DATABASE_URL = (
#     f"postgresql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}:5432/{DB_NAME}"
# )
# # создаем объект database, который будет использоваться для выполнения запросов
# database = databases.Database(SQLALCHEMY_DATABASE_URL)
#
# app = FastAPI()
#
#
# @app.on_event("startup")
# async def startup():
#     # когда приложение запускается устанавливаем соединение с БД
#     await database.connect()
#
#
# @app.on_event("shutdown")
# async def shutdown():
#     # когда приложение останавливается разрываем соединение с БД
#     await database.disconnect()
#
#
# @app.get("/")
# async def read_root():
#     # изменим роут таким образом, чтобы он брал данные из БД
#     query = (
#         select(
#             [
#                 posts_table.c.id,
#                 posts_table.c.created_at,
#                 posts_table.c.title,
#                 posts_table.c.content,
#                 posts_table.c.user_id,
#                 users_table.c.name.label("user_name"),
#             ]
#         )
#         .select_from(posts_table.join(users_table))
#         .order_by(desc(posts_table.c.created_at))
#     )
#     return await database.fetch_all(query)
