namespace TodoApp.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class InitialCreate : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Roles",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        RoleName = c.String(),
                        Role_id = c.Int(),
                        User_id = c.Int(),
                    })
                .PrimaryKey(t => t.id)
                .ForeignKey("dbo.Roles", t => t.Role_id)
                .ForeignKey("dbo.Users", t => t.User_id)
                .Index(t => t.Role_id)
                .Index(t => t.User_id);
            
            CreateTable(
                "dbo.Users",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        UserName = c.String(nullable: false, maxLength: 256),
                        Password = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.id)
                .Index(t => t.UserName, unique: true);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Roles", "User_id", "dbo.Users");
            DropForeignKey("dbo.Roles", "Role_id", "dbo.Roles");
            DropIndex("dbo.Users", new[] { "UserName" });
            DropIndex("dbo.Roles", new[] { "User_id" });
            DropIndex("dbo.Roles", new[] { "Role_id" });
            DropTable("dbo.Users");
            DropTable("dbo.Roles");
        }
    }
}
